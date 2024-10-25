/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fatin.jconnect;

import java.awt.Color;

/**
 *
 * @author moham
 */
public class JConnect extends javax.swing.JFrame {

    /**
     * Creates new form JothaTothaKotha
     */
    public JConnect() {
        initComponents();
        join.setOpaque(true);
        create.setOpaque(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        join = new javax.swing.JLabel();
        create = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(14, 22, 33));

        join.setBackground(new java.awt.Color(43, 82, 120));
        join.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        join.setForeground(new java.awt.Color(255, 255, 255));
        join.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        join.setText("Join Group");
        join.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        join.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                joinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                joinMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                joinMousePressed(evt);
            }
        });

        create.setBackground(new java.awt.Color(43, 82, 120));
        create.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Create Group");
        create.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to JConnect!!!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(join, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(join, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseEntered
        // TODO add your handling code here:
        create.setBackground(Color.decode("#1b2734"));
    }//GEN-LAST:event_createMouseEntered

    private void joinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joinMouseEntered
        // TODO add your handling code here:
        join.setBackground(Color.decode("#1b2734"));
    }//GEN-LAST:event_joinMouseEntered

    private void createMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseExited
        // TODO add your handling code here:
        create.setBackground(Color.decode("#2b5278"));
    }//GEN-LAST:event_createMouseExited

    private void joinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joinMouseExited
        // TODO add your handling code here:
        join.setBackground(Color.decode("#2b5278"));
    }//GEN-LAST:event_joinMouseExited

    private void createMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMousePressed
        // TODO add your handling code here:
        CreateGroup obj=new CreateGroup();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createMousePressed

    private void joinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_joinMousePressed
        // TODO add your handling code here:
        JoinGroup obj=new JoinGroup();
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_joinMousePressed

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
            java.util.logging.Logger.getLogger(JConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JConnect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel join;
    // End of variables declaration//GEN-END:variables
}
