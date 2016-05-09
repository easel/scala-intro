# Types

## Can be Inferred

```scala
scala> val x = 1
x: Int = 1
```

## Can be Ascribed

```scala
scala> val x: Long = 2
x: Long = 2

scala> val y = 2:Long
y: Long = 2
```

## Can be Aliased

```scala
scala> type MyLong = Long
defined type alias MyLong

scala> val x: MyLong = 2
x: MyLong = 2
```



## Type Hierarchy
![Scala Class Hierarchy](scala-class-hierarchy.png)



## Primitive Types

```scala
scala> val aChar = 'A'
aChar: Char = A

scala> val aString = "A String"
aString: String = A String

scala> val aByte = 1:Byte
aByte: Byte = 1

scala> val aShort = 1:Short
aShort: Short = 1

scala> val anInt = 1
anInt: Int = 1

scala> val aLong = 1L
aLong: Long = 1

scala> val aFloat = 1.0F
aFloat: Float = 1.0

scala> val aDouble = 1.0D
aDouble: Double = 1.0

scala> val aBoolean = false
aBoolean: Boolean = false

scala> val aUnit = ()    
aUnit: Unit = ()
```


## Packages
## Import
## Type Parameters
## Abstract Types
## Higher-Kinded Types
