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
public class FrmGenerarMask extends javax.swing.JFrame {
    

    /**
     * Creates new form FrmGenerarMask
     */
    JTextField ip1, ip2, ip3, ip4;
    JTextField bip1, bip2, bip3, bip4;
    public FrmGenerarMask(JTextField ip1, JTextField ip2,JTextField ip3,JTextField ip4,JTextField bip1, JTextField bip2,JTextField bip3,JTextField bip4) {
        initComponents();
        this.ip1=ip1;
        this.ip2=ip2;
        this.ip3=ip3;
        this.ip4=ip4;
        
        this.bip1=bip1;
        this.bip2=bip2;
        this.bip3=bip3;
        this.bip4=bip4;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        OK = new javax.swing.JButton();

        setTitle("Generar Mascara");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Cantidad de Host:");

        cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantKeyTyped(evt);
            }
        });

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OK)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
        if(!cant.getText().equals("")){
            int x=Integer.valueOf(cant.getText());
            int max=0;
            char clase='A';
            
            switch (ipField.getTipo()){
                case 0:
                    max=16777214;
                    clase ='A';
                    break;
                case 1:
                    max=65534;
                    clase='B';
                    break;
                case 2:
                    max=254;
                    clase='C';
                    break;
            }
           
            if(x>max){
                JOptionPane.showMessageDialog(this, "Clase: "+clase+" no puede tener más de "+max+" Host", "Fuera de Rango", 0);
            }else{
                String mask="";
            
                int i;
                for (i=0; (Math.pow(2, i)-2)<x;i++){}
                for (int j=0; j<i;j++){
                    mask+="0";
                }
                for (int j=0;mask.length()<24;j++){
                    mask="1"+mask;
                }
            
                String []vec=new String[3];
                vec[0]="";
                vec[1]="";
                vec[2]="";
            
                for (int j=0;j<8;j++){
                    vec[0]+=mask.charAt(j);
                    vec[1]+=mask.charAt(j+8);
                    vec[2]+=mask.charAt(j+16);
                }
                maskField.mask[0]=255;
                maskField.mask[1]=Integer.parseInt(vec[0], 2);
                maskField.mask[2]=Integer.parseInt(vec[1], 2);
                maskField.mask[3]=Integer.parseInt(vec[2], 2);
            
                maskField.abrirBin(bip1, bip2, bip3, bip4);
                maskField.abrirDec(ip1, ip2, ip3, ip4);
            
                this.setVisible(false);
                
            }
            
            
        }
    }//GEN-LAST:event_OKActionPerformed

    private void cantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantKeyTyped
        // TODO add your handling code here:
        JTextField x = (JTextField) evt.getSource();
        int k = (int) evt.getKeyChar();
        if(k==10){
            OKActionPerformed(null);
        }
        if (k < '0' || k > '9') {
            evt.consume();
        }
        if (x.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_cantKeyTyped

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        cant.setText("");
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(FrmGenerarMask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarMask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarMask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGenerarMask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new FrmGenerarMask().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK;
    private javax.swing.JTextField cant;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
