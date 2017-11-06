/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.NoSuchElementException;

import utils.DataReader;

/**
 *
 * @author Nimisha
 */
public class GetOptions {
    
     public enum Option {
      	EXIT(0, "Exit program"),
        ADD_BOOK(1, "Add a book"),
        ADD_PERIODICAL(2,"Adding a magazine / newspaper"),
        PRINT_BOOKS(3, "View available books"),
        PRINT_PERIODICALS(4, "Display of available magazines / newspapers"),
        ADD_USER(5, "Add a new user"),
        PRINT_USERS(6, "Display the list of users");
      
        private int value;
        private String descriptionPeriodical;
      
        Option(int value, String description) {
            this.value = value;
            this.descriptionPeriodical = description;
        }
          
        @Override
        public String toString() {
            return value + " - " + descriptionPeriodical;

        }
    }
}
