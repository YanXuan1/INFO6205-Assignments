package edu.neu.coe.info6205.sort;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class SortTimeTest {

    public static InsertionSort insertionSort;

    @Test
    public void runTestRandom(){

        Integer[] testRandom = createRandom();
        long meanRandom = 0;
        for(int i = 0; i<20;i++){
            testRandom(testRandom);
            if(i >= 10){
                meanRandom += testRandom(testRandom);
            }
        }
        meanRandom = meanRandom / 10;
        System.out.println("Mean time for random array is : " + meanRandom);
    }

    @Test
    public void runTestOrdered(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input the array's length: ");
//        int len = scanner.nextInt();
        Integer[] testOrdered = new Integer[20];
        for(int i = 0; i<20;i++){
            testOrdered[i] = i;
        }
        System.out.println("The ordered array is : " + Arrays.toString(testOrdered));
        long meanRandom = 0;
        for(int i = 0; i<20;i++){
            testOrdered(testOrdered);
            if(i >= 10){
                meanRandom += testOrdered(testOrdered);
            }
        }
        meanRandom = meanRandom / 10;
        System.out.println("Mean time for ordered array is : " + meanRandom);
    }

    @Test
    public void runTestPartiallyOrdered(){
        Integer[] testPartiallyOrdered = new Integer[]{3,88,45,90,56,5,6,7,8,9,74,33,880,100,567,43,77,15,687,63};
        System.out.println("The partially-ordered array is : " + Arrays.toString(testPartiallyOrdered));
        long meanRandom = 0;
        for(int i = 0; i<20;i++){
            testPartiallyOrdered(testPartiallyOrdered);
            if(i >= 10){
                meanRandom += testPartiallyOrdered(testPartiallyOrdered);
            }
        }
        meanRandom = meanRandom / 10;
        System.out.println("Mean time for partially-ordered array is : " + meanRandom);
    }

    @Test
    public void runTestReversed(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        Integer[] testReversed = new Integer[len];
        for(int i = 0; i<len;i++){
            testReversed[i] = len - i;
        }
        System.out.println("The reversed array is : " + Arrays.toString(testReversed));
        long meanRandom = 0;
        for(int i = 0; i<20;i++){
            testReversed(testReversed);
            if(i >= 10){
                meanRandom += testReversed(testReversed);
//                System.out.println(testReversed(testReversed));
            }
        }
        meanRandom = meanRandom / 10;
        System.out.println("Mean time for reversed array is : " + meanRandom);
    }


    public long testRandom(Integer[] testRandom){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testRandom, 0, testRandom.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public Integer[] createRandom(){
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Input the array's length: ");
        int len = scanner.nextInt();
        System.out.println("Input the array's max number you want: ");
        int max = scanner.nextInt();
        Integer[] testRandom = new Integer[len];
        for(int k = 0; k<len;k++){
            testRandom[k] = (int)(Math.random()*max);
        }
        System.out.println("The random array is : " + Arrays.toString(testRandom));
        return testRandom;
    }


    public long testOrdered(Integer[] testOrdered){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testOrdered, 0, testOrdered.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public long testPartiallyOrdered(Integer[] testPartiallyOrdered){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testPartiallyOrdered, 0, testPartiallyOrdered.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

    public long testReversed(Integer[] testReversed){
        insertionSort = new InsertionSort();
        long startTime = System.nanoTime();
        insertionSort.sort(testReversed, 0, testReversed.length);
        long finalTime = System.nanoTime() - startTime;
        return finalTime;
    }

}
