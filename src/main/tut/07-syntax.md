# Syntax Details

## Semicolons can replace newlines
```tut
val x = Seq(1, 2)
val y = Seq(3, 4); val z = Seq(5,6)
```



## Infix form
### If there is a single parameter to a function, . and () can be dropped
```tut
object A { def myFunc(a: String) = a.length }

val a = A.myFunc("a string") 
val b = A myFunc "a string"
```

### When using "infix", beware of operator precedence
```tut
A.myFunc("a string") == A.myFunc("a string")
A myFunc "a string" == A.myFunc("a string")
```



## Sometimes a single infix parameter might be an anonymous function
```tut
val a = A.myFunc({
  println("I'm preparing the function parameter")
  "a string"
})

val b = A.myFunc {
  println("I'm preparing the function parameter")
  "a string"
}
```

