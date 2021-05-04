package ex1;

public class ED {

	private final Letra vetorLetra[] = new Letra[26];
	private Nome vetorFim[] = new Nome[26];
	private int qntd;

	public ED() {
		for (int i = 0; i < vetorLetra.length; i++) {
			vetorLetra[i] = new Letra();
		}
		vetorLetra[0].letra = 'A';
		vetorLetra[1].letra = 'B';
		vetorLetra[2].letra = 'C';
		vetorLetra[3].letra = 'D';
		vetorLetra[4].letra = 'E';
		vetorLetra[5].letra = 'F';
		vetorLetra[6].letra = 'G';
		vetorLetra[7].letra = 'H';
		vetorLetra[8].letra = 'I';
		vetorLetra[9].letra = 'J';
		vetorLetra[10].letra = 'K';
		vetorLetra[11].letra = 'L';
		vetorLetra[12].letra = 'M';
		vetorLetra[13].letra = 'N';
		vetorLetra[14].letra = 'O';
		vetorLetra[15].letra = 'P';
		vetorLetra[16].letra = 'Q';
		vetorLetra[17].letra = 'R';
		vetorLetra[18].letra = 'S';
		vetorLetra[19].letra = 'T';
		vetorLetra[20].letra = 'U';
		vetorLetra[21].letra = 'V';
		vetorLetra[22].letra = 'W';
		vetorLetra[23].letra = 'X';
		vetorLetra[24].letra = 'Y';
		vetorLetra[25].letra = 'Z';
	}

	public int indice(String nome) {
		for (int i = 0; i < vetorLetra.length; i++) {
			if (nome.toUpperCase().charAt(0) == vetorLetra[i].letra) {
				return i;
			}
		}
		return -1;
	}

	private boolean auxGetProximoEmaior(Nome name, Nome aux) {
		if ((name.getNome().toUpperCase().charAt(1) == aux.getNome().toUpperCase().charAt(1))) {
			int limiteNome = name.getNome().length();
			int limiteAux = aux.getNome().length();
			int limiteMenor;
			if (limiteNome < limiteAux) {
				limiteMenor = limiteNome;
			} else {
				limiteMenor = limiteAux;
			}
			for (int c = 1; c < limiteMenor; c++) {
				if ((name.getNome().toUpperCase().charAt(c) == aux.getNome().toUpperCase().charAt(c))
						&& (c + 1 == limiteMenor)) {
					if (limiteNome == limiteMenor) {
						return true;
					} else {
						return false;
					}
				} else if (name.getNome().toUpperCase().charAt(c) != aux.getNome().toUpperCase().charAt(c)) {
					int indiceNome = -1;
					int indiceAux = -1;
					for (int j = 0; j < vetorLetra.length; j++) {
						if (name.getNome().toUpperCase().charAt(c) == vetorLetra[j].letra) {
							indiceNome = j;
						}
						if (aux.getNome().toUpperCase().charAt(c) == vetorLetra[j].letra) {
							indiceAux = j;
						}
						if ((indiceNome != -1) && (indiceAux != -1)) {
							j = vetorLetra.length;
						}
					}
					if (indiceNome < indiceAux) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void adicionar(String nome) {
		Nome name = new Nome(nome);
		int indice = indice(nome);
		if (vetorLetra[indice].prox == null) {
			vetorLetra[indice].prox = new Nome(nome);
			vetorFim[indice] = new Nome(nome);
		} else {
			Nome aux = vetorLetra[indice].prox;
			int f = 0;
			while ((aux != null) && (f != 1)) {
				if ((nome.toUpperCase().charAt(1) == aux.getNome().toUpperCase().charAt(1))) {
					int limiteNome = nome.length();
					int limiteAux = aux.getNome().length();
					int limiteMenor;
					if (limiteNome < limiteAux) {
						limiteMenor = limiteNome;
					} else {
						limiteMenor = limiteAux;
					}
					for (int c = 1; c < limiteMenor; c++) {
						if (((nome.toUpperCase().charAt(c) == aux.getNome().toUpperCase().charAt(c))
								&& (c + 1 == limiteMenor))
								&& ((aux.getProximo().getNome().toUpperCase().charAt(1) != nome.toUpperCase().charAt(1)
										|| (aux.getProximo() == null))
										|| (auxGetProximoEmaior(name, aux.getProximo()) == true))) {
							if (limiteNome == limiteMenor) {
								if (aux.getNome().toUpperCase()
										.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
									name.setProximo(vetorLetra[indice].prox);
									vetorLetra[indice].prox.setAnterior(name);
									vetorLetra[indice].prox = name;
									f = 1;
									c = limiteMenor;
								} else if (aux.getNome().toUpperCase()
										.equals(vetorFim[indice].getNome().toUpperCase())) {
									vetorFim[indice].getAnterior().setProximo(name);
									name.setAnterior(vetorFim[indice].getAnterior());
									name.setProximo(vetorFim[indice]);
									vetorFim[indice].setAnterior(name);
									f = 1;
									c = limiteMenor;
								} else {
									name.setAnterior(aux.getAnterior());
									aux.getAnterior().setProximo(name);
									name.setProximo(aux);
									aux.setAnterior(name);
									f = 1;
									c = limiteMenor;
								}
							} else {
								if (aux.getNome().toUpperCase()
										.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
									name.setProximo(vetorLetra[indice].prox.getProximo());
									vetorLetra[indice].prox.getProximo().setAnterior(name);
									name.setAnterior(vetorLetra[indice].prox);
									vetorLetra[indice].prox.setProximo(name);
									f = 1;
									c = limiteMenor;
								} else if (aux.getNome().toUpperCase()
										.equals(vetorFim[indice].getNome().toUpperCase())) {
									vetorFim[indice].setProximo(name);
									name.setAnterior(vetorFim[indice]);
									vetorFim[indice] = name;
									f = 1;
									c = limiteMenor;
								} else {
									name.setProximo(aux.getProximo());
									aux.getProximo().setAnterior(name);
									name.setAnterior(aux);
									aux.setProximo(name);
									f = 1;
									c = limiteMenor;
								}
							}
						} else if (nome.toUpperCase().charAt(c) != aux.getNome().toUpperCase().charAt(c)) {
							int indiceNome = -1;
							int indiceAux = -1;
							for (int j = 0; j < vetorLetra.length; j++) {
								if (nome.toUpperCase().charAt(c) == vetorLetra[j].letra) {
									indiceNome = j;
								}
								if (aux.getNome().toUpperCase().charAt(c) == vetorLetra[j].letra) {
									indiceAux = j;
								}
								if ((indiceNome != -1) && (indiceAux != -1)) {
									j = vetorLetra.length;
								}
							}
							if (indiceNome < indiceAux) {
								if (aux.getNome().toUpperCase()
										.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
									name.setProximo(vetorLetra[indice].prox);
									vetorLetra[indice].prox.setAnterior(name);
									vetorLetra[indice].prox = name;
									f = 1;
									c = limiteMenor;
								} else if (aux.getNome().toUpperCase()
										.equals(vetorFim[indice].getNome().toUpperCase())) {
									vetorFim[indice].getAnterior().setProximo(name);
									name.setAnterior(vetorFim[indice].getAnterior());
									name.setProximo(vetorFim[indice]);
									vetorFim[indice].setAnterior(name);
									f = 1;
									c = limiteMenor;
								} else {
									name.setAnterior(aux.getAnterior());
									aux.getAnterior().setProximo(name);
									name.setProximo(aux);
									aux.setAnterior(name);
									f = 1;
									c = limiteMenor;
								}
							} else {
								c = limiteMenor;
							}
						}
					}
				} else {
					int indice2aLetraInicio = -1;
					int indice2aLetraAux = -1;
					int indice2aLetraAuxgetP = -1;
					int indice2aLetraName = -1;
					for (int k = 0; k < vetorLetra.length; k++) {
						if (nome.toUpperCase().charAt(1) == vetorLetra[k].letra) {
							indice2aLetraName = k;
						}
						if (aux.getNome().toUpperCase().charAt(1) == vetorLetra[k].letra) {
							indice2aLetraAux = k;
						}
						if (vetorLetra[indice].prox.getNome().toUpperCase().charAt(1) == vetorLetra[k].letra) {
							indice2aLetraInicio = k;
						}
						if (aux.getProximo() != null) {
							if (aux.getProximo().getNome().toUpperCase().charAt(1) == vetorLetra[k].letra) {
								indice2aLetraAuxgetP = k;
							}
						}
					}
					if (indice2aLetraName < indice2aLetraAux) {
						if (aux.getNome().toUpperCase().equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
							name.setProximo(vetorLetra[indice].prox);
							vetorLetra[indice].prox.setAnterior(name);
							vetorLetra[indice].prox = name;
							f = 1;
						} else if (aux.getNome().toUpperCase().equals(vetorFim[indice].getNome().toUpperCase())) {
							vetorFim[indice].getAnterior().setProximo(name);
							name.setAnterior(vetorFim[indice].getAnterior());
							name.setProximo(vetorFim[indice]);
							vetorFim[indice].setAnterior(name);
							f = 1;
						} else {
							name.setAnterior(aux.getAnterior());
							aux.getAnterior().setProximo(name);
							name.setProximo(aux);
							aux.setAnterior(name);
							f = 1;
						}
					}
					if ((indice2aLetraName > indice2aLetraAux)
							&& ((indice2aLetraName < indice2aLetraAuxgetP) || (aux.getProximo() == null))) {
						if (aux.getProximo() == null) {
							name.setAnterior(vetorFim[indice]);
							vetorFim[indice].setProximo(name);
							vetorFim[indice] = name;
							f = 1;
						} else if (aux.getNome().toUpperCase()
								.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
							name.setProximo(vetorLetra[indice].prox.getProximo());
							name.setAnterior(vetorLetra[indice].prox);
							vetorLetra[indice].prox.setProximo(name);
							f = 1;
						} else {
							name.setProximo(aux.getProximo());
							aux.getProximo().setAnterior(name);
							name.setAnterior(aux);
							aux.setProximo(name);
							f = 1;
						}
					}
				}
				if (qntd == 1) {
					vetorLetra[indice].prox.setProximo(vetorFim[indice]);
					vetorFim[indice].setAnterior(vetorLetra[indice].prox);
				}
				aux = aux.getProximo();
			}
		}
		qntd++;
	}

	public boolean pesquisa(String nome) {
		boolean situacao = estaVazia();
		if (situacao == false) {
			int indice = indice(nome);
			Nome aux = vetorLetra[indice].prox;
			while (aux != null) {
				if (nome.toUpperCase().equals(aux.getNome().toUpperCase())) {
					return true;
				}
				aux = aux.getProximo();
			}
		} else {
			System.out.println("impossível pesquisar pois a estrutura de dados está vazia");
		}
		return false;
	}

	public void excluir(String nome) {
		boolean situacao = estaVazia();
		if (situacao == false) {
			boolean verifica = pesquisa(nome);
			if (verifica == true) {
				int indice = indice(nome);
				Nome aux = vetorLetra[indice].prox;
				int f = 0;
				while (f != 1) {
					if (nome.toUpperCase().equals(aux.getNome().toUpperCase())) {
						if (vetorFim[indice].getNome().toUpperCase()
								.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
							vetorLetra[indice].prox = null;
							vetorFim[indice] = vetorLetra[indice].prox;
							f = 1;
						} else if (aux.getNome().toUpperCase()
								.equals(vetorLetra[indice].prox.getNome().toUpperCase())) {
							vetorLetra[indice].prox = aux.getProximo();
							vetorLetra[indice].prox.setAnterior(null);
							f = 1;
						} else if (aux.getNome().toUpperCase().equals(vetorFim[indice].getNome().toUpperCase())) {
							vetorFim[indice] = aux.getAnterior();
							vetorFim[indice].setProximo(null);
							f = 1;
						} else {
							aux.getAnterior().setProximo(aux.getProximo());
							aux.getProximo().setAnterior(aux.getAnterior());
							f = 1;
						}
					}
					if (f == 0) {
						aux = aux.getProximo();
					}
				}
				qntd--;
			} else {
				System.out.println("impossível excluir pois o nome não existe na estrutura de dados");
			}
		} else {
			System.out.println("impossível excluir pois a estrutura de dados está vazia");
		}
	}

	public void renomear(String nomeAtual, String Renomeio) {
		boolean situacao = estaVazia();
		if (situacao == false) {
			boolean verifica = pesquisa(nomeAtual);
			if (verifica == true) {
				excluir(nomeAtual);
				adicionar(Renomeio);
			} else {
				System.out.println("impossível renomear pois o nome não existe na estrutura de dados");
			}
		} else {
			System.out.println("impossível renomear pois a estrutura de dados está vazia");
		}
	}

	public boolean estaVazia() {
		if (qntd == 0)
			return true;
		return false;
	}

	public int getQntd() {
		return qntd;
	}

	public void mostrarNomesDeUmaLetra(String letra) {
		boolean situacao = estaVazia();
		if (situacao == false) {
			int indice = -1;
			for (int i = 0; i < vetorLetra.length; i++) {
				if (letra.toUpperCase().charAt(0) == vetorLetra[i].letra) {
					indice = i;
				}
			}
			Nome aux = vetorLetra[indice].prox;
			while (aux != null) {
				System.out.println(aux.getNome());
				aux = aux.getProximo();
			}
		}

	}
}
