# **Welcome to TilTheEnd๐ฉโ๐ป**

### KH Acadmey Final Project **๋๊น์ง๋ฒํ**์๋๋ค.

# **Background**

ํ๋์๋์ฐจ ๊ณ ๊ฐ๋ค์ ๋ง์กฑ๋๋ฅผ ์กฐ์ฌํ๊ธฐ ์ํด ๋ง๋ค์์ต๋๋ค.

๐01. ์๋น์ค ํ์ง ํฅ์

๐02. ๊ณ ๊ฐ๋ง์กฑ๋ ํฅ์

๐03. ์ค๋ฌธ์ ํตํ ํ์ฌ์ ๋ฐ์ 

โ๏ธ์กฐ์ฌ๋ ๋ด์ฉ์ ๋ฐํ์ผ๋ก ๊ณ ๊ฐ๋๋ค๊ป **๋์ฑ ์ข์ ์๋น์ค**๋ฅผ ์ ๊ณตํ๋ **ํ๋์๋์ฐจ**๊ฐ ๋๊ฒ ์ต๋๋ค.

# **Technology stack**

### Tech Stack

- Front-end

    <img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
    <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
    <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
    <img src="https://img.shields.io/badge/jsp-FFA500?style=for-the-badge&logo=java&logoColor=white">

- Back-end

    <img src="https://img.shields.io/badge/Servlet-E11F21?style=for-the-badge&logo=&logoColor=white">

- Server

    <img src="https://img.shields.io/badge/Goorm IDE-609AE9?style=for-the-badge&logo=&logoColor=black">

- ETC

    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
    <img src="https://img.shields.io/badge/zoom-0652E2?style=for-the-badge&logo=zoom&logoColor=white">

# Project info

### ํ๋ก์ ํธ ๊ธฐ๊ฐ

- 2022.12.26 ~ 2023.01.02

### video

- [youtube](https://www.youtube.com/watch?v=fHo77uxeqzA)

# ์ฃผ์ ์ฝ๋

### ์ธ์ ์ป๊ธฐ

```
String ID = (String) httpSession.getAttribute("userId");
```

getAttribute๋ฅผ ํตํด ์ ์ ์ id๋ฅผ ๊ฐ์ ธ์จ๋ค.

### ๊ตฌ๋ฆ

```
<input class="form-control" type="text" name="id" value="<%=id%>" id="id"/>
```

๊ตฌ๋ฆ IDE์์๋ input ํ๊ทธ์ id๊ฐ ๋๋ฌธ์๋ฉด ์ธ์ํ์ง ๋ชปํ๋ค.

### ์ด๋๋ฏผ ๊ณ์  ํ์ธ

```
if(loginDao.isAdmin(userId)) {
        path="/admin.jsp";
    } else{
        path = "/indexLogined.jsp";
    }

RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
requestDispatcher.forward(request, response);
```

์ผ๋ฐ ์ฌ์ฉ์์ ์ด๋๋ฏผ์ ๊ตฌ๋ถํด์ ํ์ด์ง๋ฅผ ์ด๋ํ๋๋ก ๋ง๋ค์๋ค.

# **Team Members**

### Team TilTheEnd

- ๊ธธ์ง์ (https://github.com/Giljinsu) - ๋ก๊ทธ์ธ/๋ก๊ทธ์์/ํ์๊ฐ์/ํต๊ณ์ญ์ 
- ๊น๋ณ๊ทผ (https://github.com/kimbyeonggeun) - ์ค๋ฌธ์ง์์ฑ/๊ด๋ฆฌ์ํ์ด์ง/ํ์๋ฆฌ์คํธ/ํ์์์ธํ์ด์ง
- ๊น์ฉ๋ฒ (https://github.com/yongbeom76) - ์ ์ฒดํต๊ณ/ํ์๋ณํต๊ณ/์ค๋ฌธํ์ธ
