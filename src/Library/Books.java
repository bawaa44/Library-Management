package Library;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bawanthi
 */
public class Books extends javax.swing.JFrame {

    private Object JOptionaPane;
    
    public Books() {
        initComponents();
        BooksLoad();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void BooksLoad(){
    
        int c;
        try {
           
            DBConnection dc = new DBConnection();
            try {
                con = dc.getConnection();
            
                dc.getConnection();
            
                
                pst=dc.getConnection().prepareStatement("select * from books");
            } catch (Exception ex) {
                Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
            }
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
             
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
           while(rs.next()){
               Vector v2 = new Vector();
               
               for(int i =1; i<=c;i++){
                   v2.add(rs.getString("bookId"));
                   v2.add(rs.getString("bookName")); 
                   v2.add(rs.getString("author"));
                   v2.add(rs.getString("isbn"));
                   System.out.println(rs.getString("purDate"));
                   v2.add(rs.getString("purDate"));
                   v2.add(rs.getString("recDate"));
               }
               d.addRow(v2);
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Books = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        lblPurchased = new javax.swing.JLabel();
        lblReceived = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();
        jDatePurchased = new com.toedter.calendar.JDateChooser();
        jDateReceived = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Books.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Books.setText("Books");

        lblBookName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBookName.setText("Book Name        :");

        lblAuthor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAuthor.setText("Author                :");

        lblISBN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblISBN.setText("ISBN No             :");

        lblPurchased.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPurchased.setText("Purchased Date :");

        lblReceived.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblReceived.setText("Received Date    :");

        txtBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookNameActionPerformed(evt);
            }
        });

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "ISBN No", "Purchsed Date", "Received Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearch.setText("Search Book   :");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnPdf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPdf.setText("Generate PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(Books)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblISBN)
                        .addGap(18, 18, 18)
                        .addComponent(txtISBN))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAuthor)
                        .addGap(18, 18, 18)
                        .addComponent(txtAuthor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBookName)
                        .addGap(18, 18, 18)
                        .addComponent(txtBookName))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPurchased)
                                .addGap(18, 18, 18)
                                .addComponent(jDatePurchased, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSearch)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblReceived)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateReceived, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(421, 421, 421)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Books)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBookName)
                            .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAuthor)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblISBN)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPurchased)
                            .addComponent(jDatePurchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReceived)
                            .addComponent(jDateReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(btnPdf))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookNameActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ADD
        String bookName = txtBookName.getText();
        String author = txtAuthor.getText();
        String isbn = txtISBN.getText();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String purDate =date_format.format(jDatePurchased.getDate());
        SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
        String recDate =date_format1.format(jDateReceived.getDate());
      
        try {
            if(bookName.equals("")){
            JOptionPane.showMessageDialog(null, "Book name is Mandotory");
        }
        if(author.equals("")){
            JOptionPane.showMessageDialog(null, "Author is Mandotory");
        }
        if(isbn.equals("")){
            JOptionPane.showMessageDialog(null, "ISBN number is Mandotory");
        }
        if(purDate.equals("")){
            JOptionPane.showMessageDialog(null, "Purchased date is Mandotory");
        }
        if(recDate.equals("")){
            JOptionPane.showMessageDialog(null, "Received date is Mandotory");
        }
            
            pst = con.prepareStatement("insert into books(bookName,author,isbn,purDate,recDate) values(?,?,?,?,?)");
            pst.setString(1,bookName);
            pst.setString(2,author);
            pst.setString(3,isbn);
            pst.setString(4,purDate);
            pst.setString(5,recDate);      
            int k = pst.executeUpdate();
           
            if (k==1){
                JOptionPane.showMessageDialog(this, "Book Created");
                txtBookName.setText("");
                txtAuthor.setText("");
                txtISBN.setText("");
                jDatePurchased.setCalendar(null);
                jDateReceived.setCalendar(null);
                
                BooksLoad();
                
            }else{
                JOptionPane.showMessageDialog(this, "Error");
                txtBookName.requestFocus();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
         int selectIndex = jTable1.getSelectedRow();
         
         int bookId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
         txtBookName.setText(d1.getValueAt(selectIndex,1).toString());
         txtAuthor.setText(d1.getValueAt(selectIndex,2).toString());
         txtISBN.setText(d1.getValueAt(selectIndex,3).toString());      
      
         jButton1.setEnabled(false);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         // UPDATE
        //DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        //int selectIndex = jTable1.getSelectedRow();
        int bookId = Integer.parseInt(txtSearch.getText()); 
        //int bookId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        String bookName = txtBookName.getText();
        String author = txtAuthor.getText();
        String isbn = txtISBN.getText();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        String purDate =date_format.format(jDatePurchased.getDate());
        SimpleDateFormat date_format1 = new SimpleDateFormat("yyyy-MM-dd");
        String recDate =date_format1.format(jDateReceived.getDate());
        

        try {
            pst = con.prepareStatement("update books set bookName = ?,author = ?, isbn = ?, purDate = ?, recDate = ? where bookId = ?");
            pst.setString(1,bookName);
            pst.setString(2,author);
            pst.setString(3,isbn);
            pst.setString(4,purDate);
            pst.setString(5,recDate);
            pst.setInt(6,bookId);
            int k = pst.executeUpdate();
           
            if (k==1){
                JOptionPane.showMessageDialog(this, "Book Updated");
                txtBookName.setText("");
                txtAuthor.setText("");
                txtISBN.setText("");
                jDatePurchased.setCalendar(null);
                jDateReceived.setCalendar(null);    
                BooksLoad();
                jButton1.setEnabled(true);
                
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // DELETE
          //DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        //int selectIndex = jTable1.getSelectedRow();
        int bookId = Integer.parseInt(txtSearch.getText()); 
        //int bookId = Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        try {
            pst = con.prepareStatement("delete from books where bookId = ?");
            
            pst.setInt(1,bookId);
            int k = pst.executeUpdate();
           
            if (k==1){
                JOptionPane.showMessageDialog(this, "Book Deleted");
                txtBookName.setText("");
                txtAuthor.setText("");
                txtISBN.setText("");
                jDatePurchased.setCalendar(null);
                jDateReceived.setCalendar(null);
                BooksLoad();
                jButton1.setEnabled(true);
                
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // CANCEL
        AdminInterface ai = new AdminInterface();
        ai.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //SEARCH
        try{
        pst = con.prepareStatement("select * from books where bookId = ?");
            
          int id = Integer.parseInt(txtSearch.getText());
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                  if(rs.next()==false){
                    JOptionPane.showMessageDialog(this, "Sorry Record Not Found");
                    txtBookName.setText("");
                    txtAuthor.setText("");
                    txtISBN.setText("");
                
                    txtSearch.requestFocus();
                }
                else{
                    txtBookName.setText(rs.getString("bookName"));
                    txtAuthor.setText(rs.getString("Author"));
                    txtISBN.setText(rs.getString("ISBN"));
                    jDatePurchased.setDate(rs.getDate("purDate"));  
                    jDateReceived.setDate(rs.getDate("recDate"));
                }
        
        }
       catch (SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
           //CLEAR
            txtBookName.setText("");
            txtAuthor.setText("");
            txtISBN.setText("");
            jDatePurchased.setCalendar(null);
            jDateReceived.setCalendar(null);
            txtSearch.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        // TODO add your handling code here:
       String path="";
       JFileChooser j =new JFileChooser();
       j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       int x = j.showSaveDialog(this);
       
       if(x == JFileChooser.APPROVE_OPTION){
           path = j.getSelectedFile().getPath();
       }
       
       Document doc = new Document();
       
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"Books_Details.pdf"));
            
            doc.open();
            
            PdfPTable tbl = new PdfPTable(6);
            
            //Adding headers
            tbl.addCell("Book ID");
            tbl.addCell("Book Name");
            tbl.addCell("Author");
            tbl.addCell("ISBN Number");
            tbl.addCell("Purchased Date");
            tbl.addCell("Received Date");
            
            for(int i=0;i<jTable1.getRowCount();i++) {
            String id = jTable1.getValueAt(i, 0).toString();
            String name = jTable1.getValueAt(i,1).toString();
            String author = jTable1.getValueAt(i,2).toString();
            String isbn = jTable1.getValueAt(i,3).toString();
            String purDate = jTable1.getValueAt(i,4).toString();
            String recDate = jTable1.getValueAt(i,5).toString();
            
            tbl.addCell(id);
            tbl.addCell(name);
            tbl.addCell(author);
            tbl.addCell(isbn);
            tbl.addCell(purDate);
            tbl.addCell(recDate);
            }
            
            doc.add(tbl);
            JOptionPane.showMessageDialog(null, "Download pdf file", "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
    }//GEN-LAST:event_btnPdfActionPerformed

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
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Books;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDatePurchased;
    private com.toedter.calendar.JDateChooser jDateReceived;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblPurchased;
    private javax.swing.JLabel lblReceived;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    
}
