
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hardik
 */
public class First_Allot extends javax.swing.JFrame {

    /**
     * Creates new form First_Allot
     */
    public First_Allot() {
        initComponents();
        String source = Map_Source.getUserId();
        String user = Login_Page.getuser();
        String dest = Map_Source.getDest();
        long distance = (long)Map_Source.getDist();
        long time = (distance)*2000;
        double fare = distance*10;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardik?useSSL=false","root","Rssb18@babaji");
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet rs1 = stmt2.executeQuery("select * from login where username = \""+user+"\";");
            rs1.next();
            int wallet = rs1.getInt("wallet");
          /*  if(wallet<fare)
            {
                JOptionPane.showMessageDialog(this,"You have Insufficient Balance in your VOILA Wallet!\nPlease Add Money");
                new Add_Money().setVisible(true);
            }*/
            //else
           // {
                wallet-=fare;
//                System.out.println(user);
                Statement stmt1 = conn.createStatement();
                stmt1.executeUpdate("update login set wallet = \""+wallet+"\" where username = \""+user+"\";");
                 JOptionPane.showMessageDialog(this,"Amount "+fare+" has been deducted from your VOILA wallet.");
           // }
            ResultSet rs = stmt.executeQuery("select * from drivers where userid = \""+source+"\" order by rating desc;");
            while(rs.next())
            {
                String userid = rs.getString("userid");
                String name1 = rs.getString("name");
                String cabtype1 = rs.getString("cabtype");
                float rating1 = rs.getFloat("rating");
                String contact1 = rs.getString("contact");
                String cabnum1 = rs.getString("cabnum");
//                Statement stmt2 = conn.createStatement();
//                stmt2.executeUpdate("update drivers set flag = 0 where userid = \""+userid+"\";");
                jTextField1.setText(name1);
                jTextField2.setText(contact1);
                jTextField3.setText(cabtype1);
                jTextField4.setText(rating1+"");
                jLabel1.setText(cabnum1);
                
                jTextArea1.setText("ESTIMATED RIDE IS: "+time/1000+" seconds\n");
                jTextArea1.append("APPROXIMATE FARE IS: Rs."+fare+"\n");
                jTextArea1.append("TOTAL DISTANCE TO BE COVERED IS: "+distance+"kms.");
//                try
//                {
//                  Thread.sleep(2000);
//                }catch(InterruptedException e)
//                {
//                    System.out.println(e);
//                }
//                 try
//                {
//                    int flag5 = rs.getInt("flag");
//                System.out.println(flag5+"gf");
//                  Thread.sleep(time);
//                  int flag6 = rs.getInt("flag");
//                System.out.println(flag6+"hyt");
//                Statement stmt4=conn.createStatement();
//                stmt4.executeUpdate("update drivers set flag=1, loc = \""+dest+"\" where name = \""+name1+"\";");
//                System.out.println(dest+" Reached");
//                }catch(Exception e)
//                {
//                    System.out.println(e);
//                }
//                Statement stmt3=conn.createStatement();
//                stmt3.executeUpdate("update drivers set flag=1 where name = \""+name1+"\";");
                break;
            }
//            try
//                {
//                  Thread.sleep(2000);
//                }catch(InterruptedException e)
//                {
//                    System.out.println(e);
//                }
//            Statement stmt3=conn.createStatement();
//                stmt3.executeUpdate("UPDATE DRIVERS SET FLAG=1 WHERE userid=\""+source+"\";");
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 270, 72));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 116, 29));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Contact Number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 116, 32));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Cab Type");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 116, 31));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Rating");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 65, 25));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 124, 29));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 124, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 124, 30));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 53, 25));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(134, 216, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 610, 150));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel6.setText("YOUR CAB HAS BEEN BOOKED!");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 11, 604, 72));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardik\\Desktop\\photu.JPG")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 170, 200));

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 50));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hardik\\Desktop\\mast2.JPG")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        new Review().setVisible(true);
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
            java.util.logging.Logger.getLogger(First_Allot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(First_Allot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(First_Allot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(First_Allot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new First_Allot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
