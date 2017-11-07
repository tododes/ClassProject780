package Menu;

import LibraryActions.PrintUserBehaviour;

public class PrintUserMenuItem extends MenuItem {

	public PrintUserMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new PrintUserBehaviour();
	}

}
