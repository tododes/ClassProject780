package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Library;

public class FileManager {
	public static final String FILE_NAME = "Library.o";
	
	private static FileManager instance;
	
	private FileManager(){
		
	}
	
	public static FileManager getInstance(){
		if(instance == null)
			instance = new FileManager();
		return instance;
	}
    
    public void writeLibraryToFile(Library lib) {
        try(
        FileOutputStream fileOutput = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
                ) {
             
            objectOutput.writeObject(lib);
             
        } catch (FileNotFoundException exception) {
            System.err.println("File not found " + FILE_NAME);
        } catch (IOException exception) {
            System.err.println("Error writing to file " + FILE_NAME);
        }
    }
     
    public Library readLibraryFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        Library library = null;
        try(
        FileInputStream fileInput = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                ) {
             
            library = (Library)objectInput.readObject();
             
        } catch (FileNotFoundException exception) {
            System.err.println("File not found " + FILE_NAME);
            throw exception;
        } 
	    catch (IOException exception) {
            System.err.println("Error writing to file " + FILE_NAME);
            throw exception;
        } 
	    catch (ClassNotFoundException exception) {
            System.err.println("Invalid file format");
            throw exception;
        }
         
        return library;
    }
}
