package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberList {
    public ArrayList<HashMap> getMemberList() throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT * FROM USERS";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<HashMap> result = new ArrayList<HashMap>();
        while (resultSet.next()) {
            HashMap<String, Object> member_list = new HashMap<String, Object>();
            member_list.put("USER_ID", resultSet.getString("USER_ID"));
            member_list.put("USER_PW", resultSet.getString("USER_PW"));
            member_list.put("USER_NAME", resultSet.getString("USER_NAME"));
            member_list.put("USER_SEX", resultSet.getString("USER_SEX"));
            member_list.put("AGE", resultSet.getString("AGE"));
            member_list.put("PHONENUMBER", resultSet.getString("PHONENUMBER"));
            member_list.put("EMAIL", resultSet.getString("EMAIL"));
            member_list.put("PRIVILEGES", resultSet.getString("PRIVILEGES"));
            result.add(member_list);
        }
        return result;
    }
}
