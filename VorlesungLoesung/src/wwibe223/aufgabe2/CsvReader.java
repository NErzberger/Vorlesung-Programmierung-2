package wwibe223.aufgabe2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import wwibe223.aufgabe4.MyArrayList;

public class CsvReader {

	private File csvFile;
	
	private String splitter;
	
	private List<Waehrung> waehrungList;
	
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
			
			String zeile = null;
			while((zeile = inputReader.readLine()) != null) {
				Waehrung waehrung = mapLineToWaehrung(zeile);
				waehrungList.add(waehrung);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			success = false;
		}catch(IOException e) {
			e.printStackTrace();
			success = false;
		}finally {
			try {
				inputReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
	private Waehrung mapLineToWaehrung(String zeile) {
		String data[] = zeile.split(splitter);
		Waehrung waehrung = new Waehrung();
		waehrung.setNummer(Integer.parseInt(data[0]));
		waehrung.setKuerzel(data[1]);
		waehrung.setBezeichnung(data[2]);
		waehrung.setLand(data[3]);
		return waehrung;
	}

	public List<Waehrung> getWaehrungList() {
		return waehrungList;
	}

	public void setWaehrungList(List<Waehrung> waehrungList) {
		this.waehrungList = waehrungList;
	}
	
	
}
