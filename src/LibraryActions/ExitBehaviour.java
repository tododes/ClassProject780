package LibraryActions;

import utils.FileManager;

public class ExitBehaviour extends LibraryBehaviour {
	
	private FileManager fileManager;

	public ExitBehaviour() {
		super();
		fileManager = FileManager.getInstance();
	}

	@Override
	public void execute() {
		fileManager.writeLibraryToFile(library);
	}

}
