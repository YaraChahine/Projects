const email = document.getElementById('email');
const username = document.getElementById('username');
const password = document.getElementById('password');
const emailError = document.getElementById('emailError');
const usernameError = document.getElementById('usernameError');
const passwordError = document.getElementById('passwordError');
const formError = document.getElementById('formError');
const signupButton = document.getElementById('signupButton');

function onChange(name, value) {
  if (name === 'email') {
    if (isEmpty(value)) {
      email.style.border = '1px solid red';
      emailError.innerHTML = 'Please enter your email';
      disableSignupButton();
    } else if (!isValidEmail(value)) {
      email.style.border = '1px solid red';
      emailError.innerHTML = 'Please enter a valid email';
      disableSignupButton();
    } else {
      email.style.border = '1px solid transparent';
      emailError.innerHTML = '';
      disableSignupButton();
    }
  } else if (name === 'password') {
    if (isEmpty(value)) {
      password.style.border = '1px solid red';
      passwordError.innerHTML = 'Please enter your password';
      disableSignupButton();
    } else if (!isValidPassword(value)) {
      password.style.border = '1px solid red';
      passwordError.innerHTML =
        'Your password must be at least 8 characters long, and have at least one of the following:\n Uppercase English letters, lowercase English letters, numbers, and special characters.';
      disableSignupButton();
    } else {
      password.style.border = '1px solid transparent';
      passwordError.innerHTML = '';
      disableSignupButton();
    }
  } else if (name === 'username') {
    if (isEmpty(value)) {
      username.style.border = '1px solid red';
      usernameError.innerHTML = 'Please enter your username';
      disableSignupButton();
    } else if (!isValidUsername(value)) {
      username.style.border = '1px solid red';
      usernameError.innerHTML =
      'Your username must be between 3 and 16 characters, and made up of letters, numbers, - or _';
      disableSignupButton();
    } else {
      username.style.border = '1px solid transparent';
      usernameError.innerHTML = '';
      disableSignupButton();
    }
  }
}

function disableSignupButton() {
  if (isEmpty(emailError.innerHTML) || isEmpty(passwordError.innerHTML) || isEmpty(usernameError.innerHTML)) {
    if (isEmpty(email.value) || isEmpty(password.value) || isEmpty(username.value)) {
      signupButton.disabled = true;
    } else {
      signupButton.disabled = false;
    }
  } else {
    signupButton.disabled = true;
  }
}

function submitLoginForm() {
  // Set form error if any
}

function isValidEmail(email) {
  return /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email);
}

function isValidPassword(password) {
  return /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/.test(
    password,
  );
}

function isValidUsername(username) {
  return /^[a-z0-9_-]{3,16}$/i.test(username);
}

function isEmpty(input) {
  return input === undefined || input === '' || input === null;
}

disableSignupButton();
email.addEventListener('input', () => onChange('email', email.value));
username.addEventListener('input', () => onChange('username', username.value));
password.addEventListener('input', () => onChange('password', password.value));
