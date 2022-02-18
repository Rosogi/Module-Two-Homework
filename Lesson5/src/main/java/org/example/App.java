package org.example;

public class App {
    private static final int size = 100_000_000;
    private static final int half = size / 2;


    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    private static void firstMethod() {
        float[] array = new float[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода: " + ((endTime - startTime) / 1000) + " с.");
    }


    private static void secondMethod() {
        float[] array = new float[size];


        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        float[] firstHalf = new float[half];
        float[] secondHalf = new float[half];

        for (int i = 0; i < half; i++) {
            firstHalf[i] = array[i];
        }

        for (int i = size, x = 0; i > half; i--, x++) {
            secondHalf[x] = array[i-1];
        }

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < firstHalf.length; i++) {
                firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < secondHalf.length; i++) {
                secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println("Произошла ошибка");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения первого метода: " + ((endTime - startTime) / 1000) + " с.");

    }
}
