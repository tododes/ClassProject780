package Menu;

import LibraryActions.PrintBookBehaviour;

public class PrintBookMenuItem extends MenuItem {

	public PrintBookMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new PrintBookBehaviour();
	}

}
