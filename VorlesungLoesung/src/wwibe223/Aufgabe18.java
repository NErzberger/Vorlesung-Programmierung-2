package wwibe223;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class Aufgabe18 {

	public static void main(String[] args) {
		HashMap<String, String> userMap = loadPasswd();
		
		Scanner sc = new Scanner(System.in);
		
		String user = "";
		String password = "";
		
		while(true) 
		{
			System.out.println("Geben Sie einen Username ein:");
			user = sc.nextLine();
			
			if (user.equals("exit") || user.equals("Ende") || user.equals("q")) {
				System.out.println("Programm wird verlassen...");
				break;				
			}
			
			System.out.println("Geben Sie ein Passwort ein:");
			password = sc.nextLine();
			
			System.out.println("Das Passwort wird gespeichert. \n------------------ \n");
			
			
			
			try {
				password = hashPassword(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			userMap.put(user, password);		
		}		
		
		sc.close();
		
		writePasswd(userMap);
	}
	
	public static HashMap<String, String> loadPasswd(){
		HashMap<String, String> userMap = new HashMap<String, String>(); 
		
		BufferedReader inputReader = null;
		
		
		try {
			//BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(csvFile));
			inputReader = new BufferedReader(new FileReader("passwd"));
			String zeile = null;
			String[] fields = null;
			
			while((zeile = inputReader.readLine()) != null) {
				fields = zeile.split(";");
				userMap.put(fields[0], fields[1]);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(inputReader != null) {
					inputReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return userMap;
	}
	
	public static boolean writePasswd(HashMap<String, String> map) {
		BufferedWriter writer = null;
		
		try {
			writer = new BufferedWriter(new FileWriter("passwd"));
			
			for(String key : map.keySet()) {
				String line = key + ";" + map.get(key) + "\n";
				writer.write(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	public static String hashPassword(String password) throws NoSuchAlgorithmException, IOException  {
		MessageDigest md = MessageDigest.getInstance("SHA-512"); 
		byte[] shaHash = new byte[20];
		md.update(password.getBytes("UTF-8"));
		shaHash = md.digest();
		BigInteger number = new BigInteger(1, shaHash);
		return number.toString(16);
	}
	
	
}
