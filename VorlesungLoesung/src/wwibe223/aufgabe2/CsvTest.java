package wwibe223.aufgabe2;

public class CsvTest {

	public static void main(String[] args) {
		CsvReader csvReader = new CsvReader();
		csvReader.readFile();
		for(Waehrung waehrung : csvReader.getWaehrungList()) {
			System.out.println(waehrung);
		}

	}

}
