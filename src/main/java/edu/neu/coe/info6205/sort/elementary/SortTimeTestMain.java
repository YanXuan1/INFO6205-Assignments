package edu.neu.coe.info6205.sort.elementary;

import java.util.Arrays;
import java.util.Scanner;

public class SortTimeTestMain {

    public static InsertionSort insertionSort;

    //Run 5 loops, in each loop, the n runs the same times and then output the mean time when the array's length is n, then n becomes n*2 when the loop increases
    public void runTestRandom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        System.out.println("Input the array's max number you want: ");
        int max = scanner.nextInt();
        System.out.println("Input the number of loops you want: ");
        int loop = scanner.nextInt();
        for(int k = 1; k<=5;k++){
            Integer[] testRandom = createRandom(len,max);
            long meanRandom = 0;
            for(int i = 0; i<(loop + 10);i++){
                if(i >= 10){
                    meanRandom += testRandom(testRandom);
                }else{
                    testRandom(testRandom);
                }
            }
            meanRandom = meanRandom / loop;
            System.out.println("Mean time for random array is : " + meanRandom + " when n is : " + len);
            len = len * 2;
        }

    }

    public void runTestOrdered(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        System.out.println("Input the number of loops you want: ");
        int loop = scanner.nextInt();
        for(int k = 1; k<=5;k++){
            Integer[] testOrdered = createOrdered(len);
            long meanRandom = 0;

            for(int i = 0; i<(loop + 10);i++){
                if(i >= 10){
                    meanRandom += testOrdered(testOrdered);
                }else{
                    testOrdered(testOrdered);
                }
            }
            meanRandom = meanRandom / loop;
            System.out.println("Mean time for ordered array is : " + meanRandom + " when n is : " + len);
            len = len * 2;
        }

    }

    public void runTestPartiallyOrdered(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        System.out.println("Input the array's max number you want: ");
        int max = scanner.nextInt();
        System.out.println("Input the array's start index you want to be ordered: ");
        int start = scanner.nextInt();
        System.out.println("Input the array's end index you want to be ordered: ");
        int end = scanner.nextInt();
        System.out.println("Input the number of loops you want: ");
        int loop = scanner.nextInt();
        for(int k = 1; k<=5;k++){
            Integer[] testPartiallyOrdered = createPartiallyOrdered(len,max,start,end);
            //System.out.println("The partially-ordered array is : " + Arrays.toString(testPartiallyOrdered));
            long meanRandom = 0;
            for(int i = 0; i<(loop + 10);i++){
                if(i >= 10){
                    meanRandom += testPartiallyOrdered(testPartiallyOrdered);
                }else{
                    testPartiallyOrdered(testPartiallyOrdered);
                }
            }
            meanRandom = meanRandom / loop;
            System.out.println("Mean time for partially-ordered array is : " + meanRandom + " when n is : " + len);
            len = len * 2;
        }

    }

    public void runTestReversed(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        System.out.println("Input the number of loops you want: ");
        int loop = scanner.nextInt();
        for(int k = 1; k<=5;k++){
            Integer[] testReversed = createReversed(len);
            //System.out.println("The reversed array is : " + Arrays.toString(testReversed));
            long meanRandom = 0;
            for(int i = 0; i<(loop + 10);i++){

                if(i >= 10){
                    meanRandom += testReversed(testReversed);
                    //System.out.println(testReversed(testReversed));
                }else{
                    testReversed(testReversed);
                }
            }
            meanRandom = meanRandom / loop;
            System.out.println("Mean time for reversed array is : " + meanRandom + " when n is : " + len);
            len = len * 2;
        }

    }


    //the test function gets the time of the one sort action
    public long testRandom(Integer[] testRandom){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testRandom, 0, testRandom.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    //the create function creates the required array
    public Integer[] createRandom(int len, int max){

        Integer[] testRandom = new Integer[len];
        for(int k = 0; k<len;k++){
            testRandom[k] = (int)(Math.random()*max);
        }
        //System.out.println("The random array is : " + Arrays.toString(testRandom));
        return testRandom;
    }


    public long testOrdered(Integer[] testOrdered){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testOrdered, 0, testOrdered.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public Integer[] createOrdered(int len){
        Integer[] testOrdered = new Integer[len];
        for(int k = 0; k<len;k++){
            testOrdered[k] = k;
        }
        //System.out.println("The ordered array is : " + Arrays.toString(testOrdered));
        return testOrdered;
    }

    public long testPartiallyOrdered(Integer[] testPartiallyOrdered){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testPartiallyOrdered, 0, testPartiallyOrdered.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public Integer[] createPartiallyOrdered(int len, int max, int start, int end){

        Integer[] testPartiallyOrdered = new Integer[len];
        for(int k = 0; k<len;k++){
            testPartiallyOrdered[k] = (int)(Math.random()*max);
        }

        for(int i = start; i<=end;i++){
            testPartiallyOrdered[i] = max + i + 1 - start;
        }
        //System.out.println("The partially-random array is : " + Arrays.toString(testPartiallyOrdered));
        return testPartiallyOrdered;
    }


    public long testReversed(Integer[] testReversed){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testReversed, 0, testReversed.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public Integer[] createReversed(int len){
        Integer[] createReversed = new Integer[len];
        for(int k = 0; k<len;k++){
            createReversed[k] = len - k;
        }
        //System.out.println("The reserved array is : " + Arrays.toString(testReserved));
        return createReversed;
    }

    public static void main(String[] args) {
        SortTimeTestMain obj = new SortTimeTestMain();
        System.out.println("Test the time of Random Arrays: ");
        obj.runTestRandom();
        System.out.println("Test the time of Ordered Arrays: ");
        obj.runTestOrdered();
        System.out.println("Test the time of Partially-Ordered Arrays: ");
        obj.runTestPartiallyOrdered();
        System.out.println("Test the time of Reversed Arrays: ");
        obj.runTestReversed();
    }
}
