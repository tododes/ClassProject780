package app;

public class LibraryApp {

	public static void main(String[] args) {
		final String application_Name = "Library System version-1.0 ";
		System.out.println(application_Name);
		LibraryControl libraryControl = LibraryControl.getInstance();
		libraryControl.controlLoop();
	}

}
