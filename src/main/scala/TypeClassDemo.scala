/**
  * Created by erik on 7/20/16.
  */
object SubType {

  trait Vehicle {
    def name: String

    def copy(name: String): Vehicle
  }

  class Car(val name: String) extends Vehicle {
    val wheels = 2

    def copy(name: String): Car = new Car(name)
  }

  class Plane(val name: String) extends Vehicle {
    val wings = 2

    def copy(name: String): Plane = new Plane(name)
  }

  def main(): Unit = {
    val car1: Car = new Car("my car")
    val car2: Car = car1.copy("my other car")
    println(s"${car2.name} = ${car2.getClass.getSimpleName} ")
    val car3: Vehicle = car1.copy("my car vehicle")
    val plane: Plane = new Plane("my plane")
    println(s"${car2.name} has ${car2.wheels} wheels")
    println(s"${car3.name} = ${car3.getClass.getSimpleName} ")
    println(s"${plane.name} = ${plane.getClass.getSimpleName} ")
    val x: Seq[Vehicle] = Seq(car1, car2, car3, plane)
  }

  //  def pluralize[A <: Vehicle](a: A): A = {
  //    a.copy(a.name + "s")
  //  }

}

object FBoundedPolyMorphism {

  trait Vehicle[A <: Vehicle[A]] {
    def name: String

    def copy(name: String): A
  }

  class Car(val name: String) extends Vehicle[Car] {
    val wheels = 2

    override def copy(name: String): Car = new Car(name)
  }

  class Plane(val name: String) extends Vehicle[Plane] {
    val wings = 2

    override def copy(name: String): Plane = new Plane(name)
  }
  
  class Hovercraft(name: String) extends Plane(name)

  def pluralize[A <: Vehicle[A]](a: A): A = {
    a.copy(name = a.name + "s")
  }

  def main(): Unit = {
    // val car1: Vehicle = new Car("my car") // doesn't compile
    val car1: Car = new Car("my car")
    val car2: Car = car1.copy("my other car")
    println(s"${car2.name} has ${car2.wheels} wheels")
    println(s"${car2.name} = ${car2.getClass.getSimpleName} ")
    val plane1: Plane = new Plane("my plane")
    val plane2: Plane = plane1.copy("my other plane")
    println(s"${plane2.name} has ${plane2.wings} wings")
    println(s"${plane2.name} = ${plane2.getClass.getSimpleName} ")
    val hover1: Hovercraft = new Hovercraft("my hovercraft")
    val hover2 = hover1.copy("my other hovercraft")
    println(s"${hover2.name} = ${hover2.getClass.getSimpleName} ")
  }
}

object TypeClass {

  trait Vehicle {
    def name: String
  }

  trait Copy[A] {
    def copy(a: A, newName: String): A
  }

  case class Car(name: String) extends Vehicle

  object Car {
    implicit val CarCopy = new Copy[Car] {
      def copy(a: Car, newName: String) = a.copy(newName)
    }
  }

  implicit class CopyOps[A](a: A)(implicit ev: Copy[A]) {
    def copy(newName: String) = ev.copy(a, newName)
  }

  def main(): Unit = {
    var car1: Car = new Car("my car")
    val car2: Car = car1.copy("new name")
    println(s"Car1 ${car1.name} is a ${car1.getClass.getSimpleName}")
    println(s"Car2 ${car2.name} is a ${car2.getClass.getSimpleName}")
  }
}

object Polymorphism extends App {
  println("SubTyping")
  SubType.main()
  println("F-Bounded PolyMorphism")
  FBoundedPolyMorphism.main()
  println("TypeClass")
  TypeClass.main()
  assert(false, "Assertions are enabled")
}
