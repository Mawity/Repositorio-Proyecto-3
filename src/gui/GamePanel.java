package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import constants.Constants;
import image.Image;
import image.ImageFactory;

public class GamePanel extends JPanel {
	
	private ImageIcon BGImage;
	private Timer timer;

	public GamePanel() {
		inicializarVariables();
		inicializarLayout();
	}

	private void inicializarVariables() {
		this.BGImage = ImageFactory.crearImagen(Image.BACKGROUND);
	}

	private void inicializarLayout() {

		setPreferredSize(new Dimension(Constants.GAME_WIDTH, Constants.GAME_HEIGHT));
		

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(BGImage.getImage(), 0, 0, null);
	}
	
	
	public void doOneLoop() {
		// TODO Auto-generated method stub
		
	}
}
