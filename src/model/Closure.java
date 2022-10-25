package model;

import java.util.Map;

public class Closure extends Operation {
    protected Operation operation;
    protected Map<String, boolean[]> answers;

    public Closure(Operation operation) {
        super();
        this.operation = operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String preOrden() {
        return this.operation.preOrden();
    }
    @Override
    public String inOrden() {
        return this.operation.inOrden();
    }
    @Override
    public String postOrden() {
        return this.operation.postOrden();
    }
}
