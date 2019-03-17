/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundarys;

import Controls.ControlAgencia;
import Entity.Cliente;
import Entity.Reserva;
import Entity.Tour;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author alejo
 */
public class PantallaAgencia {

    private ControlAgencia controlaagencia;

    public PantallaAgencia() {
        this.controlaagencia = new ControlAgencia();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PantallaAgencia cd = new PantallaAgencia();
        System.out.println("Escoja la opcion deseada:");
        System.out.println("1)Ver listado de tours disponibles");
        System.out.println("2)Insertar Tour");
        System.out.println("3)Modificar Tour");
        System.out.println("4)Eliminar Tour");
        System.out.println("5)Ver listado de clientes en el sistema");
        System.out.println("6)Insertar cliente");
        System.out.println("7)Modificar datos del cliente");
        System.out.println("8)Eliminar un cliente");
        System.out.println("9)Reservar Tour");
        System.out.println("10)Modificar reserva Tour");
        System.out.println("11)Eliminar reserva Tour");
        System.out.println("12)Ver listado de reservas existentes");
        System.out.println("13)Ver listado de reservas para un tour fecha especifica");
        System.out.println("14)SALIR");
        int x = sc.nextInt();
        switch (x) {
            case 1: {
                int xx = 1;
                System.out.println("====LISTADO DE TOURS=====");
                ArrayList<Tour> tours = cd.controlaagencia.listadoTours();
                for (Tour not : tours) {
                    System.out.println("Codigo del tour " + xx + not.getCodigoIdentificacion());
                    System.out.println("Nombre del Tour: " + xx + not.getNombreComercial());
                    System.out.println("Precio del Tour: " + not.getPrecio());
                    xx++;
                }
                break;
            }
            case 2: {
                break;
            }
            case 3: {

                break;
            }
            case 4: {
                break;
            }
            case 5: {
                int xx=1;
                 ArrayList<Cliente> clientes=cd.controlaagencia.listadoclientes();
                         System.out.println("====LISTADO CLIENTES EN EL SISTEMA=====");
                for (Cliente not : clientes) {
                    System.out.println("Codigo de identificacion cliente: " + xx + not.getNumeroIdentificacion());
                    System.out.println("Nombre del Cliente: " + xx +":"+ not.getNombreCompleto());
                    System.out.println("Precio del Tour: " + ":"+not.getTelefonoContacto());
                    xx++;
                }
                break;
            }
            case 6: {
                System.out.println("Digite el los datos del cliente que desea insertar: ");
                sc.nextLine();
                System.out.print("Digite el id del nuevo cliente: ");
                long id = sc.nextLong();
                System.out.print("Digite el nombre completo para su nuevo cliente: ");
                String name = sc.nextLine();
                System.out.print("Digite el numero de telefono para su nuevo cliente: ");
                String telefono = sc.nextLine();
                if(cd.controlaagencia.insertarCliente(id, name, telefono)==true){
                    System.out.println("Cliente insertado con exito");
                }else{
                    System.out.println("Cliente con un id igual añádido con anterioridad");
                }
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                System.out.println("Digite id del usuario que quiere modificar: ");
                long id = sc.nextLong();
                System.out.println("Digite el numeral del dato que desea cambiar\n1.)Numero de identificacion: " + cd.controlaagencia.buscarCliente(id).getNumeroIdentificacion()
                        + "\n2.)Nombre: " + cd.controlaagencia.buscarCliente(id).getNombreCompleto() + "\n3.)Numero de telefono: " + cd.controlaagencia.buscarCliente(id).getTelefonoContacto() + "\nSu opcion: ");
                int opcion;
                opcion = sc.nextInt();
                if (cd.controlaagencia.buscarCliente(id) != null) {
                    switch (opcion) {
                        case 1:
                            System.out.println("\nSelecciono cambiar numero de identificacion\nDigite el numero de identificacion al cual desea cambiar: ");
                            long nuevoId = sc.nextInt();
                            if (cd.controlaagencia.modificarCliente(id, nuevoId)) {
                                System.out.println("Cambio de id del cliente exitoso");
                            } else {
                                System.out.println("Error en el cambio del id del cliente con errores, " + nuevoId + " ya esta registrado para otro cliente");
                            }
                            break;

                        case 2:
                            sc.nextLine();
                            System.out.print("Cambiar nombre de usuario\nDigite el nuevo nombre para el usuario: ");
                            String nuevoNombre = sc.nextLine();
                            cd.controlaagencia.modificarCliente(id, nuevoNombre);
                            System.out.println("Nombre cambiado con exito");
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.print("Cambiar numero de telefono\nDigite el nuevo numero de telefono: ");
                            String nuevoTelefono = sc.nextLine();
                            cd.controlaagencia.modificarCliente(nuevoTelefono, id);
                            System.out.println("Numero de telefono cambiado con exito");
                            break;
                            
                        default:
                            System.out.println("Opcion incorrecta");
                            break;

                    }
                }
                break;
            }
            case 9: {
                System.out.println("=======Eliminar un cliente==========");
                System.out.print("Digite el id del cliente que desea eliminar: ");
                int idEliminar = sc.nextInt();
                if ((cd.controlaagencia.buscarCliente(idEliminar) != null) && (cd.controlaagencia.asociacionReservas(cd.controlaagencia.buscarCliente(idEliminar)))) {
                    System.out.print("Realmente desea eliminar el cliente\n1.)Si\n2)No\nSu opcion: ");
                    int opcion = sc.nextInt();
                    while ((opcion != 2) || (opcion != 1)) {
                        switch (opcion) {
                            case 1:
                                cd.controlaagencia.eliminarCliente(idEliminar, opcion);
                                System.out.println("Cliente eliminado con exito");
                                break;
                            case 2:
                                System.out.println("No se eliminara el cliente");
                                break;
                            default:
                                System.out.println("Opcion no disponible");
                                break;
                        }
                    }
                }
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                int xx=1;
                ArrayList<Reserva> reservas=cd.controlaagencia.listadoResevas();
                System.out.println("====Listado de reservas===");
                
                 for (Reserva not : reservas)
                 {
                     System.out.println("Codigo de la  reserva " + x + ":" + not.getNumeroReserva());
                     System.out.println("Fecha de la reserva: " + not.getFecha());
                     System.out.println("Numero de personas:  " + not.getCantidadPersonas());
                     
                 }
            
                break;
            }
            case 13: {
                break;
            }
            case 14: {

                break;
            }
        }

    }

    public void imprimir(String x) {

        System.out.print(x);
    }

}
