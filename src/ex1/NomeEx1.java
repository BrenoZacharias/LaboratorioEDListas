package ex1;

public class NomeEx1 {

	private String nome;
	private NomeEx1 anterior;
	private NomeEx1 proximo;
	
	public NomeEx1(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NomeEx1 getAnterior() {
		return anterior;
	}

	public void setAnterior(NomeEx1 anterior) {
		this.anterior = anterior;
	}

	public NomeEx1 getProximo() {
		return proximo;
	}

	public void setProximo(NomeEx1 proximo) {
		this.proximo = proximo;
	}
}
