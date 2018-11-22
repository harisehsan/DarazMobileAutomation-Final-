

var apiUrl=arguments[0];
var email=arguments[1];
var password=arguments[2];
var name=arguments[3];
var csrfToken=arguments[4];



var data = JSON.stringify({
  "lzdAppVersion": "1.0",
  "name": name,
  "email": email,
  "password": password,
  "enableNewsletter": true,
  "bizScene": "visitCart_cart"
});

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;
var callback = arguments[arguments.length - 1];
xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    callback(xhr.responseText);
  }
});

xhr.open("POST", apiUrl);
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("x-csrf-token", csrfToken);
xhr.setRequestHeader("cache-control", "no-cache");

xhr.send(data);