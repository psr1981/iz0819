package com.iz0819.www.concurrency;

import java.util.Random;
import java.util.concurrent.*;

class IntSum implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}

class RandomStr implements Callable<String> {
    public String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    @Override
    public String call() throws Exception {
        return   getRandomString();
    }
}


public class CallableDemo {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> fInt;
        Future<String> fStr;

        System.out.println("Starting");

        fInt = es.submit(new IntSum());
        fStr = es.submit(new RandomStr());

        try {
            System.out.println(fInt.get());
            System.out.println(fStr.get());
        }
        catch (InterruptedException | ExecutionException ex){
            System.out.println(ex);
        }
        es.shutdown();
        System.out.println("Done");
    }
}
