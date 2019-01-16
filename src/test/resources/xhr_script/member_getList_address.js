
var apiUrl=arguments[0];
var csrfToken=arguments[1];

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;
var callback = arguments[arguments.length - 1];
xhr.addEventListener("readystatechange", function () {
  if (this.readyState === 4) {
    callback(xhr.responseText);
  }
});

xhr.open("GET", apiUrl);
xhr.setRequestHeader("content-type", "application/json");
xhr.setRequestHeader("x-csrf-token", csrfToken);
xhr.setRequestHeader("cache-control", "no-cache");
xhr.setRequestHeader("x-umidtoken", umidTokenFromHeader);

xhr.send(null);

