/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Entity.Cliente;
import Entity.Reserva;
import Entity.Tour;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author alejo
 */
public class ControlAgencia {

    protected static ArrayList<Cliente> listaClientes;
    private static ArrayList<Reserva> reservas;
    protected static ArrayList<Tour> listaTours;

    
    public static void inicializador(){
        listaClientes = new ArrayList<Cliente>();
        reservas = new ArrayList<Reserva>();
        listaTours = new ArrayList<Tour>();
        Tour n1 =new Tour(10000,"Tour chicamocha","Bogota","19:30",40000);
        listaTours.add(n1);
        Tour n2=new Tour (2300,"Tour nariz del diablo","Medellin","8:30",5550000);
        listaTours.add(n2);
        Cliente t1=new Cliente(1000285809, "Potra palacios", "3202317897");
        listaClientes.add(t1);
        Calendar calendario=new GregorianCalendar(2019, 02, 15);
        Reserva  r1=new Reserva(20000, calendario, false, 4, t1);
        reservas.add(r1);
    }
    
     public static ArrayList<Reserva> listadoResevas() {
        
        ArrayList <Reserva> retorna =new ArrayList<Reserva>();
        System.out.println("====Listado de reservas===");
        for (Reserva not : reservas) {
            retorna.add(not);
          
        }
        return retorna;
    }
        public static boolean asociacionReservas(Cliente client) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).equals(client)) {
                return true;
            }
        }
        return false;
    }
        
    public static long listadoReservasFechaEspecifica(Calendar fecha, long codigo) {

        for (Reserva not : reservas) {
            if (not.getFecha().compareTo(fecha) == 0) {
                for (Tour noti : not.getTourReservado()) {
                    if (noti.getCodigoIdentificacion() == codigo) {
                        System.out.println("Cantidad de personas:"+not.getCantidadPersonas());
                        System.out.println("nombre: "+not.getClienteReserva().getNombreCompleto());
                        return not.getCantidadPersonas();
                    }

                }

            }

        }
        return 0;

    }
    
    

    
   
}
