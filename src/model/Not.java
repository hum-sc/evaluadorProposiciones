package model;

public class Not extends Closure {
    public Not(Operation operation) {
        super(operation);
    }
    
    @Override
    public boolean carryOut() {
        return !super.carryOut();
    }
}
