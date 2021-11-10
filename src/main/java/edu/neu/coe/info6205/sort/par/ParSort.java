package edu.neu.coe.info6205.sort.par;

import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
class ParSort {

    public static int cutoff = 1000;

    public static void sort(int[] array, int from, int to) {
        if (to - from < cutoff) Arrays.sort(array, from, to);
        else {
            // FIXME next few lines should be removed from public repo.
            CompletableFuture<int[]> parsort1 = parsort(array, from, from + (to - from) / 2); // TO IMPLEMENT
            CompletableFuture<int[]> parsort2 = parsort(array, from + (to - from) / 2, to); // TO IMPLEMENT
            CompletableFuture<int[]> parsort = parsort1.thenCombine(parsort2, (xs1, xs2) -> {
                int[] result = new int[xs1.length + xs2.length];
                // TO IMPLEMENT
                int i = 0;
                int j = 0;
                for (int k = 0; k < result.length; k++) {
                    if (i >= xs1.length) {
                        result[k] = xs2[j++];
                    } else if (j >= xs2.length) {
                        result[k] = xs1[i++];
                    } else if (xs2[j] < xs1[i]) {
                        result[k] = xs2[j++];
                    } else {
                        result[k] = xs1[i++];
                    }
                }
                return result;
            });

            parsort.whenComplete((result, throwable) -> System.arraycopy(result, 0, array, from, result.length));
//            System.out.println("# threads: "+ ForkJoinPool.commonPool().getRunningThreadCount());
            parsort.join();
//            List<CompletableFuture<int[]>> parsort = new ArrayList<>();
//            int i = 1;
//            while(i <= threadsNumber){
//                if(i == 1){
//                    CompletableFuture<int[]> parsort1 = parsort(array, from, from + (to - from) / threadsNumber * i, threadsNumber);
//                    parsort.add(parsort1);
//                }else if(i == threadsNumber){
//                    CompletableFuture<int[]> parsort1 = parsort(array, from + (to - from) / threadsNumber * (i - 1), to, threadsNumber);
//                    parsort.add(parsort1);
//                }else{
//                    CompletableFuture<int[]> parsort1 = parsort(array, from + (to - from) / threadsNumber * (i - 1), from + (to - from) / threadsNumber * i, threadsNumber);
//                    parsort.add(parsort1);
//                }
//                i++;
//            }
//            CompletableFuture<Void> allFeatures = CompletableFuture.allOf(
//                    parsort.toArray(new CompletableFuture[parsort.size()])
//            );
//            CompletableFuture<int[]> partsorts = allFeatures.thenApply(v -> {
//                List<int[]> lists = new ArrayList<>();
//                for(int k = 0; k<threadsNumber;k++){
//                    lists.add(parsort.get(k).join());
//                }
//                int[] result = new int[to - from];
//                int index = 0;
//                Queue<Pair> minHeap = new PriorityQueue<>((x1,x2) -> {return x1.value - x2.value;});
//                for(int k = 0; k<lists.size();k++){
//                    if(lists.get(k).length != 0){
//                        minHeap.offer(new Pair(lists.get(k)[0], k, 0));
//                    }
//                }
//                while(!minHeap.isEmpty()){
//                    Pair pair = minHeap.poll();
//                    result[index++] = pair.value;
//                    if(pair.column < lists.get(pair.row).length - 1){
//                        pair.column++;
//                        pair.value = lists.get(pair.row)[pair.column];
//                        minHeap.offer(pair);
//                    }
//                }
//                return  result;
//            });
//            partsorts.whenComplete((result, throwable) -> System.arraycopy(result, 0, array, from, result.length));
//            partsorts.join();
        }

    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to - from];
                    // TO IMPLEMENT
                    System.arraycopy(array, from, result, 0, result.length);
                    sort(result, 0, to - from);
                    return result;
                },Main.myPool
        );
    }

//    static class Pair{
//        private int value;
//        private int row;
//        private int column;
//        public Pair(int value, int row, int column){
//            this.value = value;
//            this.column = column;
//            this.row = row;
//        }
//    }
}
