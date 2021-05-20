package ex2;

import javax.swing.JOptionPane;

public class EDVetorCircularEx2 {
	Object ed[];
	int frente;
	int fim;
	int tamanho;

	public EDVetorCircularEx2() {
		ed = new Object[10];
		frente = -1;
		fim = -1;
	}

	public void enfileira(Object obj) {
		if (!cheia()) {
			fim++;
			if (tamanho == 0) {
				ed[fim] = obj;
			} else {
				ed[fim] = obj;
				frente = fim;
			}
			tamanho++;
		} else {
				JOptionPane.showMessageDialog(null, "Está cheia");
		}
	}

	public Object desenfileira() {
		if (!vazia()) {
			int aux = fim;
			if (tamanho == 2) {
				fim--;
				frente = -1;
			} else {
				fim--;
				frente = fim;
			}
			tamanho--;
			return ed[aux];
		} else{
			JOptionPane.showMessageDialog(null, "Está vazia");
			return "Está vazia";
		}
	}

	public Object cabeca() {
		if (!vazia())
			return ed[0];
		return "Está vazia";
	}

	public Object cauda() {
		if (!vazia())
			return ed[fim];
		return "Está vazia";
	}

	public void mostrarEd() {
		if (!vazia()) {
			for (int i = fim; i >= 0; i--) {
				System.out.println("" + ed[i]);
			}
		} else {
			System.out.println("Está vazia");
		}
	}

	public boolean pesquisa(Object obj) {
		if (!vazia()) {
			for (int i = 0; i <= fim; i++) {
				if (toString(ed[i]).equals(toString(obj))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean vazia() {
		if (tamanho == 0)
			return true;
		return false;
	}

	public boolean cheia() {
		if (tamanho == ed.length)
			return true;
		return false;
	}

	public String toString(Object obj) {
		return obj + "";
	}
}
