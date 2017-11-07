package Menu;

import LibraryActions.ExitBehaviour;

public class ExitMenuItem extends MenuItem {

	public ExitMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new ExitBehaviour();
	}

}
