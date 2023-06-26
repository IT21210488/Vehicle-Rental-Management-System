/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pasan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;


/**
 *
 * @author user
 */
public class rentals_management extends javax.swing.JFrame {

    /**
     * Creates new form rentals_management
     */
    public rentals_management() {
        initComponents();
        connect();
        
         renttable();
         update();
        LoadCusID();
        Loadcarreg();
        autoid();
       
        
       java.util.Date date=new java.util.Date();
        txtdate.setMinSelectableDate(date);
        txtdue.setMinSelectableDate(date);
       
        
        txtdate.setDateFormatString("yyyy/MM/dd");
        txtdue.setDateFormatString("yyyy/MM/dd");
        
        
       
       
    }
    
     Connection conn;
     PreparedStatement ps=null;
     PreparedStatement ps1=null;
     PreparedStatement ps2=null;
     PreparedStatement ps3=null;
      PreparedStatement ps4=null;
      PreparedStatement pst=null;
      PreparedStatement pst1=null;
       PreparedStatement pst2=null;
       PreparedStatement psn=null;
        PreparedStatement psu;
        PreparedStatement pstu=null;
        PreparedStatement psd=null;
        PreparedStatement psbill=null;
        PreparedStatement ps32=null;
        PreparedStatement ps321=null;
       PreparedStatement type=null;
       PreparedStatement ps100;  
      ResultSet rs;
      ResultSet rs1;
      ResultSet rst;
      ResultSet rsn;
      ResultSet rsup;
       ResultSet rstype;
      
       public void connect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    
    }
       
      
        
       
     
        
        
        
       
      
       
       
       
       
       
       
       
       
       public void autoid()
 {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
            Statement s =conn.createStatement();
            
            rsn= s.executeQuery("select Max(rentID) from rentals ");
            rsn.next();
            rsn.getString("Max(rentID)");
            if(rsn.getString("Max(rentID)")==null){
                rentid.setText("R0001");
                
            }else{
                Long id=Long.parseLong(rsn.getString("Max(rentID)").substring(2,rsn.getString("Max(rentID)").length()));
                id++;
                
                rentid.setText("R0"+ String.format("%03d",id));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
          
}
       
              public void renttable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst2=conn.prepareStatement("select *  from rentals");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs= pst2.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd = null;
        try {
            rsmd = rs.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2=(DefaultTableModel)jTable2.getModel();
        model2.setRowCount(0);
        
        try {
            while(rs.next()){
                Vector v= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    v.add(rs.getString("rentID"));
                    v.add(rs.getString("customerid"));
                    v.add(rs.getString("vehicleNO"));
                    v.add(rs.getString("rentDate"));
                    v.add(rs.getString("returnDate"));
                    v.add(rs.getString("rentfee"));
                }
                model2.addRow(v);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
       }
              
              
                            public void update(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstu=conn.prepareStatement("select *  from rentals");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsup= pstu.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmdn = null;
        try {
            rsmdn = rsup.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmdn.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelup=(DefaultTableModel)jTable2.getModel();
        modelup.setRowCount(0);
        
        try {
            while(rsup.next()){
                Vector vn= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vn.add(rsup.getString("rentID"));
                    vn.add(rsup.getString("customerid"));
                    vn.add(rsup.getString("vehicleNO"));
                    vn.add(rsup.getString("rentDate"));
                    vn.add(rsup.getString("returnDate"));
                    vn.add(rsup.getString("rentfee"));
                }
                modelup.addRow(vn);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
       }
       

       
       
       
       

    public void LoadCusID(){
    
        
        try {
            ps=conn.prepareStatement("select Distinct Customer_ID from customers");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs= ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            combocustID.removeAllItems();
            
        try {
            while(rs.next()){
                combocustID.addItem(rs.getString("Customer_ID"));
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
     public void Loadcarreg(){
    
        
        try {
            ps1=conn.prepareStatement("select Distinct Reg_no from vehicle");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs= ps1.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            combovehID.removeAllItems();
            
        try {
            while(rs.next()){
                combovehID.addItem(rs.getString("Reg_no"));
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        combocustID = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdue = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        combovehID = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rentid = new javax.swing.JTextField();
        txtavl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ppd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        receiptpanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bill1 = new javax.swing.JTextField();
        bill2 = new javax.swing.JTextField();
        bill3 = new javax.swing.JTextField();
        bill4 = new javax.swing.JTextField();
        bill5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        loyalcombo = new javax.swing.JComboBox<>();
        typebox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 600));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("calculate fee and save");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/update.png"))); // NOI18N
        jButton4.setText("update");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/delete.png"))); // NOI18N
        jButton5.setText("delete");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel2.setText("Rent_ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel5.setText("Rent_Date: *");

        combocustID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combocustID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocustIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setText("Customer_ID:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setText("Return_Date:*");

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setText("Vehicle Reg.No:");

        combovehID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combovehID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combovehIDActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/croped new.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Vehicles");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Customers");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Returns");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/logout new.png"))); // NOI18N
        jButton9.setText("Logout");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/Car-Rent-.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        rentid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentidActionPerformed(evt);
            }
        });

        txtavl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtavl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtavlActionPerformed(evt);
            }
        });
        txtavl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtavlKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel11.setText("price per day:");

        ppd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ppd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppdActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RentID", "CustomerID", "VehicleID", "rent_Date", "return_Date", "Rent_Fee (Rs.)"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton10.setText("refresh page");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/print new.png"))); // NOI18N
        jButton11.setText("print");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("Rental mangement");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(438, 438, 438))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        receiptpanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        receiptpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel9.setText("Rent No");
        receiptpanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel10.setText("Rent_fee:");
        receiptpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel12.setText("You must return Vehicle on");
        receiptpanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel13.setText("Paid amount:");
        receiptpanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jLabel14.setText("Balance:(Rs.) ");
        receiptpanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        bill1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bill1.setBorder(null);
        receiptpanel.add(bill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 150, -1));

        bill2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bill2.setBorder(null);
        bill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill2ActionPerformed(evt);
            }
        });
        receiptpanel.add(bill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 80, -1));

        bill3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bill3.setBorder(null);
        bill3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill3ActionPerformed(evt);
            }
        });
        receiptpanel.add(bill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 176, -1));

        bill4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bill4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bill4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bill4ActionPerformed(evt);
            }
        });
        receiptpanel.add(bill4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 90, -1));

        bill5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bill5.setBorder(null);
        receiptpanel.add(bill5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 90, -1));

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel20.setText("Thank you for gttting our services!!");
        receiptpanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabel16.setText("=======================================================");
        receiptpanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 440, -1));

        jLabel17.setText("======================================================");
        receiptpanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 440, -1));

        jLabel18.setText("________________________________________________________________________________________");
        receiptpanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 430, -1));

        jLabel19.setText("======================================================");
        receiptpanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 430, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("reset");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("calculate");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("print receipt");
        jButton12.setBorder(null);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Variable", 3, 18)); // NOI18N
        jLabel15.setText("customer is loyal?");

        loyalcombo.setFont(new java.awt.Font("Segoe UI Variable", 0, 14)); // NOI18N
        loyalcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES", " " }));
        loyalcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loyalcomboActionPerformed(evt);
            }
        });

        typebox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(552, 552, 552)
                        .addComponent(loyalcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(666, 666, 666)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(rentid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1240, 1240, 1240)
                        .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(971, 971, 971)
                        .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1154, 1154, 1154)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1012, 1012, 1012)
                        .addComponent(receiptpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(720, 720, 720)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1080, 1080, 1080)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(863, 863, 863)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(880, 880, 880)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1100, 1100, 1100)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(730, 730, 730)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1240, 1240, 1240)
                        .addComponent(combovehID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1002, 1002, 1002)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(853, 853, 853)
                        .addComponent(combocustID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addComponent(ppd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1350, 1350, 1350)
                .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(receiptpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(loyalcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(rentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(495, 495, 495)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(combocustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(ppd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(combovehID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtavlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtavlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavlActionPerformed

    private void rentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentidActionPerformed

    private void combovehIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combovehIDActionPerformed

        try {

            try {
                // TODO add your handling code here:

                String car_id = combovehID.getSelectedItem() .toString();

                ps2=conn.prepareStatement("select * from vehicle where Reg_no=?");
                ps2.setString(1, car_id);
                rs1 = ps2.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(rs1.next()==false){
                JOptionPane.showMessageDialog(this,"car not found");
            }else{

                String aval=rs1.getString("Availability");
                txtavl.setText(aval.trim());

            
            }

        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
          try {
            // TODO add your handling code here:
            String car_id2 = combovehID.getSelectedItem() .toString();

            try {
                pst1=conn.prepareStatement("select * from vehicle where Reg_no=?");
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst1.setString(1, car_id2);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rst = pst1.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(rst.next()==false){
                JOptionPane.showMessageDialog(this,"car not found");
            }else{

                String aval=rst.getString("PricePerDay");
                ppd.setText(aval.trim());

            }

        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_combovehIDActionPerformed

    private void combocustIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocustIDActionPerformed
        // TODO add your handling code here:
          try {

            try {
                // TODO add your handling code here:

                String customer = combocustID.getSelectedItem() .toString();

                type=conn.prepareStatement("select * from customers where Customer_ID=?");
                type.setString(1, customer);
                rstype = type.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(rstype.next()==false){
                JOptionPane.showMessageDialog(this,"car not found");
            }else{

                String cutomertype=rstype.getString("Cus_type");
                typebox.setText(cutomertype.trim());

            
            }

        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combocustIDActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
            
       
            // TODO add your handling code here:
            String rid = rentid.getText();
            String tipe = typebox.getText();
            String cid = combocustID.getSelectedItem().toString();
            String vid = combovehID.getSelectedItem().toString();

            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String date = Date_Format.format(txtdate.getDate());
            SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date2 = Date_Format1.format(txtdue.getDate());
            String loyal = loyalcombo.getSelectedItem().toString();
           
            
            Date first=txtdate.getDate();
            Date second=txtdue.getDate();
       long diffInMillies=Math.abs(first.getTime() - second.getTime());
       long diff=TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
        
            
            
            if(rid.equals("")){
            JOptionPane.showMessageDialog(null,"rent ID must be entered");
        }

else if(cid.equals("")){
            JOptionPane.showMessageDialog(null,"customer ID must be selected");
        }




            
            
            
         else{
                 double num33;
                 double numln;
                 double numnl;
                 if(tipe.equals("local")){
                 if(loyal.equals("NO")){
                 numln=Double.parseDouble(ppd.getText());
        numnl=Double.parseDouble(String.valueOf(diff));
        num33=numln*numnl;
                 }else{
                 numln=Double.parseDouble(ppd.getText());
        numnl=Double.parseDouble(String.valueOf(diff));
        num33=(numln*numnl)-(numln*numnl*10/100.0);
                 
                 }
                 }else{
                   if(loyal.equals("NO")){
                 numln=Double.parseDouble(ppd.getText());
        numnl=Double.parseDouble(String.valueOf(diff));
        num33=numln*numnl+(1000.0);
                 }else{
                 numln=Double.parseDouble(ppd.getText());
        numnl=Double.parseDouble(String.valueOf(diff));
        num33=(numln*numnl+(1000.0))-((numln*numnl+(1000.0))*10/100.0);
                 
                 }
                 
                 
                 
                 
                 }
                try {
                    
                    
                    
                    
                    ps3 = conn.prepareStatement("insert into rentals  (rentID,customerid,vehicleNO,rentDate,returnDate,rentfee)values(?,?,?,?,?,?)");
                    
                    ps3.setString(1, rid);
                    ps3.setString(2, cid);
                    ps3.setString(3, vid);
                    ps3.setString(4, date);
                    
                    ps3.setString(5, date2);
                    ps3.setString(6, num33+"0");
                    
                   
                    ps3.executeUpdate();
                    
                    
                    
                    
                    String car_id = combovehID.getSelectedItem() .toString();
                    ps4 = conn.prepareStatement("update vehicle set Availability = 'not available' where Reg_no = ?  ");
                    
                    ps4.setString(1, car_id);
                    ps4.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Sucsessfully Saved");
                    
                    renttable();
                    
                    bill1.setText(rid);
                    bill2.setText(num33+"0");
                    bill3.setText(date2);
                    
                       int rowcountn=jTable2.getRowCount();
           DefaultTableModel dc=(DefaultTableModel)jTable2.getModel();
           ArrayList<String> list = new ArrayList<String>();
       
       
      int count = 0;
       for(int i=0;i<rowcountn;i++){
             list.add(dc.getValueAt (i, 1).toString());
           }
      
       
       
         for (int i1 = 0; i1 < rowcountn; i1++){
         
         
            if (list.get(i1).equals(combocustID.getSelectedItem().toString())){
               count++;
            }
         }
          Statement stm = conn.createStatement();
        String sql="select * from customer_rents where Cus_ID='"+cid+"'";
                     ResultSet rstest= stm.executeQuery(sql);
                     
                     if(!rstest.next()){
                          
                          try {
                   ps32 = conn.prepareStatement("insert into customer_rents(Cus_ID,No_of_Rent)values(?,?)");
               } catch (SQLException ex) {
                   Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
               }
                    
                  ps32.setString(1, cid);
                    ps32.setInt(2, count);  
               
               ps32.executeUpdate();
                     
                   
                     }else{
        
                     
               ps321 = conn.prepareStatement("update customer_rents set No_of_Rent=? where Cus_ID=?");
                           
                           ps321.setInt(1, count); 
                    ps321.setString(2, cid);
                    ps321.executeUpdate();
                     }
         
         
                     
                } catch (SQLException ex) {
                    Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
      
        
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        dispose();
              rental_login sixteenth= new rental_login();
              sixteenth.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
              returnMangemnt edited= new returnMangemnt();
              edited.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         dispose();
              customermangemnt fourth= new customermangemnt();
              fourth.setVisible(true);
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         dispose();
              VehicleManagement sixth= new VehicleManagement();
              sixth.setVisible(true); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ppdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppdActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          int option3=JOptionPane.showConfirmDialog(null,"Are you sure to delete","delete",JOptionPane.YES_NO_OPTION);
        if(option3==0){                                     
            try {
                // TODO add your handling code here:
                String ridD =rentid.getText();
                 
                psd=conn.prepareStatement("delete from rentals where rentID=?");
                psd.setString(1,ridD);
                psd.executeUpdate();
                update();
                
                String car_id = combovehID.getSelectedItem() .toString();
                psd = conn.prepareStatement("update vehicle set Availability = 'available' where Reg_no = ?  ");
                
                psd.setString(1, car_id);
                psd.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"record is deleted successfully");
                update();
                
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
                  String cusid = combocustID.getSelectedItem().toString();
            int rowcountnew=jTable2.getRowCount();
            DefaultTableModel dcn=(DefaultTableModel)jTable2.getModel();
            ArrayList<String> listnew = new ArrayList<String>();
           
            int count = 0;
            for(int i=0;i<rowcountnew;i++){
                listnew.add(dcn.getValueAt (i, 1).toString());
            }
            
            
            
            for (int i1 = 0; i1 < rowcountnew; i1++){
                
                
                if (listnew.get(i1).equals(combocustID.getSelectedItem().toString())){
                    count++;
                }
            }
            
        try {
            psd = conn.prepareStatement("update customer_rents set No_of_Rent=? where Cus_ID=?");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            psd.setInt(1, count);
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psd.setString(2, cusid);
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        
        }   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtavlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtavlKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavlKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:

           
            
            
            
            
            
            
            
            
            String rid =rentid.getText();
             String tipe = typebox.getText();
            String cid = combocustID.getSelectedItem().toString();
            String vid = combovehID.getSelectedItem().toString();

            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String date = Date_Format.format(txtdate.getDate());
            SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date2 = Date_Format1.format(txtdue.getDate());
             Date first=txtdate.getDate();
            Date second=txtdue.getDate();
            String loyal = loyalcombo.getSelectedItem().toString();
       long diffInMillies=Math.abs(first.getTime() - second.getTime());
       long diff=TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
        
            
            
            
          double num333;
                 double numlnl;
                 double numnll;
                 if(tipe.equals("local")){
                 if(loyal.equals("NO")){
                 numlnl=Double.parseDouble(ppd.getText());
        numnll=Double.parseDouble(String.valueOf(diff));
        num333=numlnl*numnll;
                 }else{
                 numlnl=Double.parseDouble(ppd.getText());
        numnll=Double.parseDouble(String.valueOf(diff));
        num333=(numlnl*numnll)-(numlnl*numnll*10/100.0);
                 
                 }
                 }else{
                   if(loyal.equals("NO")){
                 numlnl=Double.parseDouble(ppd.getText());
        numnll=Double.parseDouble(String.valueOf(diff));
        num333=numlnl*numnll+(1000.0);
                 }else{
                 numlnl=Double.parseDouble(ppd.getText());
        numnll=Double.parseDouble(String.valueOf(diff));
        num333=(numlnl*numnll+(1000.0))-((numlnl*numnll+(1000.0))*10/100.0);
                 
                 }
                 
                 
                 
                 
                 }    
            
            
        
            
            
            
          
            
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            try {
                psu=conn.prepareStatement("update rentals set customerid=?,vehicleNO=?,rentDate=?,returnDate=?,rentfee=? where rentID=?");
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
            
            
            
            
            
            try {
                psu.setString(1, cid);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                psu.setString(2, vid);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                psu.setString(3, date);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                psu.setString(4, date2);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                psu.setString(5, num333+"0");
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            try {
                psu.setString(6, rid);
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                psu.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            JOptionPane.showMessageDialog(this,"updation successful");
            update();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
                             
                             
                             
                             
                     
                     
                     
                     
                     
                     
                     
                     
                     

                
                
                 
                 
                 
                     
                   
                 
                 
             
        
    
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        dispose();
              rentals_management sr= new rentals_management();
              sr.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {
            DefaultTableModel d1=(DefaultTableModel)jTable2.getModel();
            int selectIndex=jTable2.getSelectedRow();
            
            
            
            rentid. setText (d1.getValueAt (selectIndex, 0).toString());
            
            combocustID. setSelectedItem (d1.getValueAt (selectIndex, 1).toString());
            combovehID. setSelectedItem (d1.getValueAt (selectIndex, 2).toString());
            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(d1.getValueAt (selectIndex, 3).toString());
            txtdate. setDate(date);
            Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d1.getValueAt (selectIndex, 4).toString());
            txtdue. setDate(date2);
            
           
        } catch (ParseException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_jTable2MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
              try {
            // TODO add your handling code here:
            MessageFormat header= new MessageFormat("Rent records");
            MessageFormat footer= new MessageFormat("___________________________");
            
            jTable2.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void bill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill2ActionPerformed

    private void bill3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         bill1.setText("");
                     bill2.setText("");
                     bill3.setText("");
        bill4.setText("");
        bill5.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
  
         
          double number1bill=Double.parseDouble(bill2.getText());
        double number2bill=Double.parseDouble(bill4.getText());
        double number3bill=number2bill-number1bill;
        bill5.setText(String.valueOf(number3bill)+"0");
        
        if(bill4.equals("")){
            JOptionPane.showMessageDialog(null,"paid amount must be entered");
        }
        
        
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void loyalcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loyalcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loyalcomboActionPerformed

    private void bill4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bill4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bill4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
             PrinterJob jobre = PrinterJob.getPrinterJob();
            jobre.setJobName("Print Data");
            
            jobre.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.PORTRAIT);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2re = (Graphics2D)pg;
                g2re.translate(pf.getImageableX(), pf.getImageableY());
                g2re.scale(1.2,0.99);
                
                receiptpanel.print(g2re);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = jobre.printDialog();
        if(ok){
        try{
            
        jobre.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        } 
    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(rentals_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rentals_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rentals_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rentals_management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rentals_management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bill1;
    private javax.swing.JTextField bill2;
    private javax.swing.JTextField bill3;
    private javax.swing.JTextField bill4;
    private javax.swing.JTextField bill5;
    private javax.swing.JComboBox<String> combocustID;
    private javax.swing.JComboBox<String> combovehID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> loyalcombo;
    private javax.swing.JTextField ppd;
    private javax.swing.JPanel receiptpanel;
    private javax.swing.JTextField rentid;
    private javax.swing.JTextField txtavl;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdue;
    private javax.swing.JTextField typebox;
    // End of variables declaration//GEN-END:variables

    
}
