package model;

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
}
