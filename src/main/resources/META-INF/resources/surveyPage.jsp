<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%@ include file="header_login.jsp" %>

    <main class="d-flex align-items-center mt-5" style="height: 40rem">
      <div class="container">
        <form action="./index.html">
          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">1. 현대 자동차의 브랜드 이미지에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_1" id="radio1-1" value="survey1-1" />
                <label for="radio1-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_1" id="radio1-2" value="survey1-2" />
                <label for="radio1-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_1" id="radio1-3" value="survey1-3" />
                <label for="radio1-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_1" id="radio1-4" value="survey1-4" />
                <label for="radio1-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_1" id="radio1-5" value="survey1-5" />
                <label for="radio1-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">2. 현대 차량의 주행성능에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_2" id="radio2-1" value="survey2-1" />
                <label for="radio2-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_2" id="radio2-2" value="survey2-2" />
                <label for="radio2-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_2" id="radio2-3" value="survey2-3" />
                <label for="radio2-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_2" id="radio2-4" value="survey2-4" />
                <label for="radio2-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_2" id="radio2-5" value="survey2-5" />
                <label for="radio2-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
          </div>
          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">3. 현대 차량의 가격에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_3" id="radio3-1" value="survey3-1" />
                <label for="radio3-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_3" id="radio3-2" value="survey3-2" />
                <label for="radio3-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_3" id="radio3-3" value="survey3-3" />
                <label for="radio3-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_3" id="radio3-4" value="survey3-4" />
                <label for="radio3-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio3-5" value="survey3-5" />
                <label for="radio3-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">4. 현대 차량의 디자인에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_4" id="radio4-1" value="survey4-1" />
                <label for="radio4-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_4" id="radio4-2" value="survey4-2" />
                <label for="radio4-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_4" id="radio4-3" value="survey4-3" />
                <label for="radio4-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_4" id="radio4-4" value="survey4-4" />
                <label for="radio4-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_4" id="radio4-5" value="survey4-5" />
                <label for="radio4-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">5. 현대 차량의 내구성에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio5-1" value="survey5-1" />
                <label for="radio5-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio5-2" value="survey5-2" />
                <label for="radio5-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio5-3" value="survey5-3" />
                <label for="radio5-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio5-4" value="survey5-4" />
                <label for="radio5-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_5" id="radio5-5" value="survey5-5" />
                <label for="radio5-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
          </div>

          <div class="mb-3">
            <div class="border bg-primary bg-opacity-10 mb-1 p-1 rounded">6. 현대 직원의 응대에 만족하십니까?</div>
            <div class="row">
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_6" id="radio6-1" value="survey6-1" />
                <label for="radio6-1" class="form-check-label"> (1)매우만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_6" id="radio6-2" value="survey6-2" />
                <label for="radio6-2" class="form-check-label"> (2)만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_6" id="radio6-3" value="survey6-3" />
                <label for="radio6-3" class="form-check-label"> (3)보통</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_6" id="radio6-4" value="survey6-4" />
                <label for="radio6-4" class="form-check-label"> (4)불만족</label>
              </div>
              <div class="col">
                <input type="radio" class="form-check-input" name="survey_6" id="radio6-5" value="survey6-5" />
                <label for="radio6-5" class="form-check-label"> (5)매우불만족</label>
              </div>
            </div>
            <div class="d-flex justify-content-center mt-5">
              <button type="submit" class="btn bg-primary bg-opacity-10">제출하기</button>
            </div>
          </div>
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
