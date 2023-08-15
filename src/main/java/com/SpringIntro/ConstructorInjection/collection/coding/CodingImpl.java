package com.SpringIntro.ConstructorInjection.collection.coding;

import com.SpringIntro.ConstructorInjection.collection.Stack.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Integer.parseInt;

@Component
public class CodingImpl implements Coding {
    String str = "";
    int[] array = new int[6];

    private Stack resultStack;

    private Stack tempStack;

    private Stack braceStack;
    @Autowired
    public CodingImpl(Stack stack,Stack instance, Stack brace) {
        this.str = "";
        array = new int[]{};
        resultStack = stack;
        tempStack= instance;
        braceStack=brace;
    }

    @Override
    public String binarySearchIterative(int[] array, int searchElement) {
        //sortArrayUsingStack(array);
        int low=0;
        int high=array.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(searchElement==array[mid]){
                return "Element found at " +mid;
            }else if(searchElement<array[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return " ";
    }


    @Override
    public String checkIfBalancedupdated(String str) {
        resultStack.clear();
        char[] stringArray = str.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == '[' || stringArray[i] == '(' || stringArray[i] == '{') {
                resultStack.push(stringArray[i]);
                resultStack.print();
            }else if(stringArray[i]=='}'){
                if(resultStack.peek()== 123){
                    resultStack.pop();
                }else{
                    return "Not Balanced - {";
                }
            }else if(stringArray[i]==')') {
                if (resultStack.peek() == 40) {
                    resultStack.pop();
                }else{
                    return "Not Balanced - (";
                }
            }else if(stringArray[i]==']') {
                if (resultStack.peek() == 91) {
                    resultStack.pop();
                }else{
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
    public String reverseString(String input){
        resultStack.clear();
        if(input==null){
            return null;
        }
        char[] stringArray = input.toCharArray();
        System.out.println(stringArray);
        String reverseString;
        int arrayLength=stringArray.length;
        for(int i=0;i<arrayLength;i++){
            resultStack.push(stringArray[i]);
        }
        System.out.println(resultStack.print());
        int i=0;
        for(int j= resultStack.size(); j>0;j--){
            stringArray[i]= (char) resultStack.pop();
            i++;
        }
        System.out.println(stringArray);
        reverseString= new String(stringArray);
        return reverseString;
    }

}
