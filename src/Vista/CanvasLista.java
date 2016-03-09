package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class CanvasLista extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private Image imagen;
	private Graphics graficas;
	private int[][] lista;
	
	public void setLista(int[][] l){
		lista=l;
		System.out.println("Actualizando canvas");
		this.repaint();
	}
	public CanvasLista() {
		lista=new int[1][1];
		lista[0][0]=-1;
	}
	
	@Override
	public void paint(Graphics g) {
		int lado=20;
		int al=0;
		int cont=19;
		imagen=createImage(this.getWidth(),this.getHeight());
		graficas=imagen.getGraphics();
		// fondo del canvas
		graficas.setColor(Color.white);
		graficas.fillRect(0, 0,this.getWidth(),this.getHeight());
		for(int i=0; i<lista.length;i++){
			for(int j=0; j<lista[i].length; j++){
				graficas.setColor(Color.black);
				if(i%19==0 && j==0 && i!=0){
					al+=lado*3;
				}
				graficas.drawRect(((i%cont)+1)*lado*2, (j+1)*lado + al, lado*2, lado);
				if(j==0){
					graficas.setColor(Color.red);
				}
				else{
					graficas.setColor(Color.black);
				}
				graficas.drawString(lista[i][j]+"",((i%cont)+1)*lado*2 +2,(j+2)*lado-3+al);
			}
		}
		g.drawImage(imagen, 0, 0, this);
	}
	
}
