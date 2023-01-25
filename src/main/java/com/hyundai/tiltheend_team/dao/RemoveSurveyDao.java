package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveSurveyDao {
    public Boolean removeSurvey(String userId, String password) {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT USER_PW FROM USERS WHERE USER_ID = '"+userId+"'";
        String dbPW = "";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                dbPW = resultSet.getString("USER_PW");
            }
            if(password.equals(dbPW)) {
                query = "DELETE FROM USERS_ANSWER WHERE USER_ID = '"+userId+"'";
                statement.execute(query);
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        return false;
    }
}
