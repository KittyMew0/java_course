package geekbrains_course.oop_course.seven_seminar;

import java.io.IOException;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
import java.util.Scanner; 

public class Main{ 
	public static void main(String[] args) throws IOException{ 
		Notebook model = new Notebook(); 
		NotebookView view = new ConsoleNotebookView(); 
		NotebookPresenter presenter = new NotebookPresenter(model, view);
		
		Scanner scanner = new Scanner(System.in); 
		
		while(true){ 
			System.out.println("1.AddNote"); 
			System.out.println("2.ShowNotesforDay"); 
			System.out.println("3.ShowNotesforWeek"); 
			System.out.println("4.SaveNotes"); 
			System.out.println("5.LoadNotes");
			System.out.println("6.Exit"); 
			int choice=scanner.nextInt(); 
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				presenter.addNote();
				break;
			case 2:
				presenter.showNotesForDay();
				break;
			case 3:
				presenter.showNotesForWeek();
				break;
			case 4:
				presenter.saveNotes();
				break;
			case 5:
				presenter.loadNotes();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
		
	}
}
