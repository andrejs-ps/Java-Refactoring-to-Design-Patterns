package com.textwrappers.decorator;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Not the classic GoF Decorator pattern, but a Wrapper object that adds some functionality to another object
 * Nevertheless, such an implementation is sometimes referred to as a decorator, because it "decorates" another object
 */
public class EnhancedList<E> extends AbstractList {

    private final List<E> list;

    public EnhancedList(){
        list = new ArrayList<>();
    }

    public EnhancedList(List<E> list) {
        this.list = list;
    }

    public E getFirst(){
        return list.get(0);
    }

    public E getLast(){
        return list.get(list.size() - 1);
    }


    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }
}
