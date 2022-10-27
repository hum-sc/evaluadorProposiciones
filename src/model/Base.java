package model;

import java.util.ArrayList;
import java.util.Map;


public class Base extends Operation {
    String name;
    public Base(String n){
        super();
        name = n;
    }

    @Override
    public String preOrden() {
        return name+"";
    }

    @Override
    public String inOrden() {
        return name + "";
    }

    @Override
    public String postOrden() {
        return name + "";
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public void inLavels(Map<Integer, ArrayList<String>> map, int i) {
        if(map.get(i) == null) map.put(i, new ArrayList<String>());
        map.get(i).add(name);
    }
}
