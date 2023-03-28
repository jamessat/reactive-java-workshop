package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new MyBaseSubscriber());

        System.out.println("Press a key to end");
        System.in.read();
    }

    static class MyBaseSubscriber extends BaseSubscriber<Integer> {
        public void hookOnSubscribe(Subscription subscription) {
            System.out.println("subscribed");
            request(1);
        }

        public void hookOnNext(Integer value) {
            System.out.println("received " + value);
            request(3);
        }

        protected void hookOnComplete() {
            System.out.println("complete!");
        }


    }

}