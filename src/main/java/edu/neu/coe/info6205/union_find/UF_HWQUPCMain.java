package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_HWQUPCMain {

//    public static int count(int n){
//        UF_HWQUPC h = new UF_HWQUPC(n);
//        int[] tag = new int[n];
//        Random r = new Random();
//        int temp1 = 0;
//        int temp2 = 0;
//        int count = 0;
//        int result = 0;
//        int pair = 0;
//        while(true){
//            pair = 0;
//            temp1 = r.nextInt(n);
//            if(tag[temp1] == 0){
//                tag[temp1] = 1;
//                count++;
//                temp2 = r.nextInt(n);
//                if(tag[temp2] == 0){
//                    tag[temp2] = 1;
//                    count++;
//                }
//                if(!h.connected(temp1,temp2)){
//                    h.connect(temp1, temp2);
//                    result++;
//                }
//            }else{
//                temp2 = r.nextInt(n);
//                while(tag[temp2] == 1){
//                    temp2 = r.nextInt(n);
//                }
//                tag[temp2] = 1;
//                count++;
//                if(!h.connected(temp1,temp2)){
//                    h.connect(temp1, temp2);
//                    result++;
//                }
//            }
//            if(count == n) break;
//        }
//        return result;
//    }

    public static int count(int n){
        UF_HWQUPC h = new UF_HWQUPC(n);
        Random r = new Random();
        int result = 0;
        int temp1 = 0;
        int temp2 = 0;
        while(true){
            if(h.components() == 1) break;
            temp1 = r.nextInt(n);
            temp2 = r.nextInt(n);
            if(temp1 != temp2){
                if(!h.connected(temp1, temp2)){
                    h.connect(temp1, temp2);
                    result++;
                }
            }else continue;

        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        for(int i = 0; i<10;i++){
            System.out.println("Input the number of n to determine the number of sites : ");
            n = scanner.nextInt();
            System.out.println("The number of connections is : " + count(n));
        }
    }
}
