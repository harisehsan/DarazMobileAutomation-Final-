
var apiUrl=arguments[0];
var name=arguments[1];
var phone=arguments[2];
var locationTreeAddressArray=arguments[3];
var locationTreeAddressId=arguments[4];
var locationTreeAddressName=arguments[5];
var csrfToken=arguments[6];



var data = JSON.stringify({
  "name": name,
  "phone": phone,
  "detailAddress": "123 QA Auto Address",
  "locationTreeAddressArray": locationTreeAddressArray,
  "locationTreeAddressId": locationTreeAddressId,
  "locationTreeAddressName": locationTreeAddressName
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