package controller;

import java.util.HashMap;
import java.util.Map;

import model.And;
import model.Base;
import model.Closure;
import model.Not;
import model.Operation;
import model.Or;
import view.View;

public class Controller {
    private Base p, q, r;
    private View view;
    private Closure head;
    private String proposicion;
    private String options [] = {"p","q","r","^","v","¬","(",")","Evaluar"};
    private String instruccion = "_ \n\n Seleccione la opción que desea agregar: \n";
    private Map <String, boolean[]> answers;

    public Controller(View view){

        p = new Base('p');
        q = new Base('q');
        r = new Base('r');
        proposicion = "";

        this.view = view;

        answers = new HashMap<String, boolean[]>();

        answers.put("p", new boolean[8]);
        answers.put("q", new boolean[8]);
        answers.put("r", new boolean[8]);

    }
    
    public void start(){
        
        head = createClosure();
        
        this.carryOut();
        
        boolean[] result = answers.get(head.toString());
        int classifier = 0;
        String type;
        
        for(int i = 0; i < result.length; i++){
            if(result[i]){
                classifier += 1;
            }
        }

        switch (classifier){
            case 0:
                type = "Contradiccion";
                break;
            case 8:
                type = "Tautología";
                break;
            default:
                type = "Contingencia";
                break;
        }

        view.showTable("La proposicion es una "+type, answers, "Tabla de resultados");

    }

    private Closure createClosure(){
        proposicion += "(";
        
        Operation left = selectLeft();
        Operation operation = selectType(left);
        
        Closure returnOperation = new Closure(operation, answers);
        
        proposicion+=")";
        
        return returnOperation;
    }

    private Not createNot(){
        Not not = null;
        proposicion+="¬";
        Operation content = selectNot();
        not = new Not(content, answers);

        return not;
    }

    private And createAnd(Operation left){
        
        And and = null;
        proposicion+="^";
        Operation right = selectRight();
        and = new And(left, right);
        return and;
    }

    private Or createOr(Operation left){
        Or or = null;
        proposicion+="v";
        Operation right = selectRight();
        or = new Or(left, right);
        return or;
    }

    private Operation createType(Operation left, int option) {
        Operation operation = null;
        
        switch (option) {
            case 3:
                operation =  createAnd(left);
                break;
            case 4:
                operation = createOr(left);
                break;
            default:
                break;
        }
        
        operation = operationEnded(operation);
        
        return operation;
    }

    private Operation selectLeft() {
        view.showInputOptions(proposicion+instruccion, new int[]{0,1,2,5,6});
        
        int option;
        Operation left = null;
        
        try {
            option = view.getOption();
            
            if(option >= 0 && option <= 2){
                proposicion += options[option];
            }
            switch (option) {
                case 0:
                    left = p;
                    break;
                case 1:
                    left = q;
                    break;
                case 2:
                    left = r;
                    break;
                case 5:
                    left = createNot();
                    break;
                case 6:
                    left = createClosure();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {} 
        
        return left;
    }

    private Operation selectRight(){
        view.showInputOptions(proposicion+instruccion, new int[]{0,1,2,5,6});
        
        int option;
        Operation right = null;
        
        try{
            option = view.getOption();
            
            if(option >= 0 && option <= 2){
                proposicion += options[option];
            }
            
            switch (option) {
                case 0:
                    right = p;
                    break;
                case 1:
                    right = q;
                    break;
                case 2:
                    right = r;
                    break;
                case 5:
                    right = createNot();
                    break;
                case 6:
                    right = createClosure();
                    break;
                default:
                    break;
            }
            
        }catch(Exception e){}
        
        return right;
    }
    
    private Operation selectNot(){
        
        view.showInputOptions(proposicion+instruccion, new int[]{0,1,2,6});
        
        int option;
        Operation right = null;
        
        try{
            option = view.getOption();
            if(option >= 0 && option <= 2){
                proposicion += options[option];
            }
            switch (option){
                case 0:
                    right = p;
                    break;
                case 1:
                    right = q;
                    break;
                case 2:
                    right = r;
                    break;
                case 6:
                    right = createClosure();
                    break;
                default:
                    break;
            }
        } catch (Exception e){}
        
        return right;
    }
     
    private Operation selectType(Operation left) {
        view.showInputOptions(proposicion+instruccion, new int[]{3,4});
        int option;
        Operation operation = null;
        try {
            option = view.getOption();
            operation = createType(left, option);
        }catch (Exception e){}
        return operation;
    }
    
    private Operation operationEnded(Operation operation){
        view.showInputOptions(proposicion+instruccion, new int[]{3,4,7});
        int option;
        Operation tmpRight = null;
        try{
            option = view.getOption();
            if(option == 3 && operation instanceof Or){
                tmpRight = operation.getRight();
                operation.setRight(createType(tmpRight, option));

                return operation;
            }
            if (option == 7){
                return operation;
            }

            operation = createType(operation, option);
        }catch (Exception e){}
        return operation;
    }

    private void carryOut(){
        int l = 0;
        for(int i=0; i<2; i++){
           boolean valueP = i == 0 ? false: true;
           p.setValue(valueP);
           for (int j=0; j<2; j++){
               boolean valueQ = j == 0 ? false: true;
               q.setValue(valueQ);
               for (int k=0; k<2; k++){
                    boolean valueR = k == 0 ? false: true;
                    boolean[] tmpP = answers.get("p");
                    boolean[] tmpQ = answers.get("q");
                    boolean[] tmpR = answers.get("r");
                    tmpP[l] = valueP;
                    tmpQ[l] = valueQ;
                    tmpR[l] = valueR;
                    answers.put("p", tmpP);
                    answers.put("q", tmpQ);
                    answers.put("r", tmpR);
                    r.setValue(valueR);
                    head.carryOut(l);
                    l+=1;
               }
           }
        }
    }

}
