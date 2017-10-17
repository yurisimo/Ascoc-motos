/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;

import java.util.ArrayList;

/**
 *
 * @author Yura
 */
public class Cesion {
    
    private int idMoto;
    private int idMiembroActual;
    private int idMiembroAntiguo;
    private static int NUM_CES = 0;
    
    public Cesion(int id1, int id2, int id3){
        idMoto = id1;
        idMiembroActual = id2;
        idMiembroAntiguo = id3;
        NUM_CES++;
    }
    
    public String getInfo(ArrayList<Moto> m, ArrayList<Cliente> cl){
        String nombreM = "", nomMiActual="", nomMiAntig="", resultado = "";
        
        for(int i=0; i< m.size(); i++){
            if(m.get(i).getID_MOTO() == idMoto){
                nombreM = m.get(i).getNombre();
                for(int j = 0; j < cl.size(); j++){
                    if(cl.get(j).getID() == idMiembroActual)
                        nomMiActual = cl.get(j).getNombre();
                    
                    if(cl.get(j).getID() == idMiembroAntiguo) 
                        nomMiAntig = cl.get(j).getNombre();
                }
            }
        }//for primero
        
        resultado = String.format("%03d", idMoto)+" "+nombreM +" en el garaje de "
                + nomMiActual + ", cedido por "+nomMiAntig+"\n";
        return resultado;
    }
    
}
