/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posapp;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2ndyrGroupA
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        initComponents();
         Dashboards dash = new Dashboards();
      jDesktopPane1.removeAll();
      jDesktopPane1.add(dash).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dash = new javax.swing.JToggleButton();
        menus = new javax.swing.JToggleButton();
        Transaction = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        DashboardBtn1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(221, 740));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dash.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dash.setText("Dashboard");
        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashMouseClicked(evt);
            }
        });
        jPanel2.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 50));

        menus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        menus.setText("Menu");
        menus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menusMouseClicked(evt);
            }
        });
        jPanel2.add(menus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, 50));

        Transaction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Transaction.setText("Transactions");
        Transaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransactionMouseClicked(evt);
            }
        });
        jPanel2.add(Transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 210, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posapp/rsz_60a639c68e86d.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 110));

        DashboardBtn1.setBackground(new java.awt.Color(255, 255, 255));
        DashboardBtn1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DashboardBtn1.setForeground(new java.awt.Color(255, 255, 255));
        DashboardBtn1.setText("ADMIN");
        DashboardBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardBtn1MouseClicked(evt);
            }
        });
        jPanel2.add(DashboardBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 460));

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(540, 540));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jPanel3.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 740, 460));

        jPanel1.setBackground(new java.awt.Color(25, 68, 68));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posapp/rsz_1rsz_60a646201b470.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(907, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 980, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardBtn1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     login lg=new login();
     lg.setVisible(true);
     setVisible(false);
     
    }//GEN-LAST:event_jLabel1MouseClicked

    private void TransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransactionMouseClicked
        TransactionsFrame tf = null;
        try {
            tf = new TransactionsFrame();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
       jDesktopPane1.removeAll();
       jDesktopPane1.add(tf).setVisible(true);
    }//GEN-LAST:event_TransactionMouseClicked

    private void menusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusMouseClicked
        Menu menu = null;
        try {
            menu = new Menu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
      jDesktopPane1.removeAll();
      jDesktopPane1.add(menu).setVisible(true);
    }//GEN-LAST:event_menusMouseClicked

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
       Dashboards dash = new Dashboards();
      jDesktopPane1.removeAll();
      jDesktopPane1.add(dash).setVisible(true);
    }//GEN-LAST:event_dashMouseClicked

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DashboardBtn1;
    private javax.swing.JToggleButton Transaction;
    private javax.swing.JToggleButton dash;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton menus;
    // End of variables declaration//GEN-END:variables
}
