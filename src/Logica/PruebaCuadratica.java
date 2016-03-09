package Logica;

public class PruebaCuadratica extends Colision {

	public PruebaCuadratica(int t) {
		if(isPrimo(t)){
			tamano=t;
		}
		else{
			tamano=3;
		}
		b= new int[tamano][2];
		for(int i=0; i<tamano; i++){
			b[i][0]=i;
			b[i][1]=-1;
		}
	}
	
	@Override
	public void agregarLlave(int llave) {
		int p=(tamano + 1)/2;
		int i=1;
		int dis=llave%tamano;
		int k=dis;
		while(b[dis][1]!=-1 && i<p){
			if(b[dis][1]==llave){
				return;
			}
			dis=(k + (i*i))%tamano;
			i++;
		}
		if(i==p){
			rehash();
		}
		else{
			b[dis][1]=llave;
		}
	}
	
	protected void rehash() {
		int t=tamano;
		t+=2;
		while(!isPrimo(t)){
			t+=2;
		}
		PruebaCuadratica pc=new PruebaCuadratica(t);
		pc.agregarLlave(cadenaE);
		b=pc.b;
	}

}
