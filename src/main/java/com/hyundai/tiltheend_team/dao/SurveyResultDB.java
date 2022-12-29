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
            System.out.println(count);
        }
        return count;
    }

    public void getEntireCount() {
        // getQuestionsUidList

        // getAnswersUidList(questionUid)
        // for(questionsUidList: question) {}
    }

    }

    public void getQuestionsUidList() {
        Common common = new Common();
        Statement statement = common.getStatement();
        String query = "SELECT COUNT(ANSWER_ID) AS COUNT FROM USERS_ANSWER WHERE QUESTION_ID='" + questionsUid
                + "' AND ANSWER_ID = '" + answersUid + "'";
    }

    // 전체통계 참조코드
    // public void answerStatistics(Connection connection) {
    // System.out.println("<질문별 총 답변수>");
    // String format = "%-10s%-10s%-10s%-10s%-10s%-10s%n";
    // String format2 = "%-8s%-11s%-11s%-11s%-11s%-11s%n";
    // System.out.printf(format, "Question)", "답(1)", "답(2)", "답(3)", "답(4)",
    // "답(5)");

    // // 질문별로 답변한 답항갯수의 합을 구하는 쿼리문
    // // 쿼리 결과는 Q1..Q6 각 질문에 대해 다음과 같이 한줄로 나온다.
    // // A1 A2 A3 A4 A5
    // // 2 7 0 1 3
    // String query = "SELECT * " +
    // "FROM (SELECT COUNT(ANSWER_ID) AS A1 FROM users_answer " +
    // "WHERE QUESTION_ID=? AND ANSWER_ID = 'A1') AS A1" +
    // "INNER JOIN (SELECT COUNT(ANSWER_ID) AS A2 FROM users_answer " +
    // "WHERE QUESTION_ID=? AND ANSWER_ID = 'A2') AS A2 " +
    // "INNER JOIN (SELECT COUNT(ANSWER_ID) AS A3 FROM users_answer " +
    // "WHERE QUESTION_ID=? AND ANSWER_ID = 'A3') AS A3 " +
    // "INNER JOIN (SELECT COUNT(ANSWER_ID) AS A4 FROM users_answer " +
    // "WHERE QUESTION_ID=? AND ANSWER_ID = 'A4') AS A4 " +
    // "INNER JOIN (SELECT COUNT(ANSWER_ID) AS A5 FROM users_answer " +
    // "WHERE QUESTION_ID=? AND ANSWER_ID = 'A5') AS A5";

    // try {
    // PreparedStatement preparedStatement = connection.prepareStatement(query);
    // ResultSet resultSet;

    // // 질문 숫자 세기
    // Statement statement = connection.createStatement();
    // ResultSet resultSet_QuestionCount = statement.executeQuery("SELECT
    // COUNT(QUESTION_ID) FROM question;");
    // int questionCount = 0;
    // while (resultSet_QuestionCount.next()) {
    // questionCount =
    // Integer.parseInt(resultSet_QuestionCount.getString("COUNT(QUESTION_ID)"));
    // }

    // for (int i = 0; i < questionCount; i++) { // Q1..Qn를 돌면서 각 질문에 대한 통계를 불러온다.
    // String question = "Q" + (i + 1);
    // preparedStatement.setString(1, question); // 예시, 이번쿼리는 Q1,Q2.... 등 으로 설정한다.
    // preparedStatement.setString(2, question);
    // preparedStatement.setString(3, question);
    // preparedStatement.setString(4, question);
    // preparedStatement.setString(5, question);

    // resultSet = preparedStatement.executeQuery();

    // resultSet.next();
    // int countA1, countA2, countA3, countA4, countA5; // 답변한 갯수의 합들 담는 변수
    // countA1 = resultSet.getInt("A1");
    // countA2 = resultSet.getInt("A2");
    // countA3 = resultSet.getInt("A3");
    // countA4 = resultSet.getInt("A4");
    // countA5 = resultSet.getInt("A5");
    // System.out.printf(format2, "질문" + (i + 1), countA1, countA2, countA3,
    // countA4, countA5); // 각문항에 답변한 갯수
    // // 합 출력
    // }
    // System.out.println();
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // }
}
