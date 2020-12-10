package gui;

import javax.swing.JFrame;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class GameFrame extends JFrame {

	public GameFrame() {
		inicializar();
	}

	private void inicializar() {
		
		add(GamePanel.getInstancia());
		
		setTitle(Constants.TITLE);
		setIconImage(ImageFactory.crearImagen(Image.ICON, GameFrame.class.getResource(Constants.ICON_IMAGE_URL)).getImage());
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setResizable(false);
		setVisible(true);
		
	}
	
	
}
