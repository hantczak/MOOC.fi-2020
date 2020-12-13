import java.util.ArrayList;

public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(String recipeName, String cookingDurationString, ArrayList<String> ingredients) {
        int cookingDuration = Integer.valueOf(cookingDurationString);
        recipes.add(new Recipe(recipeName, cookingDuration, ingredients));
    }

    public String toString() {
        String outprint = "Recipes:" + "\n";
        for (Recipe recipe : recipes) {
            outprint += recipe.getName() + ", cooking time: " + recipe.getCookingTime() + "\n";
        }
        return outprint;
    }

    public ArrayList<Recipe> findName(String name) {
        ArrayList<Recipe> foundRecipes = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(name)) {
                foundRecipes.add(recipe);
            }
        }
        return foundRecipes;
    }

    public ArrayList<Recipe> findRecipesWithCookingTimeBelow(int time) {
        ArrayList<Recipe> foundRecipes = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= time) {
                foundRecipes.add(recipe);
            }
        }
        return foundRecipes;
    }

    public ArrayList<Recipe> searchByIngredient(String searchedIngredient) {
        ArrayList<Recipe> foundRecipes = new ArrayList<>();
        for (Recipe recipe : recipes) {
            for (String ingredient : recipe.getIngredients()){
                if(ingredient.equals(searchedIngredient)){
                    foundRecipes.add(recipe);
                }
            }
        }
        return foundRecipes;
    }
}
