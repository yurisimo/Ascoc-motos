/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;

/**
 *
 * @author Yura
 */
public class Validacion {

    public boolean esNumero(String cadena){
        try {
            int v = Integer.parseInt(cadena);
                return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }
    
    
    
    
}
