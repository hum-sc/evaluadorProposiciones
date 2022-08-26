package model;

public class And extends Operation {
    public And(Operation left, Operation right) {
        super(left, right);
    }

    @Override
    protected boolean operator(boolean left, boolean right) {
        return ( left && right );
    }

    @Override
    public String toString() {
        return left.toString()+"^"+right.toString();
    }
    
}