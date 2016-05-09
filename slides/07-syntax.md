# Syntax Details

## Semicolons can replace newlines
```scala
scala> val x = Seq(1, 2)
x: Seq[Int] = List(1, 2)

scala> val y = Seq(3, 4); val z = Seq(5,6)
y: Seq[Int] = List(3, 4)
z: Seq[Int] = List(5, 6)
```



## Infix form
### If there is a single parameter to a function, . and () can be dropped
```scala
scala> object A { def myFunc(a: String) = a.length }
defined object A

scala> val a = A.myFunc("a string") 
a: Int = 8

scala> val b = A myFunc "a string"
b: Int = 8
```

### When using "infix", beware of operator precedence
```scala
scala> A.myFunc("a string") == A.myFunc("a string")
res0: Boolean = true

scala> A myFunc "a string" == A.myFunc("a string")
<console>:14: error: type mismatch;
 found   : Boolean
 required: String
       A myFunc "a string" == A.myFunc("a string")
                           ^
```



## Sometimes a single infix parameter might be an anonymous function
```scala
scala> val a = A.myFunc({
     |   println("I'm preparing the function parameter")
     |   "a string"
     | })
I'm preparing the function parameter
a: Int = 8

scala> val b = A.myFunc {
     |   println("I'm preparing the function parameter")
     |   "a string"
     | }
I'm preparing the function parameter
b: Int = 8
```

