const reviewName = document.getElementById('reviewName');
const reviewEmail = document.getElementById('reviewEmail');
const reviewPhoneNum = document.getElementById('reviewPhoneNum');
const reviewContent = document.getElementById('reviewContent');

const reviewNameError = document.getElementById('reviewNameError');
const reviewEmailError = document.getElementById('reviewEmailError');
const reviewPhoneNumError = document.getElementById('reviewPhoneNumError');
const reviewContentError = document.getElementById('reviewContentError');

const reviewFormError = document.getElementById('reviewFormError');
const reviewButton = document.getElementById('reviewButton');

function onChange(name, value) {
  console.log(1)
  if (name === 'reviewName') {
    if (isEmpty(value)) {
      reviewName.style.border = '1px solid red';
      reviewNameError.innerHTML = 'Please enter your name';
      disableReviewButton();
    } else if (!value.replaceAll(' ', '').length > 0) {
      reviewName.style.border = '1px solid red';
      reviewNameError.innerHTML = 'Please enter your name';
      disableReviewButton();
    } else {
      reviewName.style.border = '1px solid transparent';
      reviewNameError.innerHTML = '';
      disableReviewButton();
    }
  } else if (name === 'reviewEmail') {
    if (isEmpty(value)) {
      reviewEmail.style.border = '1px solid red';
      reviewEmailError.innerHTML = 'Please enter your email';
      disableReviewButton();
    } else if (!isValidEmail(value)) {
      reviewEmail.style.border = '1px solid red';
      reviewEmailError.innerHTML = 'Please enter a valid email';
      disableReviewButton();
    } else {
      reviewEmail.style.border = '1px solid transparent';
      reviewEmailError.innerHTML = '';
      disableReviewButton();
    }
  } else if (name === 'orderPhreviewPhoneNumoneNum') {
    if (isEmpty(value)) {
      reviewPhoneNum.style.border = '1px solid red';
      reviewPhoneNumError.innerHTML = 'Please enter your phone number';
      disableReviewButton();
    } else if (!isValidNumber(value)) {
      reviewPhoneNum.style.border = '1px solid red';
      reviewPhoneNumError.innerHTML = 'Please enter a valid phone number';
      disableReviewButton();
    } else {
      reviewPhoneNum.style.border = '1px solid transparent';
      reviewPhoneNumError.innerHTML = '';
      disableReviewButton();
    }
  } else if (name === 'reviewContent') {
    if (isEmpty(value)) {
      reviewContent.style.border = '1px solid red';
      reviewContentError.innerHTML = 'Please enter your review';
      disableReviewButton();
    } else if (value.length < 10) {
      reviewContent.style.border = '1px solid red';
      reviewContentError.innerHTML = 'Your review is too short';
      disableReviewButton();
    } else {
      reviewContent.style.border = '1px solid transparent';
      reviewContentError.innerHTML = '';
      disableReviewButton();
    }
  }
}

function disableReviewButton() {
  if (
    isEmpty(reviewNameError.innerHTML) ||
    isEmpty(reviewEmailError.innerHTML) ||
    isEmpty(reviewPhoneNumError.innerHTML) ||
    isEmpty(reviewContentError.innerHTML) 
  ) {
    if (
      isEmpty(reviewName.value) ||
      isEmpty(reviewEmail.value) ||
      isEmpty(reviewPhoneNum.value) ||
      isEmpty(reviewContent.value) 
    ) {
      reviewButton.disabled = true;
    } else {
      reviewButton.disabled = false;
    }
  } else {
    reviewButton.disabled = true;
  }
}

function submitLoginForm() {
  // Set form error if any
}

function isValidEmail(email) {
  return /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(email);
}

function isValidNumber(number) {
  return /^[0-9]*$/.test(number) && number.length === 8;
}

function isEmpty(input) {
  return input === undefined || input === '' || input === null;
}

disableReviewButton();

reviewName.addEventListener('input', () => onChange('reviewName', reviewName.value));
reviewEmail.addEventListener('input', () => onChange('reviewEmail', reviewEmail.value));
reviewPhoneNum.addEventListener('input', () => onChange('reviewPhoneNum', reviewPhoneNum.value));
reviewContent.addEventListener('input', () => onChange('reviewContent', reviewContent.value));
