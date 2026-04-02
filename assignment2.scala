object Assignment2 {
    //Global variable
    //var g=1

    def addition(a:Int, b:Int): Int = {
        if(b==0) a //Base case, when b=0 addition done
        else if (b>0) addition(a+1, b-1) //Recursion As long b is not 0, a+1
        else addition(a-1, b+1) //Recursion when b is neg, a-1
    }
    def subtraction(a:Int, b:Int): Int = {
            addition(a,-b) //Recursion with addition a+(-b) == a-b
    }
    def multiplication(a:Int, b:Int): Int = {
        if(a==0 || b==0) 0 //Base case if neither is 0, return 0
        else if (b>0) addition(a, multiplication(a,b-1)) //Recursion add a+a as many times as b
        else -multiplication(a,-b) //Recursion using same as b>0 but returning negative in the end
    }
    def division (a:Int, b:Int): Int = {
        if(b==0) throw new ArithmeticException() //If b=0 error Zero division
        else if(a<b) 0 //Base case cannot divide (a-b) if a is smaller
        //Recursion
        else if (a<0 && b<0) division(-a,-b) //Both negative return positive answer
        //If one is negative return negative answer
        else if(a<0) -division(-a, b)
        else if(b<0) -division(a, -b)
        //a-b till a<b also keeping counter with 1+. In the end get the amount of time subtracted == division
        else 1+division(subtraction(a,b),b)
    }
    def factorial(a:Int): Int = {
        if(a<=1) 1 //Base case returns 1 for a<=1
        else a*factorial(a-1) //Recursion a*a-1, so we get 10*9*8*7...
    }

    def isPrime(a:Int): Boolean = {
        if(a<=1) false //Base case: if a smaller/equal to 1: false
        def isPrimeUntil(x:Int): Boolean = {
            if (x == 1) true //If x reaches 1 it means its prime
            else if (a % x == 0) false //If divisor is found it's false
            else isPrimeUntil(x - 1) //Recursion to test the next divisor
        }
        isPrimeUntil(a-1) //Recursion call test with a-1 (Biggest we need to divide is a-1)
    }


    def task7(): Unit = {
        //Recursion
        //Easy to understand (Divide&Conquer), uses more memory, worse for large iterations
        //Example addition method

        //Loops
        //Harder to understand, uses less memory, better for large iterations
        //Example for (n <- nums)
    }
    def task8(): Unit = {
        //Local variables are only usable inside the method they were defined
        //val l=2 This cannot be accessed outside this method
        //Global variables are usable all throughout the code
        //g=2 Global variable can be accessed by everywhere
    }

    def main(args: Array[String]): Unit={
        val a: Int = 5
        val b: Int = 0
        println(s"ADD is ${addition(a,b)}")
        println(s"SUB is ${subtraction(a,b)}")
        println(s"MUL is ${multiplication(a,b)}")
        try {
            println(s"DIV is ${division(a,b)}")
        } catch{
            case e: ArithmeticException => println("Error: DIV by 0")
        }
        println(s"FAC is ${factorial(a)}")
        println(s"PRI is ${isPrime(a)}")
        task7()
        task8()
    }
}
