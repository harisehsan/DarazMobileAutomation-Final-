
// get umidToken
var umidTokenFromHeader = "defaultToken1_um_not_loaded@@" + location.href + "@@" + new Date().getTime();
AWSC.use("um", function (state, umModule) {
if (state === "loaded") {
umidTokenFromHeader = "defaultToken3_init_callback_not_called@@" + location.href + "@@" + new Date().getTime();
umModule.init({
appName: 'lazada',
serviceLocation: 'lazada'
}, function (initState, result) {
if (initState === 'success') {
umidTokenFromHeader = result.tn;
} else {
umidTokenFromHeader = "defaultToken4_init_failed with " + initState + "@@" + location.href + "@@" + new Date().getTime();
}
}
);
} else {
umidTokenFromHeader = "defaultToken2_load_failed with " + state + "@@" + location.href + "@@" + new Date().getTime();
}
});
// get user action information(UA)
window.uabModule = null;
window.UAFromHeader = 'defaultUAFromHeader with @@' + location.href + '@@' + new Date().getTime();
AWSC.use("uab", function (state, uab) {
if (state === "loaded") {
window.uabModule = uab;
window.UAFromHeader = uab.getUA();
}
})