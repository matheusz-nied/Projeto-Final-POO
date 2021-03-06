import java.io.Serializable;

public abstract class Praticante_Jiu_Jitsu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String nome;
	protected String faixa;
	protected int quantidadeGraus;

	public Praticante_Jiu_Jitsu(String nome, String faixa, int quantidadeGraus) {
		this.nome = nome;
		this.faixa = faixa;
		this.quantidadeGraus = quantidadeGraus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFaixa() {
		return faixa;
	}

	public void graduaAluno() {
		quantidadeGraus = 0;
		if(this.faixa == "Branca") {
			this.faixa = "Azul";

		} else if (this.faixa == "Azul") {
			this.faixa = "Roxa";

		}else if (this.faixa == "Roxa") {
			this.faixa = "Marrom";

		}else if (this.faixa == "Marrom") {
			this.faixa = "Preta";

		}else if (this.faixa == "Preta") {
			this.faixa = "Coral";

		}else {
			return;
		}
		

	}

	public int getQuantidade_graus() {
		return quantidadeGraus;
	}

	public void aumentaQuantidadeGraus() {
		if (quantidadeGraus == 4 && this.faixa != "Preta") {
			graduaAluno();
		} else if (this.faixa == "Preta" && quantidadeGraus == 10) {
			graduaAluno();
		} else {
			quantidadeGraus += 1;
		}
	}

}
