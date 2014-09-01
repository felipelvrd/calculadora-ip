/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public  class Field {
    
    private static void Restricion(java.awt.event.KeyEvent evt, int m, int M, int t) {
        JTextField x = (JTextField) evt.getSource();
        int k = (int) evt.getKeyChar();
        if (k < m || k > M) {
            evt.consume();
        }
        if (x.getText().length() == t) {
            evt.consume();
        }
        if (x.getText().length() >= t-1 && k != 8 && k != 127) {
            x.transferFocus();
        }
    }

    private static void StrgToInt(String x, int i, int[] ip) {
        if (!x.equals("")) {
            ip[i] = Integer.valueOf(x);
        } else {
            ip[i] = -1;
        }
    }

    private static void BinStrgToInt(String x, int i, int[] ip) {
        if (!x.equals("")) {
            ip[i] = Integer.parseInt(x, 2);
        } else {
            ip[i] = -1;
        }
    }

    private static String IntToStrg(int i, int[] ip) {
        if (ip[i] != -1) {
            String x = String.valueOf(ip[i]);
            for (int k = 0; x.length() < 3; k++) {
                x = "0" + x;
            }
            return x;
        }
        return "";
    }

    protected static String IntToBinaryStrg(int i) {
        if (i != -1) {
            String x = Integer.toBinaryString(i);
            for (int k = 0; x.length() < 8; k++) {
                x = "0" + x;
            }
            return x;
        }
        return "";
    }

    protected static void GuardarDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4, int ip[]) {
        StrgToInt(v1.getText(), 0,ip);
        StrgToInt(v2.getText(), 1,ip);
        StrgToInt(v3.getText(), 2,ip);
        StrgToInt(v4.getText(), 3,ip);
    }

    protected static void GuardarBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4, int[] ip) {
        BinStrgToInt(v1.getText(), 0,ip);
        BinStrgToInt(v2.getText(), 1,ip);
        BinStrgToInt(v3.getText(), 2,ip);
        BinStrgToInt(v4.getText(), 3,ip);
    }

    protected static void abrirDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4, int[] ip) {
        v1.setText(IntToStrg(0,ip));
        v2.setText(IntToStrg(1,ip));
        v3.setText(IntToStrg(2,ip));
        v4.setText(IntToStrg(3,ip));
    }

    protected static void abrirBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4, int[] ip) {
        v1.setText(IntToBinaryStrg(ip[0]));
        v2.setText(IntToBinaryStrg(ip[1]));
        v3.setText(IntToBinaryStrg(ip[2]));
        v4.setText(IntToBinaryStrg(ip[3]));
    }

    protected static void Reset(int[] ip) {
        for (int i = 0; i < ip.length; i++) {
            ip[i] = -1;
        }
    }
    
    public static void check(java.awt.event.FocusEvent evt) {
        JTextField x = (JTextField) evt.getSource();
        if(!x.getText().equals("")){
            if (Integer.valueOf(x.getText()) > 255) {
                JOptionPane.showMessageDialog(null, x.getText() + " no es una entrada válida. "
                                                                + "Especifique un valor entre 0 y 255.", 
                                                                  "Entrada invalida", 0);
                x.setText("255");
            }
        }
    }
    
    public static void RestricionDec(java.awt.event.KeyEvent evt) {
        Restricion(evt, 48, 57, 3);
    }

    public static void RestricionBin(java.awt.event.KeyEvent evt) {
        Restricion(evt, 48, 49, 8);
    }
    
}
