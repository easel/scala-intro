## Pure Functions

Takes parameters. Produce a result. 

```tut
val input = "a test string"
def myPureFunc(myParam: String): Int = myParam.length
myPureFunc(input)
myPureFunc(input)
```



## Impure Functions
Takes parameters. Does something else (side effects). Produces a result. 

```tut
val input = "a test string"
var x = 0
def mySideEffectingFunc(myParam: String): Int = {
  x += myParam.length
  x
}
mySideEffectingFunc(input)
mySideEffectingFunc(input)
```



## Procedures

Takes Parameters. Does something else (side effects). No result.

```tut
def myProc(myParam: String): Unit = println(s"hello world - $myParam")

myProc("it's a beautiful day")
```



## Parameters can be passed by name

Takes parameters. Wraps them in a function. Re-evaluate's whenever used.

```tut
def myParamFunc = { 
  println("getting parameter"); 
  "a string" 
}

def myFunc(myParam: String): String = { 
  println("executing myFunc"); 
  myParam 
}

def myLazyFunc(myParam: => String): String = { 
  println("executing myLazyFunc"); 
  myParam; 
}

myFunc(myParamFunc)
myLazyFunc(myParamFunc)
```



## Multiple Parameter Lists

```tut
def myMultiFunc(myParam: String)(myOtherParam: Int): String = 
  s"$myParam:$myOtherParam"

myMultiFunc("a string")(1)
```

Can be curried

```tut
val mySingleFunc = myMultiFunc("a string")(_)

mySingleFunc(1)
```



## Anonymous Functions

A function by another name?

```tut
val x = (i: Int) => s"got $i" 

x(1)
```

As a block
```tut
val x = { i: Int => 
  println("Doing some stuff")
  s"returning $i"
}
x(1)
```

As a procedure
```tut
{
  println("Doing some stuff")
  println("doing other stuff")
}
```

