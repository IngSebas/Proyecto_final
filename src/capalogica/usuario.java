/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capalogica;

import capaconexion.conexionBaseDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SEBASTIAN
 */
public class usuario extends conexionBaseDD {
    
    public String nombreu;
    public String apellidou;
    public String edadu;
    public String documentou;
    public String celularu;
    public String claveu;
    public String usuariou;
    public String confirmacionu;

    public usuario() {
        this.nombreu = nombreu;
        this.apellidou = apellidou;
        this.edadu = edadu;
        this.documentou = documentou;
        this.celularu = celularu;
        this.usuariou = usuariou;
        this.confirmacionu = confirmacionu;
    }

    public String getnombreu() {
        return nombreu;
    }

    public void setnombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getapellidou() {
        return apellidou;
    }

    public void setapellidou(String apellidou) {
        this.apellidou = apellidou;
    }

    public String getedadu() {
        return edadu;
    }

    public void setedadu(String edadu) {
        this.edadu = edadu;
    }

    public String getdocumentou() {
        return documentou;
    }

    public void setdocumentou(String documentou) {
        this.documentou = documentou;
    }

    public String getcelularu() {
        return celularu;
    }

    public void setcelularu(String celularu) {
        this.celularu = celularu;
    }

    public String getclaveu() {
        return claveu;
    }

    public void setclaveu(String claveu) {
        this.claveu = claveu;
    }

    public String getusuariou() {
        return usuariou;
    }

    public void setusuariou(String usuariou) {
        this.usuariou = usuariou;
    }

    public String getconfirmacionu() {
        return confirmacionu;
    }

    public void setconfirmacionu(String confirmacionu) {
        this.confirmacionu = confirmacionu;
    }   
public usuario buscar(String nombreu) {
          PreparedStatement ps = null;
          ResultSet rs = null;
          usuario s = new usuario();
          Connection con = getConexion();
          String sql = "SELECT * FROM usuario WHERE nombreu=?";

    try {
        
           ps = con.prepareStatement(sql);
           ps.setString(1, nombreu);
           rs = ps.executeQuery();
       if(rs != null){
        
       if(rs.next()){
              
              s.setnombreu(rs.getString("nombreu"));
              s.setapellidou(rs.getString("apellidou"));
              s.setedadu(rs.getString("edadu"));
              s.setcelularu(rs.getString("celularu"));
              s.setclaveu(rs.getString("claveu"));
              s.setconfirmacionu(rs.getString("confirmacionu"));
              s.setusuariou(rs.getString("usuariou"));
              System.out.print ("El apellido consultado"+s.getapellidou());
              }
                  return s;
       }else{
           
               return null;
              }

               } catch (SQLException e) {
                    System.err.println("error al consultar"+e);
                          return null;
                    } finally {
    try {
              con.close();
                } catch (SQLException e) {
                     System.err.println(e);
           }
           
        }
    }     
 public boolean registrarusuario(){
       boolean resultado =false;
         PreparedStatement ps;
        try {
           Connection c = getConexion();
           ps = c.prepareStatement("INSERT INTO usuario  VALUES(?,?,?,?,?,?,?) ");
           ps.setString(1, this.getnombreu());
           ps.setString(2, this.getapellidou());
           ps.setString(3, this.getedadu());
           ps.setString(4, this.getcelularu());
           ps.setString(5, this.getusuariou());
           ps.setString(6, this.getclaveu());
           ps.setString(7, this.getconfirmacionu());
 
            if (ps.executeUpdate() > 0) {
                return  true;
            } else {
                return resultado=false;
            }
        } catch (Exception e) {
            System.out.print("Error en la insercion" + e);
            return resultado;
        }
         }
   public boolean modificar(String nombreu,String apellidou,String edadu,String celularu,String usuarioapp) {
        PreparedStatement ps = null;
          Connection con = getConexion();
 
  String sql = "UPDATE usuario SET nombreu='"+nombreu+"', apellidou='"+apellidou+"' ,edadu="+edadu+",celularu="+celularu+" WHERE usuariou='"+usuarioapp+"' ";
  try {
System.out.println("nombre "+nombreu+"el apellido "
                +apellidou+"edad "+edadu+"celular "+celularu);
         ps = con.prepareStatement(sql);

         ps.executeUpdate();
         return true;
       } catch (SQLException e) {
             System.err.println(e);
             return false;
} finally {
               try {
             con.close();
      } catch (SQLException e) {
      System.err.println(e);
       }
    }
 }

    public int Login (String usuariou, String claveu) {
            Integer resultado = 0;
        try {
              PreparedStatement ps = null;
              ResultSet rs = null;
              Connection con = getConexion();
              String sql = "SELECT *FROM usuario where usuariou='"+usuariou+"' and claveu ='"+claveu+"'";
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();

              if (rs.next()) {
                  JOptionPane.showMessageDialog(null, "Bienvenido");
                  resultado=1;
              }else{
                  JOptionPane.showMessageDialog(null, "error en los usuarios");
                  resultado=0;
              }
            }catch (SQLException e) {
                System.out.println(e.toString());
            }
                return resultado;
        } 

    }