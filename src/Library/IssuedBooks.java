/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Library.DBConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bawanthi
 */
public class IssuedBooks extends javax.swing.JFrame {

    /**
     * Creates new form IssuedBooks
     */
    public IssuedBooks() {
        initComponents();
        IssuedBooksLoad();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void IssuedBooksLoad(){
    
        int c;
        try {
           
            DBConnection dc = new DBConnection();
            try {
                con = dc.getConnection();
            
                
                dc.getConnection();
            
                
                pst=dc.getConnection().prepareStatement("select * from issued_books");
            } catch (Exception ex) {
                Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
             
            DefaultTableModel d = (DefaultTableModel)jTableIssue.getModel();
            d.setRowCount(0);
            
           while(rs.next()){
               Vector v2 = new Vector();
               
               for(int i =1; i<=c;i++){
                   v2.add(rs.getString("issuedId"));
                   v2.add(rs.getString("bookId"));
                   v2.add(rs.getString("bookName")); 
                   v2.add(rs.getString("memberName"));
                   v2.add(rs.getString("issuedDate"));
                   v2.add(rs.getString("returnDate"));
                   v2.add(rs.getString("receivedDate"));
                   v2.add(rs.getString("fine"));
               }
               d.addRow(v2);
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblBookID = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblMemberID = new javax.swing.JLabel();
        lblIssued = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBookID = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        txtMemberName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFine = new javax.swing.JTextField();
        issueBtnAdd = new javax.swing.JButton();
        issueBtnUpdate = new javax.swing.JButton();
        issueBtnDelete = new javax.swing.JButton();
        issueBtnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIssue = new javax.swing.JTable();
        jDateIssue = new com.toedter.calendar.JDateChooser();
        jDateReturn = new com.toedter.calendar.JDateChooser();
        jDateReceived = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Issued Books");

        lblBookID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBookID.setText("Book ID              :");

        lblBookName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBookName.setText("Book Name        :");

        lblMemberID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMemberID.setText("Member Name        :");

        lblIssued.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIssued.setText("Issued Date        :  ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Return Date        :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Received Date     :");

        txtBookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBookIDKeyPressed(evt);
            }
        });

        txtMemberName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMemberNameKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fine                      :");

        issueBtnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueBtnAdd.setText("Add");
        issueBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnAddActionPerformed(evt);
            }
        });

        issueBtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueBtnUpdate.setText("Update");
        issueBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnUpdateActionPerformed(evt);
            }
        });

        issueBtnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueBtnDelete.setText("Delete");
        issueBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnDeleteActionPerformed(evt);
            }
        });

        issueBtnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueBtnBack.setText("Back");
        issueBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBtnBackActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Search Issued Date :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTableIssue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issued ID", "Book ID", "Book Name", "Member ID", "Issued Date", "Return Date", "Received Date", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIssueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableIssue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMemberID)
                            .addComponent(lblIssued)
                            .addComponent(lblBookName)
                            .addComponent(lblBookID)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(issueBtnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addComponent(issueBtnAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(issueBtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(issueBtnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtBookName)
                                            .addComponent(txtMemberName)
                                            .addComponent(txtBookID)
                                            .addComponent(txtFine)
                                            .addComponent(jDateIssue, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                            .addComponent(jDateReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateReceived, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBookID)
                                    .addComponent(txtBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBookName)
                                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMemberID)
                                    .addComponent(txtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblIssued))
                            .addComponent(jDateIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(issueBtnAdd)
                            .addComponent(issueBtnUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(issueBtnDelete)
                            .addComponent(issueBtnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public class BookItem{
            int bookID;
            String bookName;
         public BookItem(int bookID,String bookName){
             this.bookID = bookID;
             this.bookName =bookName;
             
         } 
         public String toString(){
             return bookName;
         }
            
    }
    
    private void txtBookIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBookIDKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
                String bookId= txtBookID.getText();
            try {
                pst = con.prepareStatement("select * from books where bookId = ?");
            } catch (SQLException ex) {
                Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst.setString(1,bookId);
            } catch (SQLException ex) {
                Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs = pst.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                if(rs.next() == false ){
                    JOptionPane.showMessageDialog(this,"Book Id not found" );
                
                }else{
                
                    String bookName = rs.getString("bookName");
                    txtBookName.setText(bookName.trim());
                }
            } catch (SQLException ex) {
                Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                
    }//GEN-LAST:event_txtBookIDKeyPressed

    private void txtMemberNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMemberNameKeyPressed
        // TODO add your handling code here:
         //if(evt.getKeyCode()== KeyEvent.VK_ENTER){
                //String memberId= txtMemberID.getText();
    }//GEN-LAST:event_txtMemberNameKeyPressed

    private void issueBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnAddActionPerformed
        //TODO add your handling code here:
        String bookId = txtBookID.getText();
        String bookName = txtBookName.getText();
        String memberName = txtMemberName.getText();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String issuedDate =date_format.format(jDateIssue.getDate());
        SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
        String returnDate =date_format1.format(jDateReturn.getDate());
        SimpleDateFormat date_format2 = new SimpleDateFormat("yyyy-MM-dd");
        String receivedDate =date_format2.format(jDateReceived.getDate());
        String fine = txtFine.getText();
     
        try {
        if(bookId.equals("")){
            JOptionPane.showMessageDialog(null, "Book ID is Mandotory");
        }
        if(bookName.equals("")){
            JOptionPane.showMessageDialog(null, "Book name is Mandotory");
        }
        if(memberName.equals("")){
            JOptionPane.showMessageDialog(null, "Member name number is Mandotory");
        }
        if(issuedDate.equals("")){
            JOptionPane.showMessageDialog(null, "Issued date is Mandotory");
        }
        if(returnDate.equals("")){
            JOptionPane.showMessageDialog(null, "Return date is Mandotory");
        }
        if(receivedDate.equals("")){
            JOptionPane.showMessageDialog(null, "Received date is Mandotory");
        }
        if(fine.equals("")){
            JOptionPane.showMessageDialog(null, "Fine is Mandotory");
        }
            
            pst = con.prepareStatement("insert into issued_books(bookId,bookName,memberName,issuedDate,returnDate,receivedDate,fine) values(?,?,?,?,?,?,?)");
         
            pst.setString(1,bookId);
            pst.setString(2,bookName);
            pst.setString(3,memberName);
            pst.setString(4,issuedDate);
            pst.setString(5,returnDate); 
            pst.setString(6,receivedDate); 
            pst.setString(7,fine);
            
            int i = pst.executeUpdate();
           
            if (i==1){
                JOptionPane.showMessageDialog(this, "Book Issued");
                txtBookID.setText("");
                txtBookName.setText("");
                txtMemberName.setText("");
                txtFine.setText("");
                jDateIssue.setCalendar(null);
                jDateReturn.setCalendar(null);
                jDateReceived.setCalendar(null);
                IssuedBooksLoad();
                
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_issueBtnAddActionPerformed
    
    
    private void issueBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnUpdateActionPerformed
        // TODO add your handling code here:
        //UPDATE
        //DefaultTableModel d1 = (DefaultTableModel)jTableIssue.getModel();
        //int selectIndex = jTableIssue.getSelectedRow();
        //int issuedId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        int id = Integer.parseInt(txtSearch.getText());
        
        String bookId = txtBookID.getText();
        String bookName = txtBookName.getText();
        String memberName = txtMemberName.getText();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String issuedDate = date_format.format(jDateIssue.getDate());
        SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
        String returnDate = date_format1.format(jDateReturn.getDate());
        SimpleDateFormat date_format2 = new SimpleDateFormat("yyyy-MM-dd");
        String receivedDate = date_format2.format(jDateReceived.getDate());
        String fine = txtFine.getText();
        
        try {
            pst = con.prepareStatement("update issued_books set bookId = ?, bookName=?, memberName=?, issuedDate=?, returnDate=?, receivedDate=?, fine=? where issuedId=?");
            pst.setString(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, memberName);
            pst.setString(4, issuedDate);
            pst.setString(5, returnDate);
            pst.setString(6, receivedDate);
            pst.setString(7, fine);
            pst.setInt(8, id);
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Issued Book Updated");
                txtBookID.setText("");
                txtBookName.setText("");
                txtMemberName.setText("");
                jDateIssue.setCalendar(null);
                jDateReturn.setCalendar(null);
                jDateReceived.setCalendar(null);
                txtFine.setText("");
                IssuedBooksLoad();
                issueBtnAdd.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
    }//GEN-LAST:event_issueBtnUpdateActionPerformed
    
    }
    
    private void jTableIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIssueMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel)jTableIssue.getModel();
        int selectIndex = jTableIssue.getSelectedRow();
         
         int issuedId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
         txtBookID.setText(d1.getValueAt(selectIndex,1).toString());
         txtBookName.setText(d1.getValueAt(selectIndex,2).toString());
         txtMemberName.setText(d1.getValueAt(selectIndex,3).toString());      
         txtFine.setText(d1.getValueAt(selectIndex,7).toString()); 
         
         issueBtnAdd.setEnabled(false);
    }//GEN-LAST:event_jTableIssueMouseClicked

    private void issueBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnDeleteActionPerformed
        // TODO add your handling code here:
        //DefaultTableModel d1 = (DefaultTableModel)jTableIssue.getModel();
        //int selectIndex = jTableIssue.getSelectedRow();
        //int issuedId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        int id = Integer.parseInt(txtSearch.getText());
        try {
            pst = con.prepareStatement("delete from issued_books where issuedId = ?");
            
            pst.setInt(1,id);
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Issued Book Deleted");
                txtBookID.setText("");
                txtBookName.setText("");
                txtMemberName.setText("");
                jDateIssue.setCalendar(null);
                jDateReturn.setCalendar(null);
                jDateReceived.setCalendar(null);
                txtFine.setText("");
                IssuedBooksLoad();
                issueBtnAdd.setEnabled(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }//GEN-LAST:event_issueBtnDeleteActionPerformed

    private void issueBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBtnBackActionPerformed
        // TODO add your handling code here:
        librarianInterface li = new librarianInterface();
        li.setVisible(true);
        this.hide();
    }//GEN-LAST:event_issueBtnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            pst = con.prepareStatement("select * from issued_books where issuedId=?");
            
            int id = Integer.parseInt(txtSearch.getText());
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==false){
                JOptionPane.showMessageDialog(this, "Sorry Record not Found");
                txtBookID.setText("");
                txtBookName.setText("");
                txtMemberName.setText("");
                jDateIssue.setCalendar(null);
                jDateReturn.setCalendar(null);
                jDateReceived.setCalendar(null);
                txtFine.setText("");
                txtSearch.requestFocus();
            }
            else{
                txtBookID.setText(rs.getString("bookId"));
                txtBookName.setText(rs.getString("bookName"));
                txtMemberName.setText(rs.getString("memberName"));
                jDateIssue.setDate(rs.getDate("issuedDate"));
                jDateReturn.setDate(rs.getDate("returnDate"));
                jDateReceived.setDate(rs.getDate("receivedDate"));
                txtFine.setText(rs.getString("fine"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(IssuedBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //CLAER
        txtBookID.setText("");
        txtBookName.setText("");
        txtMemberName.setText("");
        txtFine.setText("");
        jDateIssue.setCalendar(null);
        jDateReturn.setCalendar(null);
        jDateReceived.setCalendar(null);
        txtSearch.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new IssuedBooks().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton issueBtnAdd;
    private javax.swing.JButton issueBtnBack;
    private javax.swing.JButton issueBtnDelete;
    private javax.swing.JButton issueBtnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateIssue;
    private com.toedter.calendar.JDateChooser jDateReceived;
    private com.toedter.calendar.JDateChooser jDateReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIssue;
    private javax.swing.JLabel lblBookID;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblIssued;
    private javax.swing.JLabel lblMemberID;
    private javax.swing.JTextField txtBookID;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtFine;
    private javax.swing.JTextField txtMemberName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
