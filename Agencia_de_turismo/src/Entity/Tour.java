/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author alejo
 */
public class Tour {
    
    private long codigoIdentificacion;
    private String nombreComercial;
    private String lugarPartida;
    private String horaPartida;
    private double precio;

    public Tour(long codigoIdentificacion, String nombreComercial, String lugarPartida, String horaPartida, double precio) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreComercial = nombreComercial;
        this.lugarPartida = lugarPartida;
        this.horaPartida = horaPartida;
        this.precio = precio;
    }
    

    public long getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(long codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getLugarPartida() {
        return lugarPartida;
    }

    public void setLugarPartida(String lugarPartida) {
        this.lugarPartida = lugarPartida;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
