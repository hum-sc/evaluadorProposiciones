package model;

public class Cross extends Operation {
    public Cross(Operation left, Operation right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "*";
    }
    
}
