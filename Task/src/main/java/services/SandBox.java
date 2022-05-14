package services;

import model.Beverage;

import java.io.IOException;

public class SandBox {
    public static void main(String[] args) throws IOException {
        Beverage beverage = new Beverage("vodka");
        CocktailServiceImpl cocktailService = new CocktailServiceImpl();
        cocktailService.makeСocktail(beverage);

    }
}
