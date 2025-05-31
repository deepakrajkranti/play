package com.starter.play.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ProfileConfiguration {
//if you want to set up differnt profile then edit congiration in intellij and set active profile to dev/test/prod
//your new profile will be active and no click run it will run with that profile
    @Bean
    public String devBean() {
        System.out.println("Development profile bean created");
        return "This is a development profile bean";
    }
}
