package subway.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import subway.admin.dto.IngredientDTO;
import subway.dbUtil.DBUtil;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class AdminDAOImpl implements AdminDAO {
    private Properties proFile = DBUtil.getProFile();

    @Override
    public List<UserInfoDTO> userSearch() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserInfoDTO> list = new ArrayList();
        String sql = "select * from users";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new UserInfoDTO(rs.getString("USER_ID"), rs.getString("USER_NAME"), rs.getString("USER_PHONE"),
                        rs.getString("USER_EMAIL")));
            }
        } finally {
            DBUtil.dbClose(rs, ps, con);
        }
        return list;
    }

    @Override
    public int menuInsert(IngredientDTO ingredDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "insert into ingredients values (?, ?, ?, ?, ?, ?)";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ingredDTO.getIngredName());
            ps.setString(2, ingredDTO.getIngredCategory());
            ps.setInt(3, ingredDTO.getIngredCalorie());
            ps.setInt(4, ingredDTO.getIngredPrice15());
            ps.setInt(5, ingredDTO.getIngredPrice30());
            ps.setString(6, ingredDTO.getIngredRecommendSauce());
            result = ps.executeUpdate();

        } finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

    @Override
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "update ingredients set INGRED_CATEGORY = ?, INGRED_CALORIE = ?, "
                + "INGRED_PRICE_15 = ?, INGRED_PRICE_30 = ?, INGRED_RECOMMEND_SAUCE = ? WHERE INGRED_NAME = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ingredDTO.getIngredCategory());
            ps.setInt(2, ingredDTO.getIngredCalorie());
            ps.setInt(3, ingredDTO.getIngredPrice15());
            ps.setInt(4, ingredDTO.getIngredPrice30());
            ps.setString(5, ingredDTO.getIngredRecommendSauce());
            ps.setString(6, ingredDTO.getIngredName());
            result = ps.executeUpdate();

        } finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

    @Override
    public int menuDelete(String ingredName) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "delete from ingredients where ingred_name = ?";

        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ingredName);
            result = ps.executeUpdate();

        } finally {
            DBUtil.dbClose(ps, con);
        }
        return result;
    }

}
