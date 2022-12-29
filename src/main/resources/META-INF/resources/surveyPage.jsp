<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap,java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>설문화면</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../css/common.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  </head>

  <body>
    <% 
      HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
      ArrayList answer = (ArrayList) request.getAttribute("answer");
    %>
    <%@ include file="header_login.jsp" %>

    <% if(question != null){ %>
    <main class="d-flex align-items-center mt-5" style="height: 40rem">
      <div class="container">
        <form action="./index.html">
          <% for(int i=0;i<6;i++){ %>
            <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded"><%= question.get("ORDERS") %>. <%= question.get("QUESTION") %></div>
            <div class="row">
              <% for(int j=0;j<5;i++){ %>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_<%= i %>" id="radio<%= i %>-<%= j %>" value="survey1-1" />
                <label for="radio1-1" class="form-check-label"> (<%= (j+1) %>)<%= answer.get(j) %>></label>
              </div>
              <% } %>
            </div>
          </div>
          <% } %>
      <% } else { %>
        <div>question is null</div>
        <% } %>
        </form>
      </div>
    </main>

    <%@ include file="footer.jsp" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
