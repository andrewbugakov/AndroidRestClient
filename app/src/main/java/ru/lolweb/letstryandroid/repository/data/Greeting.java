package ru.lolweb.letstryandroid.repository.data;

/**
 * Created by Andrei on 15.10.2017.
 */
public class Greeting {
    private String greeting;

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {

        return greeting;
    }

    public Greeting() {
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
