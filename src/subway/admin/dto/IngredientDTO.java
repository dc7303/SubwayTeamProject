package subway.admin.dto;

public class IngredientDTO {
    private String ingredName;
    private String ingredCategory;
    private int ingredCalorie;
    private int ingredPrice15;
    private int ingredPrice30;
    private String ingredRecommendSauce;
    
    public IngredientDTO() {}

    public IngredientDTO(String ingredName, String ingredCategory, int ingredCalorie, int ingredPrice15,
            int ingredPrice30, String ingredRecommendSauce) {
        super();
        this.ingredName = ingredName;
        this.ingredCategory = ingredCategory;
        this.ingredCalorie = ingredCalorie;
        this.ingredPrice15 = ingredPrice15;
        this.ingredPrice30 = ingredPrice30;
        this.ingredRecommendSauce = ingredRecommendSauce;
    }

    public String getIngredName() {
        return ingredName;
    }

    public void setIngredName(String ingredName) {
        this.ingredName = ingredName;
    }

    public String getIngredCategory() {
        return ingredCategory;
    }

    public void setIngredCategory(String ingredCategory) {
        this.ingredCategory = ingredCategory;
    }

    public int getIngredCalorie() {
        return ingredCalorie;
    }

    public void setIngredCalorie(int ingredCalorie) {
        this.ingredCalorie = ingredCalorie;
    }

    public int getIngredPrice15() {
        return ingredPrice15;
    }

    public void setIngredPrice15(int ingredPrice15) {
        this.ingredPrice15 = ingredPrice15;
    }

    public int getIngredPrice30() {
        return ingredPrice30;
    }

    public void setIngredPrice30(int ingredPrice30) {
        this.ingredPrice30 = ingredPrice30;
    }

    public String getIngredRecommendSauce() {
        return ingredRecommendSauce;
    }

    public void setIngredRecommendSauce(String ingredRecommendSauce) {
        this.ingredRecommendSauce = ingredRecommendSauce;
    }

    @Override
    public String toString() {
        return ingredName + " | " + ingredCategory + " | " + ingredCalorie + " | " + ingredPrice15 + " | "
                + ingredPrice30 + " | " + ingredRecommendSauce;
    }
    
    
}
