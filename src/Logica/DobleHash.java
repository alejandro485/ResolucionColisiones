package Logica;

public class DobleHash extends Colision {

	public DobleHash(int t) {
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
		int dis=llave%tamano;
		int fijo=1+llave%(tamano-2);
		int c=0;
		while(b[dis][1]!=-1){
			if(b[dis][1]!=llave){
				dis=(dis+fijo)%tamano;
				c++;
				if(c==tamano){
					break;
				}
			}
			else{
				return;
			}
		}
		if(b[dis][1]==-1){
			b[dis][1]=llave;
		}
		else{
			rehash();
		}
	}

	@Override
	protected void rehash() {
		int t=tamano;
		t+=2;
		while(!isPrimo(t)){
			t+=2;
		}
		DobleHash dh=new DobleHash(t);
		dh.agregarLlave(cadenaE);
		b=dh.b;
	}

}
