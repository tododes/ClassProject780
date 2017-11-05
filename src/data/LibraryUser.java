package data;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {
	private final List<Publication> publicationHistory;
    private final List<Publication> borrowedPublications;
     
    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }
     
    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }
 
    public LibraryUser(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
        publicationHistory = new ArrayList<>();
        borrowedPublications = new ArrayList<>();
    }
 
    private void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }
     
    public void borrowPublication(Publication publication) {
        borrowedPublications.add(publication);
    }
     
    public boolean returnPublication(Publication publication) {
        boolean result = false;
        if(borrowedPublications.remove(publication)) {
            result = true;
            addPublicationToHistory(publication);
        }
        return result;
    }
// TO-DO :: Is there a way to make this hascode and equals method common for other class and based on input it obtains??     
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((borrowedPublications == null) ? 0 : borrowedPublications.hashCode());
        result = prime * result
                + ((publicationHistory == null) ? 0 : publicationHistory.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        LibraryUser other = (LibraryUser) obj;
        if (borrowedPublications == null) {
            if (other.borrowedPublications != null)
                return false;
        } else if (!borrowedPublications.equals(other.borrowedPublications))
            return false;
        if (publicationHistory == null) {
            if (other.publicationHistory != null)
                return false;
        } else if (!publicationHistory.equals(other.publicationHistory))
            return false;
        return true;
    }
}
