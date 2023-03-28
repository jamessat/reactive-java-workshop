package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()


        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(i -> i < 5)
                .forEach(i -> System.out.println(i));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(i -> System.out.println(i));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer result = StreamSources.intNumbersStream().filter(i -> i > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);

        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.println(name));

        System.out.println("XXX");
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .flatMap((id -> StreamSources.userStream().filter(user -> user.getId() == id)))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.println(name));

        System.out.println("XXX");
        StreamSources.userStream()
                .filter(u ->
                        StreamSources.intNumbersStream().anyMatch(i -> i == u.getId()))
                .forEach(u -> System.out.println(u.getFirstName()));

    }

}
