package model;

public class Base extends Operation {
    private boolean value;
    public Base(){
        super();
        value = false;
    }
    public Base(boolean value){
        super();
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean carryOut() {
        return this.value;
    }

}
