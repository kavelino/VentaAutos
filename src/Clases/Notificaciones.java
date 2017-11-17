/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.Oferta;
import TDAs.DoubleLinkedList;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class Notificaciones extends Thread{
    DoubleLinkedList<Oferta> listTemp = Oferta.LOfertas;
     @Override
    public void run() {
        while(true){            
            if (Oferta.LOfertas.size() > listTemp.size()) {
                
            }
            
        }
    }
    
}
