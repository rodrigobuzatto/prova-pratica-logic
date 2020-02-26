package classes;

public class OrdenacaoPorPreco extends OrdenacaoTransportadoras{

	@Override
	public int compare(Transportadora t1, Transportadora t2) {
		return super.comparaPreco(t1, t2);
	}

}
