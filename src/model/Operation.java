/**
 * 
 */
package model;

import java.util.Map;

/**
 * @author hum-s
 *
 */
public class Operation {
	private Operation left, right;
	public Map<String, boolean[]> values;
	
	public Operation() {
		
	}
	
	public Operation(Operation left, Operation right) {
		this.left = left;
		this.right = right;
	}


	public boolean carryOut(){
		boolean tmpLeft = left.carryOut();
		boolean tmpRight = right.carryOut();

		return operator(tmpLeft, tmpRight);
	}

	public void setLeft(Operation left) {
		this.left = left;
	}

	public void setRight(Operation right) {
		this.right = right;
	}

	protected boolean operator(boolean left, boolean right) {
		return false; 
	}
}
