/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;

/**
 *
 * @author alejo
 */
public class Reserva {
    
    private long numeroReserva;
    private Calendar fecha;
    private boolean pagado;
    private int cantidadPersonas;
    private Cliente clienteReserva;

    public long getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(long numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Cliente getClienteReserva() {
        return clienteReserva;
    }

    public void setClienteReserva(Cliente clienteReserva) {
        this.clienteReserva = clienteReserva;
    }
    
    
}
