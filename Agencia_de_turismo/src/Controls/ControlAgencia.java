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
import java.util.Scanner;

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
    }
    
    public void insertarCliente(long id,String nombre,String telefono){
        if(buscarCliente(id)==null){
            Cliente nuevo = new Cliente(id,nombre,telefono);
            this.listaClientes.add(nuevo);
            System.out.println("Cliente insertado con exito");
        }
        System.out.println("Cliente insertado con anterioridad");
    }

    public void modificarCliente(long id){
        if(buscarCliente(id)!=null){
            Cliente user = buscarCliente(id);
            Scanner tx = new Scanner(System.in);
            System.out.println("Digite el numeral del dato que desea cambiar\n1.)Numero de identificacion: "+user.getNumeroIdentificacion()+
                    "\n2.)Nombre: "+user.getNombreCompleto()+"\n3.)Numero de telefono: "+user.getTelefonoContacto()+"\nSu opcion: ");
            int opcion = tx.nextInt();
            int pos = this.listaClientes.indexOf(user);
            switch(opcion){
                case 1 : System.out.println("\nSelecciono cambiar numero de identificacion\n"
                        + "Digite el numero de identificacion al cual desea cambiar");
                         tx.nextLine();
                         long nuevoId = tx.nextInt();
                         if(buscarCliente(nuevoId)==null){
                             this.listaClientes.get(pos).setNumeroIdentificacion(nuevoId);
                             System.out.println("Numero de identificacion cambiado con exito");
                         }else{
                             System.out.println("Existe un usuario registrado con ese Id, imposible cambiar el dato");
                         }
                         break;
                case 2 : tx.nextLine();
                         System.out.print("Cambiar nombre de usuario\nDigite el nuevo nombre para el usuario: ");
                         String nuevoNombre = tx.nextLine();
                         this.listaClientes.get(pos).setNombreCompleto(nuevoNombre);
                         System.out.println("Nombre cambiado con exito");
                         break;
                case 3 : tx.nextLine();
                         System.out.print("Cambiar numero de telefono\nDigite el nuevo numero de telefono: ");
                         String nuevoTelefono = tx.nextLine();
                         this.listaClientes.get(pos).setTelefonoContacto(nuevoTelefono);
                         System.out.println("Numero de telefono cambiado con exito");
                         break;
                default : System.out.println("Opcion incorrecta");
                         break;
            }
        }
        System.out.println("El cliente no existe");
    }
    
    public void eliminarCliente(long id){
        if(buscarCliente(id)!=null){
            if(asociacionReservas(buscarCliente(id))==false){
                Scanner tx = new Scanner(System.in);
                System.out.print("Realmente desea eliminar el cliente\n1.)Si\n2)No\nSu opcion: ");
                int opcion = tx.nextInt();
                switch(opcion){
                    case 1 : this.listaClientes.remove(buscarCliente(id));
                             System.out.println("Cliente eliminado con exito");
                             break;
                    case 2 : System.out.println("No se eliminara el cliente");
                             break;
                    default : System.out.println("Opcion no permitida");
                              break;
                }
            }else{
                System.out.println("El cliente tiene una reserva");
            }
        }else{
            System.out.println("El cliente no existe");
        }
    }
    
    public Cliente buscarCliente(long id){
        for(int i=0;i<this.listaClientes.size();i++){
            if(this.listaClientes.get(i).getNumeroIdentificacion()==id){
                return this.listaClientes.get(i);
            }
        }
        return null;
    }
    
    public boolean asociacionReservas(Cliente client){
        for(int i=0;i<this.reservas.size();i++){
            if(this.reservas.get(i).equals(client)){
                return true;
            }
        }
        return false;
    }
     public void listadoTours ()
    {
        System.out.println("====LISTADO DE TOURS=====");
        int x=1;
        for (Tour not:  this.listaTours)
        {
            System.out.println("Nombre del tour"+x+" "+not.getNombreComercial());
            System.out.println("Codigo del tour"+x+":"+not.getCodigoIdentificacion());
            System.out.println("Precio del tour"+x+":"+not.getPrecio());
            x++;
        }
    }
    public void listadoclientes()
    {
        int x=1;
        System.out.println("====Listado de Clientes====");
        for (Cliente not:  listaClientes)
        {
            System.out.println("Numero de identificacion del cliente "+x+not.getNumeroIdentificacion());
            System.out.println("Nombre Completo del cliente "+x+not.getNombreCompleto());
            System.out.println("Telefono: "+not.getTelefonoContacto());
            x++;
        }
    }
   
    public void listadoResevas ()
    {
        int x=1;
        System.out.println("====Listado de reservas===");
        for (Reserva not:  reservas)
        {
            System.out.println("Codigo de la  reserva "+x+ ":"+not.getNumeroReserva());
            System.out.println("Fecha de la reserva: "+not.getFecha());
            System.out.println("Numero de personas:  "+not.getCantidadPersonas());
            System.out.println("Precio:");
            x++;
        }
    }
}
