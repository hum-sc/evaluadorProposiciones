package model;

import java.util.Map;

public class Not extends Closure {
    public Not(Operation operation, Map<String, boolean[]> answers) {
        super(operation, answers);
    }
    @Override
    public boolean carryOut(int i) {
        boolean[] tmpAnswers = super.answers.get(this.toString());
        tmpAnswers[i] = !operation.carryOut(i);
        return tmpAnswers[i];
    }
    @Override
    public String toString() {
        return "¬"+operation.toString();
    }
}
