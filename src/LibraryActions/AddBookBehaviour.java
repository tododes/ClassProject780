package LibraryActions;
public class AddBookBehaviour extends AddPublicationBehaviour {

	public AddBookBehaviour() {
		super();
	}

	@Override
	public void execute() {
		library.addPublication(dataReader.readBook());
	}

}
