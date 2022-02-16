package org.example;

public class MyArraySizeException extends IndexOutOfBoundsException{
    private int size;
    public MyArraySizeException(){

    }

    public MyArraySizeException(int size){
        this.size = size;
    }

    public void printError(){
        if (size <= 3){
            System.out.println("Размер вашего массива - " + size + ", что меньше 4" );
        } else {
            System.out.println("Размер вашего массива - " + size + ", что больше 4" );
        }

    }
}
