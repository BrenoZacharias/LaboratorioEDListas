package ex1;

public class Main {

	public static void main(String[] args) {
	ED ed = new ED();
	
	System.out.println(ed.indice("o"));
	System.out.println(ed.estaVazia());
	ed.adicionar("carol");
	ed.excluir("carol");
	ed.adicionar("carlos");
	ed.adicionar("caio");
	ed.adicionar("celia");
	ed.adicionar("ca");
	ed.adicionar("cz");
	ed.adicionar("cicero");
	ed.mostrarNomesDeUmaLetra("c");
	ed.excluir("caio");
	ed.mostrarNomesDeUmaLetra("c");
	ed.excluir("cz");
	ed.mostrarNomesDeUmaLetra("c");
	ed.adicionar("car");
	ed.adicionar("camila");
	ed.renomear("cicero", "cassio");
	ed.mostrarNomesDeUmaLetra("c");
	System.out.println(ed.getQntd());
	System.out.println(ed.estaVazia());
	}
}