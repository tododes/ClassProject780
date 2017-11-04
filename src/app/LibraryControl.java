package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

public class LibraryControl {

	private static LibraryControl instance;

	private DataReader dataReader;
	private FileManager fileManager;
	
	private Library library;
	
	private LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        library = Library.getInstanceFromSaveFile();
		System.out.println("Data loaded from the file ");
    }

    public static LibraryControl getInstance(){
    	if(instance == null)
    		instance = new LibraryControl();
    	return instance;
    }

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case EXIT:
                    exit();
                }
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect data entered, no publication added."+exception);
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("The selected option does not exist, select again:");
            }
        }

        dataReader.close();
    }
	
	private void printOptions() {
        System.out.println("Select an option:  ");
        for(Option o : Option.values()) {
            System.out.println(o);
        }
    }
  
    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
  
    private void printBooks() {
        LibraryUtils.printBooks(library);
    }
  
    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }
  
    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }
    
    private void addUser() {
        LibraryUser user = dataReader.readAndCreateLibraryUser();
        library.addUser(user);
    }
     
    private void printUsers() {
        LibraryUtils.printUsers(library);
    }
    
    private void exit() {
        fileManager.writeLibraryToFile(library);
    }
    
    private enum Option {
      	EXIT(0, "Exit program"),
        ADD_BOOK(1, "Add a book"),
        ADD_MAGAZINE(2,"Adding a magazine / newspaper"),
        PRINT_BOOKS(3, "View available books"),
        PRINT_MAGAZINES(4, "Display of available magazines / newspapers"),
        ADD_USER(5, "Add a new user"),
        PRINT_USERS(6, "Display the list of users");
      
        private int value;
        private String description_magazine;
      
        Option(int value, String description) {
            this.value = value;
            this.description_magazine = description;
        }
          
        @Override
        public String toString() {
            return value + " - " + description_magazine;
        }
          
        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch(ArrayIndexOutOfBoundsException exception) {
                throw new NoSuchElementException("No element specified ID"+exception);
            }
              
            return result;
        }
    }
}
