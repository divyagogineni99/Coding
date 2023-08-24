package com.SpringIntro.ConstructorInjection.collection.coding;

import com.SpringIntro.ConstructorInjection.collection.Stack.StackImpl;
import com.SpringIntro.ConstructorInjection.collection.Stack.StackUsingQueueImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CodingController {
    private Coding s;

    @Autowired
    public CodingController(Coding ci) {
        s = ci;
    }

    @PostMapping("/questions/stack/balanced-parenthesis")
    public boolean check(@RequestParam("input") String input) {
        try {
            return s.checkIfBalancedParenthesis(input);
        } catch (RuntimeException e) {
            return false;
        }
    }

    @PostMapping("/questions/stack/sortArrayUsingStack")
    public String sortArrayUsingStack(@RequestParam("array") int[] array) {
        try {
            return s.sortArrayUsingStack(array);
        } catch (RuntimeException e) {
            return "Stack Overflow!";
        }
    }

    @PostMapping("/questions/stack/reverseString")
    public String reverseString(@RequestParam("input") String input) {
        try {
            return s.reverseString(input);
        } catch (RuntimeException e) {
            return "Stack Overflow or Stack is Null";
        }
    }


    @PostMapping("/questions/stack/checkIfBalancedupdated")
    public String checkIfBalancedupdated(@RequestParam("input") String input) {
        try {
            return s.checkIfBalancedupdated(input);
        } catch (RuntimeException e) {
            return "Not Balanced";
        }
    }

    @GetMapping("/questions/binarySearchIterative")
    public String binarySearchIterative(@RequestParam("array") int[] array,
                                        @RequestParam("searchElement") int searchElement){
        return s.binarySearchIterative(array,searchElement);
    }

    @GetMapping("/questions/printRecursion")
    public String printNumbersTailRecursive(){
       return s.printNumbersTailRecursive(10);
    }

    @GetMapping("/questions/stringReverse_Recursion")
    public String stringReverse_Recursion(@RequestParam("str") String str){
        return s.stringReverse_Recursion(str);
    }

    @GetMapping("/questions/stringBracesAndDotesRecursion")
    public String stringBracesAndDotesRecursion(@RequestParam("str") String str){
        return s.stringBracesAndDotesRecursion(str);
    }


    @GetMapping("/questions/sumOfNumbers")
    public int sumOfNumbers(@RequestParam("n") int n){
        return s.sumOfNumbers(n);
    }

    @GetMapping("/questions/factorial")
    public int factorial(@RequestParam("n") int n){
        return s.factorial(n);
    }

    @GetMapping("/questions/palindrome")
    public String palindrome(@RequestParam("input") String input){
        return s.palindrome(input);
    }

    @GetMapping("/questions/fibonocii")
    public long fibonocii(@RequestParam("n") int n){
        long before = System.currentTimeMillis();
        long result=s.fibonocii(n);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
        return result;
    }

    @GetMapping("/questions/fibnonociiHashing")
    public int fibnonociiHashing(@RequestParam("n") int n){
        long before = System.currentTimeMillis();
        int result = s.fibnonociiHashing(n);
        long after = System.currentTimeMillis();
        System.out.println("Hashing "+ (after - before));
        return result;
    }


    @GetMapping("/questions/binarySearchRecursionMethod")
    public String binarySearchRecursionMethod(@RequestParam("array") int[] array,
                                        @RequestParam("searchElement") int searchElement){
        return s.binarySearchRecursionMethod(array,searchElement);
    }

}
