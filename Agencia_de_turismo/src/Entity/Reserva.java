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
}
