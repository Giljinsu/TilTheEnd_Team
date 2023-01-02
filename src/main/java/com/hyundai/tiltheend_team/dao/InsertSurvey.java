package com.hyundai.tiltheend_team.dao;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertSurvey {
    public void insertSurvey(String user_id, String question_id, String answer_id) {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "INSERT INTO USERS_ANSWER (USER_ID, QUESTION_ID, ANSWER_ID) " +
                "VALUES('" + user_id + "','" + question_id + "','" + answer_id + "');";
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
