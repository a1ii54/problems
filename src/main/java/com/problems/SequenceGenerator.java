package com.problems;

/**
 * Write a sequence generator where given a sample input "12"
 * it will generate a sequence as follows:
 *
 * 12
 * 1112
 * 3112
 * 132112
 * 1113122112
 * 311311222112
 * 13211321322112
 */



public class SequenceGenerator {


    public static void main(String[] args) {
        String input = "111111111111";


        for(int i = 0 ; i< 10 ;i++){
            String output = "";
            int count = 1;
            for(int k = 1 ; k < input.length() ; k++){
                if(input.charAt(k) == input.charAt(k-1)) {
                    count++;
                } else {
                    output += "" + count + input.charAt(k-1);
                    count = 1;
                }

                if(k == (input.length() -1)){
                    output += "" + count + input.charAt(k);
                }
            }
            System.out.println(output);
            input = output;
        }

    }
}
