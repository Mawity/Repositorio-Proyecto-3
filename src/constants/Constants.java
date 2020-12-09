package constants;

public class Constants {
	
	private Constants() {
		
	}
	
	
	public static final String TITLE = "BLOONS TD69";
	
	public static final int GAME_WIDTH = 626;
	public static final int GAME_HEIGHT = 900;
	
	//juego
	public static final int GAME_SPEED = 15;
	public static final int CANTIDAD_NIVELES = 3;
	public static final int VIDA_MAXIMA = 100;
	public static int VELOCIDAD_BASE_GLOBO = 1;
	
	
	// url imagenes
	public static final String GLOBO_ROJO_IMAGE_URL = "imagenes/red_bloon.png";
	public static final String GLOBO_AZUL_IMAGE_URL = "imagenes/blue_bloon.png";
	public static final String GLOBO_VERDE_IMAGE_URL = "imagenes/green_bloon.png";
	public static final String JUGADOR_IMAGE_URL = "imagenes/dart_monkey.png";
	public static final String PREMIO_TIEMPO_IMAGE_URL = "imagenes/slow.png";
	public static final String PREMIO_VIDA_IMAGE_URL = "imagenes/health_potion.png";
	public static final String PROYECTIL_IMAGE_URL = "imagenes/dart.png";
	public static final String BACKGROUND_IMAGE_URL = "imagenes/background.jpg";
	public static final String ICON_IMAGE_URL = "imagenes/icon.png";
	
	
	
	public static void modificarVelocidadGlobos(int i) {
		VELOCIDAD_BASE_GLOBO += i;
	}
}
