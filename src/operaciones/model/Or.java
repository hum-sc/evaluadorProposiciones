package operaciones.model;

public class Or extends Operation {
    public Or(Operation left, Operation right) {
        super(left, right);
    }
    
    @Override
    protected boolean operator(boolean left, boolean right) {
        return ( left || right );
    }

    @Override
    public String toString() {
        return left.toString()+"v"+right.toString();
    }
    
}
