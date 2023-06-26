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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class customermangemnt extends javax.swing.JFrame {

    /**
     * Creates new form customermangemnt
     */
    public customermangemnt() {
        initComponents();
        connect();
        
        custable();
        ratingTable();
        loyalcus();
        autoidforcus();
        
    }
    Connection conn;
    PreparedStatement psk;
    PreparedStatement psk1;
     PreparedStatement psk2;
     PreparedStatement pskc;
      PreparedStatement psdc;
      PreparedStatement pst21;
       PreparedStatement pslo;
        PreparedStatement search;
          PreparedStatement search2;
            ResultSet rsk;
             ResultSet rsk1;
             ResultSet rscus;
    
        public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
               
       public void autoidforcus()
 {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
            Statement scus =conn.createStatement();
            
            rscus= scus.executeQuery("select Max(Customer_ID) from customers");
            rscus.next();
            rscus.getString("Max(Customer_ID)");
            if(rscus.getString("Max(Customer_ID)")==null){
                onek.setText("C0001");
                
            }else{
                Long idcus=Long.parseLong(rscus.getString("Max(Customer_ID)").substring(2,rscus.getString("Max(Customer_ID)").length()));
                idcus++;
                
                onek.setText("C0"+ String.format("%03d",idcus));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
          
}
        
        
        
        
        
        
        
        
        
        
        
        
         public void loyalcus(){
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet rslo = stmt.executeQuery("select Cus_ID  from customer_rents where No_of_Rent>=2");
            
            while (rslo.next()) {
                String x=rslo.getString(1);
                 
                jTextArea1.append("-> "+x+"\n");
            }       } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
           }
       
       
        
        
        
        
        
        
        
             public void ratingTable(){
       
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
            pst21=conn.prepareStatement("select *  from customer_rents");
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsk1= pst21.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd1 = null;
        try {
            rsmd1 = rsk1.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd1.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2r=(DefaultTableModel)ratings.getModel();
        model2r.setRowCount(0);
        
        try {
            while(rsk1.next()){
                Vector vr= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vr.add(rsk1.getString("Cus_ID"));
                    vr.add(rsk1.getString("No_of_Rent"));
                    
                }
                model2r.addRow(vr);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
            
            
       }
        
        
        
        
        
        
        
        
                    public void custable(){
       
       int c = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection("jdbc:mysql://localhost/hbs_rent","root","");
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            psk2=conn.prepareStatement("select *  from customers");
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rsk= psk2.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            ResultSetMetaData rsmd = null;
        try {
            rsmd = rsk.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            c= rsmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model2=(DefaultTableModel)custbl.getModel();
        model2.setRowCount(0);
        
        try {
            while(rsk.next()){
                Vector vk= new Vector();
                
                for(int i=1;i<=c;i++){
                    
                    vk.add(rsk.getString("Customer_ID"));
                    vk.add(rsk.getString("Cus_type"));
                    vk.add(rsk.getString("Customer_name"));
                        vk.add(rsk.getString("NIC"));
                            vk.add(rsk.getString("passport_NO"));
                    vk.add(rsk.getString("Cus_address"));
                     vk.add(rsk.getString("cus_phone"));
                    
                }
                model2.addRow(vk);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        onek = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combok = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        twok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        threek = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        custbl = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        passbox = new javax.swing.JTextField();
        nicbox = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        searchtext = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        serchres = new javax.swing.JTextField();
        searchsel = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        phonecus = new javax.swing.JTextField();
        allcus = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ratings = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/croped new.png"))); // NOI18N

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/back-button new.png"))); // NOI18N
        jButton7.setText("Back");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(51, 51, 51));
        jButton8.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/logout new.png"))); // NOI18N
        jButton8.setText("logout");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/Car-Rent-Vector-Illustration sssssssssssss.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel3.setText("customerID:");

        onek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        onek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onekActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel4.setText("customerType:");

        combok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "local", "foreign" }));
        combok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combokMouseClicked(evt);
            }
        });
        combok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokActionPerformed(evt);
            }
        });
        combok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combokKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel5.setText("customerName:");

        twok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        twok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twokActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel6.setText("Address:");

        threek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton4.setText("reset");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        custbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        custbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "customerID", "Type", "name", "NIC", "Passport_No", "Address", "phone"
            }
        ));
        custbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(custbl);

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/print new.png"))); // NOI18N
        jButton5.setText("print");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel2.setText("Customer mangement");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel7.setText("NIC no:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel8.setText("Passport no:");

        passbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passboxActionPerformed(evt);
            }
        });

        nicbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nicbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicboxActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel11.setText("Search past customers:");

        searchtext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/search samll.png"))); // NOI18N
        jButton6.setText("Search");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        serchres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchsel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchsel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "foreign", "local" }));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pasan/refresh.png"))); // NOI18N
        jButton9.setText("refresh page");
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jLabel13.setText("phone:");

        phonecus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        allcus.setBackground(new java.awt.Color(255, 255, 255));

        ratings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "customer_ID", "number of rents"
            }
        ));
        jScrollPane2.setViewportView(ratings);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel10.setText("Loyal customers ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(117, 117, 117))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel12.setText("customers transactions");

        javax.swing.GroupLayout allcusLayout = new javax.swing.GroupLayout(allcus);
        allcus.setLayout(allcusLayout);
        allcusLayout.setHorizontalGroup(
            allcusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allcusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(allcusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(allcusLayout.createSequentialGroup()
                        .addGroup(allcusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allcusLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(111, 111, 111))))
        );
        allcusLayout.setVerticalGroup(
            allcusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allcusLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("print report");
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(threek, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(235, 235, 235)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nicbox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phonecus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(267, 267, 267)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(searchsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(serchres, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(allcus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(363, 363, 363)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(onek, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passbox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(162, 162, 162)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(twok, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(combok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(onek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                    .addComponent(twok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(passbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(threek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nicbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(serchres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(allcus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(phonecus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onekActionPerformed

    private void twokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twokActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cusId=onek.getText(); 
       String custype=(String)combok.getSelectedItem();

       
       String cusname=twok.getText();
         String nicno=nicbox.getText();
           String passno=passbox.getText();
       String adress=threek.getText();
         String phone=phonecus.getText();
        

if(cusId.equals("")){
            JOptionPane.showMessageDialog(null,"customer id must be entered");
        }
  else if(!(nicbox.getText().trim().matches("^[0-9]{9}[vV]$")) && !(nicbox.getText().trim().matches("^[0-9]{12}$"))&&!nicno.equals(""))
{
    JOptionPane.showMessageDialog(null,"Invalid NIC ");
}      

else if(cusname.equals("")){
            JOptionPane.showMessageDialog(null,"customer name must be entered");
        }

else if(adress.equals("")){
            JOptionPane.showMessageDialog(null,"customer address  must be entered");
        }
else if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"customer phone number  must be entered");
        }
 else if(!(phone.trim().matches("^[0-9]{10}$"))&& !(phone.trim().matches("^[+][0-9]{11}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid phone number ");
} 



else{
    
             
  
                
            try {
                psk1 = conn.prepareStatement("insert into customers(Customer_ID ,Cus_type,Customer_name,NIC,passport_NO,Cus_address,cus_phone)values(?,?,?,?,?,?,?)");
                
                

                psk1.setString(1,cusId);
                psk1.setString(2,custype);
                
                
                
                psk1.setString(3,cusname);
                psk1.setString(4,nicno);
                psk1.setString(5,passno);
                psk1.setString(6,adress);
                psk1.setString(7,phone);
                psk1.executeUpdate();
                
                
                JOptionPane.showMessageDialog(this,"customer alloacation successful");
                twok.setText("");
                     threek.setText("");
                     nicbox.setText("");
                      passbox.setText("");
                      phonecus.setText("");
                      
                      
                      
                        combok.setSelectedItem("select");
                       
                        
                custable();
                autoidforcus();
            } catch (SQLException ex) {
                Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                             
           
        
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int option2=JOptionPane.showConfirmDialog(null,"Are you sure to delete","delete",JOptionPane.YES_NO_OPTION);
        if(option2==0){
            try {
            // TODO add your handling code here:
            String cid =onek.getText();
            
            psdc=conn.prepareStatement("delete from customers where Customer_ID =?");
            psdc.setString(1,cid);
                psdc.executeUpdate();
                custable();
                JOptionPane.showMessageDialog(this,"record is deleted successfully");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }    
            try {
            // TODO add your handling code here:
            String cidr =onek.getText();
            
            psdc=conn.prepareStatement("delete from customer_rents where Cus_ID=?");
            psdc.setString(1,cidr);
                psdc.executeUpdate();
                
                  onek.setText("");
                     twok.setText("");
                     threek.setText("");
                     nicbox.setText("");
                      passbox.setText("");
                      phonecus.setText("");
                       combok.setSelectedItem("select");
                      
                ratingTable();
                autoidforcus();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(rentals_management.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         onek.setText("");
                     twok.setText("");
                     threek.setText("");
                     nicbox.setText("");
                      passbox.setText("");
                       combok.setSelectedItem("select");
                       serchres.setText("");
                       searchtext.setText("");
                        
                       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         dispose();
              rentals_management third= new rentals_management();
              third.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         String csid =onek.getText();
         String ctyp = combok.getSelectedItem().toString();
          String csname =twok.getText();
          String nicno=nicbox.getText();
           String csaddress =threek.getText();
            String phone =phonecus.getText();
          
           if(csid.equals("")){
            JOptionPane.showMessageDialog(null,"customer id must be entered");
        }

else if(csname.equals("")){
            JOptionPane.showMessageDialog(null,"customer name must be entered");
        }

else if(csaddress.equals("")){
            JOptionPane.showMessageDialog(null,"customer address  must be entered");
        }
 else if(!(phone.trim().matches("^[0-9]{10}$"))&& !(phone.trim().matches("^[+][0-9]{11}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid phone number ");
}
  else if(!(nicbox.getText().trim().matches("^[0-9]{9}[vV]$")) && !(nicbox.getText().trim().matches("^[0-9]{12}$")))
{
    JOptionPane.showMessageDialog(null,"Invalid NIC ");
}      

           else{
    
             
  
                
            try {
                pskc = conn.prepareStatement("update customers set Cus_type=?,Customer_name=?,NIC=?,Cus_address=?,cus_phone=? where Customer_ID=?");
                
                
                  
                pskc.setString(1,ctyp);
               
                pskc.setString(2,csname);
                pskc.setString(3,nicno);
                pskc.setString(4,csaddress);
                pskc.setString(5,phone);
                 pskc.setString(6,csid); 
                
                
                pskc.executeUpdate();
                  onek.setText("");
                     twok.setText("");
                     threek.setText("");
                     nicbox.setText("");
                      passbox.setText("");
                       combok.setSelectedItem("select");
                       phonecus.setText("");
                
                JOptionPane.showMessageDialog(this,"updated successfully");
                custable();
            } catch (SQLException ex) {
                Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                             
           
        
    }
           
           
           
    }//GEN-LAST:event_jButton2ActionPerformed

    private void custblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custblMouseClicked
        // TODO add your handling code here:
                DefaultTableModel d2c=(DefaultTableModel)custbl.getModel();
            int selectIndex=custbl.getSelectedRow();
            
            
            
            onek. setText (d2c.getValueAt (selectIndex, 0).toString());
            combok. setSelectedItem (d2c.getValueAt (selectIndex, 1).toString());
              twok. setText (d2c.getValueAt (selectIndex, 2).toString());
               nicbox. setText (d2c.getValueAt (selectIndex, 3).toString());
                passbox. setText (d2c.getValueAt (selectIndex, 4).toString());
               threek. setText (d2c.getValueAt (selectIndex, 5).toString());
               phonecus. setText (d2c.getValueAt (selectIndex, 6).toString());
    }//GEN-LAST:event_custblMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
              rental_login fourteenth= new rental_login();
              fourteenth.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
           try {
            // TODO add your handling code here:
            MessageFormat header= new MessageFormat("Customer details Report");
            MessageFormat footer= new MessageFormat("___________________________");
            
            custbl.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(VehicleManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void passboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passboxActionPerformed

    private void combokKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combokKeyPressed
        // TODO add your handling code here:
        
         
    }//GEN-LAST:event_combokKeyPressed

    private void combokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combokMouseClicked
        // TODO add your handling code here:
      
  
    }//GEN-LAST:event_combokMouseClicked

    private void combokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokActionPerformed
        // TODO add your handling code here:
           String custype2=(String)combok.getSelectedItem();
            if(custype2.equals("local")){
                   passbox.setEnabled (false);
                    nicbox.setEnabled (true);
            } else if(custype2.equals("foreign"))
                {
                    passbox.setEnabled (true);
                    nicbox.setEnabled (false);
                    
                   

               
                }else{
                 passbox.setEnabled (true);
                    nicbox.setEnabled (true);
                }
               
    }//GEN-LAST:event_combokActionPerformed

    private void nicboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicboxActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            // TODO add your handling code here:
             String typ = searchsel.getSelectedItem().toString();
            if(typ=="local"){
            
            search =conn.prepareStatement("select Customer_ID from customers where NIC=?");
             String nics=searchtext.getText();
             search.setString(1,nics);
             
              
            ResultSet rss=search.executeQuery();
           
            
            if(rss.next()==false){
                JOptionPane.showMessageDialog(null,"customer not found");
                serchres.setText("");
            }else{
                serchres.setText(rss.getString("Customer_ID"));
                 JOptionPane.showMessageDialog(null,"customer already saved in system");
            }
             
            }else{ 
             
             
             
             
             
            search2=conn.prepareStatement("select Customer_ID from customers where passport_NO=?");
            
            String passport=searchtext.getText();
            
            search2.setString(1,passport);
            
            
            
            ResultSet rss2=search2.executeQuery();
            
            if(rss2.next()==false){
                JOptionPane.showMessageDialog(null,"customer not found");
                serchres.setText("");
            }else {
                serchres.setText(rss2.getString("Customer_ID"));
                JOptionPane.showMessageDialog(null,"customer already saved in system");
            }
            
            
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(customermangemnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        dispose();
              customermangemnt cus= new customermangemnt();
              cus.setVisible(true);
               autoidforcus();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
             PrinterJob jobc = PrinterJob.getPrinterJob();
            jobc.setJobName("Print Data");
            
            jobc.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.PORTRAIT);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2c = (Graphics2D)pg;
                g2c.translate(pf.getImageableX(), pf.getImageableY());
                g2c.scale(1.2,0.99);
                
                allcus.print(g2c);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = jobc.printDialog();
        if(ok){
        try{
            
        jobc.print();
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
            java.util.logging.Logger.getLogger(customermangemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customermangemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customermangemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customermangemnt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customermangemnt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allcus;
    private javax.swing.JComboBox<String> combok;
    private javax.swing.JTable custbl;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nicbox;
    private javax.swing.JTextField onek;
    private javax.swing.JTextField passbox;
    private javax.swing.JTextField phonecus;
    private javax.swing.JTable ratings;
    private javax.swing.JComboBox<String> searchsel;
    private javax.swing.JTextField searchtext;
    private javax.swing.JTextField serchres;
    private javax.swing.JTextField threek;
    private javax.swing.JTextField twok;
    // End of variables declaration//GEN-END:variables
}
