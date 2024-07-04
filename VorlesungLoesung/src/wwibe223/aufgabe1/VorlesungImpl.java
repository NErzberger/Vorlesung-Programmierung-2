package wwibe223.aufgabe1;

import java.util.ArrayList;

public class VorlesungImpl implements Vorlesung{

	private Dozent dozent;
	
	private ArrayList<Student> studentList;
	
	public VorlesungImpl() {
		
	}
	
	@Override
	public void unterrichten() {
		String text = "Die Vorlesung wird unterrichtet von" + dozent.getVorname() 
			+ " " + dozent.getNachname() + ". In der Vorlesung sind folgende Studenten:\n";
		
		for(int i = 0; i < studentList.size(); i++) {
			text = text + "-" + studentList.get(i).getVorname() + " " + studentList.get(i).getNachname() + "\n";
		}

		System.out.println(text);
	}

	public Dozent getDozent() {
		return dozent;
	}

	public void setDozent(Dozent dozent) {
		this.dozent = dozent;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
