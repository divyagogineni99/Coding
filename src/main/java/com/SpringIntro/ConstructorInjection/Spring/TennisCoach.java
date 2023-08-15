package com.SpringIntro.ConstructorInjection.Spring;

import com.SpringIntro.ConstructorInjection.Spring.Coach;
import org.springframework.stereotype.Component;
 @Component
    public class TennisCoach implements Coach {
     public TennisCoach(){
         System.out.println("In constructor : " + getClass().getSimpleName());
     }

        @Override
        public String getDailyWorkout() {
            return "Practise your backhand volley";
        }
    }

