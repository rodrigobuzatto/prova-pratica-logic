package classes;

import java.util.Comparator;

public abstract class OrdenacaoTransportadoras implements Comparator<Transportadora>{

	public static int comparaPreco(Transportadora t1, Transportadora t2) {
		if(t1.getValor() < t2.getValor()) {
			return -1;
		} else if(t2.getValor() < t1.getValor()) {
			return 1;
		}
		return 0;
	}
	
	public static int comparaTempo(Transportadora t1, Transportadora t2) {
		if(t1.getTempo() < t2.getTempo()) {
			return -1;
		} else if(t2.getTempo() < t1.getTempo()) {
			return 1;
		}
		return 0;
	}	
}