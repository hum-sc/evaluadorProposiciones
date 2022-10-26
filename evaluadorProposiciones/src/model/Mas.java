package model;

public class Mas extends Operation{
	public Mas(Operation left, Operation right) {
        super(left, right);
    }
    


    @Override
    public String toString() {
        return left.toString()+"+"+right.toString();
    }
    
}
