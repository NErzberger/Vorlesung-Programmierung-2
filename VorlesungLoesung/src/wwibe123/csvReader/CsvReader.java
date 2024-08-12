package wwibe123.csvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import wwibe123.aufgabe4.MyArrayList;

public class CsvReader {

	private File csvFile;
	
	private String splitter;
	
	private List<Waehrung> waehrungList;
	
	public CsvReader(String path) {
		this.waehrungList = new MyArrayList<Waehrung>();
		this.csvFile = new File(path);
		this.splitter = "";
	}
	
	public CsvReader() {
		this.waehrungList = new MyArrayList<Waehrung>();
		this.csvFile = new File("waehrung.csv");
		this.splitter = "\\|";
	}
	
	public boolean readFile() {
		boolean success = true;
		BufferedReader inputReader = null;
		
		if(waehrungList == null) {
			waehrungList = new MyArrayList<Waehrung>();
		}
		
		try {
			inputReader = new BufferedReader(new FileReader(csvFile));
			String zeile = "";
			String data[] = null;
			while((zeile = inputReader.readLine()) != null) {
				data = zeile.split(splitter);
				Waehrung waehrung = new Waehrung();
				waehrung.setNummer(Integer.parseInt(data[0]));
				waehrung.setKuerzel(data[1]);
				waehrung.setBezeichnung(data[2]);
				waehrung.setLand(data[3]);
				waehrungList.add(waehrung);
			}
			inputReader.close();
		} catch (FileNotFoundException e) {
			success = false;
			e.printStackTrace();
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		}
		
		return success;
	}

	public List<Waehrung> getWaehrungList() {
		return waehrungList;
	}

	public void setWaehrungList(List<Waehrung> waehrungList) {
		this.waehrungList = waehrungList;
	}
	
	
}
