package LibraryActions;

import utils.LibraryUtils;

public class PrintPeriodicalBehaviour extends LibraryBehaviour {

	public PrintPeriodicalBehaviour() {
		super();
	}

	@Override
	public void execute() {
		LibraryUtils.printPeriodicals(library);
	}

}
