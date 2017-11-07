package LibraryActions;

import data.Library;
import utils.LibraryUtils;

public class PrintUserBehaviour extends LibraryBehaviour {
	
	public PrintUserBehaviour() {
		super();
	}

	@Override
	public void execute() {
		LibraryUtils.printUsers(library);
	}

}
