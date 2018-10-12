package subway.admin.view;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public class SuccessView {
    public static void successMessage(String message) {
        System.out.println(message);
    }
    
    
    public static void userList(List<UserInfoDTO> list) {
        for(UserInfoDTO dto : list) {
            System.out.println(dto);
        }
    }
    
    public static void ingredientList(List<IngredientDTO> list) {
        for(IngredientDTO dto : list) {
            System.out.println(dto);
        }
    }
}
