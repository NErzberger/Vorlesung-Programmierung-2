package wwibe223.aufgabe1;

import java.util.Objects;

public class Dozent extends Person{

	private String spezialisierung;
	
	public Dozent(String vorname, String nachname, String spezialisierung) {
		super(vorname, nachname);
		this.spezialisierung = spezialisierung;
	}

	public String getSpezialisierung() {
		return spezialisierung;
	}

	public void setSpezialisierung(String spezialisierung) {
		this.spezialisierung = spezialisierung;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dozent other = (Dozent) obj;
		return Objects.equals(spezialisierung, other.spezialisierung);
	}

	
}
