package gui;

public class Niveles {
	
	private int nivelActual;
	private int cantEnemigosTotales;
	private int cantEnemigosAlpha;
	private int cantEnemigosBeta;
	private int cantPremios;
	private int valorDificultad;
	
	
	public Niveles() {
		nivelActual = 0;
		cantEnemigosTotales = 0;
		cantEnemigosAlpha = 0;
		cantEnemigosBeta = 0;
		cantPremios = 0;
		valorDificultad = 10;
	}
	
	public void siguienteNivel() {
		nivelActual++;
		cantEnemigosTotales = nivelActual*valorDificultad; //ToDO:: revisar si se quiere que sea de esta manera.
		cantEnemigosAlpha = (70*cantEnemigosTotales)/100; //el 70% de enemigos son Alpha
		cantEnemigosAlpha = (30*cantEnemigosTotales)/100; //el 30% de enemigos son Beta
		cantPremios = (15*cantEnemigosTotales)/100; //la cantidad de premios es el 15% de la cant de enemigos del nivel.
	}
	
	public int getNivel() {
		return nivelActual;
	}
	
	public int getCantEnemigos() {
		return cantEnemigosTotales;
	}
	
	public int getCantAlphas() {
		return cantEnemigosAlpha;
	}
	
	public int getCantBetas() {
		return cantEnemigosBeta;
	}
	
	public int getDificultad() {
		return valorDificultad;
	}
	
	public int getCantPremios() {
		return cantPremios;
	}
}
