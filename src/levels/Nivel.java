package levels;

public class Nivel {
	
	private int cantEnemigosTotales;
	private int cantEnemigosRojos;
	private int cantEnemigosAzules;
	private int cantEnemigosVerdes;
	private int cantPremios;
	private int valorDificultad;
	
	
	public Nivel(int dificultad) {
		inicializar(dificultad);
	}
	
	private void inicializar(int dificultad) {
		valorDificultad = dificultad;
		cantEnemigosTotales = 10*valorDificultad;
		cantEnemigosRojos = (50*cantEnemigosTotales)/100; //el 70% de enemigos son rojos
		cantEnemigosAzules = (30*cantEnemigosTotales)/100; //el 30% de enemigos son azules
		cantEnemigosVerdes = (20*cantEnemigosTotales)/100; //el 20% de enemigos son verdes
		cantPremios = (15*cantEnemigosTotales)/100; //la cantidad de premios es el 15% de la cant de enemigos del nivel.
		
	}	
	
	public void reset() {
		cantEnemigosTotales = 10*valorDificultad;
		cantEnemigosRojos = (50*cantEnemigosTotales)/100; //el 70% de enemigos son rojos
		cantEnemigosAzules = (30*cantEnemigosTotales)/100; //el 30% de enemigos son azules
		cantEnemigosVerdes = (20*cantEnemigosTotales)/100; //el 20% de enemigos son verdes
		cantPremios = (15*cantEnemigosTotales)/100; //la cantidad de premios es el 15% de la cant de enemigos del nivel.
	}
	
	public int getCantEnemigos() {
		return cantEnemigosTotales;
	}
	
	public int getCantRojos() {
		return cantEnemigosRojos;
	}
	
	public int getCantAzules() {
		return cantEnemigosAzules;
	}

	public int getCantVerdes() {
		return cantEnemigosVerdes;
	}
	
	public int getDificultad() {
		return valorDificultad;
	}
	
	public int getCantPremios() {
		return cantPremios;
	}
}
