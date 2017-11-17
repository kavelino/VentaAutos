/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Formularios.FrmVendedor;
import TDAs.SimpleLinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class Oferta {
    String placa;
    String correo;
    Double precioOfertado;
    
    public static TDAs.SimpleLinkedList<Oferta> LOfertas ;
    
    public static void Llenalista(){
        ResultSet rs = null;                       
        PreparedStatement st = null;
        Connection con = null;
        
        LOfertas = new SimpleLinkedList<>();
        
        try {
            con = Conexion.Conexion.conectar();
            st = con.prepareStatement("SELECT * FROM ofertas");
            rs = st.executeQuery();             
            while (rs.next()) {
                Oferta o= new Oferta(rs.getString("placa"), rs.getString("correo"), Double.parseDouble(rs.getString("precio")));                
                Oferta.LOfertas.addFirst(o);                
            }            
        }catch (Exception ex) {
            Logger.getLogger(FrmVendedor.class.getName()).log(Level.SEVERE, null, ex);
            /*JOptionPane.showMessageDialog(this,
                    "Ocurrió un error al intentar consultar información en la base de datos. "+ ex,
                    "Vendedor",
                    JOptionPane.ERROR_MESSAGE);*/
        }finally{
            if ( con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmVendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st!=null) {
                try{
                    st.close();
                }catch (SQLException ex) {
                   Logger.getLogger(FrmVendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs!= null) {
                try{
                    rs.close();
                }catch (SQLException ex) {
                    Logger.getLogger(FrmVendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Oferta(String placa, String correo, Double precioOfertado) {
        this.placa = placa;
        this.correo = correo;
        this.precioOfertado = precioOfertado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getPrecioOfertado() {
        return precioOfertado;
    }

    public void setPrecioOfertado(Double precioOfertado) {
        this.precioOfertado = precioOfertado;
    }
    
    
}
