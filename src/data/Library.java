package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import utils.DataReader;
import utils.FileManager;

public class Library implements Serializable {
	private static final long serialVersionUID = 7346680215932771853L;
	private Map<String, Publication> publications;
	private Map<String, LibraryUser> users;
	
	private static Library instance;
	private static FileManager fileManager;
	
	private Library() {
		publications = new HashMap<>();
		users = new HashMap<>();
		fileManager = FileManager.getInstance();
	}
	
	public static Library getInstance(){
		if(instance == null)
			instance = new Library();
		return instance;
	}
	
	public static Library getInstanceFromSaveFile(){
		if(instance == null){
			if(fileManager == null)
				fileManager = FileManager.getInstance();
			try {
				instance = fileManager.readLibraryFromFile();
				System.out.println("Data loaded from the file");
			} catch (FileNotFoundException e) {
				instance = getInstance();
				System.out.println("New library database created.");
			} catch (ClassNotFoundException e) {
				instance = getInstance();
				System.out.println("New library database created.");
			} catch (IOException e) {
				instance = getInstance();
				System.out.println("New library database created.");
			}
		}
		return instance;
	}
	
	public int getPublicationsNumber(){
		return publications.size();
	}
	
	public Map<String, Publication> getPublications() {
		return publications;
	}
	
	public Map<String, LibraryUser> getUsers(){
		return users;
	}
	
	public void addPublication(Publication publication){
		publications.put(publication.getTitle(), publication);
	}
	
	
	public void addUser(LibraryUser user) {
		users.put(user.getSocialSecurityNumber(), user);
	}
	
	public void removePublication(Publication pub) {
        if(publications.containsValue(pub)){
        	publications.remove(pub.getTitle());
        }
    }
	
        @Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
        for(Publication p: publications.values()) {
            builder.append(p);
            builder.append("\n");
        }
        return builder.toString();
        }
	
}

// Extract Refactoring from library class
// AlphabeticalCOmparator and DateComparator are moved out of this class seperately to remove noise
