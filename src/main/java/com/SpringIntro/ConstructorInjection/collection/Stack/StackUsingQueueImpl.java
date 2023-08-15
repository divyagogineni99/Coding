package com.SpringIntro.ConstructorInjection.collection.Stack;

import com.SpringIntro.ConstructorInjection.collection.queue.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class StackUsingQueueImpl implements StackUsingQueue {

    private Queue resultQueue;
    private Queue tempQueue;
    int poppedElement;

    @Autowired
    public StackUsingQueueImpl(Queue myQueue, Queue theQueue) {
        this.resultQueue = myQueue;
        this.tempQueue = theQueue;
    }

    @Override
    public int push(int element) {
        resultQueue.enqueue(element);
        System.out.println("Pushed Element : " + element);
        return element;
    }

    @Override
    public int pop() {
            int resultQueueSize = resultQueue.size();
            for (int i = 0; i < resultQueueSize; i++) {
                if (i == resultQueueSize - 1) {
                    break;
                }
                tempQueue.enqueue(resultQueue.dequeue());
            }
            poppedElement = resultQueue.dequeue();
            int tempQueueSize = tempQueue.size();
            for (int i = 0; i < tempQueueSize; i++) {
                resultQueue.enqueue(tempQueue.dequeue());
            }
        System.out.println("poppedElement : " + poppedElement);
        return poppedElement;
    }

    @Override
    public int size() {
        return resultQueue.size();
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }


    @Override
    public int peek() {
        return 0;
    }

    @Override
    public String min() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String print() {
        return resultQueue.print();
    }

    @Override
    public void clear() {
        resultQueue.clear();
    }
}
