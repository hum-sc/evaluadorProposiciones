package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import model.Mas;
import model.Menos;
import model.Multiplicacion;
import model.Divicion;
import model.Potencia;
import model.Base;
import model.Closure;
import model.Operation;
import view.View;

public class Controller {
	protected Base A, B, C, D;

    private View view;
    private Closure head;
    private String proposicion;
    private String v;
    private String options [] = {"A","B","C","D","*","/","+","-","^","(",")","Evaluar"};
    private String instruccion = "_ \n\n Seleccione la opción que desea agregar: \n";

    public Controller(View view){
        A = new Base('A');
        B = new Base('B');
        C = new Base('C');
        D = new Base('D');
        proposicion = "";
        this.view = view;

    }
    
    public void start(){
        view.setVisible(true);
        
        head = createClosure();
        
        
        view.showOrden("La proposicion es una ",v, "Tabla de resultados");
    }

    private Closure createClosure(){
        proposicion += "(";
        Operation left = selectLeft();
        
        Operation operation = selectType(left);
        
        Closure returnOperation = new Closure(operation);
        this.v=operation.EnOrden();
        proposicion+=")";
        
        
        return returnOperation;
    }

    private Operation selectLeft() {
        view.showInputOptions(proposicion+instruccion, new int[]{0,1,2,3,9});
        int option;
        Operation left = null;
        try {
            option = view.getOption();
            
            if(option >= 0 && option <= 3){
                proposicion += options[option];
            }
            switch (option) {
                case 0:
                    left = A;
                    break;
                case 1:
                    left = B;
                    break;
                case 2:
                    left = C;
                    break;
                case 3:
                    left = D;
                    break;
                case 9:
                    left = createClosure();
                    break;
                default:
                    break;
            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return left;
    }
    private Operation selectRight(){
        view.showInputOptions(proposicion+instruccion, new int[]{0,1,2,3,9});
        int option;
        Operation right = null;
        try{
            option = view.getOption();
            if(option >= 0 && option <= 3){
                proposicion += options[option];
            }
            switch (option) {
            	case 0:
            		right = A;
            		break;
            	case 1:
            		right = B;
            		break;
            	case 2:
            		right = C;
                	break;
            	case 3:
            		right = D;
                	break;
            	case 9:
            		right = createClosure();
                	break;
            default:
                break;
            }
            
        }catch(Exception e){}
        
        return right;
    }


    private Operation selectType(Operation left, int option) {
        Operation operation = null;

        switch (option) {
            case 4:
                operation =  createMul(left);
                break;
            case 5:
                operation = createDiv(left);
                break;
            case 6:
                operation = createMas(left);
                break;
            case 7:
                operation = createMenos(left);
                break;
            case 8:
                operation = createPot(left);
                break;
            default:
                break;
        }
        operation = operationEnded(operation);
        
        return operation;
    }
    
    private Operation selectType(Operation left) {
        view.showInputOptions(proposicion+instruccion, new int[]{4,5,6,7,8});
        int option;
        Operation operation = null;
        try {
            option = view.getOption();
            operation = selectType(left, option);
        }catch (Exception e){}
        return operation;
    }

    
    private Multiplicacion createMul(Operation left){
    	Multiplicacion and = null;
        proposicion+="*";
        Operation right = selectRight();
        and = new Multiplicacion(left, right);
        return and;
    }
    private Divicion createDiv(Operation left){
    	Divicion and = null;
        proposicion+="/";
        Operation right = selectRight();
        and = new Divicion(left, right);
        return and;
    }
    
    private Mas createMas(Operation left){
        Mas or = null;
        proposicion+="+";
        Operation right = selectRight();
        or = new Mas(left, right);
        return or;
    }
    private Menos createMenos(Operation left){
        Menos or = null;
        proposicion+="-";
        Operation right = selectRight();
        or = new Menos(left, right);
        return or;
    }
    private Potencia createPot(Operation left){
    	Potencia pot = null;
        proposicion+="^";
        Operation right = selectRight();
        pot = new Potencia(left, right);
        return pot;
    }
    
    private Operation operationEnded(Operation operation){
        view.showInputOptions(proposicion+instruccion, new int[]{4,5,6,7,10});
        int option;
        Operation tmpRight = null;
        try{
            option = view.getOption();
            if(option == 4 && operation instanceof Mas){
                tmpRight = operation.getRight();
                operation.setRight(selectType(tmpRight, option));
                return operation;
            }
            if(option == 4 && operation instanceof Menos){
                tmpRight = operation.getRight();
                operation.setRight(selectType(tmpRight, option));
                return operation;
            }
            if(option == 5 && operation instanceof Mas){
                tmpRight = operation.getRight();
                operation.setRight(selectType(tmpRight, option));
                return operation;
            }
            if(option == 5 && operation instanceof Menos){
                tmpRight = operation.getRight();
                operation.setRight(selectType(tmpRight, option));
                return operation;
            }
            
            if (option == 10){
                return operation;
            }

            operation = selectType(operation, option);
        }catch (Exception e){}
        
        return operation;
    }
    
}