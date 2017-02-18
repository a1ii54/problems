package com.problems;

/**
 * Write code to reverse the words in a given array of characters.
 * Given the input:
 * ['t','h','e',' ','d','o','g',' ','c','h','a','s','e','s',' ','t','h','e',' ','c','a','t']
 *
 * it should produce the output:
 * ['c','a','t',' ','t','h','e',' ','c','h','a','s','e','s',' ','d','o','g',' ','t','h','e']
 */



public class ReverseTheWords {

    private static char[] inpurArray = new char[]{'t', 'h','e',' ','d','o','g',' ','c','h','a','s','e','s',' ','t','h','e',' ','c','a','t'};

    public static void main(String[] args) {

        char[] outputArray = new char[inpurArray.length];

        int index = 0;
        int lastSpace = inpurArray.length;
        for(int i = inpurArray.length-1; i>=0 ; i--){
            if(' ' == inpurArray[i]){
                for (int k=i+1;k<lastSpace;k++){
                    outputArray[index]=inpurArray[k];
                    index++;
                }
                lastSpace = i;
                outputArray[index] = ' ';
                index++;
            }

            if(i == 0){
                for (int k=i;k<lastSpace;k++){
                    outputArray[index]=inpurArray[k];
                    index++;
                }
            }
        }

        System.out.println(inpurArray);
        System.out.println(outputArray);

    }
}
