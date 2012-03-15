package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def check = Action(parse.json) {
    request =>
      (request.body \ "coup").asOpt[String].map {
        coup =>
          Ok(Json.toJson(
            Map("noirs" -> "1", "blancs" -> "2")
          ))
      }.getOrElse {
        BadRequest("Missing parameter [coup]")
      }
  }

}