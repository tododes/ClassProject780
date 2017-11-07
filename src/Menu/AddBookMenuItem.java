package Menu;

import LibraryActions.AddBookBehaviour;
import LibraryActions.AddPublicationBehaviour;
import LibraryActions.AddUserBehaviour;
import utils.DataReader;

public class AddBookMenuItem extends MenuItem {

	public AddBookMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new AddBookBehaviour();
	}

}
