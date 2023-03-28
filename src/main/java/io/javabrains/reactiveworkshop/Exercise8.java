package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()


        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(error -> System.out.println(error.getMessage()))
//                .subscribe(num -> System.out.println(num),
//                        ex -> System.out.println(ex.getMessage())
//                );


        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((e, item) -> {
//                    System.out.println(e.getMessage());
//                    System.out.println(item);
//                }).subscribe(System.out::println);


        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(error -> Flux.just(-1, -2))
                .subscribe(System.out::println);
        System.in.read();
    }

}
