package model;

public class Plus extends Operation {
    public Plus(Operation left, Operation right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "+";
    }
    
}