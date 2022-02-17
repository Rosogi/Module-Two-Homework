package org.example;

import java.util.*;

public class App
{
    public static void main(String[] args)
    {
        taskOne();
        taskTwo();
    }

    private static void taskTwo(){
        TelephoneNumber telephoneNumber = new TelephoneNumber();
        telephoneNumber.add("Карпов", "8(999) 003-02-01");
        telephoneNumber.add("Рукавчук", "8(999) 123-12-12");
        telephoneNumber.add("Мейстер", "8(999) 455-55-44");
        telephoneNumber.add("Карпов", "8(999) 234-90-90");
        telephoneNumber.add("Попов", "8(999) 000-00-01");
        telephoneNumber.add("Сидоров", "8(999) 999-00-99");

        System.out.println(telephoneNumber.get("Сидоров"));
    }

    private static void taskOne(){
        List<String> words = new ArrayList<>(Arrays.asList(
                "Яблоко", "Банан", "Яблоко", "Укроп", "Огурец",
                "Арбуз", "Помидор", "Гранат", "Банан", "Петрушка",
                "Яблоко", "Личи", "Помидор", "Авокадо", "Патисон",
                "Баклажан", "Кабачок", "Кукуруза", "Горох", "Щавяель",
                "Яблоко", "Кукуруза", "Гранат", "Личи", "Петрушка"
        ));
        System.out.println(getWordsCount(words));
        System.out.println(getUnique(words));
    }
    
    private static List<String> getUnique(List<String> array){
        List<String> uniqueItems = new ArrayList<>();
        for (int i = 0; i < array.size(); i++){
            if (!uniqueItems.contains(array.get(i))){
                uniqueItems.add(array.get(i));
            }
        }
        return uniqueItems;
    }

    private static HashMap getWordsCount(List<String> array){
        String currentValue = "";
        HashMap<String, Integer> count = new HashMap<>();
        int counter = 1;

        for (int i = 0; i < array.size(); i++){
            currentValue = array.get(i);
            for (int x = 0; x < array.size(); x++){
                if (array.get(i).equals(array.get(x))){
                    counter++;
                }
            }
            count.put(currentValue, counter);
            counter = 0;
        }

        return count;
    }
}
