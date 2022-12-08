package arbolBinario.test;

import arbolBinario.controller.Controller;
import arbolBinario.view.View;
public class App {
    public App() {
    }

    public static void main(String[] args) {
        View view = new View("Calculadora de proposiciones", "Bienvenido, selecciona la opcion correspondiente");
        Controller controller = new Controller(view);
        controller.start();
    }
}
