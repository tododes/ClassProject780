package LibraryActions;

import data.PublicationFactory;

public class AddPeriodicalbehaviour extends AddPublicationBehaviour {

	public AddPeriodicalbehaviour() {
		super();
	}

	@Override
	public void execute() {
            factory = new PublicationFactory();
            parameters = dataReader.getUserInputPeriodical();
            library.addPublication(factory.getPublication("Periodical",parameters));
	}

}
