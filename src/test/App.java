package test;

import controller.Controller;
import view.View;
public class App {
    public App() {
    }

    public static void main(String[] args) {
        View view = new View("Arbol de ordenamiento", "Bienvenido, selecciona la opcion correspondiente");
        Controller controller = new Controller(view);
        controller.start();
    }
}
