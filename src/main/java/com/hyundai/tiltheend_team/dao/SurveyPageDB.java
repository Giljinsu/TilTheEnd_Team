package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyPageDB {
    public ArrayList<HashMap> getAnswersList(String questionUid) throws SQLException {
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
        }
        return answerList;
    }
}
