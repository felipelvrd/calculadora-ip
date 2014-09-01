/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ip;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class FrmInfo extends javax.swing.JFrame {

    /**
     * Creates new form FrmInfo
     */
    String ip;
    String mask;
    String ipRed;
    String ipBroad;
    int bits;
    int clase;
    int subRed;
    frmSubNet sn;
    frmHost h;
    int [] vec;
    int [] vec1;
    int tipo;
    DefaultListModel list;
    
    public FrmInfo() {
        initComponents();
        
        vec=ipField.ip.clone();
        vec1=maskField.mask.clone();
        tipo=ipField.getTipo();
 
        javax.swing.ToolTipManager.sharedInstance().setDismissDelay( 999999999 ); 
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay( 0 );
   
        
        ip=ipField.ip[0]+"."+ipField.ip[1]+"."+ipField.ip[2]+"."+ipField.ip[3];
        lIP.setText("IP: "+ip);
        lIP.setToolTipText(Field.IntToBinaryStrg(ipField.ip[0])+" . "+
                           Field.IntToBinaryStrg(ipField.ip[1])+" . "+
                           Field.IntToBinaryStrg(ipField.ip[2])+" . "+
                           Field.IntToBinaryStrg(ipField.ip[3]));
        this.setTitle(""+ip);
        
        if(ipField.ip[0]<=127){
            lClase.setText("Clase: A");
        }else if(ipField.ip[0]<=191){
            lClase.setText("Clase: B");
        }else if(ipField.ip[0]<=223){
            lClase.setText("Clase: C");
        }else if(ipField.ip[0]<=239){
            lClase.setText("Clase: D");
            this.setSize(new Dimension(230, 90));
        }else if(ipField.ip[0]<=255){
            lClase.setText("Clase: E");
            this.setSize(new Dimension(230, 90));
        }

        if( (ipField.ip[0]==10) || ((ipField.ip[0]==172) && (ipField.ip[1]>=16 && ipField.ip[1]<=31)) || (ipField.ip[0]==192 && ipField.ip[1]==168)){
            lPublic.setText("IP Privada");
        }
        else{
            lPublic.setText("IP Publica");
        }
        
        lMask.setText("Máscara: "+ maskField.mask[0]+"."+maskField.mask[1]+"."+maskField.mask[2]+"."+maskField.mask[3]);
        lMask.setToolTipText(Field.IntToBinaryStrg(maskField.mask[0])+" . "+
                             Field.IntToBinaryStrg(maskField.mask[1])+" . "+
                             Field.IntToBinaryStrg(maskField.mask[2])+" . "+
                             Field.IntToBinaryStrg(maskField.mask[3]));
        
        bits=0;
        mask=Field.IntToBinaryStrg(maskField.mask[0])+
             Field.IntToBinaryStrg(maskField.mask[1])+
             Field.IntToBinaryStrg(maskField.mask[2])+
             Field.IntToBinaryStrg(maskField.mask[3]);
        for(int i=0;i<mask.length();i++){
            if(mask.charAt(i)=='1'){
                bits++;
            }
        }
        lMaskBits.setText("Máscara de "+bits+" bits");
        
        ipRed=(ipField.ip[0] & maskField.mask[0])+"."+
              (ipField.ip[1] & maskField.mask[1])+"."+
              (ipField.ip[2] & maskField.mask[2])+"."+
              (ipField.ip[3] & maskField.mask[3]);
        lIPRed.setText("Ip de Red: "+ ipRed);
        
        lIPRed.setToolTipText(Field.IntToBinaryStrg(ipField.ip[0] & maskField.mask[0])+" . "+
                              Field.IntToBinaryStrg(ipField.ip[1] & maskField.mask[1])+" . "+
                              Field.IntToBinaryStrg(ipField.ip[2] & maskField.mask[2])+" . "+
                              Field.IntToBinaryStrg(ipField.ip[3] & maskField.mask[3]));
      
        ipBroad= (ipField.ip[0] | ~(-256 | maskField.mask[0]))+"."+
                 (ipField.ip[1] | ~(-256 | maskField.mask[1]))+"."+
                 (ipField.ip[2] | ~(-256 | maskField.mask[2]))+"."+
                 (ipField.ip[3] | ~(-256 | maskField.mask[3]));
        lIPBroad.setText("Ip de Broadcast: "+ ipBroad);
        
        lIPBroad.setToolTipText(Field.IntToBinaryStrg(ipField.ip[0] | ~(-256 | maskField.mask[0]))+" . "+
                                Field.IntToBinaryStrg(ipField.ip[1] | ~(-256 | maskField.mask[1]))+" . "+
                                Field.IntToBinaryStrg(ipField.ip[2] | ~(-256 | maskField.mask[2]))+" . "+
                                Field.IntToBinaryStrg(ipField.ip[3] | ~(-256 | maskField.mask[3])));
        if(ipField.getTipo()==0){
            clase=128;
            subRed=bits-8;
        }else if (ipField.getTipo()==1){
            clase=16384;
            subRed=bits-16;
        }else if (ipField.getTipo()==2){
            clase=2097152;
            subRed=bits-24;
        }
        
        lCantRed.setText("Cantidad de Redes: "+clase);
        
        lCantSubRed.setText("<html><font color=\"#0000CF\"><u>"+"Cantidad de Sub Redes: "+(int)Math.pow(2, subRed)+"</u></font></html>");
        
        lCantHost.setText("<html><font color=\"#0000CF\"><u>"+"Cantidad de Host por Red: "+(int)(Math.pow(2, 32-bits)-2)+"</u></font></html>");
        
        if(ip.equals(ipRed)){
            lIpTipo.setText("Ip de Red");
        }else if(ip.equals(ipBroad)){
            lIpTipo.setText("Ip de Broadcats");
        }else{
            lIpTipo.setText("Ip de Host");
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lMask = new javax.swing.JLabel();
        lClase = new javax.swing.JLabel();
        lPublic = new javax.swing.JLabel();
        lIP = new javax.swing.JLabel();
        lMaskBits = new javax.swing.JLabel();
        lIPRed = new javax.swing.JLabel();
        lIPBroad = new javax.swing.JLabel();
        lCantRed = new javax.swing.JLabel();
        lIpTipo = new javax.swing.JLabel();
        lCantSubRed = new javax.swing.JLabel();
        lCantHost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lMask.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lMask.setText("Máscara: 000.000.000.000");
        lMask.setToolTipText("");

        lClase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lClase.setText("Clase: A");

        lPublic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lPublic.setText("IP Publica");

        lIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lIP.setText("IP: 000.000.000.000");

        lMaskBits.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lMaskBits.setText("Máscara de 32bits");

        lIPRed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lIPRed.setText("Ip de Red: 000.000.000.000");

        lIPBroad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lIPBroad.setText("Ip de Broadcast: 000.000.000.000");

        lCantRed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lCantRed.setText("Cantidad de Redes: 25");

        lIpTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lIpTipo.setText("Ip de Host");

        lCantSubRed.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lCantSubRed.setText("Cantidad de Sub Redes: 25");
        lCantSubRed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lCantSubRed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCantSubRedMouseClicked(evt);
            }
        });

        lCantHost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lCantHost.setText("Cantidad de Host por Red: 25");
        lCantHost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lCantHost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lCantHostMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMask)
                    .addComponent(lClase)
                    .addComponent(lPublic)
                    .addComponent(lIP)
                    .addComponent(lMaskBits)
                    .addComponent(lIPRed)
                    .addComponent(lIPBroad)
                    .addComponent(lCantRed)
                    .addComponent(lIpTipo)
                    .addComponent(lCantSubRed)
                    .addComponent(lCantHost))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lClase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPublic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lIpTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lMask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lMaskBits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lIPRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lIPBroad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCantRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCantSubRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lCantHost)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarList(){
        
        list=new DefaultListModel();
        int top=(int)Math.pow(2, subRed);
        for (int i=0;i<top;i++){
            String smask=Integer.toBinaryString(i);
            for (int j=0;smask.length()<subRed;j++){
                smask="0"+smask;
            }
            if(tipo==0){
                for (int j=0; j<24-subRed;j++){
                    smask+="0";
                }
                String[] sip=new String[3];
                sip[0]="";
                sip[1]="";
                sip[2]="";
                for(int j=0;j<8;j++){
                    sip[0]+=smask.charAt(j);
                    sip[1]+=smask.charAt(j+8);
                    sip[2]+=smask.charAt(j+16);
                }
                list.addElement(vec[0]+"."+Integer.parseInt(sip[0], 2)+"."+Integer.parseInt(sip[1], 2)+"."+Integer.parseInt(sip[2], 2));
            }
            
            if(tipo==1){
                for (int j=0; j<16-subRed;j++){
                    smask+="0";
                }
                String[] sip=new String[2];
                sip[0]="";
                sip[1]="";
              
                for(int j=0;j<8;j++){
                    sip[0]+=smask.charAt(j);
                    sip[1]+=smask.charAt(j+8);
                }
                list.addElement(vec[0]+"."+vec[1]+"."+Integer.parseInt(sip[0], 2)+"."+Integer.parseInt(sip[1], 2));
            }
            if(tipo==2){
                for (int j=0; j<8-subRed;j++){
                    smask+="0";
                }
                list.addElement(vec[0]+"."+vec[1]+"."+vec[2]+"."+Integer.parseInt(smask, 2));
            }
        }
    }
    
    private void lCantSubRedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCantSubRedMouseClicked
        // TODO add your handling code here:
        if(sn==null){
            if(list==null){
                llenarList();
            }
            sn=new frmSubNet(list,vec1);       
        }
        
        
        sn.setLocationRelativeTo(this);
        sn.setVisible(true);
    }//GEN-LAST:event_lCantSubRedMouseClicked

    private void lCantHostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lCantHostMouseClicked
        // TODO add your handling code here:
        if(h==null){
            if(list==null){
                llenarList();
            }
            h=new frmHost(list,vec1,bits,(int)(Math.pow(2, 32-bits)-2));       
        }
        
        
        h.setLocationRelativeTo(this);
        h.setVisible(true);
    }//GEN-LAST:event_lCantHostMouseClicked

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
            java.util.logging.Logger.getLogger(FrmInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInfo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lCantHost;
    private javax.swing.JLabel lCantRed;
    private javax.swing.JLabel lCantSubRed;
    private javax.swing.JLabel lClase;
    private javax.swing.JLabel lIP;
    private javax.swing.JLabel lIPBroad;
    private javax.swing.JLabel lIPRed;
    private javax.swing.JLabel lIpTipo;
    private javax.swing.JLabel lMask;
    private javax.swing.JLabel lMaskBits;
    private javax.swing.JLabel lPublic;
    // End of variables declaration//GEN-END:variables
}
