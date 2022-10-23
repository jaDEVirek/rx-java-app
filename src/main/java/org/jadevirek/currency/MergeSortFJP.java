package org.jadevirek.currency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MergeSortFJP {

   public void runMergeSort(int[] array){
       final SortingTask taskToExecute = new SortingTask(array);
       ForkJoinPool runningPool = new ForkJoinPool();
       runningPool.invoke(taskToExecute);
       System.out.println(Arrays.toString(array));
   }

    private static void mergeResult(int[] actual, int []first, int[]second, int middle, int subSize){
        int i = 0, j = 0, k = 0;

        while (i < middle && j < subSize) {
            if (first[i] <= second[j]) {
                actual[k++] = first[i++];
            }
            else {
                actual[k++] = second[j++];
            }
        }
        while (i < middle) {
            actual[k++] = first[i++];
        }
        while (j < subSize) {
            actual[k++] = second[j++];
        }
    }

    private static class SortingTask extends RecursiveAction {
        private final int[] taskArray;

        public SortingTask(int []array ) {
            this.taskArray=array;
        }

        /**
         * Invoke during start task.
         */
        @Override protected void compute() {
            System.out.println("SortingTask is running...");
            if (taskArray.length < 2) {
                return;
            }
            int middle = taskArray.length/2;
            final int[] firstHalf = Arrays.copyOfRange(taskArray, 0, middle);
            final int[] secondHalf = Arrays.copyOfRange(taskArray, middle, taskArray.length);

            final SortingTask sortingTask = new SortingTask(firstHalf);
            final SortingTask sortingTask1 = new SortingTask(secondHalf);

            ForkJoinTask.invokeAll(sortingTask,sortingTask1);
            mergeResult(this.taskArray,firstHalf,secondHalf,middle,taskArray.length-middle);
        }
    }
}




