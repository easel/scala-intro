/**
  * Created by erik on 8/24/16.
  */
object CurryDemo {
  
  def foo(bar: String, baz: String) = bar + baz
  
  type FooApplyResult = Function1[String, String]
  
  def fooApply(blah: String): (String) => String = { (s: String) => foo(blah, s)}

  def ASimpleFunction(a: String, b: Int) = s"$a $b"

  // doesn't compile
  val aPartiallyDefinedFunction = ASimpleFunction("a", _:Int)
  
  val anotherPartiallyFunction = ASimpleFunction(_: String, 1)
  
  val aThirdPartiallyDefinedFunction = ASimpleFunction(_: String, 1)

  // also known as aprtially
  def ACurryAbleFunction(a: String)(b: Int) = s"$a $b"

  val ACurriedFunction = ACurryAbleFunction("my string")(_)

  def main(args: Array[String]): Unit = {
    ACurriedFunction(1)
    aPartiallyDefinedFunction(1)
    aThirdPartiallyDefinedFunction("my string")
  }

}
