package com.SpringIntro.ConstructorInjection.collection.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StackController {
   private Stack s;

//Stack s=new StackImpl(5);
    @Autowired
    public void StackController(Stack divi){
        //new StackImpl(5);
        s = divi;
    }

    @GetMapping("/stack/all")
    public String print() {
        return s.print();
    }
 // Path Parameter , we use @PathVariable

//    @PostMapping("/stack/push/{element}")
//    public String push(@PathVariable int element) {
//        String str=s.push(element);
////        if(str=="Stack Overflow"){
////            return new @ResponseStatus(.BAD_REQUEST);
////            //throw new ResourceException(HttpStatus.BAD_REQUEST, "My message");
////        }else {
//            return "Pushed Element : " + element;
//
//    }
    @PostMapping("/stack/push/{element}")
    public ResponseEntity push(@PathVariable int element){
        try {
            s.push(element);
            return ResponseEntity.ok().build();
       } catch (RuntimeException e) {
           return ResponseEntity.internalServerError().build();
       }
    }


 /*

    // Query Parameter , we use @RequestParam
    @GetMapping("/stack/push/")
    public String push(@RequestParam int element) {
        s.push(element);
        return "Pushed Element : " + element;
    }

*/

    @GetMapping("/stack/pop")
    public ResponseEntity pop() {
        try{
            s.pop();
            return ResponseEntity.ok().build();
        }catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/stack/peek")
    public int peek() {
        return s.peek();
    }
    @GetMapping("/stack/min")
    public String min() {
        return s.min();
    }

    @GetMapping("/stack/size")
    /*public ResponseEntity size(){
        return ResponseEntity.ok().build();
    }*/
    public int size(){
        return s.size();
    }

    @GetMapping("/stack/isFull")
    public ResponseEntity isFull(){
        return ResponseEntity.ok().build();
    }

}