package LibraryActions;

import data.PublicationFactory;

public class AddBookBehaviour extends AddPublicationBehaviour {
        
	public AddBookBehaviour() {
		super();
	}

	@Override
	public void execute() {
            factory = new PublicationFactory();
            parameters = dataReader.getUserInputBook();
            library.addPublication(factory.getPublication("Book",parameters));
	}

}
