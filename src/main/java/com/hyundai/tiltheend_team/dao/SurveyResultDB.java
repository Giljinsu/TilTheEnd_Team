package com.hyundai.tiltheend_team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SurveyResultDB {
    // 전체통계
    // questionUid와 answersUid를 주면 그 질문에 그 대답을 한 사람의 숫자를 모두다 세주는 펑션
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
        }
        return count;
    }

    // 전체통계를 출력하기 위해서 필요한 모든 정보를 통합해서 돌려주는 펑션
    public ArrayList getEntireCount() throws SQLException {
        ArrayList<String> questionsUidList = getQuestionsUidList();
        ArrayList entireStat = new ArrayList<>();
        for (String questionUid : questionsUidList) {
            HashMap<String, Object> statRow = new HashMap<>();
            ArrayList<String> answersUidList = getAnswersUidList(questionUid);
            ArrayList<String> answers = new ArrayList<>();

            statRow.put("questionUid", questionUid);
            statRow.put("question", getQuestion(questionUid));

            ArrayList answersCount = new ArrayList<>();
            for (String answerUid : answersUidList) {
                String count = getCount(questionUid, answerUid);
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

    // questionUid를 리스트로 돌려줌
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

    // answerId를 리스트로 돌려줌
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

    // questionUid주면 question 문자열을 돌려줌
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

    // answerId 주면 답항 문자열을 돌려줌
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

    // survey를 한 user 리스트를 불러오는 펑션. user에 대한 필요한 모든 정보를 다 담아 온다.
    // 회원별 통계를 출력하기 위해서 만든 펑션. 각 줄마다 필요한 정보를 모두다 담아서 보내온다.
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
            if (hasSurvey(userId)) {// 만약에 survey를 한 유저라면 리스트에 포함시켜라.
                row.put("userId", userId); // userId담고
                row.put("userName", userName); // 이름도 담고
                ArrayList answerList = getSurveyById(userId); // 이 user가 답변한 내용 알아내와라.
                row.put("answerList", answerList); // user가 답변한 내용도 담고
                usersListWithSurvey.add(row); // 이 user에 대한 필요한 정보를 모두다 담아서 리스트에 담자.
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
