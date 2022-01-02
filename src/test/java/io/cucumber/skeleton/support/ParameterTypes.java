package io.cucumber.skeleton.support;

import io.cucumber.java.ParameterType;
import io.cucumber.skeleton.Person;

public class ParameterTypes {
    @ParameterType("Mike|Sean|Lucy")
    public Person person(String name){
        return new Person(name);
    }
}
