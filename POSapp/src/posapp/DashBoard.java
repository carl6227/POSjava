/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posapp;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author 2ndyrGroupA
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() throws ClassNotFoundException, SQLException {
        initComponents();
        reportsPane.setVisible(true);
        menuPane.setVisible(false);
        dispReports();
        dispOrders();
        dispMenu();
        id.setVisible(false);
    }
 public void dispReports() {
       LocalDate myObj = LocalDate.now(); 
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //load the driver
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
            PreparedStatement stmt = con.prepareStatement("SELECT sum(amount)as totalsale FROM sales WHERE soldDate=?"); //get the connection stream(connection port)
            stmt.setString(1,myObj.toString());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
        
                totalSales.setText(rs.getString("totalsale"));
            } else {
               
                totalSales.setText("No sales");
            }

            PreparedStatement stmt2 = con.prepareStatement("SELECT count(*) as menuCount FROM menu");
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                totalMenu.setText(rs2.getString("menuCount"));
            } else {
                JOptionPane.showMessageDialog(null, "NO Menu");
            }
            PreparedStatement stmt3 = con.prepareStatement("SELECT count(status) as orderPending FROM orders WHERE status='pending'");
            ResultSet rs3 = stmt3.executeQuery();
            if (rs3.next()) {
                pendingOrders.setText(rs3.getString("orderPending"));
            } else {
                JOptionPane.showMessageDialog(null, "NO Menu");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
 }
  public void dispOrders() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM orders");
            ResultSet rs = stmt.executeQuery();
            Class.forName("com.mysql.jdbc.Driver");

            ResultSetMetaData stData = rs.getMetaData();

            int q = stData.getColumnCount();

            javax.swing.table.DefaultTableModel RecordTable = (javax.swing.table.DefaultTableModel) transactionList.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                int i;

                for (i = 1; i <= q; i++) {
                    columnData.add(rs.getString("id"));
                    columnData.add("0" + rs.getString("tableno"));
                    columnData.add(rs.getString("item"));
                    columnData.add(rs.getString("quantity"));
                    columnData.add(rs.getString("price"));
                    columnData.add(rs.getString("subtotal"));
                    columnData.add(rs.getString("status"));

                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
public void dispMenu() throws ClassNotFoundException, SQLException {
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
        jLabel2 = new javax.swing.JLabel();
        DashboardBtn1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        reportsPane = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        totalSales = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        totalMenu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pendingOrders = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionList = new javax.swing.JTable();
        searchTableNum = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        menuPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menulist = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        category = new javax.swing.JTextField();
        menuName = new javax.swing.JTextField();
        Addmenu = new javax.swing.JButton();
        price = new javax.swing.JTextField();
        EditMenu = new javax.swing.JButton();
        DeleteMenu = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

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

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 460));

        jPanel1.setBackground(new java.awt.Color(25, 68, 68));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posapp/rsz_logout.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posapp/rsz_1refresh.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(842, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        reportsPane.setPreferredSize(new java.awt.Dimension(740, 540));
        reportsPane.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 153, 51));
        jPanel4.setLayout(null);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel6);
        jPanel6.setBounds(203, 26, 0, 0);

        jPanel7.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(0, 90, 230, 20);

        totalSales.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalSales.setForeground(new java.awt.Color(240, 240, 240));
        totalSales.setText("10,500");
        jPanel4.add(totalSales);
        totalSales.setBounds(20, 20, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Total sales Today");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(20, 50, 110, 30);

        reportsPane.add(jPanel4);
        jPanel4.setBounds(30, 50, 200, 110);

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setLayout(null);

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jPanel9);
        jPanel9.setBounds(203, 26, 0, 0);

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel10);
        jPanel10.setBounds(0, 90, 260, 20);

        totalMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalMenu.setForeground(new java.awt.Color(240, 240, 240));
        totalMenu.setText("25");
        jPanel8.add(totalMenu);
        totalMenu.setBounds(20, 20, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Total Menus");
        jPanel8.add(jLabel4);
        jLabel4.setBounds(20, 50, 110, 30);

        reportsPane.add(jPanel8);
        jPanel8.setBounds(260, 50, 200, 110);

        jPanel25.setBackground(new java.awt.Color(204, 153, 0));
        jPanel25.setLayout(null);

        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel25.add(jPanel26);
        jPanel26.setBounds(203, 26, 0, 0);

        jPanel27.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel25.add(jPanel27);
        jPanel27.setBounds(0, 90, 260, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Pending Orders");
        jPanel25.add(jLabel8);
        jLabel8.setBounds(20, 50, 110, 30);

        pendingOrders.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pendingOrders.setForeground(new java.awt.Color(240, 240, 240));
        pendingOrders.setText("10");
        jPanel25.add(pendingOrders);
        pendingOrders.setBounds(20, 20, 110, 30);

        reportsPane.add(jPanel25);
        jPanel25.setBounds(490, 50, 200, 110);

        jScrollPane1.setForeground(new java.awt.Color(0, 153, 153));

        transactionList.setBackground(new java.awt.Color(0, 153, 153));
        transactionList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        transactionList.setForeground(new java.awt.Color(255, 255, 255));
        transactionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Table Number", "Menu Name", "Price", "Quanity", "Subtotal", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        transactionList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(transactionList);

        reportsPane.add(jScrollPane1);
        jScrollPane1.setBounds(30, 260, 660, 160);

        searchTableNum.setText("Search orders...");
        searchTableNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableNumMouseClicked(evt);
            }
        });
        searchTableNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTableNumActionPerformed(evt);
            }
        });
        searchTableNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTableNumKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTableNumKeyReleased(evt);
            }
        });
        reportsPane.add(searchTableNum);
        searchTableNum.setBounds(440, 220, 160, 30);

        SearchBtn.setBackground(new java.awt.Color(0, 51, 51));
        SearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        SearchBtn.setText("Search");
        SearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBtnMouseClicked(evt);
            }
        });
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        reportsPane.add(SearchBtn);
        SearchBtn.setBounds(610, 220, 80, 30);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        reportsPane.add(jPanel11);
        jPanel11.setBounds(240, 200, 450, 10);

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Dashboard reports");
        reportsPane.add(jLabel5);
        jLabel5.setBounds(40, 20, 200, 22);

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        reportsPane.add(jPanel12);
        jPanel12.setBounds(200, 30, 490, 10);

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("List of Customer Orders");
        reportsPane.add(jLabel7);
        jLabel7.setBounds(40, 190, 200, 22);

        menuPane.setPreferredSize(new java.awt.Dimension(740, 520));
        menuPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setForeground(new java.awt.Color(0, 153, 153));

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
        jScrollPane2.setViewportView(menulist);

        menuPane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 440, 360));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Menu name");
        menuPane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 79, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Menu list");
        menuPane.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 190, -1));

        id.setForeground(new java.awt.Color(0, 153, 153));
        menuPane.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 150, 38));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Php");
        menuPane.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 41, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Price");
        menuPane.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 79, -1));
        menuPane.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 200, 38));
        menuPane.add(menuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 200, 38));

        Addmenu.setBackground(new java.awt.Color(0, 51, 51));
        Addmenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Addmenu.setForeground(new java.awt.Color(255, 255, 255));
        Addmenu.setText("Add Menu");
        Addmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddmenuMouseClicked(evt);
            }
        });
        menuPane.add(Addmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 200, 38));
        menuPane.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 150, 38));

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
        menuPane.add(EditMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 200, 38));

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
        menuPane.add(DeleteMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 200, 38));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("category");
        menuPane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 79, -1));

        jLayeredPane1.setLayer(reportsPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(menuPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(reportsPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menuPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(reportsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(menuPane, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 21, Short.MAX_VALUE)))
        );

        jPanel3.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 740, 460));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 970, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashboardBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DashboardBtn1MouseClicked

    private void menusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menusMouseClicked
        reportsPane.setVisible(false);
        menuPane.setVisible(true);
       
    }//GEN-LAST:event_menusMouseClicked

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
      
        
        menuPane.setVisible(false);
        reportsPane.setVisible(true);
       
       
    }//GEN-LAST:event_dashMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        adminLogin lg= new adminLogin();
        lg.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      
       
            
       
      
        
        try {
            dispOrders();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dispMenu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispReports();
          
       
       
    }//GEN-LAST:event_jLabel3MouseClicked

    private void transactionListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionListMouseClicked

    }//GEN-LAST:event_transactionListMouseClicked

    private void searchTableNumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTableNumMouseClicked
        searchTableNum.setText("");
    }//GEN-LAST:event_searchTableNumMouseClicked

    private void searchTableNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTableNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTableNumActionPerformed

    private void searchTableNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTableNumKeyPressed

    }//GEN-LAST:event_searchTableNumKeyPressed

    private void searchTableNumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTableNumKeyReleased

    }//GEN-LAST:event_searchTableNumKeyReleased

    private void SearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBtnMouseClicked
         javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) transactionList.getModel();
        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> tr = new javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel>(model);
        transactionList.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(searchTableNum.getText().trim()));

        if (searchTableNum.getText().matches("[0-9]+")) {
            int tblnum = parseInt(searchTableNum.getText().substring(1));
            try {
                Class.forName("com.mysql.jdbc.Driver"); //load the driver
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/posjava", "root", ""); //establishes the connection
                PreparedStatement stmt = con.prepareStatement("SELECT sum(subtotal) as totalBill FROM orders WHERE status='delivered' and tableno=?"); //get the connection stream(connection port)
                stmt.setInt(1, tblnum);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or Password");

                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);

            }       // TODO add your handling code here:

        }



    }//GEN-LAST:event_SearchBtnMouseClicked

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed

    }//GEN-LAST:event_SearchBtnActionPerformed

    private void menulistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menulistMouseClicked

        DefaultTableModel RecordTable = (DefaultTableModel) menulist.getModel();
        int SelectedRows = menulist.getSelectedRow();

        id.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        category.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        menuName.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        price.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    }//GEN-LAST:event_menulistMouseClicked

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
                try {
                    new DashBoard().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addmenu;
    private javax.swing.JLabel DashboardBtn1;
    private javax.swing.JButton DeleteMenu;
    private javax.swing.JButton EditMenu;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField category;
    private javax.swing.JToggleButton dash;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField menuName;
    private javax.swing.JPanel menuPane;
    private javax.swing.JTable menulist;
    private javax.swing.JToggleButton menus;
    private javax.swing.JLabel pendingOrders;
    private javax.swing.JTextField price;
    private javax.swing.JPanel reportsPane;
    private javax.swing.JTextField searchTableNum;
    private javax.swing.JLabel totalMenu;
    private javax.swing.JLabel totalSales;
    private javax.swing.JTable transactionList;
    // End of variables declaration//GEN-END:variables

  
}
