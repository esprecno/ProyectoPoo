/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Boundarys.PantallaAgencia;
import Entity.Cliente;
import Entity.Reserva;
import Entity.Tour;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author alejo
 */
public class ControlAgencia {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Reserva> reservas;
    private ArrayList<Tour> listaTours;

    public ControlAgencia() {
        this.listaClientes = new ArrayList<Cliente>();
        this.reservas = new ArrayList<Reserva>();
        this.listaTours = new ArrayList<Tour>();
        Tour n1 =new Tour(10000,"Tour chicamocha","Bogota","19:30",40000);
        this.listaTours.add(n1);
        Tour n2=new Tour (2300,"Tour nariz del diablo","Medellin","8:30",5550000);
        this.listaTours.add(n2);
        Cliente t1=new Cliente(1000285809, "Potra palacios", "3202317897");
        this.listaClientes.add(t1);
        Calendar calendario=new GregorianCalendar(2019, 02, 15);
        Reserva  r1=new Reserva(20000, calendario, false, 4, t1);
        this.reservas.add(r1);
    }
     
    

    public void insertarCliente(long id, String nombre, String telefono) {
        if (buscarCliente(id) == null) {
            Cliente nuevo = new Cliente(id, nombre, telefono);
            this.listaClientes.add(nuevo);
            System.out.println("Cliente insertado con exito");
        }
        System.out.println("Cliente insertado con anterioridad");
    }

    public void modificarCliente(long id) {
        if (buscarCliente(id) != null) {
            Cliente user = buscarCliente(id);
            Scanner tx = new Scanner(System.in);
            System.out.println("Digite el numeral del dato que desea cambiar\n1.)Numero de identificacion: " + user.getNumeroIdentificacion()
                    + "\n2.)Nombre: " + user.getNombreCompleto() + "\n3.)Numero de telefono: " + user.getTelefonoContacto() + "\nSu opcion: ");
            int opcion = tx.nextInt();
            int pos = this.listaClientes.indexOf(user);
            switch (opcion) {
                case 1:
                    System.out.println("\nSelecciono cambiar numero de identificacion\n"
                            + "Digite el numero de identificacion al cual desea cambiar");
                    tx.nextLine();
                    long nuevoId = tx.nextInt();
                    if (buscarCliente(nuevoId) == null) {
                        this.listaClientes.get(pos).setNumeroIdentificacion(nuevoId);
                        System.out.println("Numero de identificacion cambiado con exito");
                    } else {
                        System.out.println("Existe un usuario registrado con ese Id, imposible cambiar el dato");
                    }
                    break;
                case 2:
                    tx.nextLine();
                    System.out.print("Cambiar nombre de usuario\nDigite el nuevo nombre para el usuario: ");
                    String nuevoNombre = tx.nextLine();
                    this.listaClientes.get(pos).setNombreCompleto(nuevoNombre);
                    System.out.println("Nombre cambiado con exito");
                    break;
                case 3:
                    tx.nextLine();
                    System.out.print("Cambiar numero de telefono\nDigite el nuevo numero de telefono: ");
                    String nuevoTelefono = tx.nextLine();
                    this.listaClientes.get(pos).setTelefonoContacto(nuevoTelefono);
                    System.out.println("Numero de telefono cambiado con exito");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
        System.out.println("El cliente no existe");
    }

    public void eliminarCliente(long id) {
        if (buscarCliente(id) != null) {
            if (asociacionReservas(buscarCliente(id)) == false) {
                Scanner tx = new Scanner(System.in);
                System.out.print("Realmente desea eliminar el cliente\n1.)Si\n2)No\nSu opcion: ");
                int opcion = tx.nextInt();
                switch (opcion) {
                    case 1:
                        this.listaClientes.remove(buscarCliente(id));
                        System.out.println("Cliente eliminado con exito");
                        break;
                    case 2:
                        System.out.println("No se eliminara el cliente");
                        break;
                    default:
                        System.out.println("Opcion no permitida");
                        break;
                }
            } else {
                System.out.println("El cliente tiene una reserva");
            }
        } else {
            System.out.println("El cliente no existe");
        }
    }

    public Cliente buscarCliente(long id) {
        for (int i = 0; i < this.listaClientes.size(); i++) {
            if (this.listaClientes.get(i).getNumeroIdentificacion() == id) {
                return this.listaClientes.get(i);
            }
        }
        return null;
    }

    public boolean asociacionReservas(Cliente client) {
        for (int i = 0; i < this.reservas.size(); i++) {
            if (this.reservas.get(i).equals(client)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Tour> listadoTours() {
       ArrayList <Tour> retorna =new ArrayList<Tour>();
        
        for (Tour not : this.listaTours) {
            retorna.add(not);
        }
        return retorna;
    }

    public ArrayList<Cliente> listadoclientes() {
        ArrayList <Cliente> retorna =new ArrayList<Cliente>();
        
        for (Cliente not : this.listaClientes) {
            retorna.add(not);
        }
        return retorna;
    }

    public ArrayList<Reserva> listadoResevas() {
        
        ArrayList <Reserva> retorna =new ArrayList<Reserva>();
        System.out.println("====Listado de reservas===");
        for (Reserva not : reservas) {
            retorna.add(not);
          
        }
        return retorna;
    }

    public long listadoReservasFechaEspecifica(Calendar fecha, long codigo) {

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
    
    public Tour buscarTour(long codigo)
    {
        for(Tour tour: listaTours)
        {
            if(tour.getCodigoIdentificacion()==codigo)
                return tour;
        }
        return null;
    }
    
    public boolean validarCodigoTour(long codigo)
    {
        
        return Long.toString(codigo).length()==7;
            
    }
    
    public void InsertarTour(long codigo, String nombreC, String lugarP, String horaP, double precio)
    {
        if((buscarTour(codigo)==null)&&(validarCodigoTour(codigo)==true)){
            Tour nuevo = new Tour(codigo,nombreC,lugarP,horaP,precio);
            this.listaTours.add(nuevo);
            System.out.println("Tour insertado con exito");
        }
        if((buscarTour(codigo)==null)&&(validarCodigoTour(codigo)==false))
        {
            System.out.println("El codigo no tiene 7 digitos. Por favor verifiquelo.");
        }
        System.out.println("Tour insertado con anterioridad");
    }
    
    public void modificarTour(long codigo){
        if(buscarTour(codigo)!=null){
            Tour tuser = buscarTour(codigo);
            Scanner txt = new Scanner(System.in);
            System.out.println("Digite el numeral del dato que desea cambiar\n1.)Codigo de identificacion: "+tuser.getCodigoIdentificacion()+
                    "\n2.)Nombre Comercial: "+ tuser.getNombreComercial()+ "\n3.)Lugar de Partida: "+ tuser.getLugarPartida()+ "\n4.)Hora de Partida: "+ tuser.getHoraPartida()+ "\n5.)Precio: " +tuser.getPrecio()+"\nSu opcion: ");
            int opcion = txt.nextInt();
            int pos = this.listaTours.indexOf(tuser);
            switch(opcion){
                case 1 : System.out.println("\nSelecciono cambiar Codigo de identificacion\n"
                        + "Digite el Codigo de identificacion al cual desea cambiar");
                         txt.nextLine();
                         long nuevoCodigo = txt.nextInt();
                         if(buscarTour(nuevoCodigo)==null){
                             this.listaTours.get(pos).getCodigoIdentificacion(nuevoCodigo);
                             System.out.println("Numero de identificacion cambiado con exito");
                         }else{
                             System.out.println("Existe un usuario registrado con ese Id, imposible cambiar el dato");
                         }
                         break;
                case 2 : txt.nextLine();
                         System.out.print("Cambiar nombre de usuario\nDigite el nuevo nombre para el usuario: ");
                         String nuevoNombre = txt.nextLine();
                         this.listaClientes.get(pos).setNombreCompleto(nuevoNombre);
                         System.out.println("Nombre cambiado con exito");
                         break;
                case 3 : txt.nextLine();
                         System.out.print("Cambiar numero de telefono\nDigite el nuevo numero de telefono: ");
                         String nuevoTelefono = txt.nextLine();
                         this.listaClientes.get(pos).setTelefonoContacto(nuevoTelefono);
                         System.out.println("Numero de telefono cambiado con exito");
                         break;
                default : System.out.println("Opcion incorrecta");
                         break;
            }
        }
        System.out.println("El cliente no existe");
    }
   
}
