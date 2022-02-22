package com.dwteam;

import java.util.ArrayList;
import java.util.List;

public class ListPro<T,F> {
    private List<T> list1 ;
    private List<F> list2;
    public ListPro() {
        list1=new ArrayList<>();
        list2=new ArrayList<>();
    }
    public void add(T t,F f){
        list1.add(t);
        list2.add(f);
    }
    public String[] get(int index){
        String[] s=new String[2];
        s[0]=list1.get(index).toString();
        s[1]=list2.get(index).toString();
        return s;
    }
    public int size(){
        return list1.size();
    }


    public String toString(int i) {
        return "ListPro{" +
                "list1=" + list1.get(i).toString() +
                ", list2=" + list2.get(i).toString() +
                '}';
    }
}
