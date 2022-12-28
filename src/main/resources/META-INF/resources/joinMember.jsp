<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원가입</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <%@ include file="header_notlogin.jsp" %>
    <div class="container">
      <div class="fs-3 text-center mt-3 mb-4">회원가입</div>
      <form action="/joinMemberServlet" method="get">
        <table class="table">
          <tr>
            <th>이름</th>
            <td>
              <input class="form-control" type="text" name="name" id="" />
            </td>
          </tr>
          <tr>
            <th>나이</th>
            <td><input class="form-control" type="text" name="age" id="" /></td>
          </tr>
          <tr>
            <th>성별</th>
            <td>
              <select name="sex" id="" class="form-select w-25 text-center">
                <option value="Man">남성</option>
                <option value="Woman">여성</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>전화번호</th>
            <td class="row">
              <div class="col-2">
                <select class="form-select text-center" name="identification_number">
                  <option value="010">010</option>
                  <option value="011">011</option>
                </select>
              </div>
              <div class="col">
                <input class="form-control" type="text" name="number" id="" />
              </div>
            </td>
          </tr>
          <tr>
            <th>이메일</th>
            <td>
              <input class="form-control" type="email" name="email" placeholder="asdas@naver.com" id="" />
            </td>
          </tr>
          <tr>
            <th>ID</th>
            <td class="row">
              <div class="col-8">
                <input class="form-control" type="text" name="ID" id="" />
              </div>
              <div class="col-4">
                <button class="btn btn-outline-primary">중복확인</button>
              </div>
            </td>
          </tr>
          <tr>
            <th>PW</th>
            <td>
              <input class="form-control" type="password" name="PW" id="" />
            </td>
          </tr>
        </table>
        <div class="text-center">
          <a href="./logpage.jsp" class="btn btn-warning">뒤로가기</a>
          <button class="btn btn-warning" type="submit">회원가입</button>
        </div>
      </form>
    </div>
    <%@ include file="footer.jsp" %>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>