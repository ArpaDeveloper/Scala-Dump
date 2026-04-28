package com.rockthejvm.assignment6

object assignment6 {

  //Task1
  def task1(l:List[Int]):List[Either[String,Int]]={
    //Map l to l1 with either int or error if not prime
    val l1:List[Either[String,Int]]=l.map(n=>lookingForPrimes(n))
    l1
  }

  def lookingForPrimes(a:Int):Either[String,Int]={
    if(a<=1) return Left("f") //Base case: if a smaller/equal to 1: false
    def isPrime(x:Int):Either[String,Int]={
      if (x==1) Right(a) //If x reaches 1 it means its prime
      else if (a%x==0) Left("f") //If divisor is found it's false
      else isPrime(x-1) //Recursion to test the next divisor
    }
    isPrime(a-1) //Recursion call test with a-1 (Biggest we need to divide is a-1)
  }

  //Task2
  case class Student(name:String,age:Int,grade:Option[Int])
  def task2(l:List[Student]):Double={
    val g1=l.flatMap(_.grade) //Flatmap does the filtering so no filter needed
    g1.sum/g1.size //Return avg
  }

  //Task3
  def task3(l:List[(Int,Int)]):String={ //Has to return String to be able to pass codegrade
    //Map tuple to list using task3 to either return error or a/b
    val l1=l.map{case(a,b)=>
      if(b==0) Left("f") //If b is 0 error, because division with 0 not allowed LEFT
      else Right(a/b) //Divide RIGHT
    }
    val (lef,rig)=l1.partition(_.isLeft)
    val sum=rig.foldLeft(0){(acc, e)=>
      acc+e.getOrElse(0)
    }
    sum.toString //Codegrade doesn't allow to have helper func or print Right
  }

  //Task4
  def task4(l:List[String]):Option[String]={
    val r={
      if (l.exists(_.toLowerCase.contains("error"))) None //If error is found
      else Some(l.mkString("")) //Concat everything
    }
    r
  }


  def main(args: Array[String]):Unit={
    //Task1
    val nums=List(1,2,17,38,22,69,420,97)
    val l = task1(nums)
    l.foreach(n=>println(n))

    //Task2
    val students=List(Student("M",22,Some(5)),
      Student("E",22,Some(3)),
      Student("B",22,None),
      Student("A",22,Some(4)),
      Student("C",18,Some(3)),
      Student("G",19,None)
    )
    println(s"AVG Grades of students is: ${task2(students)}")

    //Task3
    val lot = List((5,0),(2,2),(6,9),(0,4),(8,0))
    val sum = task3(lot)
    println(s"Partition sum is: ${sum}")

    //Task4
    val sl1=List("Kiss","VanHalen","HIM","Masayoshi Takanaka","DIO","Dire Straits")
    val sl2=List("I","don't","like","rock","error")
    println(task4(sl1))
    println(task4(sl2))
  }

}
