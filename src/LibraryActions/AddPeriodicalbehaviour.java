package LibraryActions;

public class AddPeriodicalbehaviour extends AddPublicationBehaviour {

	public AddPeriodicalbehaviour() {
		super();
	}

	@Override
	public void execute() {
		library.addPublication(dataReader.readPeriodical());
	}

}
