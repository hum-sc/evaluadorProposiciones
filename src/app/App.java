package app;


public class App{
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        Ventana ventana = new Ventana(controller);
        controller.setVentana(ventana);
    }
}
