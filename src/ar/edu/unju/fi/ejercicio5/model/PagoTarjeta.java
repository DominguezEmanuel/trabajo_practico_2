package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoTarjeta() {
		
	}
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(Double monto) {
		Double recarga = monto * 0.15;
		Double nuevoMonto = monto + recarga;
		setMontoPagado(nuevoMonto);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Número de Tarjeta: "+this.numeroTarjeta);
		System.out.println("Fecha de Pago: "+this.fechaPago);
		System.out.println("Monto Pagado: $"+this.montoPagado);
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	
	
}
