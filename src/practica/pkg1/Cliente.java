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
public class Cliente {
    
    private String nombre;
    private int ID_SOCIO;
    private static int PROX_ID = 1;
    private int num_cesiones=0;
    private ArrayList<Integer> motos_dis = new ArrayList<Integer>();
    
    
    public Cliente(String nombre){
        this.nombre = nombre;
        this.ID_SOCIO = PROX_ID;
        num_cesiones = 0;
        
        PROX_ID++;
    }

    public int getPrecio(ArrayList<Moto> moto){
        int precio = 0;
        if(moto.isEmpty()){
            precio = 0;
        }
        else{
            for(int i = 0; i < moto.size(); i++){
                if(moto.get(i).getID_SOCIO() == getID()){
                    precio += moto.get(i).getPrecio();
                }     
            }   
        }
        
        return precio;
    }
    
    public String getInfo(ArrayList<Moto> moto){
        String resultado="";
        
        resultado = resultado + String.format("%03d", this.getID()) + "   " +nombre;
        
        if(!moto.isEmpty()){
            for(int i = 0; i < moto.size(); i++){
                if(moto.get(i).getID_SOCIO() == getID()){
                    resultado= resultado + String.format("   " +"%03d",moto.get(i).getID_MOTO())+ " "
                            +moto.get(i).getNombre() +", " +moto.get(i).getPrecio()
                            + " €"+". Otros gastos de la moto: "+moto.get(i).getOtros_gastos() +"€.";
                }
            }
            
        }
        else{
            resultado = "No hay ni miembros ni motos.\n";
        }
        return resultado;
    }
    
    public int getID(){
        return ID_SOCIO;
    }
    
    public void setMotDis(int x){
        motos_dis.add(x);
    }
    public String getNombre(){
        return nombre;
    }

    /**
     * @return the num_cesiones
     */
    public int getNum_cesiones() {
        return num_cesiones;
    }

    /**
     * @param num_cesiones the num_cesiones to set
     */
    public void setNum_cesiones(int num_cesiones) {
        this.num_cesiones = num_cesiones + 1;
    }
}