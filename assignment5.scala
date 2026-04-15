package com.rockthejvm.assignment5

object assignment5 {

  //Task1
  def sumRec[A](l:List[A])(implicit n:Numeric[A]):Option[Double]={
    l match {
      case Nil=>None //If list is empty
      case _=> //Else
        val sum=l.reduce((x,y)=>n.plus(x, y)) //Sum the elements of the list
        Some(n.toDouble(sum)/l.length) //Return avg
    }
  }

  //Wrapper func to call sumRec
  //I didn't know any other way to have task1 return option
  def task1[A](l: List[A])(implicit n: Numeric[A]): Double = {
    sumRec(l).getOrElse(throw new IllegalArgumentException("Empty list"))
  }

  //Task2
  abstract class Animal { //So called "Superclass"
    def makeSound: String
  }
  class Bird extends Animal { //All birds Tweet
    override def makeSound:String="Tweet"
  }
  class Mammal extends Animal { //All mammals roar
    override def makeSound:String="Roar"
  }
  //makeAllSounds
  def task2(a:List[Animal]):List[String]={
    //Return a list of the sounds the animals make by mapping sound in the place of animal
    a.map(Animal=>Animal.makeSound)
  }

  //Task3
  //Typeclass
  trait Sortable[A] {
    def sort(l:List[A]):List[A]
  }

  //Put e into sorted l
  def genericSortable[A](e:A, l:List[A])(implicit s:Sortable[A]):List[A]={
    //Place e in front if list empty or it should be there
    if (l.isEmpty||s.sort(List(e,l.head)).head==e)e::l
    else l.head::genericSortable(e,l.tail) //Else recurse e in the tail till you find spot
  }

  def sort[A](l:List[A])(implicit s:Sortable[A]):List[A]=l match {
    case Nil=>Nil //Empty
    case head::tail=>genericSortable(head,sort(tail)) //Recurse on tail and insert head at right pos
  }

  //Instances that will swap if not correct placement
  implicit val intS:Sortable[Int]=(l:List[Int])=>
    if(l.isEmpty||l.head<=l.tail.head)l //Right place
    else List(l.tail.head,l.head) //Swap

  implicit val doubleS:Sortable[Double]=(l:List[Double])=>
    if(l.isEmpty||l.head<=l.tail.head)l
    else List(l.tail.head,l.head)

  implicit val strS:Sortable[String]=(l:List[String])=>
    if(l.isEmpty||l.head<=l.tail.head)l
    else List(l.tail.head,l.head)

  //Wrapper func to pass codegrade
  def task3[A](l:List[A])(implicit s:Sortable[A]):List[A]={
    sort(l)
  }

  //Task4
  def isPalindrome(s:String):Boolean={
    s match {
      case _ if s.length<=1=>true //When the string is smaller/equal to 1 we know it matches
      case _ if s.head!=s.last=>false //If no match return false
      case _ =>isPalindrome(s.tail.init) //recurse without first&last
    }
  }


  def main(args: Array[String]): Unit= {
    //List/parametres
    val ints:List[Int]=List(1,2,3,4,5,6)
    val floats:List[Float]=List(1,2,3,4,5,7)
    val doubles:List[Double]=List(1.0,2.0,3.0,4.0,5.0,6.0)
    val animals:List[Animal]=List(new Bird, new Bird, new Mammal)
    val nums:List[Int]=List(69,24,7,22,666)
    val strs:List[String]=List("HIM","SCORPIONS","BEATLES","DIO","RAINBOW","VANHALEN","DIRE STRAITS")

    //Task1
    println(s"Average of ints: ${task1(ints)}")
    println(s"Average of floats: ${task1(floats)}")
    println(s"Average of doubles: ${task1(doubles)}")
    //Task2
    println(s"Sounds of animals: ${task2(animals)}")

    //Task3
    println(s"Sorted ints: ${task3(nums)}")
    println(s"Sorted strs: ${task3(strs)}")

    //Task4
    val s1:String="rotator"
    val s2:String="Scala"
    println(s"S1 Palindrome is: ${isPalindrome(s1)}")
    println(s"S2 Palindrome is: ${isPalindrome(s2)}")


  }

}
