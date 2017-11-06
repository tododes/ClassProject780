package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Periodical;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;
import app.GetOptions;;

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
        GetOptions.Option option = null;
        while (option != GetOptions.Option.EXIT) {
            try {
                printOptions();
                //option = app.GetOptions.Option.createFromInt(dataReader.getInt());
                option = GetOptions.createOptionFromDataReader(dataReader);
                switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_PERIODICAL:
                    addPeriodical();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_PERIODICALS:
                    printPeriodicals();
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
        for(GetOptions.Option o : GetOptions.Option.values()) {
            System.out.println(o);
        }
    }
  
    private void addBook() {
        library.addPublication(dataReader.readBook());
    }
  
    private void printBooks() {
        LibraryUtils.printBooks(library);
    }
  
    private void addPeriodical() {
        library.addPublication(dataReader.readPeriodical());
    }
  
    private void printPeriodicals() {
        LibraryUtils.printPeriodicals(library);
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
    
}
