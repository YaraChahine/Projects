const pizzaName = document.getElementById('pizzaName');
const pizzaSize = document.getElementById('pizzaSize');
const doughType = document.getElementById('doughType');
const crustType = document.getElementById('crustType');
const toppings = document.getElementById('topChoices');

const pizzaNameError = document.getElementById('pizzaNameError');
const pizzaSizeError = document.getElementById('pizzaSizeError');
const doughTypeError = document.getElementById('doughTypeError');
const crustTypeError = document.getElementById('crustTypeError');
const toppingsError = document.getElementById('topChoicesError');

const calculatePriceButton = document.getElementById('btn-totalPrice');
const calculatedPrice = document.getElementById('priceText');
const submitPizzaButton = document.getElementById('submitPizza');

const prices = {
  smallPizza: 8,
  mediumPizza: 12,
  largePizza: 15,
  xLargePizza: 25,
  veganDough: 5,
  regularDough: 0,
  glutenFreeDough: 5,
  wholeWheatDough: 5,
  thinCrust: 4,
  normalCrust: 2,
  thickCrust: 6,
  stuffedCrust: 5,
  newYorkStyleCrust: 8,
  chicagoDeepDishCrust: 8,
  olives: 2,
  mushroom: 2,
  greenPeppers: 2,
  crispySageLeaves: 3,
  onion: 2,
  extraCheese: 4,
  asparagus: 3,
  pepperoni: 1,
  sausage: 3,
  pancetta: 3,
  chicken: 2,
  anchovies: 2,
  prosciutto: 5,
  BBQ: 1,
  ranch: 1,
  blueCheese: 3,
};

function onChange(name, value) {
  if (name === 'pizzaName') {
    if (isEmpty(value)) {
      pizzaName.style.border = '1px solid red';
      pizzaNameError.innerHTML = 'Please enter your pizza name';
    } else if (!isValidName(value)) {
      pizzaName.style.border = '1px solid red';
      pizzaNameError.innerHTML =
        'Your pizza name must be between 3 and 16 characters, and made up of letters, numbers, - or _';
    } else {
      pizzaName.style.border = '1px solid transparent';
      pizzaNameError.innerHTML = '';
    }
    disableSubmitButton();
  } else if (name === 'pizzaSize') {
    if (isEmpty(value)) {
      pizzaSize.style.border = '1px solid red';
      pizzaSizeError.innerHTML = "Choose your pizza's size";
    } else {
      pizzaSize.style.border = '1px solid transparent';
      pizzaSizeError.innerHTML = '';
    }
    disableSubmitButton();
  } else if (name === 'doughType') {
    if (isEmpty(value)) {
      doughType.style.border = '1px solid red';
      doughTypeError.innerHTML = "Choose your pizza's dough";
    } else {
      doughType.style.border = '1px solid transparent';
      doughTypeError.innerHTML = '';
    }
    disableSubmitButton();
  } else if (name === 'crustType') {
    if (isEmpty(value)) {
      crustType.style.border = '1px solid red';
      crustTypeError.innerHTML = "Choose your pizza's crust";
    } else {
      crustType.style.border = '1px solid transparent';
      crustTypeError.innerHTML = '';
    }
    disableSubmitButton();
  } else if (name === 'toppings') {
    let selected = [];
    for (let i = 0; i < value.options.length; i++) {
      if (value.options[i].selected) {
        selected.push(value.options[i].value);
      }
    }
    // options.forEach((option) =>
    //   option.selected ? selected.push(option.value) : {},
    // );
    if (selected.length === 0) {
      toppings.style.border = '1px solid red';
      toppingsError.innerHTML = 'Choose at least one topping';
    } else {
      toppings.style.border = '1px solid transparent';
      toppingsError.innerHTML = '';
    }
  }
  disableSubmitButton();
}

function isEmpty(input) {
  return input === undefined || input === '' || input === null;
}

function isValidName(name) {
  return /^[a-z0-9_-]{3,16}$/i.test(name);
}

function disableSubmitButton() {
  if(isEmpty(pizzaNameError.innerHTML) || 
  isEmpty(pizzaSizeError.innerHTML) || 
  isEmpty(doughTypeError.innerHTML) || 
  isEmpty(crustTypeError.innerHTML) ||
  isEmpty(toppingsError.innerHTML)){
    if (
      isEmpty(pizzaName.value) ||
      isEmpty(pizzaSize.value) ||
      isEmpty(doughType.value) ||
      isEmpty(crustType.value)
    ){
        submitPizzaButton.disabled = true;
    }
     else {
        submitPizzaButton.disabled = false;
      }
  }
  else{
    submitPizzaButton.disabled = true;
  }
}

function calcPrice() {
  let sum = 0;
  if (!isEmpty(pizzaSize.value)) {
    sum += prices[pizzaSize.value];
  }
  if (!isEmpty(doughType.value)) {
    sum += prices[doughType.value];
  }
  if (!isEmpty(crustType.value)) {
    sum += prices[crustType.value];
  }
  let selectedToppings = [];
  for (let i = 0; i < toppings.options.length; i++) {
    if (toppings.options[i].selected) {
      selectedToppings.push(toppings.options[i].value);
    }
  }
  if(selectedToppings.length > 0){
    selectedToppings.forEach(topping => sum += prices[topping]);
  }
  calculatedPrice.innerHTML = `${sum}$`;
}
disableSubmitButton();

pizzaName.addEventListener('input', () =>
  onChange('pizzaName', pizzaName.value),
);
pizzaSize.addEventListener('change', () =>
  onChange('pizzaSize', pizzaSize.value),
);
doughType.addEventListener('change', () =>
  onChange('doughType', doughType.value),
);
crustType.addEventListener('change', () =>
  onChange('crustType', crustType.value),
);
toppings.addEventListener('change', () => onChange('toppings', toppings));
calculatePriceButton.addEventListener('click', () => calcPrice());

// function click(e) {
//   e.preventDefault(); //prevents it from defaulting aka submitting and refreshing the page before the user is done creating
//   let ele = toppings;
//   let choice = ele.options[ele.selectedIndex].text;
//   if (choice != 'Choose your toppings!') {
//     const listEle = document.createElement('li');
//     const listEleSpan = document.createElement('span');
//     const listEleBtn = document.createElement('button');

//     listEle.appendChild(listEleSpan);
//     listEle.appendChild(listEleBtn);

//     listEleSpan.innerHTML = choice;
//     listEleBtn.innerHTML = 'Remove item';

//     list.appendChild(listEle);

//     listEleBtn.addEventListener('click', function () {
//       listEle.remove();
//     });
//   }
// }
// addToppings.addEventListener('click', click);

// const priceText = document.getElementById('priceText');
// let totalPriceBtn = document.getElementById('btn-totalPrice');
// // let pizzaName = document.getElementById(pizzaName);

// function calculatePrice(e) {
//   e.preventDefault();
//   let element = document.getElementById('pizzaSize');
//   let pizzaSize = element.options[element.selectedIndex].value;

//   element = document.getElementById('doughType');
//   let doughType = element.options[element.selectedIndex].value;

//   element = document.getElementById('crustType');
//   let crustType = element.options[element.selectedIndex].value;

//   element = document.getElementById('topChoices');
//   let topChoices = element.options[element.selectedIndex].value;

//   //convert data to int
//   pizzaSize = parseInt(pizzaSize);
//   doughType = parseInt(doughType);
//   crustType = parseInt(crustType);
//   topChoices = parseInt(topChoices);

//   let totalPrice = pizzaSize + doughType + crustType + topChoices;

//   // document.getElementById("btn-totalPrice").value = totalPriceBtn;

//   document.getElementById('priceText').value = totalPrice;

//   totalPriceBtn.addEventListener('click', function () {
//     // let totalPriceBtn = document.getElementById("btn-totalPrice");

//     // priceText.innerText(totalPriceBtn) = totalPriceBtn;
//     document.getElementById('priceText').innerHTML = totalPrice;
//   });
// }
// totalPriceBtn.addEventListener('click', calculatePrice);
