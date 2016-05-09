## Variables

Immutable values don't change. Use them whenever possible

```scala
scala> val x = "a string"
x: String = a string

scala> x = "another string"
<console>:13: error: reassignment to val
       x = "another string"
         ^

scala> x
res0: String = a string
```

Mutable variables can change.

```scala
scala> var x = "a mutable string"
x: String = a mutable string

scala> x = "another string"
x: String = another string

scala> x
res1: String = another string
```



## Lazy Variables

Variables can be lazy. Not evaluated until used.

```scala
scala> val x = {
     |   println("defining x")
     |   1
     | }
defining x
x: Int = 1

scala> lazy val lazyX = {
     |   println("defining lazyX")
     |   1
     | }
lazyX: Int = <lazy>

scala> x
res2: Int = 1

scala> x
res3: Int = 1

scala> lazyX
defining lazyX
res4: Int = 1

scala> lazyX
res5: Int = 1
```



## Primitive Types

```scala
scala> val aChar = 'A'
aChar: Char = A

scala> val anInt = 1
anInt: Int = 1

scala> val aLong = 1L
aLong: Long = 1

scala> val aFloat = 1.0F
aFloat: Float = 1.0

scala> val aDouble = 1.0D
aDouble: Double = 1.0

scala> val aString = "A String"
aString: String = A String

scala> val aBoolean = false
aBoolean: Boolean = false

scala> val aUnit = ()              // no result
aUnit: Unit = ()
```

