package com.SpringIntro.ConstructorInjection.collection.leetCode;

import com.SpringIntro.ConstructorInjection.collection.leetCode.Leetcode;

import java.util.Stack;

public class LeetcodeImpl implements Leetcode {


    @Override
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if(str.charAt(i) =='}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            } else if(str.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if(str.charAt(i) == ']') {
                if ( !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
