package Menu;

import LibraryActions.PrintPeriodicalBehaviour;

public class PrintPeriodicalMenuItem extends MenuItem {

	public PrintPeriodicalMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new PrintPeriodicalBehaviour();
	}

}
