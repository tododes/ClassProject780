package utils;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import app.GetOptions.Option;
import data.LibraryUser;
import data.PublicationParameters;
import data.PublicationFactory;
import data.Publication;

public class DataReader {

	private Scanner scanner;
	PublicationParameters parameters = new PublicationParameters();
        PublicationFactory factory = new PublicationFactory();
        
	public DataReader(){
		scanner = new Scanner(System.in);
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
	
	public Publication readBook() throws InputMismatchException {
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
 
            return factory.getPublication("Book",parameters);
        }
	
	public Publication readPeriodical() throws InputMismatchException {

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
 
        return factory.getPublication("Periodical",parameters);
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
	
	   public Option createOption() throws NoSuchElementException{
	    	  Option result = null;
	          try {
	              result = Option.values()[getInt()];
	          } catch(ArrayIndexOutOfBoundsException exception) {
	              throw new NoSuchElementException("No element specified ID"+exception);
	          }
	          return result;
	    }
}
