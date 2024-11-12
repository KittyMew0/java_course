package geekbrains_course.oop_course.seven_seminar;

import java.time.LocalDateTime; 
import java.util.List; 

public interface NotebookView{ 
	void showNotes(List<Note> notes); 
	void showMessage(String message); 
	LocalDateTime getDateTimeInput(); 
	String getDescriptionInput(); 
	String getFileNameInput(); 
}