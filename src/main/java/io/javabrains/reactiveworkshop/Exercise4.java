package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(i -> System.out.println(i));

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Optional<Integer> i = ReactiveSources.intNumberMono().blockOptional();
        if (i.isPresent()) {
            System.out.println(i.get());
        } else {
            System.out.println("null");
        }

        ReactiveSources.userMono().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
