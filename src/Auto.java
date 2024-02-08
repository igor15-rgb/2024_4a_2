/**
 * 
 * @author 4a
 *
 */
public class Auto extends Veicolo {
	private String tipo;
	private final int tariffaG = 10;

	/**
	 * 
	 * @param t    targa
	 * @param m    marca
	 * @param dis  veicolo previsto per disabili
	 * @param cost costo vigilanza
	 * @param tip  tipo auto
	 */
	public Auto(String t, String m, boolean dis, float cost, String tip) {
		super(t, m, dis, cost);
		tipo = tip;

	}

	/**
	 * 	
	 */
	public float getCostoG() {
		return tariffaG - costovig;
	}

	/**
	 * 	
	 */
	public String toString() {
		String s = "VEICOLO: AUTO\n";
		s += super.toString();
		s += "Tipo auto: " + tipo + "\n";
		s += "Tariffa giornarliera: " + tariffaG + "€\n";
		return s;
	}

	public static void main(String[] args) {
		Auto a = new Auto("FA903AZ", "Nissan", true, 45, "Utilitaria");
		System.out.println(a);
	}

}
