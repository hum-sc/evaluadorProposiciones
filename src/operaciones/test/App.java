package operaciones.test;

import operaciones.controller.Controller;
import operaciones.view.View;
public class App {

    public static void main(String[] args) {
        View view = new View("Calculadora de proposiciones", "Bienvenido, selecciona la opcion correspondiente");
        Controller controller = new Controller(view);
        controller.start();
    }
}
