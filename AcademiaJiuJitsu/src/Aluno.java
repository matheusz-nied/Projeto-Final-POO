
public class Aluno extends Praticante_Jiu_Jitsu {
	
	boolean mensalidadeVigente;

	public Aluno(String nome, String faixa, int quantidadeGraus) {
		super(nome, faixa,quantidadeGraus);
		this.mensalidadeVigente = true;
	}

	public boolean isMensalidade_vigente() {
		return mensalidadeVigente;
	}

	public void setMensalidade_vigente(boolean mudaStatusMensalidade) throws MensalidadePagaException {
		if(this.mensalidadeVigente && mudaStatusMensalidade) {
			throw new MensalidadePagaException("Mensalidade já paga");
		} else {			
			this.mensalidadeVigente = mensalidadeVigente;
		}
			
	}
	
	
	@Override
	public String toString() {
		return nome + ", faixa " + faixa  + " com " +quantidadeGraus + " graus"+ ", status mensalidade: " + mensalidadeVigente  + "\n";
	}
}
