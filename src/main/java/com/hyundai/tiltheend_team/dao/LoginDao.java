package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
    public int login(String id, String pw) {
        Common common = new Common();
        Statement statement = common.getStatement();
        String idCheck = "";
        String pwCheck = "";
        // SELECT USER_ID, USER_PW FROM users WHERE USER_ID='아이디';
        String query = "SELECT USER_ID, USER_PW  FROM USERS WHERE USER_ID='"+id+"'";
        ResultSet resultSet = null;
        try {
            if(id != "" && pw != "") {
                resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    idCheck = resultSet.getString("USER_ID");
                    pwCheck = resultSet.getString("USER_PW");
                }
                if(id.equals(idCheck)&&pw.equals(pwCheck)) {
                    return 1; // 로그인 성공
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return 0; // 로그인 실패
    }

    public boolean isAdmin(String id) {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT USER_ID, USER_PW, PRIVILEGES FROM USERS WHERE USER_ID='"+id+"'";
        ResultSet resultSet = null;
        String privilege = "";
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                privilege = resultSet.getString("PRIVILEGES");
            }
            if(privilege.equals("ADMIN")) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String getName(String id) {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT USER_NAME FROM USERS WHERE USER_ID='"+id+"'";
        ResultSet resultSet = null;
        String name="";
        try {
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                name = resultSet.getString("USER_NAME");
            }
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "nameError";
    }
}
