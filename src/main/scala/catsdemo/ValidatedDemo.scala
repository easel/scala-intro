package catsdemo

import cats._
import cats.data._
import cats.implicits._

/**
  * Created by erik on 8/23/16.
  */
object ValidatedDemo {
  sealed abstract class Error extends Product with Serializable {
    def msg: String
  }
  object Error {
    case object Missing extends Error {
      val msg = "Input missing"
    }
    case class Impolite(msg: String) extends Error
  }
  
  def validateLength(input: String): Validated[Error.Missing.type, Int] = {
    if(input.length == 0) Validated.Invalid(Error.Missing)
    else Validated.Valid(input.length)
  }
  
  def validateRequest(input: String): Validated[Error.Impolite, String] = {
    input.split("please").toList match {
      case request :: rest :: Nil => Validated.Valid(request.trim)
      case _ => Validated.Invalid(Error.Impolite("You didn't say please"))
    }
  }

  case class ParsedRequest(length: Int, request: String)
  def validate(input: String): ValidatedNel[Error, ParsedRequest] = Apply[ValidatedNel[Error, ?]].map2(
    validateLength(input).toValidatedNel,
    validateRequest(input).toValidatedNel
  ) { 
    case (length, request) => 
      ParsedRequest(length, request)
  }
  
  /*
   * Validate(): Invalid(OneAnd(Missing,List(Impolite(You didn't say please))))
   * Validate(Show me the money!): Invalid(OneAnd(Impolite(You didn't say please),List()))
   * Validate(May I have some money please?): Valid(ParsedRequest(30,May I have some money ))
   */
  def main(args: Array[String]): Unit = {
    val emptyRequest = ""
    println(s"Validate($emptyRequest): ${validate(emptyRequest)}")
    val rudeRequest = "Show me the money!"
    println(s"Validate($rudeRequest): ${validate(rudeRequest)}")
    val politeRequest = "May I have some mone please?"
    println(s"Validate($politeRequest): ${validate(politeRequest)}")
  }

}
