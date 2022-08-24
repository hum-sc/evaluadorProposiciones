package test;

import controller.Controller;
import view.View;
public class App {
    public App() {
    }

    public static void main(String[] args) {
        View view = new View("Calculadora de proposiciones");
        Controller controller = new Controller(view);
        controller.start();
    }
}
