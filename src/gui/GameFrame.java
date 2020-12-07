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
		
		add(new GamePanel());
		
		setTitle(Constants.TITLE);
		setIconImage(ImageFactory.crearImagen(Image.ICON).getImage());
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		setResizable(false);
		setVisible(true);
		
	}
	
	
}
