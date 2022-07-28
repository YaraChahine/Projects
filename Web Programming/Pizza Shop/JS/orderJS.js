const orderName = document.getElementById('orderName');
const orderEmail = document.getElementById('orderEmail');
const orderPhoneNum = document.getElementById('orderPhoneNum');
const orderDate = document.getElementById('orderDate');
const orderAddress = document.getElementById('orderAddress');
const orderChosenPizza = document.getElementById('orderChosenPizza');

const orderNameError = document.getElementById('orderNameError');
const orderEmailError = document.getElementById('orderEmailError');
const orderPhoneNumError = document.getElementById('orderPhoneNumError');
const orderDateError = document.getElementById('orderDateError');
const orderAddressError = document.getElementById('orderAddressError');
const orderChosenPizzaError = document.getElementById('orderChosenPizzaError');

const orderFormError = document.getElementById('orderFormError');
const orderButton = document.getElementById('orderButton');

function onChange(name, value) {
  if (name === 'orderName') {
    if (isEmpty(value)) {
      orderName.style.border = '1px solid red';
      orderNameError.innerHTML = 'Please enter your name';
      disableOrderButton();
    } else if (!value.replaceAll(' ', '').length > 0) {
      orderName.style.border = '1px solid red';
      orderNameError.innerHTML = 'Please enter your name';
      disableOrderButton();
    } else {
      orderName.style.border = '1px solid transparent';
      orderNameError.innerHTML = '';
      disableOrderButton();
    }
  } else if (name === 'orderEmail') {
    if (isEmpty(value)) {
      orderEmail.style.border = '1px solid red';
      orderEmailError.innerHTML = 'Please enter your email';
      disableOrderButton();
    } else if (!isValidEmail(value)) {
      orderEmail.style.border = '1px solid red';
      orderEmailError.innerHTML = 'Please enter a valid email';
      disableOrderButton();
    } else {
      orderEmail.style.border = '1px solid transparent';
      orderEmailError.innerHTML = '';
      disableOrderButton();
    }
  } else if (name === 'orderPhoneNum') {
    if (isEmpty(value)) {
      orderPhoneNum.style.border = '1px solid red';
      orderPhoneNumError.innerHTML = 'Please enter your phone number';
      disableOrderButton();
    } else if (!isValidNumber(value)) {
      orderPhoneNum.style.border = '1px solid red';
      orderPhoneNumError.innerHTML = 'Please enter a valid phone number';
      disableOrderButton();
    } else {
      orderPhoneNum.style.border = '1px solid transparent';
      orderPhoneNumError.innerHTML = '';
      disableOrderButton();
    }
  } else if (name === 'orderDate') {
    let dateNow = new Date();
    let dateOrder = new Date(value);
    if (isEmpty(value)) {
      orderDate.style.border = '1px solid red';
      orderDateError.innerHTML = 'Please enter your order date';
      disableOrderButton();
    } else if (dateOrder < dateNow.setMinutes(dateNow.getMinutes() + 30)) {
      orderDate.style.border = '1px solid red';
      orderDateError.innerHTML =
        'Your order must be at least 30 minutes from the current date and time.';
      disableOrderButton();
    } else {
      orderDate.style.border = '1px solid transparent';
      orderDateError.innerHTML = '';
      disableOrderButton();
    }
  } else if (name === 'orderAddress') {
    if (isEmpty(value)) {
      orderAddress.style.border = '1px solid red';
      orderAddressError.innerHTML = 'Please enter your address';
      disableOrderButton();
    } else if (value.length < 10) {
      orderAddress.style.border = '1px solid red';
      orderAddressError.innerHTML = 'Your address is too short';
      disableOrderButton();
    } else {
      orderAddress.style.border = '1px solid transparent';
      orderAddressError.innerHTML = '';
      disableOrderButton();
    }
  } else if (name === 'orderChosenPizza') {
    if (isEmpty(value)) {
      orderChosenPizza.style.border = '1px solid red';
      orderChosenPizzaError.innerHTML = 'Please select at least one pizza';
      disableOrderButton();
    } else {
      orderChosenPizza.style.border = '1px solid transparent';
      orderChosenPizzaError.innerHTML = '';
      disableOrderButton();
    }
  }
}

function disableOrderButton() {
  if (
    isEmpty(orderNameError.innerHTML) ||
    isEmpty(orderEmailError.innerHTML) ||
    isEmpty(orderPhoneNumError.innerHTML) ||
    isEmpty(orderDateError.innerHTML) ||
    isEmpty(orderAddressError.innerHTML) ||
    isEmpty(orderChosenPizzaError.innerHTML)
  ) {
    if (
      isEmpty(orderName.value) ||
      isEmpty(orderEmail.value) ||
      isEmpty(orderPhoneNum.value) ||
      isEmpty(orderDate.value) ||
      isEmpty(orderAddress.value) ||
      isEmpty(orderChosenPizza.value)
    ) {
      orderButton.disabled = true;
    } else {
      orderButton.disabled = false;
    }
  } else {
    orderButton.disabled = true;
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

disableOrderButton();

orderName.addEventListener('input', () => onChange('orderName', orderName.value));
orderEmail.addEventListener('input', () => onChange('orderEmail', orderEmail.value));
orderPhoneNum.addEventListener('input', () => onChange('orderPhoneNum', orderPhoneNum.value));
orderDate.addEventListener('input', () => onChange('orderDate', orderDate.value));
orderAddress.addEventListener('input', () => onChange('orderAddress', orderAddress.value));
orderChosenPizza.addEventListener('change', () => onChange('orderChosenPizza', orderChosenPizza.value));
