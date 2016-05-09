# Data Structures



## Tuples
Fixed-size groups of un-named things.
```scala
scala> val x = ("aString", 1)
x: (String, Int) = (aString,1)

scala> x._1
res0: String = aString

scala> x._2
res1: Int = 1
```

Can be combined with pattern matching as a "destructuring bind"
```scala
scala> val (x, y, z) = (1, 2, "aString")
x: Int = 1
y: Int = 2
z: String = aString

scala> x
res2: Int = 1

scala> y
res3: Int = 2

scala> z
res4: String = aString
```



## Classes

Can be abstract.
```scala
scala> abstract class Vehicle {
     |   def name: String
     |   def maxSpeed: Int
     | }
defined class Vehicle
```

Can inherit from other classes.
```scala
scala> class Car(val name: String) extends Vehicle {
     |   val maxSpeed = 10
     | }
defined class Car
```



## Traits

Can provide implementations.

```scala
scala> trait Flyable {
     |   def maxAirSpeed: Int
     |   def maxGroundSpeed(windSpeed: Int): Int = maxAirSpeed - windSpeed
     | }
defined trait Flyable
```

Can be inherited
```scala
scala> class MyAirPlane(val maxAirSpeed: Int) extends Flyable
defined class MyAirPlane
```

Can be mixed in
```scala
scala> class MyAirCar(name: String) extends Car(name) {
     |   val maxAirSpeed = 100
     | }
defined class MyAirCar
```



## Instantiating Classes
Instantiating Concrete Types
```scala
scala> val myCar = new Car("honda")
myCar: Car = Car@33aa211
```

Can be instantiated anonymously
```scala
scala> val myAirplane = new Vehicle with Flyable {
     |   val name = "my airplane"
     |   val maxAirSpeed = 120
     |   override def maxSpeed = maxAirSpeed
     | }
myAirplane: Vehicle with Flyable{val name: String; val maxAirSpeed: Int} = $anon$1@6d403693

scala> val myBird = new Flyable { val maxAirSpeed = 100 }
myBird: Flyable{val maxAirSpeed: Int} = $anon$1@566eae10
```



## Singleton Objects
- There can only be one. Mostly. 
- Instantiated at JVM startup. 
- Replaces java static methods and classes.
- Makes a nice place to put pure functions

```scala
scala> object MySingleton {
     |   val name = "i am a singleton"
     | }
defined object MySingleton

scala> MySingleton.name
res5: String = i am a singleton
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

```scala
scala> case class MyCaseClass(a: Int, b: String)
defined class MyCaseClass

scala> val x = MyCaseClass(1, "a class") 
x: MyCaseClass = MyCaseClass(1,a class)
```

all members are public and immutable
```scala
scala> val y = x.a 
y: Int = 1

scala> x.a = 2
<console>:15: error: reassignment to val
       x.a = 2
           ^
```
copy method provided
```scala
scala> val x2 = x.copy(a=2) 
x2: MyCaseClass = MyCaseClass(2,a class)
```

value-wise comparisons for set membership and equality
```scala
scala> x == x2 
res6: Boolean = false

scala> val x3 = x2.copy(a=1)
x3: MyCaseClass = MyCaseClass(1,a class)

scala> x3 == x // values are now same
res7: Boolean = true
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
