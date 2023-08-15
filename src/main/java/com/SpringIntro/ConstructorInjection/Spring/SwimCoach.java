package com.SpringIntro.ConstructorInjection.Spring;

import com.SpringIntro.ConstructorInjection.Spring.Coach;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as warm up";
    }
}
