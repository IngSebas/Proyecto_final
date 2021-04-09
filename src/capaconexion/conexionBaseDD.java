/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaconexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SEBASTIAN
 */
public class conexionBaseDD {


    private final String base = "proyectofinal3";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConexion() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error en la conexion 1 "+e);      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionBaseDD.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "error en la conexion 2 "+ex);
        }
        return con;
        }
    }

