package model;

public class Minus extends Operation {
    public Minus(Operation left, Operation right) {
        super(left, right);
    }
    @Override
    public String toString() {
        return "-";
    }
    
}
