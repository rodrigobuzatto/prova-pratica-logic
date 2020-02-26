package classes;

public class OrdenacaoPorTempo extends OrdenacaoTransportadoras{

	@Override
	public int compare(Transportadora t1, Transportadora t2) {
		return super.comparaTempo(t1, t2);
	}

}
