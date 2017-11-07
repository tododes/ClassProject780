package Menu;

import LibraryActions.AddPeriodicalbehaviour;
import LibraryActions.AddPublicationBehaviour;
import utils.DataReader;

public class AddPeriodicalMenuItem extends MenuItem {

	public AddPeriodicalMenuItem(int index, String description) {
		super(index, description);
		myBehaviour = new AddPeriodicalbehaviour();
	}

}
