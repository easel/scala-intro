## Variables

Immutable values don't change. Use them whenever possible

```tut
val x = "a string"
x = "another string"
x
```

Mutable variables can change.

```tut
var x = "a mutable string"
x = "another string"
x
```



## Lazy Variables

Variables can be lazy. Not evaluated until used.

```tut
val x = {
  println("defining x")
  1
}
lazy val lazyX = {
  println("defining lazyX")
  1
}
x
x

lazyX
lazyX
```


## Scope Rules
## Closures
