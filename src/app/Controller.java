package app;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Controller implements ActionListener{
    Ventana ventana;
    public Controller(){
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }
    public void proposicones(){
        operaciones.view.View vista = new operaciones.view.View("Calculadora de proposiciones", "Bienvenido, selecciona la opcion correspondiente");
        operaciones.controller.Controller controller = new operaciones.controller.Controller(vista);
        controller.start();
    }

    private void arbolOperaciones(){
        arbolBinario.view.View vista = new arbolBinario.view.View("Arbol de operaciones", "Bienvenido, selecciona la opcion correspondiente");
        arbolBinario.controller.Controller controller = new arbolBinario.controller.Controller(vista);
        controller.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "proposiciones":
                proposicones();
                break;
            case "arbolOperaciones":
                arbolOperaciones();
                break;
            case "torresHanoi":
                new torresHanoi.Ventana();
                break;
        }
    }

}