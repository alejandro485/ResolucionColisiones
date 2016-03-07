package Logica;

public abstract class Colision {
	public int[][] b;
	public int tamano;
	public String cadenaE;
	
	abstract public void agregarLlave(int llave);
	abstract protected void rehash();
	
	protected boolean isPrimo(int num){
		int raiz=(int)Math.sqrt(num);
		for(int i=2;i<=raiz;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public void agregarLlave(String llave){
		cadenaE=llave;
		String la="";
		for(int i=0; i<llave.length();i++){
			if(llave.charAt(i)==','){
				agregarLlave(Integer.parseInt(la));
				la="";
			}
			else{
				la+=llave.charAt(i);
			}
		}
		if(la!=""){
			agregarLlave(Integer.parseInt(la));
		}
	}
	
}
