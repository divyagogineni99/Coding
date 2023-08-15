package com.SpringIntro.ConstructorInjection.collection.queue;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class QueueImpl implements Queue{
    public int[] array;
    public int capacity;
    public int top;
    public int last;
    public int lookupElement;

    public QueueImpl(){
        this.capacity=5;
        this.top=0;
        this.last=0;
        this.array =new int[capacity];
    }


    @Override
    public int dequeue() {
        if(last==0){
            //System.out.println("In dequeue if");
            throw new RuntimeException("queue is Empty");
        }
        int temp=array[0];
        for(int i=0;i<last-1;i++) {
            array[i] = array[i + 1];
        }
        //array[last-1]= 0;
        last--;
        return temp;
    }

    @Override
    public String enqueue(int element) {
        if(last>=capacity){
            throw new RuntimeException("queue is Full");
        }
        array[last++]=element;
        return " Element added :" + array[last];
    }

    @Override
    public String peek() {
        System.out.println(" Top Element : " +array[top]);
        return " Top Element : " +array[top];

    }

    @Override
    public String lookup(int lookupElement) {
        if(lookupElement<=last) {
            System.out.println("Element is : " + array[lookupElement-1]);
            return " Element is : " + array[lookupElement-1];
        }else{
            throw new RuntimeException("No Element");
        }
    }

    @Override
    public String print(){
        String result = "";
        for(int i=0;i<last;i++){
            result = result  + array[i] + " -> ";
        }
        if(result.isEmpty()){
            return "Empty queue";
        }
        return result;
    }

    @Override
    public int size() {
        return last;
    }

    @Override
    public boolean isFull() {
        if (last+1 == capacity) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void clear() {
        try {
            while(true) {
                dequeue();
            }
        } catch (Exception e) {

        }
    }
}
