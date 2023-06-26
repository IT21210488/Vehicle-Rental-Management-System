/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pasan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.*;
import java. lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.util.ArrayList;
import javax.swing.JTable;
/**
 *
 * @author user
 */
public class VehicleManagement extends javax.swing.JFrame {

    /**
     * Creates new form VehicleManagement
     */
    public VehicleManagement() {
        initComponents();
        connect();
       
        vehicletable();
        maintaintable();
        Loadcarreg2();
        formula();
        totmaintain();
        mostrentedveh();
        leastrented();
        
        
        
        
        
    }
Connection conn;
PreparedStatement psa;
PreparedStatement psa1;
PreparedStatement psa2;
PreparedStatement pskv;
PreparedStatement psdv;
PreparedStatement psdv2;
PreparedStatement pmain;
PreparedStatement loadc;
PreparedStatement mainup;
PreparedStatement ps50;
PreparedStatement ps505;
            ResultSet rsa;
            ResultSet rsa2;
             ResultSet rsa22;
             ResultSet rsload;
      public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
      
        public void mostrentedveh(){
        try {
            Statement stmtr = conn.createStatement();
            
            ResultSet rslor = stmtr.executeQuery("select vehicleNO,count(*) from rentals group by vehicleNO order by count(*)DESC LIMIT 1");
            
            while (rslor.next()) {
                String x=rslor.getString(1);
                 
                mostr.setText(x);
            }       } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
           }
        
            public void leastrented(){
        try {
            Statement stmtrl = conn.createStatement();
            
            ResultSet rslorl = stmtrl.executeQuery("select vehicleNO,count(*) from rentals group by vehicleNO order by count(*)ASC LIMIT 1");
            
            while (rslorl.next()) {
                String xl=rslorl.getString(1);
                 
                leastrent.setText(xl);
            }       } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
           }
      
      
      
      
      
      
       public void formula(){
           int rowcountn=maintaintable.getRowCount();
           DefaultTableModel d112a=(DefaultTableModel)maintaintable.getModel();
           ArrayList<String> list = new ArrayList<String>();
       
       int max_count = 0;
      String maxfreq = "";
       for(int i=0;i<rowcountn;i++){
             list.add(d112a.getValueAt (i, 1).toString());
           }
         for (int i1 = 0; i1 < rowcountn; i1++){
         int count = 0;
         for (int j = 0; j < rowcountn; j++){
            if (list.get(i1).equals(list.get(j))){
               count++;
            }
         }
        
         if (count > max_count){
            max_count = count;
            maxfreq = list.get(i1);
         }
         maxbox.setText(maxfreq);
         
      }
       
     
   }
       
       
         public void totmaintain(){
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet rslo = stmt.executeQuery("select sum(cost) from maintenancet");
            
            while (rslo.next()) {
                double x=rslo.getDouble(1);
                 
                
                  totcost.setText("Rs."+Double.toString(x)+"0");
            }       } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
           }
       
    
      
      
      
      
      
      
      
      
      
      
           public void Loadcarreg2(){
    
        
        try {
            loadc=conn.prepareStatement("select Distinct Reg_no from vehicle");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsload= loadc.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            maintaincombo.removeAllItems();
            
        try {
            while(rsload.next()){
                maintaincombo.addItem(rsload.getString("Reg_no"));
                
            }   
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
      
      
      
      
      
      
      
      
          
       public void maintaintable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psdv2=conn.prepareStatement("select *  from maintenancet");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsa22= psdv2.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd2 = null;
        try {
            rsmd2= rsa22.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd2.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2m=(DefaultTableModel)maintaintable.getModel();
        model2m.setRowCount(0);
        
        try {
            while(rsa22.next()){
                Vector vam= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vam.add(rsa22.getString("id"));
                    vam.add(rsa22.getString("vehicle_no"));
                    vam.add(rsa22.getString("maintenance"));
                    vam.add(rsa22.getDouble("cost"));
                    vam.add(rsa22.getString("status"));
                }
                model2m.addRow(vam);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
       }
      
      
      
      
      
      
      
      
      
      
      
       public void vehicletable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psa2=conn.prepareStatement("select *  from vehicle");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsa2= psa2.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd = null;
        try {
            rsmd = rsa2.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2=(DefaultTableModel)veht.getModel();
        model2.setRowCount(0);
        
        try {
            while(rsa2.next()){
                Vector va= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    va.add(rsa2.getString("Reg_no"));
                    va.add(rsa2.getString("BrandModel"));
                    va.add(rsa2.getString("Availability"));
                    va.add(rsa2.getString("PricePerDay"));
                    
                }
                model2.addRow(va);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        onea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        twoa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboa = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        threea = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        veht = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        maintaincombo = new javax.swing.JComboBox<>();
        mintain = new javax.swing.JTextField();
        maint = new javax.swing.JScrollPane();
        maintaintable = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        costv = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        statuscombo = new javax.swing.JComboBox<>();
        vehicles = new javax.swing.JPanel();
        maxbox = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totcost = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mostr = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        leastrent = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        updatepurposes = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/croped new.png"))); // NOI18N

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/logout new.png"))); // NOI18N
        jButton7.setText("logout");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/back-button new.png"))); // NOI18N
        jButton8.setText("Back");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/Car-Rent-Vector-Illustration sssssssssssss.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setText("Reg No:");

        onea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setText("Brand & model:");

        twoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        twoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel5.setText("Availability:");

        comboa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "available", "not available" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setText("Price per day:");

        threea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        threea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/save.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/update.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/delete.png"))); // NOI18N
        jButton4.setText("Delete");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        veht.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        veht.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "regNo", "Brand&Model", "availablity", "Price Per KM"
            }
        ));
        veht.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(veht);

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/print new.png"))); // NOI18N
        jButton9.setText("print");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setText("Vehicle Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(325, 325, 325))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("vehicle no:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Maintenance:");

        maintaincombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mintain.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mintain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mintainActionPerformed(evt);
            }
        });

        maintaintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "vehicle", "description", "cost", "status"
            }
        ));
        maintaintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintaintableMouseClicked(evt);
            }
        });
        maint.setViewportView(maintaintable);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/save.png"))); // NOI18N
        jButton5.setText("Save");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/update.png"))); // NOI18N
        jButton6.setText("Update");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("cost:");

        costv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costvActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("status:");

        statuscombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statuscombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "on maintaining", "completed" }));

        vehicles.setBackground(new java.awt.Color(255, 255, 255));

        maxbox.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        maxbox.setBorder(null);
        maxbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxboxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel13.setText("most maintained vehicle:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel16.setText("Total cost for all maintainings:");

        totcost.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        totcost.setBorder(null);

        jLabel14.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel14.setText("mostly rented vehicle:");

        mostr.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        mostr.setBorder(null);
        mostr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel17.setText("Least rented vehicle:");

        leastrent.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        leastrent.setBorder(null);

        jLabel18.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel18.setText("Vehicle details' summary");

        javax.swing.GroupLayout vehiclesLayout = new javax.swing.GroupLayout(vehicles);
        vehicles.setLayout(vehiclesLayout);
        vehiclesLayout.setHorizontalGroup(
            vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehiclesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(vehiclesLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(maxbox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehiclesLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(leastrent, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vehiclesLayout.createSequentialGroup()
                        .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(vehiclesLayout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vehiclesLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(totcost, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehiclesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mostr, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(165, 165, 165))
            .addGroup(vehiclesLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vehiclesLayout.setVerticalGroup(
            vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vehiclesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addGap(34, 34, 34)
                .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(mostr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vehiclesLayout.createSequentialGroup()
                        .addComponent(maxbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vehiclesLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)))
                .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(leastrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vehiclesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(totcost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel12.setText("Maintenance management");

        updatepurposes.setBackground(new java.awt.Color(204, 204, 255));
        updatepurposes.setForeground(new java.awt.Color(204, 204, 255));
        updatepurposes.setBorder(null);

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/print new.png"))); // NOI18N
        jButton10.setText("print");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(onea, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(240, 240, 240)
                                .addComponent(twoa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(197, 197, 197)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(218, 218, 218)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(maintaincombo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(mintain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(costv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(statuscombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(24, 24, 24))
                                            .addComponent(maint, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(347, 347, 347)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addComponent(threea, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updatepurposes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(onea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(threea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(maintaincombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mintain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(costv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(statuscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatepurposes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(maint, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void oneaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oneaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        onea.setText("");
                     twoa.setText("");
                         comboa.setSelectedItem("select");
                     threea.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String rgno=onea.getText(); 
       

       
       String bnm=twoa.getText();
       String aval=(String)comboa.getSelectedItem();
       String ppkm=threea.getText();
       
       if(rgno.equals("")){
            JOptionPane.showMessageDialog(null,"regno  must be entered");
        }
       else if(!(onea.getText().trim().matches("^[A-Z]{3}[0-9]{4}$")) )
{
    JOptionPane.showMessageDialog(null,"Invalid Reg no ");
}  

else if(bnm.equals("")){
            JOptionPane.showMessageDialog(null,"brand and model must be entered");
        }

else if(ppkm.equals("")){
            JOptionPane.showMessageDialog(null,"price per day address  must be entered");
        }



else{
    
             
  
                
            
             try {
                 psa1 = conn.prepareStatement("insert into vehicle(Reg_no,BrandModel,Availability,PricePerDay)values(?,?,?,?)");
                 
                 
                 
                 psa1.setString(1,rgno);
                 psa1.setString(2,bnm);
                 
                 
                 
                 psa1.setString(3,aval);
                 psa1.setString(4,ppkm);
                 
                 
                 psa1.executeUpdate();
                  onea.setText("");
                     twoa.setText("");
                         comboa.setSelectedItem("select");
                     threea.setText("");
                 
                 JOptionPane.showMessageDialog(this,"vehicle added successful");
                 vehicletable();
             } catch (SQLException ex) {
                 Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
             }
                
            
                
                
                
                
                
        }
      
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         dispose();
              rentals_management eightth= new rentals_management();
              eightth.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void vehtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehtMouseClicked
        // TODO add your handling code here:
           DefaultTableModel d2v=(DefaultTableModel)veht.getModel();
            int selectIndex=veht.getSelectedRow();
            
            
            
            onea. setText (d2v.getValueAt (selectIndex, 0).toString());
            
            
              twoa. setText (d2v.getValueAt (selectIndex, 1).toString());
              comboa. setSelectedItem (d2v.getValueAt (selectIndex, 2).toString());
               threea. setText (d2v.getValueAt (selectIndex, 3).toString());
    }//GEN-LAST:event_vehtMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                String vno =onea.getText();
         String vavilable = comboa.getSelectedItem().toString();
          String bm =twoa.getText();
           String pricepd =threea.getText();
          
           if(vno.equals("")){
            JOptionPane.showMessageDialog(null,"vehicle no must be entered");
        }

else if(bm.equals("")){
            JOptionPane.showMessageDialog(null,"brand and model must be entered");
        }

else if(pricepd.equals("")){
            JOptionPane.showMessageDialog(null,"price must be entered");
        }
 else if(!(onea.getText().trim().matches("^[A-Z]{3}[0-9]{4}$")) )
{
    JOptionPane.showMessageDialog(null,"Invalid Reg no ");
}  
           else{
    
             
  
                
            try {
                pskv = conn.prepareStatement("update vehicle set BrandModel=?,Availability=?,PricePerDay=? where Reg_no=?");
                
                

                pskv.setString(1,bm);
               
                pskv.setString(2,vavilable);
                pskv.setString(3,pricepd);
                  pskv.setString(4,vno); 
                
                
                pskv.executeUpdate();
                 onea.setText("");
                     twoa.setText("");
                         comboa.setSelectedItem("select");
                     threea.setText("");
                
                JOptionPane.showMessageDialog(this,"updated successfully");
                vehicletable();
            } catch (SQLException ex) {
                Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                             
           
        
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int option4=JOptionPane.showConfirmDialog(null,"Are you sure to delete","delete",JOptionPane.YES_NO_OPTION);
        if(option4==0){
           try {
            // TODO add your handling code here:
            String cid =onea.getText();
            
            psdv=conn.prepareStatement("delete from vehicle where Reg_no =?");
            psdv.setString(1,cid);
                psdv.executeUpdate();
                 onea.setText("");
                     twoa.setText("");
                         comboa.setSelectedItem("select");
                     threea.setText("");
                vehicletable();
                JOptionPane.showMessageDialog(this,"record is deleted successfully");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void twoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twoaActionPerformed

    private void threeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_threeaActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // TODO add your handling code here:
            MessageFormat header= new MessageFormat("Vehicle Availability Report");
            MessageFormat footer= new MessageFormat("___________________________");
            
            veht.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
              rental_login thirteenth= new rental_login();
              thirteenth.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void mintainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mintainActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mintainActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                 String first = maintaincombo.getSelectedItem().toString();
          String second =mintain.getText();
           double costformaintain=Double.parseDouble(costv.getText());
          String status = statuscombo.getSelectedItem().toString();
           String updatepur =updatepurposes.getText();
    
             
  
                
            try {
                mainup = conn.prepareStatement("update maintenancet set maintenance=?,cost=?,status=?,vehicle_no=? where id=?");
                
                

                mainup.setString(1,second);
                mainup.setDouble(2,costformaintain);
                  mainup.setString(3,status);
                mainup.setString(4,first);
                mainup.setString(5,updatepur);
                  
                
                
                mainup.executeUpdate();
                
                JOptionPane.showMessageDialog(this,"updated successfully");
                maintaintable();
                totmaintain();
                String vehicleno1 = maintaincombo.getSelectedItem() .toString();
                    ps505 = conn.prepareStatement("update vehicle set Availability = 'available' where Reg_no = ?  ");
                    
                    ps505.setString(1, vehicleno1);
                    ps505.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                             
           
        
    
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        
       String vehicle=(String)maintaincombo.getSelectedItem();
      
       String maintenance=mintain.getText();
       double costformaintain=Double.parseDouble(costv.getText());
        String status=(String)statuscombo.getSelectedItem();
       if(mintain.equals("")){
            JOptionPane.showMessageDialog(null,"please add the maintenance of the vehicel");
        }else if(costv.equals("")){
            JOptionPane.showMessageDialog(null,"please add the maintenance cost");
        }





else{
    
             
  
                
            
             try {
                 pmain = conn.prepareStatement("insert into maintenancet(vehicle_no,maintenance,cost,status)values(?,?,?,?)");
                 
                 
                 
                 pmain.setString(1,vehicle);
                 pmain.setString(2,maintenance);
                 pmain.setDouble(3,costformaintain); 
                 pmain.setString(4,status);  
                 
                 
                 
                 pmain.executeUpdate();
                 
                 
                 maintaintable();
                 totmaintain();
                 String vehicleno = maintaincombo.getSelectedItem() .toString();
                    ps50 = conn.prepareStatement("update vehicle set Availability = 'on maintaining' where Reg_no = ?  ");
                    
                    ps50.setString(1, vehicleno);
                    ps50.executeUpdate();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
             }
                
            
                
                
                
                
                
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void maintaintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintaintableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1m = (DefaultTableModel)maintaintable.getModel();
        int selectIndex=maintaintable.getSelectedRow();
         updatepurposes. setText (d1m.getValueAt (selectIndex, 0).toString());
        maintaincombo. setSelectedItem (d1m.getValueAt (selectIndex, 1).toString());
        mintain. setText (d1m.getValueAt (selectIndex, 2).toString());
         costv. setText (d1m.getValueAt (selectIndex, 3).toString());
        statuscombo. setSelectedItem (d1m.getValueAt (selectIndex, 4).toString());
        
    }//GEN-LAST:event_maintaintableMouseClicked

    private void costvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costvActionPerformed

    private void maxboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxboxActionPerformed

    private void mostrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
                PrinterJob jobv = PrinterJob.getPrinterJob();
            jobv.setJobName("Print Data");
            
            jobv.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.PORTRAIT);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2v = (Graphics2D)pg;
                g2v.translate(pf.getImageableX(), pf.getImageableY());
                g2v.scale(1.2,0.99);
                
                vehicles.print(g2v);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = jobv.printDialog();
        if(ok){
        try{
            
        jobv.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        } 
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(VehicleManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VehicleManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboa;
    private javax.swing.JTextField costv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField leastrent;
    private javax.swing.JScrollPane maint;
    private javax.swing.JComboBox<String> maintaincombo;
    private javax.swing.JTable maintaintable;
    private javax.swing.JTextField maxbox;
    private javax.swing.JTextField mintain;
    private javax.swing.JTextField mostr;
    private javax.swing.JTextField onea;
    private javax.swing.JComboBox<String> statuscombo;
    private javax.swing.JTextField threea;
    private javax.swing.JTextField totcost;
    private javax.swing.JTextField twoa;
    private javax.swing.JTextField updatepurposes;
    private javax.swing.JPanel vehicles;
    private javax.swing.JTable veht;
    // End of variables declaration//GEN-END:variables
}
