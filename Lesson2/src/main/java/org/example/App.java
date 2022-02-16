package org.example;

import java.util.Random;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        String[][] array = new String[size][size];

        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array.length; x++){
               array[i][x] = String.valueOf( (int) (Math.random() * 10));
            }
        }

        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array.length; x++){
                System.out.print(" " + array[i][x] + " ");
            }
        }
        System.out.println();
        //Внесение злополучного символа
        //array[1][1] = "#";
        try{
            System.out.println(arraySum(array));
        } catch (MyArraySizeException e){
            e.printError();
        } catch (MyArrayDataException e){
            e.printError();
        }
    }

    private static int arraySum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4){
            throw new MyArraySizeException(array.length);
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array.length; x++){
                try {
                    sum += Integer.parseInt(array[i][x]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(array[i][x], x, i);
                }
            }

        }

        return sum;
    }
}

