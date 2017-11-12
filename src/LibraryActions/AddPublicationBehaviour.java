package LibraryActions;

import data.Library;
import data.Periodical;
import data.Publication;
import utils.DataReader;
import data.PublicationParameters;
import data.PublicationFactory;

public abstract class AddPublicationBehaviour extends LibraryBehaviour {
	
	protected DataReader dataReader;
        public PublicationParameters parameters;
        public PublicationFactory factory;

	public AddPublicationBehaviour(){
		super();
		dataReader = DataReader.getInstance();
	}

	public abstract void execute();
}
