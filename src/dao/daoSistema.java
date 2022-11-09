package dao;

import conexion.Conexion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sistema;

public class daoSistema {

    Conexion cx = null;

    public daoSistema() {
        cx = new Conexion();
    }

    public boolean insertarSistema(Sistema user) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("INSERT INTO Sistema VALUES(null,?,?,?)");
            ps.setString(1, user.getUser());
            ps.setString(2, convertirSHA256(user.getPassword()));
            ps.setString(3, user.getNombre());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(daoSistema.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Sistema> fetchUsuarios() {
        ArrayList<Sistema> lista = new ArrayList<Sistema>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = cx.conectar().prepareStatement("SELECT * FROM Sistema");
            rs = ps.executeQuery();
            while (rs.next()) {
                Sistema u = new Sistema();
                u.setId(rs.getInt("id"));
                u.setUser(rs.getString("user"));
                u.setPassword(rs.getString("password"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public boolean eliminarSistema(int Id) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("DELETE FROM Sistema WHERE id=?");
            ps.setInt(1, Id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(daoSistema.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean editarUsuario(Sistema user) {
        PreparedStatement ps = null;
        try {
            ps = cx.conectar().prepareStatement("UPDATE Sistema SET user=?,password=?,nombre=? WHERE id=?");
            ps.setString(1, user.getUser());
            ps.setString(2, convertirSHA256(user.getPassword()));
            ps.setString(3, user.getNombre());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
		e.printStackTrace();
		return null;
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
	    
	return sb.toString();
}
    
}

