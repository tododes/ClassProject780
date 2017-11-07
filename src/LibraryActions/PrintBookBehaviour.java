package LibraryActions;

import utils.LibraryUtils;

public class PrintBookBehaviour extends LibraryBehaviour {

	public PrintBookBehaviour() {
		super();
	}

	@Override
	public void execute() {
		LibraryUtils.printBooks(library);
	}

}
