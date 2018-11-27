/*
    Require for arguments:
    1st: login email
    2nd: password
    3rd: api url (e.g https://member.daraz.pk/user/api/login)
    4th: csrf token
*/

var apiUrl=arguments[0];
var email=arguments[1];
var password=arguments[2];
var csrfToken=arguments[3];

var data = JSON.stringify({
  "lzdAppVersion": "1.0",
  "loginName": email,
  "password": password
});
var callback = arguments[arguments.length - 1];
var xhr = new XMLHttpRequest();
xhr.withCredentials = true;
xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    callback(xhr.responseText);
  }
});

xhr.open("POST", apiUrl);
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("x-csrf-token",csrfToken);
xhr.setRequestHeader("cache-control", "no-cache");
xhr.setRequestHeader("x-umidtoken", umidTokenFromHeader);

xhr.send(data);