package jetty

import javax.ws.rs.{Path, Produces}
import jetty.web.JettyUtils._
import jetty.web.RouteApi
import org.json4s.JValue
import org.json4s.JsonAST._
import org.json4s.JsonDSL._

import javax.servlet.http.HttpServletRequest

/**
  http://localhost:8080/http/v1/preview
 */

@Path("/http/v1")
@Produces(value = Array("application/json"))
class HttpApi extends RouteApi{

  val PREVIEW_ACTION = "preview"

  override val basePath: String = "/http/v1"
  override val callMethodMap: Map[(String, String), HttpServletRequest => JValue] = Map(
    (POST_METHOD, PREVIEW_ACTION) -> preview
  )

  private def preview: Responder[JValue] = (request: HttpServletRequest) => {
    ("status" -> "0") ~ ("value" -> "hello")
  }

}
