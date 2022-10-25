package controller;

import model.Plus;

import model.Base;
import model.Closure;
import model.Cross;
import model.Division;
import model.Operation;
import model.Minus;
import view.View;

public class Controller {
    private Base p, q, r;
    private View view;
    private Closure head;
    private String operation;
    private String options [] = {"+","-","*","(",")","/"};
    private String instruccion = "_ \n\n Seleccione la opción que desea agregar: \n";
    private int maxLetters = 90;

    public Controller(View view){

        for(int i = 65; i <= maxLetters; i++){
            int length = options.length;
            String [] temp = options;
            options = new String[length+1];
            for(int j = 0; j < length; j++){
                options[j] = temp[j];
            }
            options[length] = (char)i+"";
        }
        this.operation = "";
        this.view = view;
        this.view.setOptions(options);
    }
    
    public void start(){
        
        head = createClosure();
        String inOrder = head.inOrden();
        String postOrden = head.postOrden();
        String preOrden = head.preOrden();

        System.out.println("en "+inOrder+"\n pre "+preOrden+"\n post "+postOrden);

    }

    private Closure createClosure(){
        this.operation+="(";

        Operation left = selectLeft();
        Operation operation = selectType(left);
        
        Closure returnOperation = new Closure(operation);
        
        return returnOperation;
    }

    private Cross createCross(Operation left){
        Cross cross = null;
        Operation right = selectRight();
        cross = new Cross(left, right);
        return cross;
    }

    private Plus createPlus(Operation left){
        
        Plus plus = null;
        Operation right = selectRight();
        plus = new Plus(left, right);
        return plus;
    }

    private Minus createMinus(Operation left){
        Minus minus = null;
        Operation right = selectRight();
        minus = new Minus(left, right);
        return minus;
    }

    private Division createDivision(Operation left){
        Division division = null;
        Operation right = selectRight();
        division = new Division(left, right);
        return division;
    }

    private Operation createType(Operation left, int option) {
        Operation operationLocal = null;
        operation+=options[option];
        
        switch (option) {
            case 0:
                operationLocal =  createPlus(left);
                break;
            case 1:
                operationLocal = createMinus(left);
                break;
            case 2:
                operationLocal = createCross(left);
                break;
            case 5:
                operationLocal = createDivision(left);
            default:
                break;
        }
        
        operationLocal = operationEnded(operationLocal);
        
        return operationLocal;
    }

    private Operation selectLeft() {

        int[] opt = new int[maxLetters-63];
        for(int i = 0; i < opt.length-1; i++){
            opt[i] = i+6;
        }
        opt[opt.length-1] = 3;
        view.showInputOptions(operation+instruccion, opt);
        
        int option;
        Operation left = null;
        
        try {
            option = view.getOption();
            
            if(option >= 6 && option <= 6+maxLetters-65){
                operation += options[option];
                left = new Base(options[option]);
            } else if (option == 3){
                left = createClosure();
            }
        } catch (Exception e) {} 
        
        return left;
    }

    private Operation selectRight(){
        int[] opt = new int[maxLetters-63];
        for(int i = 0; i < opt.length-1; i++){
            opt[i] = i+6;
        }
        opt[opt.length-1] = 3;
        view.showInputOptions(operation+instruccion, opt);
        
        int option;
        Operation right = null;
        
        try {
            option = view.getOption();
            
            if(option >= 6 && option <= 6+maxLetters-65){
                operation += options[option];
                right = new Base(options[option]);
            } else if (option == 3){
                right = createClosure();
            }
        } catch (Exception e) {} 
        
        return right;
    }
     
    private Operation selectType(Operation left) {
        view.showInputOptions(operation+instruccion, new int[]{0,1,2,5});
        int option;
        Operation operationLocal = null;
        try {
            option = view.getOption();
            operationLocal = createType(left, option);
        }catch (Exception e){}
        return operationLocal;
    }
    
    private Operation operationEnded(Operation operation){
        view.showInputOptions(this.operation+instruccion, new int[]{0,1,2,5,4});
        int option;
        Operation tmpRight = null;
        try{
            option = view.getOption();
            if((option == 2 || option == 5) && (operation instanceof Plus && operation instanceof Minus)){
                tmpRight = operation.getRight();
                operation.setRight(createType(tmpRight, option));

                return operation;
            }
            if (option == 4){
                this.operation+=")";
                return operation;
            }

            operation = createType(operation, option);
        }catch (Exception e){}
        return operation;
    }

}
