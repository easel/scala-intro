## Pure Functions

Takes parameters. Produce a result. 

```scala
scala> val input = "a test string"
input: String = a test string

scala> def myPureFunc(myParam: String): Int = myParam.length
myPureFunc: (myParam: String)Int

scala> myPureFunc(input)
res0: Int = 13

scala> myPureFunc(input)
res1: Int = 13
```



## Impure Functions
Takes parameters. Does something else (side effects). Produces a result. 

```scala
scala> val input = "a test string"
input: String = a test string

scala> var x = 0
x: Int = 0

scala> def mySideEffectingFunc(myParam: String): Int = {
     |   x += myParam.length
     |   x
     | }
mySideEffectingFunc: (myParam: String)Int

scala> mySideEffectingFunc(input)
res2: Int = 13

scala> mySideEffectingFunc(input)
res3: Int = 26
```



## Procedures

Takes Parameters. Does something else (side effects). No result.

```scala
scala> def myProc(myParam: String): Unit = println(s"hello world - $myParam")
myProc: (myParam: String)Unit

scala> myProc("it's a beautiful day")
hello world - it's a beautiful day
```



## Parameters can be passed by name

Takes parameters. Wraps them in a function. Re-evaluate's whenever used.

```scala
scala> def myParamFunc = { 
     |   println("getting parameter"); 
     |   "a string" 
     | }
myParamFunc: String

scala> def myFunc(myParam: String): String = { 
     |   println("executing myFunc"); 
     |   myParam 
     | }
myFunc: (myParam: String)String

scala> def myLazyFunc(myParam: => String): String = { 
     |   println("executing myLazyFunc"); 
     |   myParam; 
     | }
myLazyFunc: (myParam: => String)String

scala> myFunc(myParamFunc)
getting parameter
executing myFunc
res5: String = a string

scala> myLazyFunc(myParamFunc)
executing myLazyFunc
getting parameter
res6: String = a string
```



## Multiple Parameter Lists

```scala
scala> def myMultiFunc(myParam: String)(myOtherParam: Int): String = 
     |   s"$myParam:$myOtherParam"
myMultiFunc: (myParam: String)(myOtherParam: Int)String

scala> myMultiFunc("a string")(1)
res7: String = a string:1
```

Can be curried

```scala
scala> val mySingleFunc = myMultiFunc("a string")(_)
mySingleFunc: Int => String = <function1>

scala> mySingleFunc(1)
res8: String = a string:1
```



## Anonymous Functions

A function by another name?

```scala
scala> val x = (i: Int) => s"got $i" 
x: Int => String = <function1>

scala> x(1)
res9: String = got 1
```

As a block
```scala
scala> val x = { i: Int => 
     |   println("Doing some stuff")
     |   s"returning $i"
     | }
x: Int => String = <function1>

scala> x(1)
Doing some stuff
res10: String = returning 1
```

As a procedure
```scala
scala> {
     |   println("Doing some stuff")
     |   println("doing other stuff")
     | }
Doing some stuff
doing other stuff
```

