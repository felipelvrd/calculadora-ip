/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class FrmGenerarIP extends javax.swing.JFrame {

    /**
     * Creates new form frmGenerarIP
     */
    
    Random rand = new Random();
    JTextField ip1, ip2, ip3, ip4;
    JTextField bip1, bip2, bip3, bip4;
    FrmPrin x;
    
    
    public FrmGenerarIP(FrmPrin x, JTextField ip1, JTextField ip2,JTextField ip3,JTextField ip4,JTextField bip1, JTextField bip2,JTextField bip3,JTextField bip4) {
        initComponents();
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
        
        this.bip1=bip1;
        this.bip2=bip2;
        this.bip3=bip3;
        this.bip4=bip4;
        
        this.x = x;
        
    }

    private FrmGenerarIP() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        clase = new javax.swing.JComboBox();
        tipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("jLabel2");

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setTitle("Generar IP");
        setResizable(false);

        clase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "A", "B", "C", "D", "E" }));
        clase.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                claseItemStateChanged(evt);
            }
        });

        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Publica", "Privada" }));

        jLabel1.setText("Clase:");

        jLabel3.setText("IP:");

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setClase(){
        switch (clase.getSelectedIndex()){
            case 0:
                ipField.ip[0]=rand.nextInt(254)+1;
                break;
            case 1:
                ipField.ip[0]=rand.nextInt(127)+1;
                break;
            case 2:
                ipField.ip[0]=rand.nextInt(64)+128;
                break;
            case 3:
                ipField.ip[0]=rand.nextInt(32)+192;
                break;
            case 4:
                ipField.ip[0]=rand.nextInt(16)+224;
                break;
            case 5:
                ipField.ip[0]=rand.nextInt(15)+240;
                break;
        }
    }
    
    private void setTipo(){
        switch (tipo.getSelectedIndex()){
            case 1:
                while((ipField.ip[0]==10) || ((ipField.ip[0]==172) && (ipField.ip[1]>=16 && ipField.ip[1]<=31)) || (ipField.ip[0]==192 && ipField.ip[1]==168)){
                    setClase();
                }
                break;
            case 2:
                int x;
                if(clase.getSelectedIndex()==0){
                    x=rand.nextInt(3)+1;
                }else{
                    x=clase.getSelectedIndex();
                }
                switch (x){
                    case 1:
                        ipField.ip[0]=10;
                        break;
                    case 2:
                        ipField.ip[0]=172;
                        ipField.ip[1]=rand.nextInt(16)+16;
                        break;
                    case 3:
                        ipField.ip[0]=192;
                        ipField.ip[1]=168;
                        break;
                }
                break;
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        setClase();
        
        ipField.ip[1]=rand.nextInt(256);
        ipField.ip[2]=rand.nextInt(256);
        ipField.ip[3]=rand.nextInt(256);
        
        
        
        if(tipo.isEnabled()){
            setTipo();
        }
        
        ipField.abrirDec(ip1, ip2, ip3, ip4);
        ipField.abrirBin(bip1, bip2, bip3, bip4);

        this.setVisible(false);
        x.setMask();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void claseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_claseItemStateChanged
        // TODO add your handling code here:
        switch (clase.getSelectedIndex()){
            case 0:
            case 1:
            case 2:
            case 3:
                tipo.setEnabled(true);
                break;
            case 4:
            case 5:
                tipo.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_claseItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new FrmGenerarIP().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox clase;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox tipo;
    // End of variables declaration//GEN-END:variables
}
