package ex2;

public class MainEx2 {

	public static void main(String[] args) {
		EDVetorCircularEx2 ed = new EDVetorCircularEx2();

		System.out.println("esta vazia? " + ed.vazia());
		System.out.println("esta cheia? " + ed.cheia());
		ed.enfileira(5);
		ed.enfileira("i");
		ed.enfileira(1.6);
		ed.mostrarEd();
		System.out.println("desenfileirado " + ed.desenfileira());
		System.out.println("desenfileirado " + ed.desenfileira());
		ed.mostrarEd();
		System.out.println("" + ed.pesquisa("i"));
		System.out.println("" + ed.pesquisa(5));
		ed.enfileira("y");
		ed.enfileira(3);
		ed.enfileira(44.8);
		ed.enfileira("tp");
		ed.enfileira(7.0);
		ed.enfileira(2);
		ed.enfileira(88);
		ed.enfileira(93.1);
		ed.enfileira("ea");
		ed.mostrarEd();
		System.out.println("esta cheia? " + ed.cheia());
		System.out.println("cabeca = " + ed.cabeca());
		System.out.println("cauda = " + ed.cauda());
		System.out.println("esta vazia? " + ed.vazia());
	}
}
