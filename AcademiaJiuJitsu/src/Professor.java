
public class Professor extends Praticante_Jiu_Jitsu {
	
	double valorAula;
	int quantidadeAulasMes;
	
	public Professor(String nome,String faixa, int quantidadeGraus, double valor_aula) {
		super(nome,faixa,quantidadeGraus);
		this.valorAula = valor_aula;
		quantidadeAulasMes = 0;
	}

	public double getValorAula() {
		return valorAula;
	}

	public void setValorAula(double valorAula) {
		this.valorAula = valorAula;
	}

	public int getQuantidadeAulas() {
		return quantidadeAulasMes;
	}

	public void setQuantidadeAulas(int quantidadeAulasMes) {
		this.quantidadeAulasMes = quantidadeAulasMes;
	}
	
	public double getSalario() {
		return valorAula * quantidadeAulasMes;
	}
	
	@Override
	public String toString() {
		return nome + ", faixa " + faixa  + " com " +quantidadeGraus + " graus"+  ", Salario do mês: " + getSalario() + "\n";
	}

}
