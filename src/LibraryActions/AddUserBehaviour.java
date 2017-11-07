package LibraryActions;

import data.Library;
import data.LibraryUser;
import utils.DataReader;

public class AddUserBehaviour extends LibraryBehaviour {
	
	private LibraryUser libraryUser;
	
	public AddUserBehaviour(){
		super();
	}

	@Override
	public void execute() {
		libraryUser = DataReader.getInstance().readAndCreateLibraryUser();
		library.addUser(libraryUser);
	}

}
