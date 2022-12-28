<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원별 통계화면</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <!-- <link rel="stylesheet" href="./css/common.css" /> -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  </head>

  <body>
    <%@ include file="header_login.jsp" %>

    <main class="d-flex align-items-center" style="height: 40rem">
      <div class="container">
        <div>
          <table class="table table-striped">
            <thead>
              <tr class="bg-warning">
                <th>이름</th>
                <th>질문(1)</th>
                <th>질문(2)</th>
                <th>질문(3)</th>
                <th>질문(4)</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th>설문자(1)</th>
                <td>3</td>
                <td>2</td>
                <td>4</td>
                <td>1</td>
              </tr>
              <tr>
                <th>설문자(2)</th>
                <td>1</td>
                <td>2</td>
                <td>4</td>
                <td>3</td>
              </tr>
              <tr>
                <th>설문자(3)</th>
                <td>2</td>
                <td>1</td>
                <td>4</td>
                <td>3</td>
              </tr>
              <tr>
                <th>설문자(4)</th>
                <td>4</td>
                <td>3</td>
                <td>1</td>
                <td>2</td>
              </tr>
            </tbody>
          </table>
        </div>
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