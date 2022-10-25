package view;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import model.Operation;
import java.awt.Dimension;
import java.util.Map;
public class PanelResultados extends JSplitPane {
    public PanelResultados(Operation head, Map <String,String> map) {
        super(JSplitPane.HORIZONTAL_SPLIT);
        ArbolBinarioGrafico arbol = new ArbolBinarioGrafico(head);
        Dimension minimumSize = new Dimension(500, 500);
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        
        //listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            JLabel label = new JLabel(entry.getKey() + " = " + entry.getValue());
            listPanel.add(label);

        }

        
        listPanel.setMinimumSize(minimumSize);
        this.setLeftComponent(arbol);
        this.setRightComponent(listPanel);
        this.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width-500);
    }
}
