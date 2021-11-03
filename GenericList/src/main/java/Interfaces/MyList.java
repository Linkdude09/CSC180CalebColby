package Interfaces;

import java.util.ArrayList;


public interface MyList<T> {

    void add(T val);
    void remove(T val);
    ArrayList<T> get();
    int size();
}
