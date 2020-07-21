/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import static Controls.ControlAgencia.listaClientes;
import static Controls.ControlAgencia.listaTours;
import Entity.Tour;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alejo
 */
public class GestionTours {

    public static ArrayList<Tour> listadoTours() {
       ArrayList <Tour> retorna =new ArrayList<Tour>();
        
        for (Tour not : listaTours) {
            retorna.add(not);
        }
        return retorna;
    }

    

    

 
    
    public static Tour buscarTour(long codigo)
    {
        for(Tour tour: listaTours)
        {
            if(tour.getCodigoIdentificacion()==codigo)
                return tour;
        }
        return null;
    }
    
    public static boolean validarCodigoTour(long codigo)
    {
        
        return Long.toString(codigo).length()==7;
            
    }
    
    public static void InsertarTour(long codigo, String nombreC, String lugarP, String horaP, double precio)
    {
        if((buscarTour(codigo)==null)&&(validarCodigoTour(codigo)==true)){
            Tour nuevo = new Tour(codigo,nombreC,lugarP,horaP,precio);
            listaTours.add(nuevo);
            System.out.println("Tour insertado con exito");
        }
        if((buscarTour(codigo)==null)&&(validarCodigoTour(codigo)==false))
        {
            System.out.println("El codigo no tiene 7 digitos. Por favor verifiquelo.");
        }
        System.out.println("Tour insertado con anterioridad");
    }
    
    public static void modificarTour(long codigo){
        if(buscarTour(codigo)!=null){
            Tour tuser = buscarTour(codigo);
            Scanner txt = new Scanner(System.in);
            System.out.println("Digite el numeral del dato que desea cambiar\n1.)Codigo de identificacion: "+tuser.getCodigoIdentificacion()+
                    "\n2.)Nombre Comercial: "+ tuser.getNombreComercial()+ "\n3.)Lugar de Partida: "+ tuser.getLugarPartida()+ "\n4.)Hora de Partida: "+ tuser.getHoraPartida()+ "\n5.)Precio: " +tuser.getPrecio()+"\nSu opcion: ");
            int opcion = txt.nextInt();
            int pos = listaTours.indexOf(tuser);
            switch(opcion){
                case 1 : System.out.println("\nSelecciono cambiar Codigo de identificacion\n"
                        + "Digite el Codigo de identificacion al cual desea cambiar");
                         txt.nextLine();
                         long nuevoCodigo = txt.nextInt();
                         if(buscarTour(nuevoCodigo)==null){
                             listaTours.get(pos).getCodigoIdentificacion(nuevoCodigo);
                             System.out.println("Numero de identificacion cambiado con exito");
                         }else{
                             System.out.println("Existe un usuario registrado con ese Id, imposible cambiar el dato");
                         }
                         break;
                case 2 : txt.nextLine();
                         System.out.print("Cambiar nombre de usuario\nDigite el nuevo nombre para el usuario: ");
                         String nuevoNombre = txt.nextLine();
                         listaClientes.get(pos).setNombreCompleto(nuevoNombre);
                         System.out.println("Nombre cambiado con exito");
                         break;
                case 3 : txt.nextLine();
                         System.out.print("Cambiar numero de telefono\nDigite el nuevo numero de telefono: ");
                         String nuevoTelefono = txt.nextLine();
                         listaClientes.get(pos).setTelefonoContacto(nuevoTelefono);
                         System.out.println("Numero de telefono cambiado con exito");
                         break;
                default : System.out.println("Opcion incorrecta");
                         break;
            }
        }
        System.out.println("El cliente no existe");
    }
}
