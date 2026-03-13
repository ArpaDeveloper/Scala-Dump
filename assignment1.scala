object assignment1 {
  def task1(): Unit={
    var a=10;
    val b=10;
    a=20;
    //b=20; //Immutable so throws error
  }

  def task2(): Unit={
    val bool=true
    val doubl=2.22
    val integ=1
    val str="I'm a string"
  }

  def task3(): Unit={
    val c01: Char='V'
    val c02: Char='i'
    val c03: Char='l'
    val c04: Char='j'
    val c05: Char='a'
    val c06: Char='n'
    val c07: Char='e'
    val lastName: String=""+c01+c02+c03+c04+c05+c06+c07+c06
  }

  def task4(): Unit={
    var age: Int = 22
    var text: String = s"I am learning Scala at the ${age} of years"
  }

  def task5(): Unit={
    //This is an expression. I prefer // (Scala, C) over # (Python)
  }

  def task6(): Unit={
    val a: Int = 1;
    if(a==1) 1
    else if(a==2) 2
    else if(a==3) 3
    else 0
  }

  def task7(): Unit={
    var firstName: String="John"
    var lastName: String="Smith"
    var fullName: String=firstName+" "+lastName
  }

  def task8(a:Int, b:Int): String={
    s"The sum of ${a} and ${b} is: ${a+b}"
  }

  def main(args: Array[String]): Unit={
    task1()
    task2()
    task3()
    task4()
    task6()
    task7()
    task8(1, 2)
  }
}
