package levels;

public class Nivel {
	
	private int cantEnemigosTotales;
	private int cantEnemigosRojos;
	private int cantEnemigosAzules;
	private int cantEnemigosVerdes;
	private int cantEnemigosGlobos;
	private int cantEnemigosMoabs;
	private int cantPremios;
	private int valorDificultad;
	
	
	public Nivel(int dificultad) {
		valorDificultad = dificultad;
		inicializar();
	}
	
	private void inicializar() {
		cantEnemigosGlobos = 10*valorDificultad;
		cantEnemigosMoabs = valorDificultad;              //1 moab extra por cada nivel
		cantEnemigosRojos = (50*cantEnemigosGlobos)/100;  //el 50% de enemigos son rojos
		cantEnemigosAzules = (30*cantEnemigosGlobos)/100; //el 30% de enemigos son azules
		cantEnemigosVerdes = (20*cantEnemigosGlobos)/100; //el 20% de enemigos son verdes
		cantEnemigosTotales = cantEnemigosGlobos + cantEnemigosMoabs;
		cantPremios = (5*cantEnemigosTotales)/100; //la cantidad de premios es el 5% de la cant de enemigos del nivel.
		
		
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
	
	public int getCantMoabs() {
		return cantEnemigosMoabs;
	}	
	
	public void restarRojo() {
		cantEnemigosRojos--;
	}
	
	public void restarAzul() {
		cantEnemigosAzules--;
	}
	
	public void restarVerde() {
		cantEnemigosVerdes--;
	}
	
	public void restarMoab() {
		cantEnemigosMoabs--;
	}
	
	public void reiniciarNivel() {
		inicializar();
	}
	
	
	
	
	
	public int getDificultad() {
		return valorDificultad;
	}
	
	public int getCantPremios() {
		return cantPremios;
	}
	
	public void restarPremio() {
		cantPremios--;
	}
}
