package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import lu.ade.kata._


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

	val mastermind=new MasterMind(List("R","R","B","M"),List("R","V","J","B","M","O"))

  def check = Action(parse.json) {
    request =>
      (request.body \ "coup").asOpt[String].map {
		coup =>{
			val (noir,blanc)=mastermind.check(coup.split(",").toList)
          Ok(Json.toJson(
            Map("noirs" -> noir.toString, "blancs" -> blanc.toString)
          ))
		}
      }.getOrElse {
        BadRequest("Missing parameter [coup]")
      }
  }

}