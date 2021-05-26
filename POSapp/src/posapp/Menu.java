/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posapp;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 2ndyrGroupA
 */
public final class Menu extends javax.swing.JInternalFrame {

    /**
     * Creates new form Menu
     */
    public Menu() throws ClassNotFoundException, SQLException {
        initComponents();
        id.setVisible(false);
        dispOrders();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //function
    public void dispOrders() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM menu");
            ResultSet rs = stmt.executeQuery();
            Class.forName("com.mysql.jdbc.Driver");

            ResultSetMetaData stData = rs.getMetaData();

            int q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel) menulist.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                int i;

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("id"));
                    columnData.add(rs.getString("category"));
                    columnData.add(rs.getString("menuname"));
                    columnData.add(rs.getString("price"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menulist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        menuName = new javax.swing.JTextField();
        Addmenu = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        EditMenu = new javax.swing.JButton();
        DeleteMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(740, 460));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(740, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setForeground(new java.awt.Color(0, 153, 153));

        menulist.setBackground(new java.awt.Color(0, 153, 153));
        menulist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menulist.setForeground(new java.awt.Color(255, 255, 255));
        menulist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "category", "Menu name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        menulist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menulistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menulist);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 440, 360));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Menu name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 79, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Menu list");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 190, -1));

        id.setForeground(new java.awt.Color(0, 153, 153));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 150, 38));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Php");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 41, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 79, -1));
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 38));
        jPanel1.add(menuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 200, 38));

        Addmenu.setBackground(new java.awt.Color(0, 51, 51));
        Addmenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Addmenu.setForeground(new java.awt.Color(255, 255, 255));
        Addmenu.setText("Add Menu");
        Addmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddmenuMouseClicked(evt);
            }
        });
        jPanel1.add(Addmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 200, 38));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 150, 38));

        EditMenu.setBackground(new java.awt.Color(0, 51, 51));
        EditMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EditMenu.setForeground(new java.awt.Color(255, 255, 255));
        EditMenu.setText("Edit Menu");
        EditMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMenuMouseClicked(evt);
            }
        });
        EditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenuActionPerformed(evt);
            }
        });
        jPanel1.add(EditMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 38));

        DeleteMenu.setBackground(new java.awt.Color(0, 51, 51));
        DeleteMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DeleteMenu.setForeground(new java.awt.Color(255, 255, 255));
        DeleteMenu.setText("Delete Menu");
        DeleteMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMenuMouseClicked(evt);
            }
        });
        DeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 200, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("category");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 79, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void AddmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddmenuMouseClicked

        String Category = category.getText();
        String menuname = menuName.getText();

        if (Category.matches("[0-9]+") == false && menuname.matches("[0-9]+") == false && price.getText().matches("[0-9]+")) {
            int Price = parseInt(price.getText());

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
                PreparedStatement stmt = con.prepareStatement("INSERT INTO menu(category,menuname,price) values(?,?,?)");
                stmt.setString(1, Category);
                stmt.setString(2, menuname);
                stmt.setInt(3, Price);
//     

                stmt.executeUpdate();
                dispOrders();
                JOptionPane.showMessageDialog(this, "Record Added");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid input");

        }

    }//GEN-LAST:event_AddmenuMouseClicked

    private void menulistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulistMouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel) menulist.getModel();
        int SelectedRows = menulist.getSelectedRow();

        id.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        category.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        menuName.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        price.setText(RecordTable.getValueAt(SelectedRows, 3).toString());

    }//GEN-LAST:event_menulistMouseClicked

    private void EditMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMenuMouseClicked
        
        if(!"".equals(id.getText())){
        
      
        String Category = category.getText();
        String menuname = menuName.getText();
        int Price = parseInt(price.getText());
        int ID = parseInt(id.getText());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
            PreparedStatement stmt = con.prepareStatement("UPDATE menu SET category=?,menuname=?,price=? where id=?");
            stmt.setString(1, Category);
            stmt.setString(2, menuname);
            stmt.setInt(3, Price);
            stmt.setInt(4, ID);
//     

            stmt.executeUpdate();
            dispOrders();
            JOptionPane.showMessageDialog(this, "Record Updated");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
          }else{
         JOptionPane.showMessageDialog(this, "No selected item");
        
        }
    }//GEN-LAST:event_EditMenuMouseClicked

    private void EditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMenuActionPerformed

    private void DeleteMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMenuMouseClicked
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this menu?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION &&!"".equals(id.getText())) {
           
            int ID = parseInt(id.getText());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
                PreparedStatement stmt = con.prepareStatement("DELETE FROM menu where id=?");
                stmt.setInt(1, ID);
                stmt.executeUpdate();
                dispOrders();
                JOptionPane.showMessageDialog(this, "Deleted Successfully");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
        JOptionPane.showMessageDialog(this, "No selected item");
        }

    }//GEN-LAST:event_DeleteMenuMouseClicked

    private void DeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addmenu;
    private javax.swing.JButton DeleteMenu;
    private javax.swing.JButton EditMenu;
    private javax.swing.JTextField category;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField menuName;
    private javax.swing.JTable menulist;
    private javax.swing.JTextField price;
    // End of variables declaration//GEN-END:variables
}
