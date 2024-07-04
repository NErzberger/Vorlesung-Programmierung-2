package wwibe223.aufgabe1;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {
		Dozent d1 = new Dozent("Max", "Mustermann", "Programmierung");
		
		Student s1 = new Student("Max", "Müller", "1001");
		Student s2 = new Student("Pauline", "Schulz", "1001");
		Student s3 = new Student("Elias", "Fischer", "1001");
		Student s4 = new Student("Michael", "Schreiner", "1001");
		Student s5 = new Student("Victoria", "Schied", "1001");
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		Vorlesung vorlesung = new VorlesungImpl();
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		
		vorlesung.setDozent(d1);
		
		vorlesung.setStudentList(studentList);
		
		vorlesung.unterrichten();
	}
}
