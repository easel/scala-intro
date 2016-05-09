# Data Structures



## Tuples
Fixed-size groups of un-named things.
```tut
val x = ("aString", 1)
x._1
x._2
```

Can be combined with pattern matching as a "destructuring bind"
```tut
val (x, y, z) = (1, 2, "aString")
x
y
z
```



## Classes

Can be abstract.
```tut
abstract class Vehicle {
  def name: String
  def maxSpeed: Int
}
```

Can inherit from other classes.
```tut
class Car(val name: String) extends Vehicle {
  val maxSpeed = 10
}
```



## Traits

Can provide implementations.

```tut
trait Flyable {
  def maxAirSpeed: Int
  def maxGroundSpeed(windSpeed: Int): Int = maxAirSpeed - windSpeed
}
```

Can be inherited
```tut
class MyAirPlane(val maxAirSpeed: Int) extends Flyable
```

Can be mixed in
```tut
class MyAirCar(name: String) extends Car(name) {
  val maxAirSpeed = 100
}
```



## Instantiating Classes
Instantiating Concrete Types
```tut
val myCar = new Car("honda")
```

Can be instantiated anonymously
```tut
val myAirplane = new Vehicle with Flyable {
  val name = "my airplane"
  val maxAirSpeed = 120
  override def maxSpeed = maxAirSpeed
}

val myBird = new Flyable { val maxAirSpeed = 100 }
```



## Singleton Objects
- There can only be one. Mostly. 
- Instantiated at JVM startup. 
- Replaces java static methods and classes.
- Makes a nice place to put pure functions

```tut
object MySingleton {
  val name = "i am a singleton"
}

MySingleton.name
```



## Companion Objects
- Must be defined in the same file as their class.
- Included in implicit search
- Often used for "static" methods
- Provides `apply` and `unapply` method syntax sugar

```scala
class MyClass {
  import MyClass._
  var myState = 0
   
  def mutate: Unit = myState = mutateTheState(myState)
}

object MyClass {
  def mutateTheState(i: Int): Int = i * 2
  def apply(): MyClass = new MyClass()
}

val x = MyClass()
```



## Case Classes
"Product Types". Adds `apply`, `copy`, `hashcode` and `equals`. 

```tut
case class MyCaseClass(a: Int, b: String)
val x = MyCaseClass(1, "a class") 
```

all members are public and immutable
```tut
val y = x.a 
x.a = 2
```
copy method provided
```tut
val x2 = x.copy(a=2) 
```

value-wise comparisons for set membership and equality
```tut
x == x2 
val x3 = x2.copy(a=1)
x3 == x // values are now same
```



## Algebraic Data Types
"Sum Types". Typeful answer to enumerations, etc.

```scala
sealed trait VehicleType
object VehicleType {
  case object Airplane extends VehicleType
  case object Boat extends VehicleType
  case object Car extends VehicleType
  
  val All = Set(Airplane, Boat, Car)
}
val myVehicleType: VehicleType = VehicleType.Car
```
