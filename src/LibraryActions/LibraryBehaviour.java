package LibraryActions;

import data.Library;

public abstract class LibraryBehaviour {
	
	protected Library library;
	
	public LibraryBehaviour(){
		library = Library.getInstance();
	}
	
	public abstract void execute();
}
