package com.SpringIntro.ConstructorInjection.config;

import com.SpringIntro.ConstructorInjection.Spring.Coach;
import com.SpringIntro.ConstructorInjection.Spring.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
