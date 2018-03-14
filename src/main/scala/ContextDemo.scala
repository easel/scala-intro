/**
  * Created by erik on 8/23/16.
  */
object ContextDemo {
  case class WorkContext(baseUrl: String, resourcePool: Seq[String])
  
  def getAResource(name: String)(implicit workContext: WorkContext) = {
    println(s"Getting ${workContext.baseUrl}/${name}")
  }
  
  def main(args: Array[String]) = {
    implicit val ctx = WorkContext("https://google.com/", Seq.empty)
    getAResource("doodle")
  }
}
