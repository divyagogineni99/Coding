package com.SpringIntro.ConstructorInjection.collection.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QueueController {
    private Queue myQueue;
@Autowired
    public QueueController(Queue theQueue) {
        myQueue = theQueue;
    }
    @DeleteMapping("/queue/dequeue")
    public ResponseEntity dequeue() {
        try {
            myQueue.dequeue();
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/queue/enqueue/{element}")
    public ResponseEntity enqueue(@PathVariable int element) {
        try {
            myQueue.enqueue(element);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/queue/peek")
    public ResponseEntity peek() {
        myQueue.peek();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/queue/lookup/")
    public ResponseEntity lookup(@RequestParam int lookupElement) {
        //myQueue.lookup(lookupElement);
        try {
            myQueue.lookup(lookupElement);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
           return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/queue/print")
    public String print() {
        return myQueue.print();
    }

    @GetMapping("/queue/size")
    public ResponseEntity size(){
        return ResponseEntity.ok().build();
    }


    @GetMapping("/queue/isFull")
    public ResponseEntity isFull(){
        return ResponseEntity.ok().build();
    }
}
