package catsdemo

import cats.data.Xor

/**
  * http://typelevel.org/cats/
  * https://www.manning.com/books/functional-programming-in-scala
  * http://eed3si9n.com/herding-cats/
  */
class DataTypesDemo {
  
  // Will be deprecated in favor of either
  val x: Xor[String, Int] = Xor.left("error")
  val y: Xor[String, Int] = Xor.right(1)
  
  

}
