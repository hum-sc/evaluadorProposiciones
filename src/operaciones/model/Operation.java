/**
 * 
 */
package operaciones.model;

/**
 * @author hum-s
 *
 */
public class Operation {
	protected Operation left, right, parent;

	public Operation() {
		
	}
	
	public Operation(Operation left, Operation right) {
		this.left = left;
		this.right = right;
		this.parent = null;
	}


	public boolean carryOut(int i){
		boolean tmpLeft = left.carryOut(i);
		boolean tmpRight = right.carryOut(i);

		return operator(tmpLeft, tmpRight);
	}

	public void setLeft(Operation left) {
		this.left = left;
	}

	public void setRight(Operation right) {
		this.right = right;
	}
	public Operation getLeft() {
		return left;
	}
	public Operation getRight() {
		return right;
	}

	protected boolean operator(boolean left, boolean right) {
		return false; 
	}
	@Override
    public String toString() {
        return left.toString()+"operando"+right.toString();
    }
}
