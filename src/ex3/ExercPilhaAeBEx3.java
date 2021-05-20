package ex3;
import javax.swing.JOptionPane;


public class ExercPilhaAeBEx3 {

	public static void main(String[] args) {
		controllerEx3 p = new controllerEx3();
		
		JOptionPane.showMessageDialog(null, p.estaVaziaA());
		JOptionPane.showMessageDialog(null, p.estaVaziaB());
		
		p.pushA("Millena");
		p.pushA("Vitória");
		p.pushA("Nathalia");
		p.pushA("Stephanie");
		p.pushA("Bruno");

		p.pushB("Pedro");
		p.pushB("Luana");
		p.pushB("Gabriel");
		p.pushB("Daniel");
		p.pushB("Marcela");
		
		
		JOptionPane.showMessageDialog(null, p.estaCheiaA()); 
		JOptionPane.showMessageDialog(null, p.estaCheiaB()); 
		
		p.mostrarA();
		p.mostrarB();

	    p.popA(); //Retira Bruno da pilha
	    p.popB(); //Retura Marcela da pilha
	    
	    JOptionPane.showMessageDialog(null, p.tamanhoA()); //Retorna o tamanho da pilha A
	    JOptionPane.showMessageDialog(null, p.tamanhoB()); //Retorna o tamanho da pilha B
	    
	    JOptionPane.showMessageDialog(null, p.mostrarTopoA());
	    JOptionPane.showMessageDialog(null, p.mostrarTopoB());
	    
	    p.mostrarA();
	    p.mostrarB();
	}

}
