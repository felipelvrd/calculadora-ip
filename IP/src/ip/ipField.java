/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author felipe
 */
public class ipField extends Field{

    static int[] ip = new int[4];
    
    public static void abrirBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        abrirBin(v1, v2, v3, v4,ip);
    }
    public static void abrirDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        abrirDec(v1, v2, v3, v4,ip);
    }
    public static void GuardarBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        GuardarBin(v1, v2, v3, v4,ip);
    }
    public static void GuardarDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        GuardarDec(v1, v2, v3, v4,ip);
    }
    public static void Reset(){
        Reset(ip);
    }
    public static int getTipo(){
     
        if(ip[0]<=127){
         //clase A
            return 0;
        }else if(ip[0]<=191){
         ///clase B
            return 1;
               
        }else if(ip[0]<=223){
         //clase C
            return 2;
                
        }else if(ip[0]<=239){
         //clase D
            return 3;
        }else if(ip[0]<=255){
         //clase E
            return 4;
        }
        return -1;
    }
    
    public static void setMask(JTextField x,JTextField m1,JTextField m2,JTextField m3,JTextField m4,JTextField mb1,JTextField mb2,JTextField mb3,JTextField mb4,JTabbedPane panel, JButton gm){
        if(!x.getText().equals("")){
            if(ip[0]<=127){
                //clase A
                panel.setEnabled(true);
                m2.setEditable(true);
                m3.setEditable(true);
                m4.setEditable(true);
                mb2.setEditable(true);
                mb3.setEditable(true);
                mb4.setEditable(true);
                gm.setEnabled(true);
                m1.setText("255"); 
                mb1.setText("11111111");
                m2.setText("");
                mb2.setText("");
                m3.setText("");
                mb3.setText("");
                m4.setText("");
                mb4.setText("");
            }else if(ip[0]<=191){
                ///clase B
                panel.setEnabled(true);
                m2.setEditable(false);
                m3.setEditable(true);
                m4.setEditable(true);
                mb2.setEditable(false);
                mb3.setEditable(true);
                mb4.setEditable(true);
                gm.setEnabled(true);
                m1.setText("255");
                mb1.setText("11111111");
                m2.setText("255");
                mb2.setText("11111111");
                m3.setText("");
                mb3.setText("");
                m4.setText("");
                mb4.setText("");
            }else if(ip[0]<=223){
                //clase C
                panel.setEnabled(true);
                m2.setEditable(false);
                m3.setEditable(false);
                m4.setEditable(true);
                mb2.setEditable(false);
                mb3.setEditable(false);
                mb4.setEditable(true);
                gm.setEnabled(true);
                m1.setText("255");
                mb1.setText("11111111");
                m2.setText("255");
                mb2.setText("11111111");
                m3.setText("255");
                mb3.setText("11111111");
                m4.setText("");
                mb4.setText("");
            }else if(ip[0]<=255){
                //clase D o clase E
                panel.setEnabled(false);
                m2.setEditable(false);
                m3.setEditable(false);
                m4.setEditable(false);
                mb2.setEditable(false);
                mb3.setEditable(false);
                mb4.setEditable(false);
                gm.setEnabled(false);
                m1.setText("");
                mb1.setText("");
                m2.setText("");
                mb2.setText("");
                m3.setText("");
                mb3.setText("");
                m4.setText("");
                mb4.setText("");
            }
        }else{
            panel.setEnabled(false);
            m2.setEditable(false);
            m3.setEditable(false);
            m4.setEditable(false);
            mb2.setEditable(false);
            mb3.setEditable(false);
            mb4.setEditable(false);
            gm.setEnabled(false);
        }
    }
    
}
