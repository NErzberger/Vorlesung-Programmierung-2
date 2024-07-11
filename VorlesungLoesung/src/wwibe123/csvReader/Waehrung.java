package wwibe123.csvReader;

import java.util.Objects;

public class Waehrung {

	private int nummer;
	private String kuerzel;
	private String bezeichnung;
	private String land;
	
	public Waehrung() {
		
	}

	public Waehrung(int nummer, String kuerzel, String bezeichnung, String land) {
		super();
		this.nummer = nummer;
		this.kuerzel = kuerzel;
		this.bezeichnung = bezeichnung;
		this.land = land;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		return Objects.equals(bezeichnung, other.bezeichnung) && Objects.equals(kuerzel, other.kuerzel)
				&& Objects.equals(land, other.land) && nummer == other.nummer;
	}
	
	public String toString() {
		String result = nummer + "|" + kuerzel + "|" + bezeichnung + "|" + land;
		return result;
	}
}
