package classes;

public abstract class Utils {
	public static double precoFinal(int km, double preco) {
		return ((km * preco) / 10);
	}
	
	public static int converteTempo(double tempo) {
		final int horas = (int) tempo;
		final int minutos = (int)Math.round((tempo - (int)tempo) * 100);
		return (int) ((horas * 60) + minutos);
	}	
}
