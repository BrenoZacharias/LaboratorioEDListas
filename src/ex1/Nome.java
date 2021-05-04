package ex1;

public class Nome {

	private String nome;
	private Nome anterior;
	private Nome proximo;
	
	public Nome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nome getAnterior() {
		return anterior;
	}

	public void setAnterior(Nome anterior) {
		this.anterior = anterior;
	}

	public Nome getProximo() {
		return proximo;
	}

	public void setProximo(Nome proximo) {
		this.proximo = proximo;
	}
}
