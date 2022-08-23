package model;

public class Or extends Operation {
    public Or(Operation left, Operation right) {
        super(left, right);
    }
    
    @Override
    protected boolean operator(boolean left, boolean right) {
        return ( left || right );
    }
    
}
