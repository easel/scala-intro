# Control Flow
- Everything is an expression.
- Sometimes that expression returns a Unit 



## If / Then Conditionals
```tut
val x = if(1 == 1) "true" else "false"
```

## While / Do Loops

```tut
var i = 0
val x = while(i < 2) { println(i); i += 1 }

do { println(i); i += 1 } while (i < 4)
```



## Pattern Matching
```tut
val thingToCheck = "my string"
val x = thingToCheck match {
  case x: String => s"was a string of length ${x.length}"
  case _ => "was not a string"
}
```



## For comprehensions
```tut
for (i <- 0 to 1) println(i)
for (i <- 0 until 1) println(i)
for (i <- Seq("aString", "bString")) println(i)

for (a <- Option.empty[String]; b <- Option("bString")) println(a+b) 

for (a <- Option("aString"); b <- Option("bString")) println(a+b)
```



//## Exception Handling
