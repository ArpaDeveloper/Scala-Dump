object assignment3 {

  //Task1
  //Parameters: List of Ints & Function[Int(input),Int(output)]
  //Return: List of Int
  def operateOnList(l: List[Int], f:Function[Int, Int]): List[Int] ={
    if(l.isEmpty) l //If empty return
    else f(l.head) :: operateOnList(l.tail,f)
    //Turn head to even, then recurse on the rest of the list
  }

  //Turn odd num to even num
  def oddToEven(x:Int): Int={
    if(x%2==0) x //Even if divided by 2
    else x+1 //Odd+1 results in even
  }

  //Task2
  //Parameters: List of Str & Function[Str(input),Str(output)]
  //Return: List of Str
  def filterAndMap(l: List[String], f1:Function[String,Boolean], f2:Function[String,String]): List[String]={
    if(l.isEmpty) l //If empty return
    else if(!f1(l.head)) filterAndMap(l.tail,f1,f2)
    //If head length < 6, drop it off & recurse
    else f2(l.head) :: filterAndMap(l.tail,f1,f2)
    //If head length >= 6, concat str & recurse
  }

  //Check if str length >= 6
  def greaterLength(s:String): Boolean={
    if (s.length >= 6) true
    else false
  }

  //Add string length to end of string
  def concat(s:String): String={
    s+s"${s.length}"
  }

  //Task3
  //Parameters: list of anytype & Function[Anytype(input),Anytype(output)]
  //Return: List of anytype
  def listTransformation[A,B](list: List[A], transformFunc:Function[A,B]): List[B] = {
    if(list.isEmpty) List.empty[B] //If empty return
    else transformFunc(list.head) :: listTransformation(list.tail,transformFunc)
    //Transform head & recurse
  }

  //Turn Str to its length (Int)
  def task1(s:String): Int={ //stringToLength
    s.length
  }
  //Turn Int to Double
  def task2(n:Int): Double={ //intToDouble
    val d:Double = n
    d
  }

  //Task4

  //Curried func to multiply 3 Ints
  def task3(a:Int)(b:Int)(c:Int): Int={ //curriedFunction
    a*b*c
  }

  //Partially applied func to multiply 2 Ints to constant of 2 using Curried func
  val task4 = task3(2) _ //partialAppliedFunction = curriedFunction(2) _
  //Another way of doing it
  //def task4(b:Int,c:Int): Int={
  //  curriedFunction(2)(b)(c)
  //}

  //Curried func
  //Works by taking one argument at time, then returning new func to be used with the next argument
  //It uses multiple func invocations back-to-back to get final result
  //Is defined like this test1(a)(b)(c) and called same way

  //Partially applied func
  //Is func where one || more of the parameters are already defined in the func
  //So, its partially applied
  //Is defined like test2=tes1(constant)_ and called test2(a)(b)


  def main(args: Array[String]): Unit= {
    //List examples
    val List1=List(1,2,3,4,5)
    val List2=List("VanHalen","Queen","GunsNRoses","Rainbow","Beatles","Kiss","Him")
    //Examples
    println(s"Operate on list: ${operateOnList(List1,oddToEven)}")
    println(s"Filter and Map: ${filterAndMap(List2,greaterLength,concat)}")

    println(s"List Transformation (String): ${listTransformation(List2,task1)}") //stringToLength
    println(s"List Transformation (Int): ${listTransformation(List1,task2)}") //intToDouble

    println(s"Curried func ex1: ${task3(1)(2)(3)}") //curriedFunction
    println(s"Curried func ex2: ${task3(4)(5)(1)}")
    println(s"Curried func ex3: ${task3(3)(6)(3)}")

    println(s"partially applied func ex3: ${task4(6)(3)}") //partialAppliedFunction
    println(s"partially applied func ex3: ${task4(1)(4)}")
    println(s"partially applied func ex3: ${task4(3)(10)}")

  }
}
