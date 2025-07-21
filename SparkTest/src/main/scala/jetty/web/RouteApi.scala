package jetty.web

//import jakarta.servlet.http.HttpServletRequest

import javax.servlet.http.HttpServletRequest
import jetty.web.JettyUtils._
import log.LazyLogging
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler, ServletHolder}
import org.json4s.{DefaultFormats, Formats, JValue}
import org.json4s.JsonDSL._
trait RouteApi extends LazyLogging{

  implicit val formats: Formats = DefaultFormats

  // method
  val POST_METHOD = "POST"
  val GET_METHOD = "GET"

  // 加载各方法路径
  val routes: Map[String, Responder[JValue]] = Map("/*" -> restfulController)
  val basePath: String
  val callMethodMap: Map[(String, String), HttpServletRequest => JValue]
  def mapRoutes(): Unit = {
    routes.foreach { (info: (String, Responder[JValue])) =>
      val path = info._1
      val handler = handlerWrapper(path, info._2)
      JettyUtils.addHandler(path, handler, basePath)
    }
  }

  def restfulController(request: HttpServletRequest): JValue = {
    val action = request.getPathInfo.split("/").last
    callMethodMap((request.getMethod, action))(request)
  }

  /**
   * 异常处理
   */
  def handlerWrapper(path: String, handler: Responder[JValue]): Responder[JValue] = (request: HttpServletRequest) => {
    try {
      handler(request)
    } catch {
      case t: Throwable =>
        logger.error(s"${request.getRequestURI} error.", t)
        ("status" -> 1) ~ ("msg" -> s"${t.getMessage}") ~ ("result" -> Nil)
    }
  }
}
