package com.hyundai.tiltheend_team.dao;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertSurvey {
    // 같은 유저 삭제
    public void isDuplicate(String user_id) {
        Common common = new Common();
        Statement statement = common.getStatement();

        // 무조건 삭제(중복된 유저가 설문을 작성하는 것을 막기 위해)
        String query = "DELETE FROM USERS_ANSWER " +
                "WHERE USER_ID = '" + user_id + "';";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DB삽입
    public void insertSurvey(String user_id, String question_id, String answer_id) {
        Common common = new Common();
        Statement statement = common.getStatement();

        // 삽입
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
