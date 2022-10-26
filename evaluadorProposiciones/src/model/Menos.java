package model;

public class Menos extends Operation{
	public Menos(Operation left, Operation right) {
        super(left, right);
    }
    


    @Override
    public String toString() {
        return left.toString()+"-"+right.toString();
    }
}
