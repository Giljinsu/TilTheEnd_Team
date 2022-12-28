package com.hyundai.tiltheend_team.dao;

import java.sql.SQLException;
import java.sql.Statement;


public class InsertUsers {
    public void insertUser(String name, String age, String sex, String identification_number, String number,String email, String ID, String PW ) {
        Common common = new Common();
        Statement statement  = common.getStatement();
        String query = "INSERT INTO USERS (USER_ID, USER_PW, PRIVILEGES, USER_NAME, USER_SEX, PHONENUMBER, EMAIL, AGE)"+
                        "VALUES('"+ID+"','"+PW+"','MEMBER','"+name+"','"+sex+"','"+number+"','"+email+"', '"+age+"');";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
