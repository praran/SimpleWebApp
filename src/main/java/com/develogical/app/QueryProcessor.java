package com.develogical.app;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }else if (query.toLowerCase().contains("what is your name")){
            return "basil";
        }else if(query.toLowerCase().contains("plus")){
            String[] strings = query.split(" ");
            return String.valueOf(Integer.valueOf(strings[3]) + Integer.valueOf(strings[5]));
        }else if (query.toLowerCase().contains("which  of  the  following  numbers  is  the  largest:")){
            int[] ints = getIntsFromString(query);
            Arrays.sort(ints);
            return String.valueOf(ints[ints.length-1]);
        }else if(query.toLowerCase().contains("which of the following numbers is both a square and a cube:")){
            int[] nums = getIntsFromString(query);
            StringBuffer buffer = new StringBuffer();
            boolean isFirst = true;
            for(int i =0; i < nums.length ; i++){
                int n = nums[i];
                if(isSquareAndCube(n)){
                    if(isFirst){
                        buffer.append(n);
                        isFirst = false;
                    }else{
                        buffer.append(", "+n);

                    }
                }
            }
             return buffer.toString();

        }
        return "No answer";
    }


    private boolean isSquareAndCube(int i){
        long sqrt = Math.round(Math.sqrt(new Double(i)));
        long cube = Math.round( Math.cbrt(new Double(i)));
        return (sqrt * sqrt) == i && (cube * cube * cube) == i;
    }



    private int[] getIntsFromString(String query) {
        String[] strings = query.split(":");
        String[] nums = strings[2].split(",");
        int[] ints = new int[nums.length];
        for(int i =0; i < nums.length ; i ++){
            ints[i] = Integer.valueOf(nums[i].trim());
        }
        return ints;
    }
}
