package com.develogical.app;

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
        }
        return "No answer";
    }
}
