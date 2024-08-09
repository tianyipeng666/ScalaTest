package jetty.web

// import jakarta.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import log.LazyLogging
import org.eclipse.jetty.server.handler.{HandlerList, StatisticsHandler}
import org.eclipse.jetty.server.{HttpConnectionFactory, Server, ServerConnector}
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.eclipse.jetty.util.thread.{QueuedThreadPool, ScheduledExecutorScheduler}
import org.json4s.JValue
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

object JettyUtils extends LazyLogging {

  type Responder[T] = HttpServletRequest => T

  val contextHandler = new ServletContextHandler

  class ServletParams(val responder: Responder[JValue],
                      val contentType: String,
                      val extractFn: (JValue, HttpServletResponse) => Unit = (in: Any, response: HttpServletResponse) =>
                        response.getWriter.println(in.toString)) {}

  // 隐式转换
  implicit def jsonResponderToServlet(responder: Responder[JValue]): ServletParams =
    new ServletParams(responder, "text/json", (in: JValue, response: HttpServletResponse) =>
      response.getWriter.println(pretty(render(in))))

  def startJettyServer(host: String, port: Int, maxThreads: Int = 10, serverName: String): Unit = {
    val pool = new QueuedThreadPool
    pool.setMaxThreads(maxThreads)
    pool.setDaemon(true)
    val server = new Server(pool)

    val httpConnector = new ServerConnector(
      server,
      null,
      new ScheduledExecutorScheduler(s"${serverName}Scheduler", true),
      null,
      -1,
      -1,
      new HttpConnectionFactory())
    httpConnector.setHost(host)
    httpConnector.setPort(port)
    server.setConnectors(Array(httpConnector))

    // handler
    val handlerList = new HandlerList
    contextHandler.setContextPath("/")
    handlerList.addHandler(contextHandler)
    val statisticsHandler = new StatisticsHandler()
    statisticsHandler.setHandler(handlerList)
    server.setHandler(statisticsHandler)

    server.start()
  }

  def createServlet(servletParams: ServletParams): HttpServlet = {
    // 每个api创建Servlet
    new HttpServlet {
      def handleRequest(servletParams: ServletParams,
                        request: HttpServletRequest,
                        response: HttpServletResponse): Unit = {
        val start = System.currentTimeMillis()
        var isSuccess = true
        var errorMsg: String = null
        var statusCode = 0
        try {
          response.setContentType("%s;charset=utf-8".format(servletParams.contentType))
          response.setStatus(HttpServletResponse.SC_OK)
          response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
          response.setHeader("Server", "JettyServer")
          val result = servletParams.responder(request)
          servletParams.extractFn(result, response)
        } catch {
          case e: Throwable =>
            statusCode = 1
            isSuccess = false
            errorMsg = e.getMessage
            e.printStackTrace()
        } finally {
          if (!isSuccess) {
            val errMsg = s"${request.getRequestURI} error: $errorMsg"
            val json = ("status" -> statusCode) ~ ("msg" -> errMsg)
            response.getWriter.println(compact(render(json)))
          }
        }
        if (request.getRequestURI != "/") {
          logger.info(s"Request end: ${request.getRequestURI}:$isSuccess ${System.currentTimeMillis() - start} ms")
        }
      }

      override def doGet(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        handleRequest(servletParams, request, response)
      }

      override def doPost(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        handleRequest(servletParams, request, response)
      }

      override def doDelete(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        handleRequest(servletParams, request, response)
      }
    }
  }

  def addHandler(path: String,
                 servletParams: ServletParams,
                 basePath: String = ""): Unit = {
    val servlet = createServlet(servletParams)
    val prefixedPath = attachPrefix(basePath, path)
    val holder = new ServletHolder(path, servlet)
    contextHandler.addServlet(holder, prefixedPath)
  }

  /**
   * path修正
   */
  def attachPrefix(basePath: String, relativePath: String): String = {
    if (basePath == "") relativePath else (basePath + relativePath).stripSuffix("/")
  }

}
