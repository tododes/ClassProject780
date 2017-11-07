package Menu;

import LibraryActions.LibraryBehaviour;

public abstract class MenuItem {
	
	protected int index;
	protected String description;
	protected LibraryBehaviour myBehaviour;
	
	public MenuItem(int index, String description) {
		super();
		this.index = index;
		this.description = description;
	}

	public void OnSelected(){
		myBehaviour.execute();
	}

	public int getIndex() {
		return index;
	}

	public String getDescription() {
		return description;
	}
	
}
