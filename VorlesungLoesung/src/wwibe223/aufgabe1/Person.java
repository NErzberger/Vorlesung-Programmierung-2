package wwibe223.aufgabe1;

import java.util.Objects;

public abstract class Person {

	private String vorname;
	private String nachname;
	
	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(nachname, other.nachname) && Objects.equals(vorname, other.vorname);
	}
	
	
	
}
