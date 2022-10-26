package model;

public class Base extends Operation {

    char name;
    public Base(char n){
        super();

        name = n;
    }


    @Override
    public String toString() {
        return ""+name;
    }

}
