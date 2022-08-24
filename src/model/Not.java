package model;

import java.util.Map;

public class Not extends Closure {
    public Not(Operation operation, Map<String, boolean[]> answers) {
        super(operation, answers);
    }
    
    @Override
    public boolean carryOut(int i) {
        return !super.carryOut(i);
    }
    @Override
    public String toString() {
        return "¬"+operation.toString();
    }
}
