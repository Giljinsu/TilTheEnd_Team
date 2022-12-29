package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyPageDB {
    public ArrayList<HashMap> getAnswersList() throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT SURVEY.QUESTION_ID, ANSWER.ORDERS, ANSWER.ANSWER" +
                "FROM SURVEY INNER JOIN ANSWER" +
                "ON SURVEY.ANSWER_ID = ANSWER.ANSWER_ID" +
                "ORDER BY QUESTION_ID";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<HashMap> answerList = new ArrayList<HashMap>();
        while (resultSet.next()) {
            HashMap<String, Object> answer = new HashMap<String, Object>();
            answer.put("QUESTION_ID", resultSet.getString("QUESTION_ID"));
            answer.put("ORDERS", resultSet.getInt("ORDERS"));
            answer.put("ANSWER", resultSet.getString("ANSWER"));
            answerList.add(answer);
        }
        return answerList;
    }

    public HashMap<String, Object> getQuestion() throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT * FROM QUESTION";
        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> result = null;
        while (resultSet.next()) {
            result = new HashMap<>();
            result.put("QUESTION_ID", resultSet.getString("QUESTION_ID"));
            result.put("ORDERS", resultSet.getString("ORDERS"));
            result.put("QUESTION", resultSet.getString("QUESTION"));
        }
        return result;
    }
}
