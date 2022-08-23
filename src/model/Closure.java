package model;

public class Closure extends Operation {
    private Operation operation;

    public Closure(Operation operation){
        super();
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean carryOut() {
        return operation.carryOut();
    }
}
