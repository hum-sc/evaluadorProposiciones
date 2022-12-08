package operaciones.model;

public class Base extends Operation {
    private boolean value;
    char name;
    public Base(char n){
        super();
        value = false;
        name = n;
    }
    public Base(char n, boolean value){
        super();
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean carryOut(int i) {
        return this.value;
    }

    @Override
    public String toString() {
        return ""+name;
    }

}
