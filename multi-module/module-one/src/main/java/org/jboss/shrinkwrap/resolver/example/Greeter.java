package org.jboss.shrinkwrap.resolver.example;

/**
 * A component for creating personal greetings.
 */
public class Greeter {

    public String createGreeting(String name) {
        return "Hello, " + name + "!";
    }
}