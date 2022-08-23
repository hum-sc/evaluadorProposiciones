package model;

public class And extends Operation {
    public And(Operation left, Operation right) {
        super(left, right);
    }

    @Override
    protected boolean operator(boolean left, boolean right) {
        // TODO Auto-generated method stub
        return ( left && right );
    }
    
}