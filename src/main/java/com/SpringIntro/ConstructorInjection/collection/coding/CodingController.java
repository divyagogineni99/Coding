package com.SpringIntro.ConstructorInjection.collection.coding;

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

}