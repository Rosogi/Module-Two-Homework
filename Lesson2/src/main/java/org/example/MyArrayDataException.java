package org.example;

public class MyArrayDataException extends NumberFormatException{
    private String symbol;
    private int xIndex, yIndex;
    public MyArrayDataException(){

    }
    public MyArrayDataException(String symbol, int x, int y){
        this.symbol = symbol;
        this.xIndex = x;
        this.yIndex = y;
    }

    public void printError(){
        System.out.println("Невозможно преобразовать данный символ: " + symbol + "; Адрес: [" + xIndex + "][" + yIndex + "]");
    }
}
