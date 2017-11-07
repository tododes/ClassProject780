package Menu;

import LibraryActions.AddUserBehaviour;

public class AddUserMenuItem extends MenuItem {

	public AddUserMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new AddUserBehaviour();
	}
}
