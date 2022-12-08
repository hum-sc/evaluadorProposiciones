package arbolBinario.view;
import javax.swing.*;

import arbolBinario.model.Closure;
import arbolBinario.model.Operation;

import java.awt.*;

public class ArbolBinarioGrafico extends JPanel {

    private Operation head;

    public ArbolBinarioGrafico(Operation head) {
        super();
        this.head = head;
        this.setSize(400,400);
    }

    public int drawTree(Graphics g, Operation x, int x0, int x1, int y){
        if (x instanceof Closure) x = x.getOperation();
        int m = (x0 + x1) / 2;
        g.setColor(Color.WHITE);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = x.toString();
        g.drawString(t, m+20, y+30);
        if (x.getLeft() != null) {
            int x2 = drawTree(g, x.getLeft(),x0,m,y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (x.getRight() != null) {
            int x2 = drawTree(g, x.getRight(),m,x1,y+50);
            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTree(g, head, 0, this.getWidth()-25, 100);
    }
}