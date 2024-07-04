package wwibe223.aufgabe1;

import java.util.ArrayList;

public interface Vorlesung {

	void unterrichten();
	
	void setDozent(Dozent dozent);
	
	void setStudentList(ArrayList<Student> studentList);
}
