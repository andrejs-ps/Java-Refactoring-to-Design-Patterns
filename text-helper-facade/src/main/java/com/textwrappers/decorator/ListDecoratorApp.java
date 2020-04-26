package com.textwrappers.decorator;

import java.util.List;

public class ListDecoratorApp {

    public static void main(String[] args){

        EnhancedList<String> list = new EnhancedList<>(List.of("a", "b", "c"));

        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
