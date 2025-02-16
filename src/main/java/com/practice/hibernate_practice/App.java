package com.practice.hibernate_practice;


public class App 
{
    public static void main( String[] args )
    {
    	SuperheroDAO superheroDAO = new SuperheroDAO();
    	
        // Save new superhero
    	Superhero hero = new Superhero("Superman", "Super Strength");
        superheroDAO.saveSuperhero(hero);
        
//        Superhero hero = new Superhero("Spiderman", "Spider web");
//        superheroDAO.saveSuperhero(hero);
        
        Superhero retrievedHero = superheroDAO.getSuperhero(hero.getId());
        System.out.println("Retrieved Superhero: " + retrievedHero);

        superheroDAO.close();
    }
}
