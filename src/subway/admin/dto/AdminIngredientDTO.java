package subway.admin.dto;

public class AdminIngredientDTO {
    private String ingredName;
    private String ingredCategory;
    private int ingredCalorie;
    private int ingredPrice15;
    private int ingredPrice30;
    private String ingredRecommendSauce;
    
    public AdminIngredientDTO() {}

    public AdminIngredientDTO(String ingredName, String ingredCategory, int ingredCalorie, int ingredPrice15,
            int ingredPrice30, String ingredRecommendSauce) {
        super();
        this.ingredName = ingredName;
        this.ingredCategory = ingredCategory;
        this.ingredCalorie = ingredCalorie;
        this.ingredPrice15 = ingredPrice15;
        this.ingredPrice30 = ingredPrice30;
        this.ingredRecommendSauce = ingredRecommendSauce;
    }
    
    
}
