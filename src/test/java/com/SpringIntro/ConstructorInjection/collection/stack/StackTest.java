package com.SpringIntro.ConstructorInjection.collection.stack;

import com.SpringIntro.ConstructorInjection.collection.Stack.Stack;
import com.SpringIntro.ConstructorInjection.collection.Stack.StackImpl;
import com.SpringIntro.ConstructorInjection.collection.Stack.StackUsingQueue;
import com.SpringIntro.ConstructorInjection.collection.Stack.StackUsingQueueImpl;
import com.SpringIntro.ConstructorInjection.collection.queue.Queue;
import com.SpringIntro.ConstructorInjection.collection.queue.QueueImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    Stack stack;

    @BeforeEach
    void setUp(){
        Queue queuee = new QueueImpl();
        Queue stackUsingQueuee = new QueueImpl();
        stack = new StackUsingQueueImpl(queuee, stackUsingQueuee);
    }
    @ParameterizedTest
    @CsvSource({"2,3,5,6,6"})
    void StackUsingQueueImplPush(int input,int input2, int input3, int input4,int output){
        stack.push(input);
        stack.push(input2);
        stack.push(input3);
        stack.push(input4);
    //void StackUsingQueueImplPop(){
        int resultPop=stack.pop();
        assertEquals(resultPop,output);
    }
}
