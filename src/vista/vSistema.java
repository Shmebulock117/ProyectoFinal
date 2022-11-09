package vista;

import dao.daoSistema;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Sistema;

public class vSistema extends javax.swing.JFrame {

    daoSistema dao = new daoSistema();
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Sistema> lista = new ArrayList<Sistema>();
    int fila = -1;
     Sistema Sistema=new Sistema();

    public vSistema() {
        initComponents();
        this.setTitle("Sistema");
        this.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo.jpeg"));
        this.setIconImage(icono);
        this.setResizable(false);
        modelo.addColumn("ID");
        modelo.addColumn("USER");
        modelo.addColumn("PASSWORD");
        modelo.addColumn("NOMBRE");
        tblSistema.setModel(modelo);
        actualizarTabla();
    }

    public void limpiar() {
        TXTUser.setText("");
        txtPassword.setText("");
        txtNombre.setText("");
    }

    public void actualizarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        lista = dao.fetchUsuarios();
        for (Sistema u : lista) {
            Object o[] = new Object[4];
            o[0] = u.getId();
            o[1] = u.getUser();
            o[2] = u.getPassword();
            o[3] = u.getNombre();
            modelo.addRow(o);
        }
        tblSistema.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXTUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSistema = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD SISTEMA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("1");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 20, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("USUARIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        TXTUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTUserActionPerformed(evt);
            }
        });
        getContentPane().add(TXTUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("PASSWORD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("NOMBRE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, 30));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnEditar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        btnBorrar.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        tblSistema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSistemaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSistema);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 600, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            if (TXTUser.getText().equals("") || txtPassword.getText().equals("") || txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "CAMPOS VACIOS");
                return;
            }
            Sistema.setUser(TXTUser.getText());
            Sistema.setPassword(txtPassword.getText());
            Sistema.setNombre(txtNombre.getText());
            if (dao.editarUsuario(Sistema)) {
                actualizarTabla();
                limpiar();
                JOptionPane.showMessageDialog(null, "SE ACTUALIZO CORRECTAMENTE!!");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       try {
           Sistema user=new Sistema();
           user.setUser(TXTUser.getText());
           user.setPassword(txtPassword.getText());
           user.setNombre(txtNombre.getText());
           if(dao.insertarSistema(user)) {
               actualizarTabla();
               limpiar();
               JOptionPane.showMessageDialog(null, "SE AGREGO CORRECTAMENTE!!");
           }else {
               JOptionPane.showMessageDialog(null, "error");
           }
       }catch(Exception ex) {
           JOptionPane.showMessageDialog(null, "error");
       }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSistemaMouseClicked
    fila=tblSistema.getSelectedRow();
        Sistema=lista.get(fila);
        lblID.setText(""+Sistema.getId());
        TXTUser.setText(Sistema.getUser());
        txtPassword.setText(Sistema.getPassword());
        txtNombre.setText(Sistema.getNombre());
    }//GEN-LAST:event_tblSistemaMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    try {
        int opcion=JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este usuario?");
        if(opcion==0) { 
           if(dao.eliminarSistema(lista.get(fila).getId())) {
               actualizarTabla();
               JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE!!");
           }else {
               JOptionPane.showMessageDialog(null, "error");
           }
        }
       }catch(Exception ex) {
           JOptionPane.showMessageDialog(null, "error");
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TXTUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTUserActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
    limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(vSistema.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vSistema.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vSistema.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vSistema.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vSistema().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXTUser;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblID;
    private javax.swing.JTable tblSistema;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
