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
		imagen=createImage(this.getWidth(),this.getHeight());
		graficas=imagen.getGraphics();
		// fondo del canvas
		graficas.setColor(Color.white);
		graficas.fillRect(0, 0,this.getWidth(),this.getHeight());
		for(int i=0; i<lista.length;i++){
			for(int j=0; j<lista[i].length; j++){
				graficas.setColor(Color.black);
				graficas.drawRect((i+1)*lado*2, (j+1)*lado, lado*2, lado);
				if(j==0){
					graficas.setColor(Color.red);
				}
				else{
					graficas.setColor(Color.black);
				}
				if(lista[i][j]!=-1){
					graficas.drawString(lista[i][j]+"",(i+1)*lado*2 +2,(j+2)*lado-3);
				}
			}
		}
		g.drawImage(imagen, 0, 0, this);
	}
	
}
