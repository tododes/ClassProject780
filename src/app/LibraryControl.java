package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import Menu.AddBookMenuItem;
import Menu.MenuItem;
import Menu.NullMenuItem;
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
	private GetOptions options;
	
	private LibraryControl() {
        dataReader = DataReader.getInstance();
        fileManager = FileManager.getInstance();
        library = Library.getInstanceFromSaveFile();
        options = GetOptions.getInstance();
    }

    public static LibraryControl getInstance(){
    	if(instance == null)
    		instance = new LibraryControl();
    	return instance;
    }

    public void controlLoop() {
        MenuItem currentMenuItem = new NullMenuItem();
        while (currentMenuItem.getIndex() != 0){
            try {
                printOptions();
                currentMenuItem = dataReader.getMenuItem();
                currentMenuItem.OnSelected();
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
        options.printOptions();
    }
}
