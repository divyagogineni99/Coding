package com.SpringIntro.ConstructorInjection.Spring;

import com.SpringIntro.ConstructorInjection.Spring.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// This should be written in application.properties files for lazy implementation
// "spring.main.lazy-initialization=true"

@RestController
public class DemoController {
    //define a private field for dependency

    /*private Coach myCoach;
    private Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        //System.out.println("In contructor : " + theCoach.hashCode() +"::::"+ anotherCoach.hashCode());
        System.out.println("In contructor : " +getClass().getSimpleName());
        myCoach= theCoach;
        anotherCoach = theAnotherCoach;
    }*/

    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        //System.out.println("In constructor : " + theCoach.hashCode() +"::::"+ anotherCoach.hashCode());
        System.out.println("In constructor : " +getClass().getSimpleName());
        myCoach= theCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    /* // check if this is same bean
    //by default SINGLETON scope, hence (myCoach == anotherCoach) returns true
    // if the scope is PROTOTYPE, (myCoach == anotherCoach) returns false
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach = anotherCoach " + (myCoach == anotherCoach) ;
    }
    */
}
