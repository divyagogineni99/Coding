package com.SpringIntro.ConstructorInjection.collection;

import com.SpringIntro.ConstructorInjection.collection.Stack.Stack;
import com.SpringIntro.ConstructorInjection.collection.Stack.StackImpl;
import com.SpringIntro.ConstructorInjection.collection.coding.Coding;
import com.SpringIntro.ConstructorInjection.collection.coding.CodingImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CodingTest {

    Coding coding;
    @BeforeEach
    void setUp() {
        Stack stack = new StackImpl();
        Stack instance = new StackImpl();
        Stack brace = new StackImpl();
        coding = new CodingImpl(stack,instance, brace);
    }
    @ParameterizedTest
    @CsvSource({")(", "))(()", "())(", "()())()(",")()()()", "()))))",
            "))))))", ")))(((", "))()()(", ")))(("})

    void testExpectedException(String input) {

        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            Boolean result = coding.checkIfBalancedParenthesis(input);
            assertEquals(result, true);
        });

        Assertions.assertEquals("Zero Elements, Cannot pop", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"()()", "()", "((((()))))", "(()())", "()"})
    void balancedParenthesis(String input) {
        Boolean result = coding.checkIfBalancedParenthesis(input);
        assertEquals(result, true);
    }

    @Test
    void notBalancedParenthesis() {
        Boolean result = coding.checkIfBalancedParenthesis("(");
        assertFalse(result);
    }

   @Test
   void sortArrayUsingStack(){
        int[] array={2,-1,0};
        String result=coding.sortArrayUsingStack(array);
        assertEquals(result, " == 2 == 0 == -1");
   }

    @Test
    void sortArrayUsingStack1(){
        int[] array={};
        String result=coding.sortArrayUsingStack(array);
        assertEquals(result, "");
    }

    @Test
    void sortArrayUsingStack2(){
        int[] array={0};
        String result=coding.sortArrayUsingStack(array);
        assertEquals(result, " == 0");
    }

    @Test
    void sortArrayUsingStack3(){
        int[] array={1,2,3,4,5};
        String result=coding.sortArrayUsingStack(array);
        assertEquals(result, " == 5 == 4 == 3 == 2 == 1");
    }

    @Test
    void sortArrayUsingStack4(){
        int[] array={5,4,3,2,1};
        String result=coding.sortArrayUsingStack(array);
        assertEquals(result, " == 5 == 4 == 3 == 2 == 1");
    }


    @ParameterizedTest
    @CsvSource({"ab,ba", "aba,aba", "aaa,aaa", "divya,ayvid", "a,a",","})
    void reverseString(String input, String output){
        String result=coding.reverseString(input);
        assertEquals(result, output);
    }

    @ParameterizedTest
    @CsvSource({"[(],Not Balanced - [" , "[{(})],Not Balanced - {" , "[({}())],Balanced"})
    void checkIfBalancedupdated(String input, String output){
        String result=coding.checkIfBalancedupdated(input);
        assertEquals(result,output);
    }

    @Test
    void binarySearchIterative(){
        int[] binaryArray={1, 2, 3, 4, 5};
        int searchElement= 2;
        String result = coding.binarySearchIterative(binaryArray,searchElement);
        assertEquals(result,"Element found at 1");
    }


}
