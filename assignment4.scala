package com.rockthejvm.assignment4

object assignment4 {

  def task0():Unit={
    //Make list
    val nums=List(1,2,3,4,5)
    //Map every element's square (n*n) from nums to square
    val squares=nums.map(n=>n*n)
    println(s"Nums squares: ${squares}")
    //Filter every element of squares taking only those that divide by 2 (even)
    val evenSquares=squares.filter(n=>n%2==0)
    println(s"EvenSquares: ${evenSquares}")
    //Filter every element from nums taking only those that divide by 2 (even)
    //If you use Set(x) you get Set[List[Int]], you need to use x.toSet to get Set[Int]
    val evenSet:Set[Int]=nums.filter(n=>n%2==0).toSet
    println(s"Set of even from nums: ${evenSet}")
    //Use foldLeft to add all elements together to val sum. Same could be done with sum()
    val sum=evenSet.foldLeft(0)((total, element)=> total + element)
    println(s"Sum of even Set: ${sum}")
    //Use Zip method to put two lists together to one map. Source:
    //https://stackoverflow.com/questions/2189784/in-scala-is-there-a-way-to-take-convert-two-lists-into-a-map
    val squaresMap:Map[Int,Int]=(nums zip squares).toMap
    println(s"Map of nums+their squares: ${squaresMap}")
    //Use getOrElse to try to find 11, if not found return 0.
    println(s"Get eleven from squaresMap (0 if fails): ${squaresMap.getOrElse(11,0)}")
  }

  def removeDuplicates(strings:Seq[String]):Seq[String]={
    //Start by giving foldLeft empty Seq[String]
    strings.foldLeft(Seq.empty[String])((strings,current)=>
    if(strings.contains(current)){ //If current is in strings(new seq we are building) skip
      strings
    }else{ //If current is not in add it in
      strings:+current
    }
    )
  }

  def findCommonElements[A](set1:Set[A], set2:Set[A]):Set[A]={
    set1&set2 //Return intersection of two sets
    //I was already familiar with set, because I have done a LeetCode problem,
    //where returning the intersection of two sets was a solution.
  }

  def removeKeys(m:Map[String,String],l:List[String]):Map[String,String]={
    m--l
    //Easiest way to achieve this is by -- method. I found this from:
    //https://stackoverflow.com/questions/72195316/how-to-remove-key-value-from-map-when-keys-are-store-in-list-in-scala
  }

  def task4(filename:String):Map[String, Int]={
    //I had no idea how to read from file in scala,So I found info from:
    //https://stackoverflow.com/questions/1284423/read-entire-file-in-scala
    //https://docs.scala-lang.org/

    //Source file
    if(filename==null) return Map.empty
    val source=scala.io.Source.fromFile(filename)
    //Read whole file and then split it to words/case-insensitive
    val words=source.mkString
      .split("\\W+") //Removes punctuation and other stuff
      .map(_.toLowerCase) //Case-insensitive
      .sorted //Sort to get alphabetical order
    //Close file
    source.close()
    //Iterate through words using foldLeft
    //Map every word and their frequency
    //If getOrElse finds the word change the freq, else increment the word freq 1
    //Then map.updated changes it
    val wordCount=words.foldLeft(Map.empty[String,Int]){
      (map,word)=>map.updated(word,map.getOrElse(word,0)+1)
    }
    //Print all the words+their count once
    //words.distinct.foreach {word=>println(f"$word ${wordCount(word)}")}
    //Return map
    wordCount
  }

  def main(args: Array[String]): Unit= {
    //Examples
    val strings=Seq("hello", "world", "hello", "scala", "world");
    val set1=Set(1,2,3,4,5)
    val set2=Set(3,4,5,6,7)
    val list1=List("2","4","7")
    val map1:Map[String,String]= Map(
      "1"->"VanHalen",
      "2"->"Kiss",
      "3"->"HIM",
      "4"->"Beatles",
      "5"->"Rainbow",
      "6"->"Europe",
      "7"->"ACDC"
    )
    val filename="file.txt"
    //Method calls
    task0()
    println(s"Remove duplicates: ${removeDuplicates(strings)}")
    println(s"Common Elements: ${findCommonElements(set1,set2)}")
    println(s"Remove keys: ${removeKeys(map1,list1)}")
    task4(filename)
  }
}
