package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.LibraryUser;
import data.Periodical;

public class DataReader {

	private Scanner scanner;	
	
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
	
	public Book readAndCreateBook() throws InputMismatchException {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Publishing house: ");
        String publisher = scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Publication year: ");
        int releaseDate = 0;
        int pages = 0;
        try {
            releaseDate = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Number of pages: ");
            pages = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.nextLine();
            throw exception;
        }
 
        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }
	
	public Periodical readAndCreatePeriodical() throws InputMismatchException {
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Publishing house: ");
        String publisher = scanner.nextLine();
        System.out.println("Language: ");
        String language = scanner.nextLine();
        System.out.println("Publication year: ");
        int year = 0;
        int month = 0;
        int day = 0;
        try {
            year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Publication Month: ");
            month = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Publication Day: ");
            day = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException exception) {
            scanner.nextLine();
            throw exception;
        }
 
        return new Periodical(title, publisher, language, year, month, day);
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
}
