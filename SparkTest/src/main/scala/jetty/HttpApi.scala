package jetty

import javax.ws.rs.{Path, Produces}
import jetty.web.JettyUtils._
import org.json4s.JsonAST._
import org.json4s.JsonDSL._
import javax.servlet.http.HttpServletRequest

@Path("/http/v1")
@Produces(value = Array("application/json"))
class HttpApi {

  val routes = Map[String, Responder[JValue]](
    "/preview" -> preview
  )

  private def preview: Responder[JValue] = (request: HttpServletRequest) => {
    ("status" -> "0") ~ ("value" -> "hello")
  }

}
