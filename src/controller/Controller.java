package controller;

import model.Base;
import view.View;

public class Controller {
    Base p, q, r;
    View view;
    Controller(){
        p = new Base();
        q = new Base();
        r = new Base();
        view = new View();
    }   
}
