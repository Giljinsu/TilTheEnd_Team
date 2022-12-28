package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JoinMember {
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

    public int idCheck(String id) { // 중복값인지
        int isTrue = 0;
        Common common = new Common();
        String compareId = null;
        Statement statement  = common.getStatement();
        String query = "SELECT USER_ID FROM users WHERE USER_ID = '"+id+"';";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                compareId = resultSet.getString("USER_ID");
            }
            if(compareId != null) {
                if(compareId.equals(id)) {
                    isTrue=1;
                } else {
                    isTrue = 0;
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isTrue;
    }
}
