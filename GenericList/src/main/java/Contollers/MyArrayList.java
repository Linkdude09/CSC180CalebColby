package Contollers;

import Interfaces.MyList;

import java.util.ArrayList;

public class MyArrayList<T> implements MyList<T> {

    private ArrayList<T> MAL;

    @Override
    public void add(T val) {
        MAL.add(val);
    }

    @Override
    public void remove(T val) {
        for (int i = 0;i < MAL.size(); i++){
            if(MAL.get(i) == val){
                MAL.remove(i);
            }
        }
    }

    @Override
    public ArrayList<T> get() {
        return MAL;
    }

    @Override
    public int size() {
        return MAL.size();
    }

    @Override
    public String toString(){

        if(this.size() == 0){
            return "There are no elements in this List"
        }
        StringBuilder RS = new StringBuilder("Here are the contents of this list");
        for (int i = 0; i < this.size();i++){
            RS.append("\n" + (i+1) + "): " + MAL.get(i));
        }
        return RS.toString();
    }
}
