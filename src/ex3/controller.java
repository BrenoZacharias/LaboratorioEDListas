package ex3;
public class controller {
	private Object[] pilha;
	private int elementosA, elementosB, pilhaA, pilhaB;
	private Object topoA;
	private Object topoB;
	
	public controller() {
		this.elementosA = -1;
		this.elementosB = -1;
		this.pilha = new Object[10];
		if(pilha.length % 2 == 0) {
			this.pilhaA = pilha.length/2;
			this.pilhaB = pilha.length-pilhaA;
		}
		else{
			this.pilhaA = (pilha.length+1)/2;
			this.pilhaB = pilha.length-pilhaA;
		}
	}
	public void pushA(Object objeto) {
		if(!estaCheiaA()) {
			pilha[++elementosA] = objeto;
			topoA = objeto;
		}
	}
	public void pushB(Object objeto) {
		if(!estaCheiaB()) {
			elementosB++;
			pilha[(pilha.length-1)-elementosB] = objeto;
			topoB = objeto;
		}
	}
	public boolean estaVaziaA() {
		if(elementosA == -1) {
			return true;
		}
		return false;
	}
	public boolean estaVaziaB() {
		if(elementosB == -1) {
			return true;
		}
		return false;
	}
	public Object popA() {
	        if (!estaVaziaA()) {
	        	int aux  = elementosA--;
	        	topoA = pilha[elementosA];
	            return pilha[aux];
	        }
	        return false;
	}
	public Object popB() {
		if (!estaVaziaB()) {
			int aux = pilha.length-elementosB;
			elementosB--;
			topoB = pilha[aux];
			return pilha[aux];
		}
		return false;
	}
	public boolean estaCheiaA() {
		if(elementosA+1 == pilhaA) {
			return true;
		}
		return false;
	}
	public boolean estaCheiaB(){
		if(elementosB+1 == pilhaB) {
			return true;
		}
		return false;
	}
	public Object mostrarTopoA() {
		return "Topo = " +topoA;
	}
	public Object mostrarTopoB() {
		return "Topo = " +topoB;
	}
	public void mostrarA() {
        String printar = "";
        System.out.println("-=-=-=-= pilha A =-=-=-=-");
        for (int c = 0; c != elementosA+1; c++) {
    		printar += "[ ";
    		printar += pilha[c];
    		printar += " ]\n";
        }
        System.out.println(printar);

	}
	public void mostrarB() {
		String printar = "";
		System.out.println("-=-=-=-= pilha B =-=-=-=-");
		for(int c = (pilha.length-1)-elementosB; c <= pilha.length-1; c++) {
			printar += "[ ";
            printar += pilha[c];
            printar += " ]\n";
		}
		System.out.println(printar);
		
	}
	public void mostrar() {
		String printar = "";
		for(int c = 0; c < pilha.length; c++) {
			printar += pilha[c] + " ";
		}
		System.out.println(printar);
	}
    public int tamanhoA(){
    	return pilhaA;
    }
    public int tamanhoB() {
    	return pilhaB;
    }
	
	
}