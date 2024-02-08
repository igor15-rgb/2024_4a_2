/**
 * 
 * @author 4a
 *
 */
public class Parcheggio {

	private String indirizzo;
	// private int maxCap;
	private int nVeicoli;
	private Veicolo[] veicoli;

	/**
	 * 
	 * @param ind  indirizzo
	 * @param mxC  capienza massima parcheggio
	 * @param cost costo
	 */
	public Parcheggio(String ind, int mxC, float cost) {
		indirizzo = ind;
		// maxCap = mxC;
		nVeicoli = 0;
		veicoli = new Veicolo[mxC];

	}

	/**
	 * 
	 * @param v oggetto di tipo veicolo
	 * @return valore boolean
	 */
	public boolean addVeicolo(Veicolo v) {
		if (nVeicoli < veicoli.length) {
			veicoli[nVeicoli++] = v;
			return true;

		}
		return false;
	}

	/**
	 * 
	 * @param t targa veicolo
	 * @return valore boolean
	 */
	public boolean removeVeicolo(String t) {
		for (int i = 0; i < nVeicoli; i++) {
			if (veicoli[i] != null)
				if (t.equalsIgnoreCase(veicoli[i].targa)) {
					veicoli[i] = null;
					return true;

				}
		}

		return false;
	}

	/**
	 * 
	 * @param t  targa veicolo
	 * @param nM nuova marca
	 * @return valore boolean
	 */
	public boolean modMarca(String t, String nM) {
		for (int i = 0; i < nVeicoli; i++) {
			if (veicoli[i] != null)
				if (t.equalsIgnoreCase(veicoli[i].targa)) {
					veicoli[i].setMarca(nM);
					return true;
				}
		}
		return false;
	}

	/**
	 * 
	 * @return gaudagno
	 */
	public float visGuadagno() {
		float contat = 0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null) {
				contat += veicoli[i].getCostoG();
			}
		return contat;
	}

	/**
	 * 
	 * @return vettore di oggetti moto
	 */
	public Veicolo[] visMotoSup() {
		int contamot = 0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null)
				if (veicoli[i] instanceof Moto) {
					Moto moto = (Moto) veicoli[i];
					if (moto.getNRuote() > 2)
						contamot++;
				}

		Veicolo[] motopiuruote = new Veicolo[contamot];
		int id = 0;
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null)
				if (veicoli[i] instanceof Moto) {
					Moto moto = (Moto) veicoli[i];
					if (moto.getNRuote() > 2)
						motopiuruote[id++] = veicoli[i];

				}

		return motopiuruote;

	}

	/**
	 * 
	 */
	public String toString() {
		String s = "Parcheggio in via: " + indirizzo + "\n";
		s += "Capienza massima: " + veicoli.length + "\n";
		s += "Veicoli presenti: " + "\n";
		for (int i = 0; i < nVeicoli; i++)
			if (veicoli[i] != null)
				s += veicoli[i] + "\n";
		return s;
	}

	public static void main(String[] args) {
		Parcheggio p = new Parcheggio("Via Taranto,59", 3, 2);

		Auto a = new Auto("FA903AZ", "Nissan", true, 2, "Utilitaria");

		Moto m = new Moto("AY0231AB", "KTM", false, 2, 3);

		Auto ab = new Auto("TA903AZa", "AUTO2", false, 2, "SUV");

		Moto m1 = new Moto("xY0231AB", "SC", false, 2, 4);

		System.out.println(p.addVeicolo(a));
		System.out.println(p.addVeicolo(m));
		System.out.println(p.addVeicolo(ab));
		System.out.println(p.addVeicolo(m1));

		System.out.println(p);

		System.out.println("Guadagno giornaliero affitto: " + p.visGuadagno() + "\n");

		// System.out.println(p.removeVeicolo("FA903AZ"));
		System.out.println(p.modMarca("AY0231AB", "MERCEDES"));

		System.out.println(p);

		System.out.println("Guadagno giornaliero affitto: " + p.visGuadagno() + "\n");

		Veicolo[] motopiur = p.visMotoSup();

		System.out.println("Moto con numero di ruote maggiore di 2: \n");
		for (Veicolo moto : motopiur) {
			System.out.println(moto);
		}

	}

}
