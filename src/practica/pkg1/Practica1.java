/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean salir = false;
        boolean ok = false;
        int idCliente=0, precio=0, pre =0,cont=0;
        int menu=0,idMoto=0,usuarioAntiguo=0;
        String opcion = "",nombre = "", marca, matricula, motor;
        Cliente cliente;
        ArrayList<Cliente> cli= new ArrayList<Cliente>();
        Moto moto;
        ArrayList<Moto> mot= new ArrayList<Moto>();
        Cesion cesion;
        ArrayList<Cesion> ces= new ArrayList<Cesion>();
        Scanner capt = new Scanner(System.in);
        Validacion val = new Validacion();
        int PR = 6000;

        /*Pedir precio por pantalla*/
        System.out.println("Introduzca el precio total de las motos"
                +" que puede tener un mismo miembro");
        do{
            opcion = capt.nextLine();
            if(val.esNumero(opcion)){
                menu = Integer.parseInt(opcion);
                PR = menu;
                ok=false;
            }  
            else{
                System.out.println("\033[31mNo es un numero, vuelve a intentarlo.\033[30m");
                ok = true;
            } 
        }
        while(ok == true);
        
        //Acuerdate de instanciar las clases
        
        System.out.println("\033[34m ### - Asociación Cultural de Amigos de las Motos Antiguas - ###\033[30m\n");
        
        System.out.println("Para seleccionar una opcion, "
                + "inserte un numero y pulse \"Enter\" \n");
        // Menu
        Menu();
        
        while(salir == false){

            // Comprobacion de los numeros
            do{
                opcion = capt.nextLine();
                if(val.esNumero(opcion)){
                    menu = Integer.parseInt(opcion);
                    System.out.println("Has seleccionado la opcion " +menu+"\n");
                }  
                else{
                    menu = 10;
                    System.out.println("\033[31mNo es un numero, vuelve a intentarlo.\033[30m");
                } 
            }
            while(menu >7 || menu <= 0);
            
            switch(menu){
                case 1:
                    System.out.println(">> Registrar un nuevo miembro\n");
                    System.out.println("Introduzca nombre: ");
                    nombre = capt.nextLine();
                    cliente = new Cliente(nombre);
                    System.out.println("\033[32mSe ha creado un nuevo cliente" 
                            +" con numero ID_CLIENTE: " + 
                            String.format("%03d", cliente.getID())+"\033[30m\n");
                    cli.add(cliente);
                    menu = 0;
                    Menu();
                    break;
                case 2:
                    System.out.println(">> Registrar una nueva motocicleta\n");
                    
                    //EL PRECIO TIENE QUE SER UN ENTERO Y SER MENOS DE 6000euros
                    do{
                        System.out.println("Introduzca Precio de la Motocicleta: ");
                        opcion = capt.nextLine();
                        if(val.esNumero(opcion) !=false){
                                precio = Integer.parseInt(opcion);
                        }
                    }
                    while(precio >= PR);
                    
                    // COMPROBACION DEL CLIENTE
                    do{
                        System.out.println("Introduzca ID_CLIENTE: ");
                        opcion = capt.nextLine();
                        // SI id cliente es numerico
                        if(val.esNumero(opcion) !=false){
                            idCliente = Integer.parseInt(opcion);                            
                            for(int i = 0; i < cli.size(); i++){
                                if(cli.get(i).getID() == idCliente){
                                    //precio de las motos
                                    pre = cli.get(i).getPrecio(mot);
                                    ok = false;
                                }   
                            }
                            
                            if((precio+pre) > PR){
                                System.out.println("El precio total de las motos"
                                        + " no puede superar los 6000 euros."
                                +" O el ID_CLIENTE NO EXISTE.");
                                ok = true;
                            }else{
                                ok = false;
                            }    
                                
                        }else{
                            System.out.println("\033[31mNo es un numero, vuelve a intentarlo.\033[30m");
                            ok = true;
                        }
                    }
                    while(ok == true);
                    
                    System.out.println("Introduzca el Modelo: ");
                    marca = capt.nextLine();
                    
                    System.out.println("Introduzca la Matricula: ");
                    matricula = capt.nextLine();
                    
                    System.out.println("Introduzca Motor: ");
                    motor = capt.nextLine();
                    
                    moto = new Moto(matricula, marca, motor, precio, idCliente);
                    idMoto = moto.getID_MOTO();
                    System.out.println("\033[32mSe ha creado una nueva moto" 
                            +" con numero ID_MOTO: " + 
                            String.format("%03d", moto.getID_MOTO())+"\033[30m\n");
                   
                    mot.add(moto);
                    moto.setID_SOCIO(idCliente);
                    
                    menu = 0;
                    Menu();
                    
                    break;
                case 3:    
                    System.out.println(">> Registrar una cesión\n");
                    ok = true;
                do{
                    System.out.println("Introduzca ID_MOTO: ");
                    opcion = capt.nextLine();
                    if(val.esNumero(opcion)){
                        idMoto = Integer.parseInt(opcion);
                        System.out.println("Has seleccionado ID_MOTO: " +idMoto+"\n");
                        //1ºcomprobar si existe la moto
                        for(int i = 0; i < mot.size(); i++){
                            if(mot.get(i).getID_MOTO() == idMoto){
                                ok = false;
                                precio = mot.get(i).getPrecio();
                                usuarioAntiguo = mot.get(i).getID_SOCIO();  
                                cont++;
                            }  
                        }// for 
                        
                        if(cont ==0){
                            System.out.println("No existe ninguna moto con esa ID.");
                            ok = true;
                        } 
                    }  
                    else{
                        menu = 10;
                        System.out.println("\033[31mNo es un numero, vuelve a intentarlo.\033[30m");
                    } 
                }
                while(ok);
                
                // INSERCION Y COMPROBACION DEL NUEVO USUARIO
                ok=true;
                do{
                    System.out.println("ID_CLIENTE del nuevo miembro: ");
                    opcion = capt.nextLine();
                    if(val.esNumero(opcion)){
                        idCliente = Integer.parseInt(opcion);
                        System.out.println("Has seleccionado ID_CLIENTE: " +idCliente+"\n\n");
                        for(int i = 0; i < cli.size(); i++){
                            if(cli.get(i).getID() == idCliente)
                                pre = cli.get(i).getPrecio(mot);
                            cont++;
                        }// for     
                        if(cont != 0){

                            if((precio + pre) > PR){
                                System.out.println("El precio total de las motos"
                                            + " no puede superar los 6000 euros.");
                                ok = true;
                            }else{
                                        //Si todo ha ido bien hacemos las cesiones
                                cesion = new Cesion(idMoto, idCliente, usuarioAntiguo);
                                ces.add(cesion);
                                
                                for(int j=0; j < mot.size(); j++){
                                    if(mot.get(j).getID_MOTO() == idMoto){
                                        //Asignamos nueva moto
                                        mot.get(j).setID_SOCIO(idCliente);
                                        System.out.println("\033[32mSe ha creado una nueva cesion entre miembro.\033[30m\n");
                                    }
                                }
                                ok = false;
                            }
                        }//if contador
                        else{
                            System.out.println("No hay ningun ID CLIENTE.");
                            ok = true;
                        }
                    }else{
                        System.out.println("\033[31mNo es un numero, vuelve a intentarlo.\033[30m");
                    }
                }
                while(ok);
                    menu = 0;
                    Menu();
                    break;
                case 4:
                    System.out.println(">> Listado de miembros con motos en posesión\n");
                    if(cli.isEmpty()){
                        System.out.println("\033[31mAun no hay ningun miembro dado de alta.\033[30m\n");
                    }
                    else{    
                        for(int i = 0; i < cli.size(); i++){
                            System.out.println(cli.get(i).getInfo(mot));
                        }
                        System.out.println("\n");
                    }
                    menu = 0;
                    Menu();
                    break;
                    
                case 5:
                    System.out.println(">> Listado de motos\n");
                    for(int i = 0; i < mot.size(); i++){
                        System.out.println(mot.get(i).getInfo(cli));
                    }
                    System.out.println("\n");
                    menu = 0;
                    Menu();
                    break;
                case 6:
                    System.out.println(">> Listado de cesiones\n");
                    for(int i = 0; i < ces.size(); i++){
                        System.out.println(ces.get(i).getInfo(mot, cli));
                    }
                    System.out.println("\n");
                    menu = 0;
                    Menu();
                    break;
                case 7:
                    System.out.println(">> Finalizar programa\n");
                    
                    System.out.println("Introduzca nombre del archivo: ");
                    opcion = capt.nextLine();
                    
                    Escribir(opcion, mot, cli, ces);
                    
                    System.out.println("\033[32mSe ha creado una nuevo archivo. \033[30m" +opcion+".txt"+"\n");
                    salir = true;
                    break;
            } // switch

        } //while
        
        System.exit(0);
    }
    
    public static void Menu(){
        /* MENU */
        System.out.println("#########################################################");
        System.out.println("1. Registrar un nuevo miembro.\n"
                + "2. Registrar una nueva motocicleta\n" 
                + "3. Registrar una cesión\n"
                + "4. Listar en pantalla los miembros con motos en posesión\n"
                + "5. Listar todas las motos\n"
                + "6. Mostrar las cesiones realizadas\n"
                + "7. Salir del programa");      
        System.out.println("#########################################################");
    }
    
    public static void Escribir(String fich, ArrayList<Moto> m, ArrayList<Cliente> cl, ArrayList<Cesion> c){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(fich+".txt");
            pw = new PrintWriter(fichero);

            /*CODIGO PARA ESCRIBIR EN EL ARCHIVO*/
            pw.println("Informacion de los Miembros y Motos");
            for(int i = 0; i < cl.size(); i++){
                pw.println(cl.get(i).getInfo(m));
            }
            pw.println("\nHistorial de Cesiones");
            for(int i = 0; i < c.size(); i++){
                pw.println(c.get(i).getInfo(m, cl));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
}
