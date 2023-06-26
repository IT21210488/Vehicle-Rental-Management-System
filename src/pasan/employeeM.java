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
import java.lang.*;
import java.text.SimpleDateFormat;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 * 
 */
public class employeeM extends javax.swing.JFrame {

    /**
     * Creates new form employeeM
     */
    public employeeM() {
        initComponents();
        connect();
       
        LoadempID2();
       
        emptable();
        atttable();
        autoidforemp();
         java.util.Date date=new java.util.Date();
        attdate.setMinSelectableDate(date);
      
        
        attdate.setDateFormatString("yyyy/MM/dd");
        
        
    }
    Connection conn;
   ResultSet rsn;
   ResultSet rsnew;
      ResultSet rsnatt;
      ResultSet rstest;
      ResultSet rsempid;
      ResultSet rsnewest;
      ResultSet rsnewest2;
    PreparedStatement psn1;
    PreparedStatement psne;
    PreparedStatement psde;
     PreparedStatement psnew;
     PreparedStatement psatt;
     PreparedStatement psn1att;
      PreparedStatement psdatt;
      PreparedStatement test;
    PreparedStatement newest;
    PreparedStatement newest2;
           public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
           
           
           
            public void autoidforemp()
 {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
            Statement scus =conn.createStatement();
            
            rsempid= scus.executeQuery("select Max(employee_id) from employee");
            rsempid.next();
            rsempid.getString("Max(employee_id)");
            if(rsempid.getString("Max(employee_id)")==null){
                onen.setText("E0001");
                
            }else{
                Long idemp=Long.parseLong(rsempid.getString("Max(employee_id)").substring(2,rsempid.getString("Max(employee_id)").length()));
                idemp++;
                
                onen.setText("E0"+ String.format("%03d",idemp));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
          
}
             public void LoadempID2(){
    
        
        try {
            psnew=conn.prepareStatement("select employee_id from employee");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsnew= psnew.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            while(rsnew.next()){
                idcombo.addItem(rsnew.getString("employee_id"));
                 idcombo2.addItem(rsnew.getString("employee_id"));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
            
            
      
           
           
           
      
               
             
             
             
             
             
           
           
           
           
           
           
                   
                    public void emptable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psn1=conn.prepareStatement("select *  from employee");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsn= psn1.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd = null;
        try {
            rsmd = rsn.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2=(DefaultTableModel)employee.getModel();
        model2.setRowCount(0);
        
        try {
            while(rsn.next()){
                Vector vk1= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vk1.add(rsn.getString("employee_id"));
                    vk1.add(rsn.getString("employee_name"));
                     vk1.add(rsn.getString("employee_phone"));
                    vk1.add(rsn.getString("employee_address"));
                   vk1.add(rsn.getString("emp_NIC"));
                     vk1.add(rsn.getString("JobRole"));
                    
                    
                }
                model2.addRow(vk1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
       }
            public void atttable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psn1att=conn.prepareStatement("select *  from emp_attendance");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsnatt= psn1att.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmdatt = null;
        try {
            rsmdatt = rsnatt.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmdatt.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2att=(DefaultTableModel)att.getModel();
        model2att.setRowCount(0);
        
        try {
            while(rsnatt.next()){
                Vector vka= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vka.add(rsnatt.getString("Date"));
                    vka.add(rsnatt.getString("employee_ID"));
                     vka.add(rsnatt.getString("Status"));
                    
                   
                    
                    
                }
                model2att.addRow(vka);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton5 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        onen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        twon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fourn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        threen = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        emptable = new javax.swing.JScrollPane();
        employee = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idcombo = new javax.swing.JComboBox<>();
        statecobo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        attdate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        att = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        fiven = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        rolecombo = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        panelslip = new javax.swing.JPanel();
        idcombo2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        rolebox = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bsal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        allo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        taxbox = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        netbox = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/croped new.png"))); // NOI18N

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/logout new.png"))); // NOI18N
        jButton5.setText("logout");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/Car-Rent-Vector-Illustration sssssssssssss.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(105, 105, 105)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setText("Employee Mangement");

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setText("employee ID:");

        onen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onenActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setText("employee name:");

        twon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        twon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel5.setText("employee phone:");

        fourn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setText("employee address:");

        threen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/save.png"))); // NOI18N
        jButton1.setText("save");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/update.png"))); // NOI18N
        jButton2.setText("update");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/delete.png"))); // NOI18N
        jButton3.setText("delete");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/print new.png"))); // NOI18N
        jButton4.setText("print");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "empID", "name", "phoneNo", "Address", "NIC", "jobRole"
            }
        ));
        employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeMouseClicked(evt);
            }
        });
        emptable.setViewportView(employee);

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton6.setText("reset");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel7.setText("employee ID:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel8.setText("Attendance status:");

        idcombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        statecobo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statecobo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presence", "Absent" }));

        jLabel9.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel9.setText("Date:");

        att.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        att.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Employee ID", "Attendance status"
            }
        ));
        jScrollPane1.setViewportView(att);

        jLabel10.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel10.setText("Attendance Marking");

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Mark");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Print ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel11.setText("employee NIC:");

        fiven.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton10.setText("refresh page");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel12.setText("Job Role:");

        rolecombo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Assistant", "HR_manager", "CS_manager", "VH_manager", "RH_manager", " " }));

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("calc salary");
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        panelslip.setBackground(new java.awt.Color(255, 255, 255));

        idcombo2.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        idcombo2.setBorder(null);
        idcombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcombo2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("employee:");

        rolebox.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        rolebox.setBorder(null);
        rolebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleboxActionPerformed(evt);
            }
        });
        rolebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roleboxKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("job role:");

        bsal.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        bsal.setBorder(null);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Basic salary(Rs):");

        allo.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        allo.setBorder(null);
        allo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alloActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Allowances(Rs):");

        taxbox.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        taxbox.setBorder(null);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Tax(Rs):");

        netbox.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        netbox.setBorder(null);
        netbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netboxActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("Net salary:");

        jLabel19.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel19.setText("Employee payslip");

        javax.swing.GroupLayout panelslipLayout = new javax.swing.GroupLayout(panelslip);
        panelslip.setLayout(panelslipLayout);
        panelslipLayout.setHorizontalGroup(
            panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelslipLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelslipLayout.createSequentialGroup()
                        .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(panelslipLayout.createSequentialGroup()
                        .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taxbox)
                    .addComponent(allo)
                    .addComponent(rolebox)
                    .addComponent(idcombo2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bsal)
                    .addComponent(netbox))
                .addContainerGap())
            .addGroup(panelslipLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel19)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        panelslipLayout.setVerticalGroup(
            panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelslipLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(32, 32, 32)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idcombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(19, 19, 19)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(rolebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(19, 19, 19)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taxbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(panelslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jButton12.setBackground(new java.awt.Color(51, 51, 51));
        jButton12.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("clear ");
        jButton12.setBorder(null);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(51, 51, 51));
        jButton13.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Print slip");
        jButton13.setBorder(null);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(fiven, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(statecobo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(idcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(attdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(onen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(threen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(63, 63, 63)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fourn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(twon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rolecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emptable, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(226, 226, 226)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(emptable, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(onen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(twon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(threen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(fourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fiven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(rolecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(attdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(idcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(statecobo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(panelslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onenActionPerformed

    private void twonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String emid =onen.getText();
         String emname =twon.getText();
         String emaddress =fourn.getText();
         String emphone =threen.getText();
          String empnic =fiven.getText();
          String role = rolecombo.getSelectedItem().toString();
           
           
           if(emid.equals("")){
            JOptionPane.showMessageDialog(null,"employee id must be entered");
        }

else if(emname.equals("")){
            JOptionPane.showMessageDialog(null,"employee name must be entered");
        }

else if(emphone.equals("")){
            JOptionPane.showMessageDialog(null,"employee phone number must be entered");
        }
else if(emaddress.equals("")){
            JOptionPane.showMessageDialog(null,"employee address  must be entered");
        }
 else if(!(emphone.trim().matches("^[0-9]{10}$"))&& !(emphone.trim().matches("^[+][0-9]{11}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid phone number ");
} 
  else if(!(fiven.getText().trim().matches("^[0-9]{9}[vV]$")) && !(fiven.getText().trim().matches("^[0-9]{12}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid NIC ");
}        
           else{             
            
                   try {
                       psne = conn.prepareStatement("update employee set employee_name=?,employee_phone=?,employee_address=?,emp_NIC=?,JobRole=? where employee_id=?") ;
                       
                       
                       
                       
                       psne.setString(1,emname);
                       
                       psne.setString(2,emphone);
                       psne.setString(3,emaddress);
                       
                       
                       psne.setString(4,empnic);
                       psne.setString(5,role);
                       psne.setString(6,emid);
                        
                       psne.executeUpdate();
                        onen.setText("");
                     twon.setText("");
                     threen.setText("");
        fourn.setText("");
        fiven.setText("");
                       
                       JOptionPane.showMessageDialog(this,"updated successful");
                       emptable();
                       
                       
                   } catch (SQLException ex) {
                       Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
           
                
                
                
            
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               String emid=onen.getText(); 
       String emname=twon.getText();
         String emphone=threen.getText();
        String emaddress=fourn.getText();
      String empnic=fiven.getText();
      String role = rolecombo.getSelectedItem().toString();
      
        

if(emid.equals("")){
            JOptionPane.showMessageDialog(null,"employee id must be entered");
        }

else if(emname.equals("")){
            JOptionPane.showMessageDialog(null,"employee name must be entered");
        }
  else if(!(emphone.trim().matches("^[0-9]{10}$"))&& !(emphone.trim().matches("^[+][0-9]{11}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid phone number ");
}       

else if(emphone.equals("")){
            JOptionPane.showMessageDialog(null,"employee phone number must be entered");
        }
else if(emaddress.equals("")){
            JOptionPane.showMessageDialog(null,"employee address  must be entered");
        }else if(empnic.equals("")){
            JOptionPane.showMessageDialog(null,"employee NIC  must be entered");
        }
        else if(!(fiven.getText().trim().matches("^[0-9]{9}[vV]$")) && !(fiven.getText().trim().matches("^[0-9]{12}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid NIC ");
}        



else{             
            
                   try {
                       psn1 = conn.prepareStatement("insert into employee(employee_id,employee_name,employee_phone,employee_address,emp_NIC,JobRole)values(?,?,?,?,?,?)");
                       
                       
                       
                       psn1.setString(1,emid);
                       psn1.setString(2,emname);
                       
                       
                       
                       psn1.setString(3,emphone);
                       psn1.setString(4,emaddress);
                       psn1.setString(5,empnic);
                        psn1.setString(6,role);
                       psn1.executeUpdate();
                       twon.setText("");
                     threen.setText("");
        fourn.setText("");
        fiven.setText("");
        
                       
                       JOptionPane.showMessageDialog(this,"employee information saved successful");
                       emptable();
                       autoidforemp();
                       LoadempID2();
                   } catch (SQLException ex) {
                       Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
                   }
                
           
                
                
                
            
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
              empLog seventh= new empLog();
              seventh.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d2e=(DefaultTableModel)employee.getModel();
            int selectIndex=employee.getSelectedRow();
            
            
            
            onen. setText (d2e.getValueAt (selectIndex, 0).toString());
             twon. setText (d2e.getValueAt (selectIndex, 1).toString());
                threen. setText (d2e.getValueAt (selectIndex, 2).toString());
              fourn. setText (d2e.getValueAt (selectIndex, 3).toString());
             fiven. setText (d2e.getValueAt (selectIndex, 4).toString());
             rolecombo. setSelectedItem (d2e.getValueAt (selectIndex, 5).toString());
                
    }//GEN-LAST:event_employeeMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
               try {
            // TODO add your handling code here:
            MessageFormat header= new MessageFormat("Employee details Report");
            MessageFormat footer= new MessageFormat("___________________________");
            
            employee.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int option=JOptionPane.showConfirmDialog(null,"Are you sure to delete","delete",JOptionPane.YES_NO_OPTION);
        if(option==0){
         try {
            // TODO add your handling code here:
            String emid =onen.getText();
            
            psde=conn.prepareStatement("delete from employee where employee_id=?");
            psde.setString(1,emid);
                psde.executeUpdate();
                emptable();
                 
                     twon.setText("");
                     threen.setText("");
        fourn.setText("");
        fiven.setText("");
                JOptionPane.showMessageDialog(this,"record is deleted successfully");
               
            LoadempID2();
            autoidforemp();
            
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        onen.setText("");
                     twon.setText("");
                     threen.setText("");
        fourn.setText("");
        fiven.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String dateatt = Date_Format.format(attdate.getDate());
            String eidatt = idcombo.getSelectedItem().toString();
            String attst = statecobo.getSelectedItem().toString();
            
            psatt = conn.prepareStatement("insert into emp_attendance  (Date,employee_ID,Status)values(?,?,?)");
            
            psatt.setString(1, dateatt);
            psatt.setString(2, eidatt);
            psatt.setString(3, attst);
            psatt.executeUpdate();
            
                     
            atttable();
            autoidforemp();
            JOptionPane.showMessageDialog(this, "marked attendance successfully");
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
                    
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
              SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
            String dateatt = Date_Format.format(attdate.getDate());
            
            psdatt=conn.prepareStatement("delete from emp_attendance where Date=?");
            psdatt.setString(1,dateatt);
                psdatt.executeUpdate();
                 atttable();
                JOptionPane.showMessageDialog(this,"deleted successfully");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
                  try {
            // TODO add your handling code here:
            MessageFormat header= new MessageFormat("daily attendance Report");
            MessageFormat footer= new MessageFormat("___________________________");
            
            att.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         dispose();
              employeeM empr= new employeeM();
              empr.setVisible(true);
               autoidforemp();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void roleboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleboxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_roleboxActionPerformed

    private void idcombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcombo2ActionPerformed
        // TODO add your handling code here:
        try {

            try {
                // TODO add your handling code here:

                String empId = idcombo2.getSelectedItem() .toString();

                newest=conn.prepareStatement("select JobRole from employee where employee_id=?");
                newest.setString(1, empId);
                rsnewest = newest.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(rsnewest.next()==false){
                JOptionPane.showMessageDialog(this,"employee not found");
            }else{

                String jbrole=rsnewest.getString("JobRole");
                rolebox.setText(jbrole.trim());

            
            }

        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         
    }//GEN-LAST:event_idcombo2ActionPerformed

    private void roleboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roleboxKeyPressed
        // TODO add your handling code here:
                     
    }//GEN-LAST:event_roleboxKeyPressed

    private void alloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alloActionPerformed

    private void netboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netboxActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         try {

            try {
                // TODO add your handling code here:

                String jrole = rolebox.getText();

                newest2=conn.prepareStatement("select * from basics where job_role=?");
                newest2.setString(1, jrole);
                rsnewest2 = newest2.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(rsnewest2.next()==false){
                JOptionPane.showMessageDialog(this,"employee not found");
            }else{

                Double bassalry=rsnewest2.getDouble("Basic_sal");
                bsal.setText(Double.toString(bassalry));

            
            }

        } catch (SQLException ex) {
            Logger.getLogger(employeeM.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
          double allowance;
         double basicsalary=Double.parseDouble(bsal.getText());
         if(basicsalary>40000.0){
            allowance=basicsalary*(10/100.0);
         }else{
         allowance=basicsalary*(5/100.0);
         }
         allo.setText(Double.toString(allowance));
         
         double tax;
         double basicsalary2=Double.parseDouble(bsal.getText());
        if(basicsalary2>=50000){
        tax=basicsalary*(1/100.0);
        }else{
        tax=0;
        } 
        taxbox.setText(Double.toString(tax));

        double netsalary;
        double basicsalary3=Double.parseDouble(bsal.getText());
        double allowance3=Double.parseDouble(allo.getText());
        double tax3=Double.parseDouble(taxbox.getText());
        
        netsalary=(basicsalary3+allowance3)-tax3;
        netbox.setText("Rs."+Double.toString(netsalary)+"0");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         PrinterJob jobe = PrinterJob.getPrinterJob();
            jobe.setJobName("Print Data");
            
            jobe.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.PORTRAIT);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2e = (Graphics2D)pg;
                g2e.translate(pf.getImageableX(), pf.getImageableY());
                g2e.scale(1.2,0.99);
                
                panelslip.print(g2e);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = jobe.printDialog();
        if(ok){
        try{
            
        jobe.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }    
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        rolebox.setText("");
        bsal.setText("");
         allo.setText("");
        taxbox.setText("");
        netbox.setText("");
        
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
            java.util.logging.Logger.getLogger(employeeM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeeM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeeM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeeM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeeM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allo;
    private javax.swing.JTable att;
    private com.toedter.calendar.JDateChooser attdate;
    private javax.swing.JTextField bsal;
    private javax.swing.JTable employee;
    private javax.swing.JScrollPane emptable;
    private javax.swing.JTextField fiven;
    private javax.swing.JTextField fourn;
    private javax.swing.JComboBox<String> idcombo;
    private javax.swing.JComboBox<String> idcombo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField netbox;
    private javax.swing.JTextField onen;
    private javax.swing.JPanel panelslip;
    private javax.swing.JTextField rolebox;
    private javax.swing.JComboBox<String> rolecombo;
    private javax.swing.JComboBox<String> statecobo;
    private javax.swing.JTextField taxbox;
    private javax.swing.JTextField threen;
    private javax.swing.JTextField twon;
    // End of variables declaration//GEN-END:variables
}
