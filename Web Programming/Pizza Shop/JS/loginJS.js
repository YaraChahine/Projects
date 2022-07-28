const email = document.getElementById('email');
const password = document.getElementById('password');
const emailError = document.getElementById('emailError');
const passwordError = document.getElementById('passwordError');
const formError = document.getElementById('formError');
const loginButton = document.getElementById('submitLogin');

function onChange(name, value) {
  if (name === 'email') {
    if(isEmpty(value)){
      email.style.border = "1px solid red";
      emailError.innerHTML = "Please enter your email";
      disableLoginButton();
    }
    else if(!isValidEmail(value)){
      email.style.border = "1px solid red";
      emailError.innerHTML = "Please enter a valid email";
      disableLoginButton();
    }
    else{
      email.style.border = "1px solid transparent";
      emailError.innerHTML = "";
      disableLoginButton();
    }
  } else if (name === 'password') {
    if(isEmpty(value)){
      password.style.border = "1px solid red";
      passwordError.innerHTML = "Please enter your password";
      disableLoginButton();
    }
    else if(!isValidPassword(value)){
      password.style.border = "1px solid red";
      passwordError.innerHTML = "Your password must be at least 8 characters long, and have at least one of the following:\n Uppercase English letters, lowercase English letters, numbers, and special characters.";
      disableLoginButton();
    }
    else{
      password.style.border = "1px solid transparent";
      passwordError.innerHTML = "";
      disableLoginButton();
    }
  }
}

function disableLoginButton(){
  if(isEmpty(emailError.innerHTML) || isEmpty(passwordError.innerHTML)){
    if(isEmpty(email.value) || isEmpty(password.value)){
      loginButton.disabled = true;
    }
    else{
      loginButton.disabled = false;
    }
  }
  else{
    loginButton.disabled = true;
  }
}

function submitLoginForm(){
  // Set form error invalid credentials and submit
}

function isValidEmail(email) {
  return /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email);
}

function isValidPassword(password) {
  return /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/.test(password);  
}

function isEmpty(input) {
  return input === undefined || input === '' || input === null;
}

disableLoginButton();
email.addEventListener("input", () => onChange("email", email.value));
password.addEventListener("input", () => onChange("password", password.value));
