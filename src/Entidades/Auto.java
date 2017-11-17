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
public class Auto {
    private String placa;
    private String marca;
    private String modelo;
    private double tipoMotor;
    private int anio;
    private String tipo;
    private int recorrido;
    private String color;
    private String tipoCombustible;
    private String vidrios;
    private String transmision;
    private Double precio;
    
    public static TDAs.SimpleLinkedList<Auto> LAutos; //lista de autos que se encuentran en la base de datos
    
    public static void LlenarLista(){
        LAutos = new SimpleLinkedList<>();
        
        ResultSet rs = null;                       
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = Conexion.Conexion.conectar();            
            st = con.prepareStatement("SELECT * FROM autos");
            rs = st.executeQuery(); 
            while(rs.next()){
                Auto v = new Auto(rs.getString("placa"), rs.getString("marca"),rs.getString("modelo") , 
                        Double.parseDouble(rs.getString("tipoMotor")), Integer.parseInt(rs.getString("ano")), 
                        rs.getString("tipo"), Integer.parseInt(rs.getString("recorrido")), rs.getString("color"), 
                        rs.getString("tipoCombustible"), rs.getString("vidrio"), rs.getString("transmision"), 
                        Double.parseDouble(rs.getString("precio")));
                LAutos.addFirst(v);
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

    public Auto(String placa, String marca, String modelo, double tipoMotor, int anio, String tipo, int recorrido, String color, String tipoCombustible, String vidrios, String transmision, Double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.anio = anio;
        this.tipo = tipo;
        this.recorrido = recorrido;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(double tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
