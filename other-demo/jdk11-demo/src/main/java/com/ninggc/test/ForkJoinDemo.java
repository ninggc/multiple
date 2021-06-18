package com.ninggc.test;

import lombok.SneakyThrows;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
    public static void main(String[] args) {
        int end = 100 * 1000;
        RecursiveTask<String> recursiveTask = new SumTask(0, end);

        long l = System.currentTimeMillis();
        String invoke = ForkJoinPool.commonPool().invoke(recursiveTask);
        System.out.println(System.currentTimeMillis() - l);

        l = System.currentTimeMillis();
        String sum = "";
        for (int i = 0; i < end; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    static class SumTask extends RecursiveTask<String> {
        int start;
        int end; // not include

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @SneakyThrows
        @Override
        protected String compute() {
            if (start - end > 100) {
                int middle = start + (end - start) / 2;
                SumTask task1 = new SumTask(start, middle);
                SumTask task2 = new SumTask(middle, end);
                task1.join();
                task2.join();
                return task1.get() + task2.get();
            } else {
                String sum = "";
                for (int i = 0; i < end; i++) {
                    sum += i;
                }
                return sum;
            }
        }
    }

}
