/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import Menu.AddBookMenuItem;
import Menu.AddPeriodicalMenuItem;
import Menu.AddUserMenuItem;
import Menu.ExitMenuItem;
import Menu.MenuItem;
import Menu.PrintBookMenuItem;
import Menu.PrintPeriodicalMenuItem;
import Menu.PrintUserMenuItem;
import utils.DataReader;

/**
 *
 * @author Nimisha
 */
public class GetOptions {
	
	private static GetOptions instance;
	
	private static ArrayList<MenuItem> menuItems = new ArrayList<>();
	
	public static GetOptions getInstance(){
		if(instance == null)
			instance = new GetOptions();
		return instance;
	}
	
	private GetOptions(){
		menuItems.add(new ExitMenuItem(0, "Exit program"));
		menuItems.add(new AddBookMenuItem(1, "Add a book"));
		menuItems.add(new AddPeriodicalMenuItem(2, "Adding a magazine / newspaper"));
		menuItems.add(new PrintBookMenuItem(3, "View available books"));
		menuItems.add(new PrintPeriodicalMenuItem(4, "Display of available magazines / newspapers"));
		menuItems.add(new AddUserMenuItem(5, "Add a new user"));
		menuItems.add(new PrintUserMenuItem(6, "Display the list of users"));
	}
    
     public MenuItem getMenuItemAt(int index){
    	 return menuItems.get(index);
     }
     
     public void printOptions(){
    	 for(int i=0;i<menuItems.size();i++){
    		 System.out.println(menuItems.get(i).getIndex() + " - " + menuItems.get(i).getDescription());
    	 }
     }
     
     
}
