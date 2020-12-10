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
	public static int DMG_BASE_DARDO = 1;
	public static final int TIEMPO_SLOW = 500;
	public static final int TIEMPO_EXTRA_DMG= 750;
	
	
	// url imagenes
	public static final String GLOBO_ROJO_IMAGE_URL = "imagenes/red_bloon.png";
	public static final String GLOBO_AZUL_IMAGE_URL = "imagenes/blue_bloon.png";
	public static final String GLOBO_VERDE_IMAGE_URL = "imagenes/green_bloon.png";
	public static final String JUGADOR_IMAGE_URL = "imagenes/dart_monkey.png";
	public static final String PREMIO_TIEMPO_IMAGE_URL = "imagenes/slow.png";
	public static final String PREMIO_VIDA_IMAGE_URL = "imagenes/health_potion.png";
	public static final String PREMIO_DMG_IMAGE_URL = "imagenes/plus_dmg.png";
	public static final String PROYECTIL_IMAGE_URL = "imagenes/dart.png";
	public static final String BACKGROUND_IMAGE_URL = "imagenes/background.jpg";
	public static final String ICON_IMAGE_URL = "imagenes/icon.png";
	public static final String LVL_CLEAR_IMAGE_URL = "imagenes/level_clear.png";
	//url numeros
	public static final String NUM_0_IMAGE_URL = "imagenes/numero_0.png";
	public static final String NUM_1_IMAGE_URL = "imagenes/numero_1.png";
	public static final String NUM_2_IMAGE_URL = "imagenes/numero_2.png";
	public static final String NUM_3_IMAGE_URL = "imagenes/numero_3.png";
	public static final String NUM_4_IMAGE_URL = "imagenes/numero_4.png";
	public static final String NUM_5_IMAGE_URL = "imagenes/numero_5.png";
	public static final String NUM_6_IMAGE_URL = "imagenes/numero_6.png";
	public static final String NUM_7_IMAGE_URL = "imagenes/numero_7.png";
	public static final String NUM_8_IMAGE_URL = "imagenes/numero_8.png";
	public static final String NUM_9_IMAGE_URL = "imagenes/numero_9.png";
	
	
	
	public static void changeDartsDMG(int dmg) {
		DMG_BASE_DARDO = dmg;
	}
	
	public static void changeBloonsSpeed(int speed) {
		VELOCIDAD_BASE_GLOBO = speed;
	}

}
