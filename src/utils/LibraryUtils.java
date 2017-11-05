package utils;



import data.Book;
import data.Library;
import data.Periodical;

public class LibraryUtils {

	public static void printBooks(Library library) {
		printPublications(library, Book.class);
    }
     
    public static void printPeriodicals(Library library) {
    	printPublications(library, Periodical.class);
    }
    
    private static void printPublications(Library library, Class<?> cl) {
    	long countPublications = library.getPublications().values().stream()
    			.filter(cl::isInstance).sorted(new Library.AlphabeticalComparator())
    			.peek(System.out::println).count();
    	if(countPublications == 0) {
    		System.out.println("No type publication was found in the library: " + cl.getSimpleName());
    	}
    }
    
    public static void printUsers(Library library) {
    	library.getUsers().values().stream()
    				.sorted((a,b) -> a.getLastName().compareTo(b.getLastName()))
    				.forEach(System.out::println);
    }
}
