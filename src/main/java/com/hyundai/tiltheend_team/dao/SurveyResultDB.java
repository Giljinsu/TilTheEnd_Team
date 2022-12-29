package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyResultDB {
    // 전체통계
    public String getCount(String questionsUid, String answersUid) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT COUNT(ANSWER_ID) AS COUNT FROM USERS_ANSWER WHERE QUESTION_ID='" + questionsUid
                + "' AND ANSWER_ID = '" + answersUid + "'";
        // "SELECT COUNT(ANSWER_ID) AS COUNT FROM USERS_ANSWER WHERE QUESTION_ID='Q1'
        // AND ANSWER_ID = 'E1'"
        ResultSet resultSet = statement.executeQuery(query);

        String count = null;
        while (resultSet.next()) {
            count = resultSet.getString("COUNT");
            // System.out.println(count);
        }
        return count;
    }

    public ArrayList getEntireCount() throws SQLException {
        ArrayList<String> questionsUidList = getQuestionsUidList();
        ArrayList entireStat = new ArrayList<>();
        for (String questionUid : questionsUidList) {
            HashMap<String, Object> statRow = new HashMap<>();
            ArrayList<String> answersUidList = getAnswersUidList(questionUid);
            ArrayList<String> answers = new ArrayList<>();

            // System.out.println("questionUid: " + questionUid);
            statRow.put("questionUid", questionUid);
            statRow.put("question", getQuestion(questionUid));

            ArrayList answersCount = new ArrayList<>();
            for (String answerUid : answersUidList) {
                String count = getCount(questionUid, answerUid);
                // System.out.println("getCount:" + count);
                answersCount.add(count);
                String answer = null;
                answer = getAnswer(answerUid);
                answers.add(answer);
            }
            statRow.put("answersCount", answersCount);
            statRow.put("answers", answers);
            entireStat.add(statRow);
        }
        return entireStat;
    }

    public ArrayList<String> getQuestionsUidList() throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT QUESTION_ID FROM QUESTION";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList questionUids = new ArrayList<>();
        while (resultSet.next()) {
            String questionUid = resultSet.getString("QUESTION_ID");
            questionUids.add(questionUid);
        }
        return questionUids;
    }

    public ArrayList getAnswersUidList(String questionUid) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT ANSWER_ID FROM SURVEY WHERE QUESTION_ID='" + questionUid + "';";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList answerUids = new ArrayList<>();
        while (resultSet.next()) {
            String answerUid = resultSet.getString("ANSWER_ID");
            answerUids.add(answerUid);
        }
        return answerUids;
    }

    public String getQuestion(String questionUid) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT QUESTION FROM QUESTION WHERE QUESTION_ID='" + questionUid + "'";
        ResultSet resultSet = statement.executeQuery(query);
        String question = null;
        while (resultSet.next()) {
            question = resultSet.getString("QUESTION");
        }
        return question;
    }

    public String getAnswer(String answerUid) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT ANSWER FROM ANSWER WHERE ANSWER_ID='" + answerUid + "'";
        ResultSet resultSet = statement.executeQuery(query);
        String answer = null;
        while (resultSet.next()) {
            answer = resultSet.getString("ANSWER");
        }
        return answer;
    }

    public ArrayList getUsersListWithSurvey() throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT * FROM USERS";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList usersListWithSurvey = new ArrayList<>();
        while (resultSet.next()) {
            HashMap row = new HashMap<>();
            String userId = resultSet.getString("USER_ID");
            String userName = resultSet.getString("USER_NAME");
            if (hasSurvey(userId)) {// 만약에 survey를 한 유저라면
                row.put("userId", userId);
                row.put("userName", userName);
                ArrayList answerList = getSurveyById(userId);
                row.put("answerList", answerList);
                usersListWithSurvey.add(row);
            }
        }
        return usersListWithSurvey;
    }

    // user가 survey를 했는지 알아내는 펑션
    public boolean hasSurvey(String userId) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT COUNT(USER_ID) AS COUNT FROM USERS_ANSWER WHERE USER_ID='" + userId + "'";
        ResultSet resultSet = statement.executeQuery(query);
        String countStr = null;
        while (resultSet.next()) {
            countStr = resultSet.getString("COUNT");
        }
        int count = Integer.parseInt(countStr);
        boolean hasSurvey;
        if (count > 0) {
            hasSurvey = true;
        } else {
            hasSurvey = false;
        }
        return hasSurvey;
    }

    // user가 survey답변한 내용을 불러오는 펑션, answer 문자열을 리스트 형태로 돌려줌.
    public ArrayList getSurveyById(String userId) throws SQLException {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT * FROM USERS_ANSWER WHERE USER_ID='" + userId + "'";
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList answerList = new ArrayList();
        while (resultSet.next()) {
            String questionId = resultSet.getString("QUESTION_ID");
            String answerId = resultSet.getString("ANSWER_ID");
            String answerStr = getAnswer(answerId);
            answerList.add(answerStr);
        }
        return answerList;
    }
}
