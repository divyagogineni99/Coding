package com.SpringIntro.ConstructorInjection.collection.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stack/stackusingqueue/")
public class StackUsingQueueController {

    private StackUsingQueue stackQueue;

    @Autowired
    public StackUsingQueueController(StackUsingQueue myStackQueue){
        stackQueue=myStackQueue;
    }

    @PostMapping("push/{element}")
    public ResponseEntity push(@PathVariable int element){
        try{
            stackQueue.push(element);
            return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("pop")
    public ResponseEntity pop(){
        System.out.println(stackQueue.pop());
        return ResponseEntity.ok().build();
    }

    @GetMapping("all")
    public String print() {
        return stackQueue.print();
    }
}
