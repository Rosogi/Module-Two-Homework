package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneNumber {
    private HashMap<String, String> phoneNumbers = new HashMap<>();

    public void add(String name, String phone){
        phoneNumbers.put(phone, name);
    }

    public String get(String name){
        String numbers = name + ": ";
        for (Map.Entry<String, String> o : phoneNumbers.entrySet()) {
            //System.out.println(o.getKey() + ": " + o.getValue());
            if (o.getValue().equals(name)){
                numbers += o.getKey() + ", ";
            }
        }

        return numbers;
    }

}
