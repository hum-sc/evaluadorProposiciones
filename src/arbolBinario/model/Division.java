package arbolBinario.model;

public class Division extends Operation {
    public Division(Operation left, Operation right){
        super(left, right);
    }

    @Override
    public String toString() {
        return "/";
    }
}
