package view;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;


public class View{
    private JFrame frame;
    
    public View(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public View(String title){
        
    }

    public void showTable(String message, Map<String, boolean[]> data, String title){
        String[] columnNames = new String[data.size()];
        String[][] rowData = new String[8][data.size()];
        int i = 0;
        for(String key : data.keySet()){
            columnNames[i] = key;
            boolean[] values = data.get(key);
            for(int j = 0; j < values.length; j++){
                rowData[j][i] = values[j] ? "1" : "0";
            }
            i++;
        }
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(450,150));
        table.setFillsViewportHeight(true);
        JFrame frame = new JFrame(title);
        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public int showInputOptions(String instruction, int requiredOptions []){
        String options [] = {"p","q","r","^","v","¬","(",")","Evaluar"};
        String data = instruction+"\n";
        int selected = 1000000000;
        
        for(int i = 0; i < requiredOptions.length; i++){
            data +=requiredOptions[i] + ". " + options[requiredOptions[i]]+"\n";
        }
        
        try {
            selected = Integer.parseInt(JOptionPane.showInputDialog(null,data));
        } catch (Exception e) {
            System.out.println(e);
            if(!e.getMessage().equals("Cannot parse null string")){
                this.showMessage("El valor ingresado no es valido");
                selected = this.showInputOptions(instruction, requiredOptions);
            }
           
            //TODO: handle exception
        }
        return selected;
    }

}
