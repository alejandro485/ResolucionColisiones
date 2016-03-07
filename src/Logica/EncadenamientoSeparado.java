package Logica;

public class EncadenamientoSeparado extends Colision{
	public Nodo[] a;
	
	public EncadenamientoSeparado(int t) {
		if(isPrimo(t)){
			tamano=t;
		}
		else{
			tamano=3;
		}
		a=new Nodo[tamano];
		b=new int[tamano][3];
		for(int i=0; i<tamano; i++){
			a[i]=null;
			b[i][0]=i+1;
			b[i][1]=(-1);
			b[i][2]=(i+2);
		}
	}
	
	public void agregarLlave(int llave){
		int dis=llave%tamano;
		Nodo n=a[dis];
		while(n!=null){
			n=n.sig;
		}
		n=new Nodo(llave);
		int poc_as=-1;
		for(int i=0; i<tamano; i++){
			if(b[i][1]==-1){
				b[i][1]=llave;
				b[i][2]=0;
				if(poc_as!=-1){
					b[poc_as][2]=b[i][0];
				}
				return;
			}
			else{
				if(dis==b[i][1]%tamano){
					if(llave!=b[i][1]){
						poc_as=i;
					}
					else{
						return;
					}
				}
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
		EncadenamientoSeparado es=new EncadenamientoSeparado(t);
		es.agregarLlave(cadenaE);
		b=es.b;
	}
	
}
