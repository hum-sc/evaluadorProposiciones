package model;

public class Potencia extends Operation{
	public Potencia(Operation left, Operation right) {
        super(left, right);
    }


    @Override
    public String toString() {
        return left.toString()+"^"+right.toString();
    }
}
