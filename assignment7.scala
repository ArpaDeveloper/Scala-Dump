package com.rockthejvm.assignment7

import scala.annotation.tailrec

object assignment7 {
  
  //Task1 sumList
  @tailrec def sumLists(l1:List[Int],l2:List[Int]):Int={
    if(l2.isEmpty) l1.sum //When everything is added from l2 to l1 return sum
    else {
      //Add l2 head to l1 head
      val sl=l1.head+l2.head::l1.tail
      sumLists(sl,l2.tail)
    }
  }

  //Task2 concatUnlessError
  def concatUnlessError(l:List[String]):Option[String]={
    val r={
      if (l.exists(_.toLowerCase.contains("error"))) None //If error is found
      else Some(l.mkString("")) //Concat everything
    }
    r
  }

  //Task3 Reflection on functional programming
  //+Code can be reused to greater extent (More modular). Always positive.
  //+Code is actually quite clean. Not too much extra stuff or variables. (Readability)
  //-Can't use loops. Loops are so useful in many cases and the fact that they are not usable is pain.
  //-Harder to understand, because recursion is harder in my mind than loops.
  //-Sometimes feel that kind of "ivory tower" like,
  //because the purist version of functional programming feels like a hassle to implement

  def main(args: Array[String]):Unit={
    //Task1
    val n1=List(1,2,17,38,22,69,420,97)
    val n2=List(6,6,6,42,0,17,38)
    val sum=sumLists(n1,n2)
    println(s"Tailrec sum is: ${sum}")

    //Task2
    val sl1=List("Kiss","VanHalen","HIM","Rainbow","DIO","DireStraits")
    val sl2=List("I","don't","like","rock","error")
    println(concatUnlessError(sl1))
    println(concatUnlessError(sl2))
  }
}
