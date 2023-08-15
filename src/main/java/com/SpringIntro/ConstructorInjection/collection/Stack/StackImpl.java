package com.SpringIntro.ConstructorInjection.collection.Stack;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StackImpl implements Stack{
        public int[] array;
        public int top;
        public int capacity;
        public int poppedElement;
        public int min;
//        public char[] charArray;
//        public char poppedCharecter=Character.MIN_VALUE;

    public StackImpl(){
        System.out.println("In constructor : " +getClass().getSimpleName());
            this.capacity=6;
            this.array = new int[capacity];
            this.top = 0;
            this.min=Integer.MAX_VALUE;
            //this.charArray=new char[capacity];
        }


//    @Override
//    public  char pushReverseString(char element){
//        if (top >= array.length) {
//            throw new RuntimeException("Stack overflow");
//        } else {
//            charArray[top] = element;
//            top++;
//        }
//        return  element;
//    }
//    @Override
//    public  char popReverseString(){
//        if(top<=0){
//            throw new RuntimeException("Zero Elements, Cannot pop");
//        }else {
//            top--;
//            poppedCharecter = charArray[top];
//        }
//        return poppedCharecter;
//    }

        @Override
        public String print(){
            String result = "";
            for(int i=top-1;i>=0;i--){
                result = result + " == " + array[i];
                System.out.println(array[i]);
            }
            return result;
        }

        @Override
        public int push(int element){
            if (top >= array.length) {
                throw new RuntimeException("Stack overflow");
            } else {
                array[top] = (char) element;
                top++;
                if (element < min) {
                    min = element;
                }
            }
            return element;
        }

        @Override
        public int pop() {
            if(top<=0){
                throw new RuntimeException("Zero Elements, Cannot pop");
            }else {
                top--;
                poppedElement = array[top];
                if (poppedElement == min) {
                     min = Integer.MAX_VALUE;
                    for (int i = top - 1; i >= 0; i--) {
                        if (array[i] < min) {
                            min = array[i];
                        }
                    }
                }
            }
            return poppedElement;
        }

        @Override
        public int peek() {
        if(top==0){
            return Integer.MAX_VALUE;
        }
            return  array[top-1];
        }

        @Override
        public String min() {
            return"Min Element : " + min;
        }

    @Override
    public int size() {
        System.out.println(top);
        return top;
    }

    @Override
    public boolean isFull() {
        if (top == capacity) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void clear() {
        try {
            while(true) {
                pop();
            }
        } catch (Exception e) {

        }
    }


}
