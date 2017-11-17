/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Entidades.Auto;
import Entidades.Oferta;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class FrmVehiculo extends javax.swing.JFrame {

    private boolean isVendedor; //para saber que funcion es la que debe usar
    private File file; //ruta de imagen 
    
    /**
     * Creates new form FrmVehiculo
     * @param _nuevo = saber si el auto es nuevo o solo estoy usando para revision
     */
    public FrmVehiculo(boolean _nuevo, boolean _vendedor) {
        initComponents();
        
        if (_nuevo) {
            btnAnterior.setVisible(false);
            btnSiguiente.setVisible(false);
            lblOferta.setVisible(false);
            btnOferta.setVisible(false);
            btnLoQuiero.setVisible(false);
            lblNuevasOfertas.setVisible(false);
            lstListaOfertas.setVisible(false);
        }else{
            btnIngresar.setVisible(false);
            btnCancelar.setVisible(false);
            Auto.LlenarLista();
            Oferta.Llenalista();
            isVendedor = _vendedor;
            if (_vendedor) {
                btnLoQuiero.setVisible(false);
                Siguiente();                
            }else{
                lblNuevasOfertas.setVisible(false);
                lstListaOfertas.setVisible(false);
                lblOferta.setVisible(false);
                btnOferta.setVisible(false);
                Siguiente_Compra();
            }
        }
    }
    
    int indexOferta = -1; //por la primera iteracion que apunta a siguiente
    
    //cuando el formulario esta en modo vendedor
    private void Siguiente(){
        //actualizo las tablas
        Oferta.Llenalista();
        Auto.LlenarLista();
        indexOferta++;
        if (indexOferta >= Oferta.LOfertas.size()) {
            indexOferta=0;
        }
        //lstListaOfertas.ad
        if (Oferta.LOfertas.size() > 0) {
            for (int i = 0; i < Auto.LAutos.size(); i++) {
                if (Auto.LAutos.get(i).getPlaca().equalsIgnoreCase(Oferta.LOfertas.get(indexOferta).getPlaca())) { //si ls placas coinciden en ambas tablas
                    LlenarCampos(Auto.LAutos.get(i));
                }
            }
            lblOferta.setText(String.valueOf(Oferta.LOfertas.get(indexOferta).getPrecioOfertado()));
        }
    }
    
    //cuando el formulario esta en modo vendedor
    private void Anterior(){
        Oferta.Llenalista();
        Auto.LlenarLista();
        indexOferta--;
        if (indexOferta < 0) {
            indexOferta = Oferta.LOfertas.size()-1;
        }
        if (Auto.LAutos.size() > 0) {
            for (int i = 0; i < Auto.LAutos.size(); i++) {
                Oferta o = Oferta.LOfertas.get(indexOferta);
                if (Auto.LAutos.get(i).getPlaca().equalsIgnoreCase(o.getPlaca())) { //si ls placas coinciden en ambas tablas
                    LlenarCampos(Auto.LAutos.get(i));
                }
            }
            lblOferta.setText(String.valueOf(Oferta.LOfertas.get(indexOferta).getPrecioOfertado()));
        }        
    }
    
    private void LlenarCampos(Auto _auto){
        try { //por el acceso a la base de datos
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (_auto != null) {
            txtPlaca.setText(_auto.getPlaca());
            txtMarca.setText(_auto.getMarca());
            txtModelo.setText(_auto.getModelo());
            txtTipoMotor.setText(String.valueOf(_auto.getTipoMotor()));        
            txtAnio.setText(String.valueOf(_auto.getAnio()));
            txtTipoVehiculo.setText(_auto.getTipo());
            txtRecorrido.setText(String.valueOf(_auto.getRecorrido()));
            txtColor.setText(_auto.getColor());
            txtTipoCombustible.setText(_auto.getTipoCombustible());
            txtVidrio.setText(_auto.getVidrios());
            txtTransmision.setText(_auto.getTransmision());
            txtPrecio.setText(String.valueOf(_auto.getPrecio()));
            if (!_auto.getImagen().isEmpty()) {
                BufferedImage img = null;
            try 
            {
                img = ImageIO.read(new File("./src/imagenes/"+_auto.getImagen()));                
                lblImagen.setIcon(new ImageIcon(img));                
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
            }
            
            return;
        }     
        limpiarCajas();
    }
    
    private void limpiarCajas(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtTipoMotor.setText("");        
        txtAnio.setText("");
        txtTipoVehiculo.setText("");
        txtRecorrido.setText("");
        txtColor.setText("");
        txtTipoCombustible.setText("");
        txtVidrio.setText("");
        txtTransmision.setText("");
        txtPrecio.setText(""); 
        lblOferta.setText("");
        lblImagen.setIcon(null);
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
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTipoMotor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipoVehiculo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRecorrido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTipoCombustible = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtVidrio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTransmision = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblOferta = new javax.swing.JLabel();
        btnOferta = new javax.swing.JButton();
        btnLoQuiero = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListaOfertas = new javax.swing.JList<>();
        lblNuevasOfertas = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Placa");

        txtPlaca.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel2.setText("Marca");

        txtMarca.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel3.setText("Modelo");

        txtModelo.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel4.setText("Tipo de Motor");

        txtTipoMotor.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel5.setText("Año");

        txtAnio.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel6.setText("Tipo de Vehiculo");

        txtTipoVehiculo.setMinimumSize(new java.awt.Dimension(6, 30));
        txtTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoVehiculoActionPerformed(evt);
            }
        });

        jLabel7.setText("Recorrido");

        txtRecorrido.setMinimumSize(new java.awt.Dimension(6, 30));
        txtRecorrido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecorridoActionPerformed(evt);
            }
        });

        jLabel8.setText("Color ");

        txtColor.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel9.setText("Tipo de Combustible");

        txtTipoCombustible.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel10.setText("Vidrio");

        txtVidrio.setMinimumSize(new java.awt.Dimension(6, 30));

        jLabel11.setText("Transmision");

        txtTransmision.setMinimumSize(new java.awt.Dimension(6, 30));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        txtPrecio.setMinimumSize(new java.awt.Dimension(6, 30));
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel12.setText("Precio");

        jLabel13.setText("Imagen");

        lblOferta.setText("jLabel14");

        btnOferta.setText("Aceptar Oferta");
        btnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertaActionPerformed(evt);
            }
        });

        btnLoQuiero.setText("Lo Quiero");
        btnLoQuiero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoQuieroActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstListaOfertas);

        lblNuevasOfertas.setText("Nuevas Ofertas");

        lblImagen.setText("Imagen");

        btnCargarFoto.setText("Cargar");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVidrio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnLoQuiero)
                            .addComponent(btnOferta)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblOferta)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSiguiente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCargarFoto, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNuevasOfertas)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtTipoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnterior))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(txtRecorrido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiguiente))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel9)
                            .addComponent(txtTipoCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOferta))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOferta)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel10)
                                    .addComponent(txtVidrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTransmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel12)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLoQuiero)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCargarFoto)
                                .addContainerGap(21, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnIngresar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblNuevasOfertas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoVehiculoActionPerformed

    private void txtRecorridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecorridoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecorridoActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if (ValidarNumero(txtAnio.getText(), false)&& 
                ValidarNumero(txtRecorrido.getText(), false) &&
                ValidarNumero(txtTipoMotor.getText(), true) &&
                ValidarNumero(txtPrecio.getText(), true)) { //se validan que el usuario ingrese solo numeros, por un ingreso que este mal no se procede a la operacion

            //se crea una entidad tipo auto
            Auto v = new Auto(txtPlaca.getText(),txtMarca.getText(),txtModelo.getText(),
                    Double.parseDouble(txtTipoMotor.getText()), Integer.parseInt(txtAnio.getText()),
                    txtTipoVehiculo.getText(), Integer.parseInt(txtRecorrido.getText()), txtColor.getText(), 
                    txtTipoCombustible.getText(), txtVidrio.getText(), txtTransmision.getText(), 
                    Double.parseDouble(txtPrecio.getText()),file.getName());
            
            //verifico que no haya ya un vehiculo con la misma placa en el sistema
            for (int i = 0; i < Auto.LAutos.size(); i++) {
                if (Auto.LAutos.get(i).getPlaca().equalsIgnoreCase(v.getPlaca())) {
                    Auto.LAutos.set(i, v);
                    System.out.println("Actualización de Vehiculo exitosa");
                    return; //finalizo en caso de que se haya hecho una actualizacion
                }
            }

            Auto.LAutos.addFirst(v);
            System.out.println("Ingreso de Vehiculo exitoso");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (isVendedor) {
            Siguiente();
        }else{
            Siguiente_Compra();
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (isVendedor) {
            Anterior();
        }else{
            Anterior_Compra();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertaActionPerformed
        String plc = Oferta.LOfertas.get(indexOferta).getPlaca();
        for (int i = 0; i < Entidades.Auto.LAutos.size(); i++) {
            if (Entidades.Auto.LAutos.get(i).getPlaca().equalsIgnoreCase(plc)) {
                JOptionPane.showMessageDialog(this,
                "Se se esta procediendo a concretar la compra",
                "Ver Oferta",
                JOptionPane.INFORMATION_MESSAGE);
                
                Entidades.Auto.LAutos.remove(i);
                System.out.println("Auto Vendido con éxito");
            }
        }
        for (int j = 0; j < Oferta.LOfertas.size(); j++) {
            if (Oferta.LOfertas.get(j).getPlaca().equalsIgnoreCase(plc)) {
                Oferta.LOfertas.remove(j);
                System.out.println("Auto Eliminado de las ofertas con éxito");
            }
        }
    }//GEN-LAST:event_btnOfertaActionPerformed

    private void btnLoQuieroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoQuieroActionPerformed
        FrmLoQuiero frm = new FrmLoQuiero(txtPlaca.getText());
        frm.setVisible(true);
    }//GEN-LAST:event_btnLoQuieroActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de Archivos de Imagenes(*.JPG;*.JPEG;*.PNG)", "jpg","png","jpeg");
        JFileChooser archivo = new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir Imagen de Auto");
        File ruta = new File("./src/imagenes");
        try {
            archivo.setCurrentDirectory(ruta.getCanonicalFile());
        } catch (IOException ex) {
            Logger.getLogger(FrmVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            file = archivo.getSelectedFile();
            Image foto = getToolkit().getImage(String.valueOf(file));
            foto = foto.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            lblImagen.setIcon(new ImageIcon(foto));            
        }       
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    //permite saber si los valores son los apropiados para los no String
    private boolean ValidarNumero(String _numero, boolean _esDouble){
        if (_esDouble) {
            try {
                Double.parseDouble(_numero);   
                return true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                    "Existen datos que no son Double",
                    "Ingresar",
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        try {
            Integer.parseInt(_numero);  
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Existen valores que no son Enteros",
                "Ingresar",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }        
    }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLoQuiero;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNuevasOfertas;
    private javax.swing.JLabel lblOferta;
    private javax.swing.JList<String> lstListaOfertas;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRecorrido;
    private javax.swing.JTextField txtTipoCombustible;
    private javax.swing.JTextField txtTipoMotor;
    private javax.swing.JTextField txtTipoVehiculo;
    private javax.swing.JTextField txtTransmision;
    private javax.swing.JTextField txtVidrio;
    // End of variables declaration//GEN-END:variables

    //cuando el formulario esta en modo comprador
    private void Siguiente_Compra() {        
        Auto.LlenarLista();
        indexOferta++;
        if (indexOferta > Auto.LAutos.size()) {
            indexOferta=0;
        }
        LlenarCampos(Auto.LAutos.get(indexOferta));
    }
    
    //cuando el formulario esta en modo comprador
    private void Anterior_Compra(){        
        Auto.LlenarLista();
        indexOferta--;
        if (indexOferta < 0) {
            indexOferta = Auto.LAutos.size()-1;
        }
        LlenarCampos(Auto.LAutos.get(indexOferta));       
    }
}
