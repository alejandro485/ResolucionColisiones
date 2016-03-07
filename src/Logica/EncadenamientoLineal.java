package Logica;

public class EncadenamientoLineal extends Colision{
	
	public EncadenamientoLineal(int t) {
		if(isPrimo(t)){
			tamano=t;
		}
		else{
			tamano=3;
		}
		b= new int[tamano][3];
		for(int i=0; i<tamano; i++){
			b[i][0]=i;
			b[i][1]=-1;
			b[i][2]=0;
		}
	}

	@Override
	public void agregarLlave(int llave) {
		int dis=llave%tamano;
		if(b[dis][2]==0){
			b[dis][2]=llave;
			return;
		}
		while(b[dis][2]!=0){
			if(b[dis][1]==-1){
				break;
			}
			else{
				dis=b[dis][1];
			}
		}
		for(int i=tamano-1; i>=0; i--){
			if(b[i][2]==0){
				b[i][2]=llave;
				b[dis][1]=i;
				return;
			}
		}
		rehash();
	}
	
	protected void rehash() {
		int t=tamano;
		t+=2;
		while(!isPrimo(t)){
			t+=2;
		}
		EncadenamientoLineal el=new EncadenamientoLineal(t);
		el.agregarLlave(cadenaE);
		b=el.b;
	}
	
}
