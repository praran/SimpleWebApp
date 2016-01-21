package com.develogical.app;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("what is your name")) {
            return "basil";
        } else if (query.toLowerCase().contains("plus")) {
            String[] strings = query.split(" ");
            return String.valueOf(Integer.valueOf(strings[3]) + Integer.valueOf(strings[5]));
        } else if (query.toLowerCase().contains("multiplied by")) {
            String[] strings = query.split(" ");
            return String.valueOf(Integer.valueOf(strings[3].trim()) * Integer.valueOf(strings[6].trim()));
        } else if (query.toLowerCase().contains("which  of  the  following  numbers  is  the  largest:")) {
            int[] ints = getIntsFromString(query);
            Arrays.sort(ints);
            return String.valueOf(ints[ints.length - 1]);
        } else if (query.toLowerCase().contains("which of the following numbers is both a square and a cube:")) {
            int[] nums = getIntsFromString(query);
            StringBuffer buffer = new StringBuffer();
            boolean isFirst = true;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (isSquareAndCube(n)) {
                    if (isFirst) {
                        buffer.append(n);
                        isFirst = false;
                    } else {
                        buffer.append(", " + n);

                    }
                }
            }
            return buffer.toString();

        } else if (query.toLowerCase().contains("38cd5870:  which  of  the  following  numbers  are  primes:")) {
            int[] nums = getIntsFromString(query);
            StringBuffer buffer = new StringBuffer();
            boolean isFirst = true;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (isPrime(n)) {
                    if (isFirst) {
                        buffer.append(n);
                        isFirst = false;
                    } else {
                        buffer.append(", " + n);

                    }
                }
            }
            return buffer.toString();
        } else if (query.contains("Fibonacci sequence")) {
            String[] arr = query.split(":");
            String str = arr[1].replaceAll("[^0-9]", "");
            System.out.println(str);
            return String.valueOf(fibonaciNumber(Integer.valueOf(str)));
        }
        return "No answer";
    }

    long fibonaciNumber(int n) {
        long[] fib = new long[n + 1];
        // base cases
        fib[0] = 1;
        fib[1] = 1;

        // bottom-up dynamic programming
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        return fib[n-1];
    }

    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    private boolean isSquareAndCube(int i) {
        long sqrt = Math.round(Math.sqrt(new Double(i)));
        long cube = Math.round(Math.cbrt(new Double(i)));
        return (sqrt * sqrt) == i && (cube * cube * cube) == i;
    }


    private int[] getIntsFromString(String query) {
        String[] strings = query.split(":");
        String[] nums = strings[2].split(",");
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = Integer.valueOf(nums[i].trim());
        }
        return ints;
    }
}
