/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class maskField extends Field{

    static int[] mask=new int[4];
    
    public static void abrirBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        abrirBin(v1, v2, v3, v4,mask);
    }
    public static void abrirDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        abrirDec(v1, v2, v3, v4,mask);
    }
    public static void GuardarBin(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        GuardarBin(v1, v2, v3, v4,mask);
    }
    public static void GuardarDec(JTextField v1, JTextField v2, JTextField v3, JTextField v4){
        GuardarDec(v1, v2, v3, v4,mask);
    }
    public static void Reset(){
        Reset(mask);
    }
    public static boolean isOK(){
        Field x = new Field();
        String mascara=IntToBinaryStrg(mask[0])+
                       IntToBinaryStrg(mask[1])+
                       IntToBinaryStrg(mask[2])+
                       IntToBinaryStrg(mask[3]);
        for(int i=0; i<mascara.length();i++){
            if(mascara.charAt(i)=='0'){
                for(int j=i;j<mascara.length();j++){
                    if(mascara.charAt(j)!='0'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}