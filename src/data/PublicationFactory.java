/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author karmadog
 */
public class PublicationFactory {
    
    public Publication getPublication(String publicationType, PublicationParameters parameters){
        if(publicationType==null)
            return null;
        if(publicationType.equalsIgnoreCase("Book"))
            return new Book(parameters);
        if(publicationType.equalsIgnoreCase("Periodical"))
            return new Periodical(parameters);
        return null;
    }
    
}
