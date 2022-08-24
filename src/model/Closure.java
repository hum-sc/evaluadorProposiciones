package model;

import java.util.Map;

public class Closure extends Operation {
    protected Operation operation;
    private Map<String, boolean[]> answers;

    public Closure(Operation operation, Map<String, boolean[]> answers) {
        super();
        this.operation = operation;
        this.answers = answers;
        answers.put(this.toString(), new boolean[8]);
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean carryOut(int i) {
        boolean[] tmpAnswers = answers.get(this.toString());
        tmpAnswers[i] = operation.carryOut(i);
        return tmpAnswers[i];
    }
    @Override
    public String toString() {
        return "("+operation.toString()+")";
    }


}
