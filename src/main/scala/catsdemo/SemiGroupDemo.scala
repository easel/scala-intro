package catsdemo

import cats._
import cats.implicits._

/**
  * http://eed3si9n.com/herding-cats/Semigroup.html
  */
object SemiGroupDemo {
  case class MyThing(b: Int)
  
  object MyThing {
    implicit val myThingSemiGroup = new Semigroup[MyThing] {
      override def combine(x: MyThing, y: MyThing): MyThing = MyThing(x.b + y.b)
    }
  }
  
  def main(args: Array[String]) = {
    val a = MyThing(1)
    val b = MyThing(2)
    // a + b not defined
    // a ++ b not defined
    val c = a |+| b // defined via semigroup instance
    println(s"$a |+| $b = $c")
  }
}
