/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.Oferta;
import Formularios.FrmVendedor;
import TDAs.SimpleLinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class Notificaciones extends Thread{
    TDAs.SimpleLinkedList<Oferta> listTemp = new SimpleLinkedList<>();
    int ultimoValor = Oferta.LOfertas.size();
    FrmVendedor frm= null;
     @Override
    public void run() {
        while(true){  
            synchronized(this){
            if (Oferta.LOfertas.size() != ultimoValor) {
                listTemp.removeLast();
                listTemp.addFirst(Oferta.LOfertas.getFirst());
                FrmVendedor.Notifiaciones(listTemp.getLast().toString());       
                                
                //listTemp.removeLast();          
                ///frm.Notifiaciones(listTemp.getLast().toString());
                ultimoValor = Oferta.LOfertas.size();
            }
            }
        }
    } 
    
    public void LoadFrm(FrmVendedor _form){
        frm = _form;
    }
    
}
