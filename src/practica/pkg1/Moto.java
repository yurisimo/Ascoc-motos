/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Moto {
    //Declaracion de variables
    private String matricula, nombre, motor;
    private int ID_MOTO;
    private int precio;
    private int ID_SOCIO;
    private static int PROX_ID = 1;
    private static int N_MOTOS = 0;
    
    //Constructor de la clase
    public Moto(String matricula, String nombre, String motor, int precio, int id_socio){
        this.matricula = matricula;
        this.nombre = nombre;
        this.motor = motor;
        this.precio = precio;
        this.ID_MOTO = PROX_ID;
        this.ID_SOCIO = id_socio;
        
        N_MOTOS++;
        PROX_ID++;
    }
    
    public String getMatricula(){
       return matricula; 
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @return the ID_MOTO
     */
    public int getID_MOTO() {
        return ID_MOTO;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @return the PROX_ID
     */
    public static int getPROX_ID() {
        return PROX_ID;
    }

    /**
     * @return the N_MOTOS
     */
    public static int getN_MOTOS() {
        return N_MOTOS;
    }
    
    public void setID_SOCIO(int idSoc){
        ID_SOCIO = idSoc;
    }
    
    public int getID_SOCIO(){
        return ID_SOCIO;
    }
    
    public String getInfo(ArrayList<Cliente> cl){
        
        String moto="", resultado="";
        
        for(int i = 0; i < cl.size(); i++)
            if(cl.get(i).getID() == ID_SOCIO){
                moto = cl.get(i).getNombre();
        resultado = "ID_MOTO: " + 
                            String.format("%03d", ID_MOTO)+ " " 
                                +nombre +", de "
                                +motor+ ",con matricula "
                                +matricula + " y precio "
                                +precio +"€ " +"(" +moto+ ")" + "\n";
            }
        return resultado;
        }
    
}
