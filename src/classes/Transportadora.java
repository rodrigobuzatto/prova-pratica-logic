package classes;

public class Transportadora{
	private int idTipoTransporte;
	private double valor;
	private double tempo;
	
	public Transportadora(int idTipoTransporte, double valor, double tempo) {
		this.idTipoTransporte = idTipoTransporte;
		this.valor = valor;
		this.tempo = tempo;
	}

	protected int getIdTipoTransporte() {
		return idTipoTransporte;
	}
	
	protected double getValor() {
		return valor;
	}
	
	protected double getTempo() {
		return tempo;
	}	

	@Override
	public String toString() {
		return "Transportadora [idTipoTransporte=" + idTipoTransporte + ", valor=" + valor + ", tempo=" + tempo + "]";
	}
}
