package com.SpringIntro.ConstructorInjection.collection.coding;

import com.SpringIntro.ConstructorInjection.collection.Stack.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static java.lang.Integer.parseInt;

@Component
public class CodingImpl implements Coding {
    String str = "";
    int[] array;

    private Stack resultStack;

    private Stack tempStack;

    private Stack braceStack;

    HashMap<Integer,Integer> cache;

    @Autowired
    public CodingImpl(Stack stack, Stack instance, Stack brace) {
        this.str = "";
        array = new int[]{};
        resultStack = stack;
        tempStack = instance;
        braceStack = brace;
        cache = new HashMap();
        cache.put(0,1);
        cache.put(1,1);
    }

    @Override
    public String stringBracesAndDotesRecursion(String str) {
        if (str.length() == 1) {
            return "[.]";
        }
        return "[" + str.charAt(0) + "]" + stringBracesAndDotesRecursion(str.substring(1));
    }


    @Override
    public int sumOfNumbers(int n) {
        if (n == 1) {
            return n;
        }
        int sum = sumOfNumbers(n - 1) + n;
        return sum;
    }

    @Override
    public int factorial(int n) {
        if (n == 1) {
            return n;
        }
        int fact = factorial(n - 1) * n;
        return fact;
    }

    @Override
    public String palindrome(String str) {
        return palindrome(str, 0, str.length() - 1);
    }

    private String palindrome(String str, int start, int end) {
        if (start > end) {
            return "Palindrome";
        }
        return str.charAt(start) == str.charAt(end) ? palindrome(str, ++start, --end) : "Not Palindrome" ;
    }

    @Override
    public int fibonocii(int number){
        if(number ==0 || number ==1){
            return 1;
        }
       return fibonocii(number - 1) + fibonocii(number - 2);
    }


    private int fibonocii_cache(int number){
        System.out.println("Computing for "+number);
        if(number ==0 || number ==1){
            return 1;
        }
        int  number2 = cache.get(number - 2) == null ? fibonocii_cache(number - 2) : cache.get(number - 2);
        int number1 = cache.get(number - 1) == null ? fibonocii_cache(number - 1) : cache.get(number - 1);
        int result = number1 + number2;
        cache.put(number, result);
        return result;
    }

    @Override
    public int fibnonociiHashing(int input){
        return fibonocii_cache(input);
    }


    public String binarySearchRecursion(int[] array, int first, int last, int searchElement) {
        int mid = (first + last) / 2;
        if (first <= last) {
            if (array[mid] == searchElement) {
                return "Element Found";
            } else if (searchElement < array[mid]) {
                last = mid - 1;
                return binarySearchRecursion(array, first, last, searchElement);
            } else {
                first = mid + 1;
                return binarySearchRecursion(array, first, last, searchElement);
            }
        } else {
            return " Element Not Found";
        }
    }


    @Override
    public String binarySearchRecursionMethod(int[] array, int searchElement){
        return binarySearchRecursion(array, 0, array.length-1, searchElement);
    }

    @Override
    public String stringReverse_Recursion(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 1) {
            return str;
        }
        return stringReverse_Recursion(str.substring(1)) + str.charAt(0);
    }

    @Override
    public String printNumbersTailRecursive(int n) {
        return printRecursive(10);
    }

    public String printRecursive(int n) {
        if (n == 1)
            return "1";
        String returned = printRecursive(n - 1);
        return returned + " " + n;
    }

    @Override
    public String binarySearchIterative(int[] array, int searchElement) {
        //sortArrayUsingStack(array);
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (searchElement == array[mid]) {
                return "Element found at " + mid;
            } else if (searchElement < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return "Element not found!";
    }


    @Override
    public String checkIfBalancedupdated(String str) {
        resultStack.clear();
        char[] stringArray = str.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == '[' || stringArray[i] == '(' || stringArray[i] == '{') {
                resultStack.push(stringArray[i]);
                resultStack.print();
            } else if (stringArray[i] == '}') {
                if (resultStack.peek() == 123) {
                    resultStack.pop();
                } else {
                    return "Not Balanced - {";
                }
            } else if (stringArray[i] == ')') {
                if (resultStack.peek() == 40) {
                    resultStack.pop();
                } else {
                    return "Not Balanced - (";
                }
            } else if (stringArray[i] == ']') {
                if (resultStack.peek() == 91) {
                    resultStack.pop();
                } else {
                    return "Not Balanced - [";
                }
            }
        }
        if (resultStack.size() == 0) {
            return "Balanced";
        } else {
            resultStack.print();
            return "Not Balanced";
        }
    }

    @Override
    public boolean checkIfBalancedParenthesis(String str) {
        resultStack.clear();
        char[] stringArray = str.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == '(') {
                resultStack.push(stringArray[i]);
            } else {
                resultStack.pop();
            }
        }
        return resultStack.size() == 0;
    }

    @Override
    public String sortArrayUsingStack(int[] array) {
        resultStack.clear();
        int arrLength = array.length;
        for (int i = 0; i < arrLength; i++) {
            if (resultStack.size() == 0) {
                resultStack.push(array[i]);
            } else {
                if (array[i] < resultStack.peek()) {
                    int elements = resultStack.size();
                    for (int j = 0; j < elements; j++) {
                        if (array[i] < resultStack.peek()) {
                            tempStack.push(resultStack.pop());
                        }
                    }
                    resultStack.push(array[i]);
                    elements = tempStack.size();
                    for (int j = 0; j < elements; j++) {
                        resultStack.push(tempStack.pop());
                    }
                } else {
                    resultStack.push(array[i]);
                }
            }
        }
        return resultStack.print();
    }

    @Override
    public String reverseString(String input) {
        resultStack.clear();
        if (input == null) {
            return null;
        }
        char[] stringArray = input.toCharArray();
        System.out.println(stringArray);
        String reverseString;
        int arrayLength = stringArray.length;
        for (int i = 0; i < arrayLength; i++) {
            resultStack.push(stringArray[i]);
        }
        System.out.println(resultStack.print());
        int i = 0;
        for (int j = resultStack.size(); j > 0; j--) {
            stringArray[i] = (char) resultStack.pop();
            i++;
        }
        System.out.println(stringArray);
        reverseString = new String(stringArray);
        return reverseString;
    }

}
