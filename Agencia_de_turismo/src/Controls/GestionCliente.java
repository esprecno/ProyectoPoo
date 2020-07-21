/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;
import Entity.Cliente;
import java.util.ArrayList;
import static Controls.ControlAgencia.listaClientes;
/**
 *
 * @author alejo
 */
public class GestionCliente {

    
    public static ArrayList<Cliente> listadoclientes() {
        ArrayList <Cliente> retorna =new ArrayList<Cliente>();
        
        for (Cliente not : listaClientes) {
            retorna.add(not);
        }
        return retorna;
    }
    
    public static boolean insertarCliente(long id, String nombre, String telefono) {
        if (buscarCliente(id) == null) {
            Cliente nuevo = new Cliente(id, nombre, telefono);
            listaClientes.add(nuevo);
            return true;
        }
        return false;
    }
    
    public static void modificarCliente(String nuevoTelefono, long id) {
        int pos = listaClientes.indexOf(buscarCliente(id));
        listaClientes.get(pos).setTelefonoContacto(nuevoTelefono);
        System.out.println("Numero de telefono cambiado con exito");
    }
    
    public static boolean modificarCliente(long id, long nuevoId) {
        int pos = listaClientes.indexOf(buscarCliente(id));
        if (buscarCliente(nuevoId) == null) {
            listaClientes.get(pos).setNumeroIdentificacion(nuevoId);
            return true;
        } else {
            return false;
        }
    }
    
    public static void modificarCliente(long id, String nuevoNombre) {
        int pos = listaClientes.indexOf(buscarCliente(id));
        listaClientes.get(pos).setNombreCompleto(nuevoNombre);
    }
    
    public static void eliminarCliente(long id,int opcion) {
        listaClientes.remove(buscarCliente(id));
    }

    public static Cliente buscarCliente(long id) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroIdentificacion() == id) {
                return listaClientes.get(i);
            }
        }
        return null;
    }
}
