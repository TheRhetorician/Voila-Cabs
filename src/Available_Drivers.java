
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hardik
 */
public class Available_Drivers extends javax.swing.JFrame {
static String source,name;
public static String getSource()
{
    return source;
}
    /**
     * Creates new form Available_Drivers
     */
    public Available_Drivers() {
        initComponents();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
//        int rows = model.getRowCount();
        String dest = Map_Source.getDest();
        source = Map_Source.getSource();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardik?useSSL=false","root","Rssb18@babaji");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from drivers where flag = 1 and loc = \""+source+"\" order by rating desc;");
            while(rs.next())
            {
                name = rs.getString("name");
                String cabtype = rs.getString("cabtype");
                float rating = rs.getFloat("rating");
                model.addRow(new Object[]{name,cabtype,rating});
            }
//            Thread.sleep(2000);
//            System.out.println("Flag is going to be set zero now");
//            Statement stmt2 = conn.createStatement();
//                stmt2.executeUpdate("update drivers set flag=0 where name = \""+name+"\" ;");
           
        }
        catch(Exception e){
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIST OF AVAILABLE DRIVERS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 620, 110));

        jTable1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Cab Type", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 171, 580, 110));

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jButton1.setText("BOOK RIDE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 320, 80));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardik\\Desktop\\mast.JPG")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user = Login_Page.getuser();
        String userid = Map_Source.getUserId();
        String dest = Map_Source.getDest();
        float distance = Map_Source.getDist();
        double fare = distance*10;
        long time = (long)distance*10000;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardik?useSSL=false","root","Rssb18@babaji");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from login where username = \""+user+"\";");
            rs.next();
            int wallet = rs.getInt("wallet");
//            if(wallet<fare)
//            {
//                JOptionPane.showMessageDialog(this,"You have Insufficient Balance in your VOILA Wallet!\nPlease Add Money");
//                new Add_Money().setVisible(true);
//            }
//            else
//            {
                wallet-=fare;
//                System.out.println(user);
                Statement stmt1 = conn.createStatement();
                stmt1.executeUpdate("update login set wallet = \""+wallet+"\" where username = \""+user+"\";");
                 JOptionPane.showMessageDialog(this,"Amount "+fare+" has been deducted from your VOILA wallet.");
//            }
        }
        catch(Exception e)
        {
           System.out.println("vvv  "+e);
        }
        dispose();
        new Trip().setVisible(true);
       
        
         try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardik?useSSL=false","root","Rssb18@babaji");
                    Statement stmt2 = conn.createStatement();
                    System.out.println(userid);
                 stmt2.executeUpdate("update drivers set flag = 0 where userid = \""+userid+"\";");
                 JOptionPane.showMessageDialog(this,"Ride has started!\nEnjoy....");
                  Thread.sleep(44000);
                  Statement stmt3 = conn.createStatement();
                 stmt3.executeUpdate("update drivers set flag = 1,loc = \""+dest+"\" where userid = \""+userid+"\";");
                }catch(Exception e)
                {
                    System.out.println(e);
                }
                JOptionPane.showMessageDialog(null,"Ride has Ended");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Available_Drivers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Available_Drivers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Available_Drivers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Available_Drivers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Available_Drivers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
