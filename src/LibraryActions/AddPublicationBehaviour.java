package LibraryActions;

import data.Library;
import data.Periodical;
import data.Publication;
import utils.DataReader;

public abstract class AddPublicationBehaviour extends LibraryBehaviour {
	
	protected DataReader dataReader;

	public AddPublicationBehaviour(){
		super();
		dataReader = DataReader.getInstance();
	}

	public abstract void execute();
}
