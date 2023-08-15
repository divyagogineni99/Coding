package com.SpringIntro.ConstructorInjection.Spring;

import com.SpringIntro.ConstructorInjection.Spring.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach(){
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run hard for 3 miles";
    }
}
