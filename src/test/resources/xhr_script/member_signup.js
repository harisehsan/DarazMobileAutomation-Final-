

var apiUrl=arguments[0];
var email=arguments[1];
var password=arguments[2];
var name=arguments[3];
var csrfToken=arguments[4];
//var csrfToken=document.getElementById("X-CSRF-TOKEN").getAttribute("content");
//var csrfToken=document.cookie.match(new RegExp('(^| )_tb_token_=([^;]+)'))[2]



var data = JSON.stringify({
  "lzdAppVersion": "1.0",
  "email": email,
  "password": password,
  "name": name
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
xhr.setRequestHeader("x-umidtoken", umidTokenFromHeader);

xhr.send(data);