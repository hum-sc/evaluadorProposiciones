package model;

import java.util.Map;

public class Closure extends Operation {
    protected Operation operation;


    public Closure(Operation operation) {
        super();
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "("+operation.toString()+")";
    }


}
