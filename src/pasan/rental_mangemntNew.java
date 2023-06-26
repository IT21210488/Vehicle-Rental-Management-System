/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pasan;
import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PasanBandara
 */
public class rental_mangemntNew extends javax.swing.JFrame {

    /**
     * Creates new form rental_mangemntNew
     */
    public rental_mangemntNew() {
        initComponents();
        connect();
         renttable();
        LoadCusID();
        Loadcarreg();
        Loadcarreg2();
       
        
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
      ResultSet rs;
      ResultSet rs1;
      ResultSet rst;
      
      
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
        DefaultTableModel model2=(DefaultTableModel)jTable1.getModel();
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
            
            
                public void Loadcarreg2(){
    
        
        try {
            pst=conn.prepareStatement("select Distinct Reg_no from vehicle");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs= pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            combovc.removeAllItems();
            
        try {
            while(rs.next()){
                combovc.addItem(rs.getString("Reg_no"));
                
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rentid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combocustID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combovehID = new javax.swing.JComboBox<>();
        txtavl = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtdue = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        fee = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combovc = new javax.swing.JComboBox<>();
        ppd = new javax.swing.JTextField();
        nod = new javax.swing.JTextField();
        result = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jLabel2.setText("Rental Mangemnt");

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel3.setText("rentID:");

        rentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel4.setText("rentdate:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel5.setText("customerID:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel6.setText("rentID:");

        combovehID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combovehIDActionPerformed(evt);
            }
        });

        txtavl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtavlActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel7.setText("rentFee:");

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabel8.setText("rentdate:");

        jLabel9.setText("vehicle:");

        jLabel10.setText("price per day:");

        jLabel11.setText("number of days:");

        jLabel12.setText("rent fee:");

        combovc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combovcActionPerformed(evt);
            }
        });

        ppd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppdActionPerformed(evt);
            }
        });

        jButton5.setText("calculate fee");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "RentID", "Customer", "Vehicle", "RentDate", "Returndate", "RentFee"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/croped new.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rentid, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combocustID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jButton1)
                                                .addGap(39, 39, 39)
                                                .addComponent(jButton2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(38, 38, 38)
                                                .addComponent(jButton4))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combovehID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nod)
                                            .addComponent(combovc, 0, 101, Short.MAX_VALUE)
                                            .addComponent(ppd)
                                            .addComponent(result))
                                        .addGap(89, 89, 89))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jButton5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(combocustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(combovehID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtavl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(fee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(combovc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(ppd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(nod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jButton5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rentidActionPerformed

    private void txtavlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtavlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavlActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                try {
            // TODO add your handling code here:
            String rid = rentid.getText();
            String cid = combocustID.getSelectedItem().toString();
            String vid = combovehID.getSelectedItem().toString();

            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String date = Date_Format.format(txtdate.getDate());
            SimpleDateFormat Date_Format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date2 = Date_Format1.format(txtdue.getDate());
            String rfee = fee.getText();

            ps3 = conn.prepareStatement("insert into rentals  (rentID,customerid,vehicleNO,rentDate,returnDate,rentfee)values(?,?,?,?,?,?)");

            ps3.setString(1, rid);
            ps3.setString(2, cid);
            ps3.setString(3, vid);
            ps3.setString(4, date);

            ps3.setString(5, date2);
            ps3.setString(6, rfee);
            ps3.executeUpdate();

            String car_id = combovehID.getSelectedItem() .toString();
            ps4 = conn.prepareStatement("update vehicle set Availability = 'not available' where Reg_no = ?  ");

            ps4.setString(1, car_id);
            ps4.executeUpdate();

            JOptionPane.showMessageDialog(this, "Sucsessfully Saved");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ppdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppdActionPerformed

    private void combovehIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combovehIDActionPerformed
        // TODO add your handling code here:
        
        
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

                if(aval.equals("available"))
                {
                    rentid.setEnabled (true);
                    combocustID.setEnabled (true);
                    txtdate.setEnabled (true);
                    txtdue.setEnabled (true);

                }else{
                    rentid.setEnabled (false);
                    combocustID.setEnabled (false);
                    txtdate.setEnabled (false);
                    txtdue.setEnabled (false);

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_combovehIDActionPerformed

    private void combovcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combovcActionPerformed
        // TODO add your handling code here:
                try {
            // TODO add your handling code here:
            String car_id = combovc.getSelectedItem() .toString();

            try {
                pst1=conn.prepareStatement("select * from vehicle where Reg_no=?");
            } catch (SQLException ex) {
                Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst1.setString(1, car_id);
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
        
    }//GEN-LAST:event_combovcActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
          double num1=Double.parseDouble(ppd.getText());
        double num2=Double.parseDouble(nod.getText());
        double num3=num1*num2;
        result.setText("Rs."+num3+"0");
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(rental_mangemntNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rental_mangemntNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rental_mangemntNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rental_mangemntNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rental_mangemntNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combocustID;
    private javax.swing.JComboBox<String> combovc;
    private javax.swing.JComboBox<String> combovehID;
    private javax.swing.JTextField fee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nod;
    private javax.swing.JTextField ppd;
    private javax.swing.JTextField rentid;
    private javax.swing.JTextField result;
    private javax.swing.JTextField txtavl;
    private com.toedter.calendar.JDateChooser txtdate;
    private com.toedter.calendar.JDateChooser txtdue;
    // End of variables declaration//GEN-END:variables
}
