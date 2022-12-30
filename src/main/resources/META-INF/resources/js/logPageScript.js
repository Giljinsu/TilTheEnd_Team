function validateForm() {
    let idValue = document.querySelector("#id").value;
    let pwValue = document.querySelector("#password").value;
    if(idValue = "") {
        let errorLogin = document.querySelector("#errorLogin");
        errorLogin.innerHTML = "유효하지않은 ID입니다."
        errorLogin.style.color = "red";
        return false;
    }
    errorLogin.innerHTML = "";
    if(pwValue = "") {
        let errorLogin = document.querySelector("#errorLogin");
        errorLogin.innerHTML = "유효하지않은 비밀번호입니다."
        errorLogin.style.color = "red";
        return false;
    }
    errorLogin.innerHTML = "";
    return true;
}