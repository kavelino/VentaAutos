/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import static Entidades.Oferta.LOfertas;
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
    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
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
                        Double.parseDouble(rs.getString("precio")), rs.getString("imagen"));
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
    
    public static void GuardarDatos(){
        ResultSet rs = null;                       
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = Conexion.Conexion.conectar();
            st= con.prepareStatement("delete * from autos");
            st.executeUpdate();
            System.out.println("Eliminando datos pasados");
            for (int i = 0; i < LAutos.size(); i++) {
                st = con.prepareStatement("INSERT INTO autos(idautos,placa,marca,modelo,tipoMotor,ano,tipo,recorrido,color,tipoCombustible,vidrio,transmision,precio,imagen) VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                st.setString(1, LAutos.get(i).getPlaca());
                    st.setString(2, LAutos.get(i).getMarca());
                    st.setString(3, LAutos.get(i).getModelo());
                    st.setString(4, String.valueOf(LAutos.get(i).getTipoMotor()));
                    st.setString(5, String.valueOf(LAutos.get(i).getAnio()));
                    st.setString(6,LAutos.get(i).getTipo());
                    st.setString(7, String.valueOf(LAutos.get(i).getRecorrido()));
                    st.setString(8, LAutos.get(i).getColor());
                    st.setString(9, LAutos.get(i).getTipoCombustible());
                    st.setString(10, LAutos.get(i).getVidrios());
                    st.setString(11, LAutos.get(i).getTransmision());
                    st.setString(12, String.valueOf(LAutos.get(i).getPrecio()));
                    st.setString(13, LAutos.get(i).getImagen());
                st.executeUpdate();
                System.out.println("oferta para el auto "+LOfertas.get(i).getPlaca()+". Ingresada con éxito" );
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

    public Auto(String placa, String marca, String modelo, double tipoMotor, int anio, String tipo, int recorrido, String color, String tipoCombustible, String vidrios, String transmision, Double precio, String imagen) {
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
        this.imagen = imagen;
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
