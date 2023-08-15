package com.SpringIntro.ConstructorInjection.Spring;

import com.SpringIntro.ConstructorInjection.Spring.Coach;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Scope is PROTOTYPE, new object instance for each injection

public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In constructor : " + getClass().getSimpleName());
    }
    /*
    // define init method
    @PostConstruct
    public void doMyStartupStuff(){
            System.out.println(" In doMyStartupStuff " + getClass().getSimpleName());
    }

    // define destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(" In doMyCleanupStuff " + getClass().getSimpleName());
    }
     */


    @Override
    public String getDailyWorkout() {
        return "Practise fast bowling for 15 minutes!!!";
    }
}
