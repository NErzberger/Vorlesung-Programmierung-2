package wwibe123.aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		Dozent dozent = new Dozent("Ralf", "Müller", "Informatik");
		
		Student student1 = new Student("Max", "Müller", "1001");
		Student student2 = new Student("Pauline", "Schulz", "1002");
		Student student3 = new Student("Elias", "Fischer", "1003");
		Student student4 = new Student("Miachael", "Schreiner", "1004");
		Student student5 = new Student("Victoria", "Schmied", "1005");

		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		
		Vorlesung vorlesung = new VorlesungImpl();
		vorlesung.setDozent(dozent);
		vorlesung.setStudentList(studentList);
		
		vorlesung.unterrichten();
	}

}
