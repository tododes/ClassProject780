package utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Menu.MenuItem;
import app.GetOptions;
import data.LibraryUser;
import data.PublicationParameters;


public class DataReader {

	private static DataReader instance;
	
	private final Scanner scanner;
        
        
	private DataReader(){
		scanner = new Scanner(System.in);
	}
	
	public static DataReader getInstance(){
		if(instance == null)
			instance = new DataReader();
		return instance;
	}
	
	public void close(){
		scanner.close();
	}
	
	public int getInt() throws NumberFormatException {
            int number = 0;
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException exception) {
                throw new NumberFormatException("Number entered in incorrect form"+exception);
            } finally {
                scanner.nextLine();
            }
            return number;
        }
	
	public PublicationParameters getUserInputBook() throws InputMismatchException {
            PublicationParameters parameters = new PublicationParameters();
            System.out.println("Title: ");
            parameters.title = scanner.nextLine();
            System.out.println("Author: ");
            parameters.author = scanner.nextLine();
            System.out.println("Publishing house: ");
            parameters.publisher = scanner.nextLine();
            System.out.println("ISBN: ");
            parameters.isbn = scanner.nextLine();
            System.out.println("Publication year: ");
            try {
                parameters.year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Number of pages: ");
                parameters.pages = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                scanner.nextLine();
                throw exception;
            }
 
            return parameters;
        }
	
	public PublicationParameters getUserInputPeriodical() throws InputMismatchException {
            PublicationParameters parameters = new PublicationParameters();
        System.out.println("Title: ");
        parameters.title = scanner.nextLine();
        System.out.println("Publishing house: ");
        parameters.publisher = scanner.nextLine();
        System.out.println("Language: ");
        parameters.language = scanner.nextLine();
        System.out.println("Publication year: ");
        parameters.year = 0;
        parameters.month = 0;
        parameters.day = 0;
        try {
            parameters.year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Publication Month: ");
            parameters.month = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Publication Day: ");
            parameters.day = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.nextLine();
            throw exception;
        }
 
        return parameters;
    }
	
	public LibraryUser readAndCreateLibraryUser() {
        System.out.println("First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Social Security Number, ######### format: ");
        String socialSecurityNumber = scanner.nextLine();
  
        return new LibraryUser(firstName, lastName, socialSecurityNumber);
    }
	
	   public MenuItem getMenuItem() throws NoSuchElementException{
		   MenuItem result = null;
		   try {
               result = GetOptions.getInstance().getMenuItemAt(getInt());
           } catch(ArrayIndexOutOfBoundsException exception) {
               throw new NoSuchElementException("No element specified ID"+exception);
           }
		   return result;
	    }
}
