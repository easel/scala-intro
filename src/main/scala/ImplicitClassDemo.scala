object ImplicitClassDemo {
  implicit class MyRichString(s: String) {
    def obfuscate: String = s.replace("e", "z")
  }
  
  def main(args: Array[String]): Unit = {
    val s1 = "My test string"
    println(s"Obfuscating '$s1' results in '${s1.obfuscate}'")
  }

}
