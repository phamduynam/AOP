package com.in28minutes.springboot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.in28minutes.springboot.aspect")
public class ConfigAOP {

}
