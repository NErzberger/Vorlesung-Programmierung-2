package wwibe223.aufgabe1;

import java.util.Objects;

public class Student extends Person{

	private String matrikelnummer;
	
	public Student(String vorname, String nachname, String matrikelnummer) {
		super(vorname, nachname);
		this.matrikelnummer = matrikelnummer;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(matrikelnummer, other.matrikelnummer);
	}
	
	
}
