package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {

	JUJUY(770881, 53244.2), 
	SALTA(1424397, 155340.5), 
	TUCUMAN(1694656, 22592.1), 
	CATAMARCA(415438, 101486.1), 
	LA_RIOJA(393531, 91493.7), 
	SANTIAGO_DEL_ESTERO(978313, 136934.3);
	
	
	private int poblacion;
	private Double superficie;
	
	private Provincia(int poblacion, Double superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	
	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

	public Double densidadPoblacional(int poblacion, Double superficie) {
		Double densidad;
		densidad = poblacion / superficie;
		return densidad;
	}
}
