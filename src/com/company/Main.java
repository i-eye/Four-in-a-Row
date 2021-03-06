package com.company;
/* Ivan Freeman
   13 January 2022
   The purpose of this program is to get a 2d array of integers from the user, see if there are four integers of the
   same value in a row, then print the results
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // creates array and gets values from user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Number of Columns: ");
        int columns = sc.nextInt();
        int[][]values = new int[rows][columns];
        for(int x = 0; x<values.length; x++){
            for(int y = 0; y<values[x].length;y++){
                System.out.print("Enter Row "+(x+1)+", Column "+(y+1)+": ");
                values[x][y] = sc.nextInt();
            }
        }
        /* debugging
        for(int[] x : values) {
            for (int y : x) {
                System.out.print("[" + y + "]");
            }
            System.out.println();
        }
        */

        // finds out if there are four integers of the same value in a row, then prints the results
        if(isFour(values)){
            System.out.print("There are four ints of the same value in a row!");
        } else {
            System.out.print("There unfortunately aren't four ints of the same value in a row...");
        }
    }
    public static boolean isFour(int[][] values){
        // checks horizontally
        for (int row = 0; row<values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                /* debugging
                System.out.println(row+ " "+column);
                System.out.println(column + 3);
                System.out.println(values[row].length);

                 */
                if ((column + 3) >= values[row].length) {

                } else if (values[row][column] == values[row][column + 1] && values[row][column + 1] == values[row][column + 2] && values[row][column + 2] == values[row][column + 3]) {
                    return true;
                }
            }
        }

        // checks vertically
        for(int row=0;row<values.length;row++){
            for(int column=0;column<values[row].length;column++){
                if((row+3) >= values.length){

                } else if (values[row][column] == values[row+1][column] && values[row][column] == values[row+2][column] && values[row][column] == values[row+3][column]){
                    return true;
                }
            }
        }

        //checks diagonally to the right
        for(int row=0;row<values.length;row++){
            for(int column=0;column<values[row].length;column++){
                if((column + 3) >= values[row].length || (row+3) >= values.length){

                }else if (values[row][column] == values[row+1][column+1] && values[row][column] == values[row+2][column+2] && values[row][column] == values[row+3][column+3]){
                    return true;
                }
            }
        }

        // check diagonally to the left
        for(int row=0;row<values.length;row++){
            for(int column=values[row].length-1;column>=0;column--){
                if((column - 3)  < 0 || (row+3) >= values.length){
                    // debugging
                    //System.out.println("Breaking at "+row+" "+column);
                }else if (values[row][column] == values[row+1][column-1] && values[row][column] == values[row+2][column-2] && values[row][column] == values[row+3][column-3]){
                    return true;
                }
            }
        }
        return false;
    }
}
