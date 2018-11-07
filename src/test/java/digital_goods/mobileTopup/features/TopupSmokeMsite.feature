@TopupMobileSmoke
Feature: Smoke tests for topup mobile page

    @PhoneInput
    Scenario: Enter number
        Given open Chrome mobile browser
        Given open topup page on M-site
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check value in input "Phone input" should be "098 252 1223" on "topup mobile" page

    @PhoneInput
    Scenario: Enter number with country code
        Given open Chrome mobile browser
        Given open topup page on M-site
        And type to input with name "Phone input" text: "+84982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check value in input "Phone input" should be "098 252 1223" on "topup mobile" page

    @PhoneInput
    Scenario: Enter number with country code
        Given open Chrome mobile browser
        Given open topup page on M-site
        And type to input with name "Phone input" text: "00000" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check that element "Phone input error" is on "topup mobile" page

    @PhoneInput
    Scenario: Check list with previous numbers
        Given open Chrome mobile browser
        Given open page "https://member-m.lazada.vn/user/login?"
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        Then check value in input "Phone input" should be "096 121 2121" on "topup mobile" page
        And click element "Phone input" on "topup mobile" page
        Then check correct of list with previous numbers

    @OperatorBlock
    Scenario: Check change operator manual
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check that operator "Viettel" selected correct
        And click element "Operator button" on "topup mobile" page
        And select operator "vinaphone"
        Then check that operator "vinaphone" selected correct

    @OperatorBlock
    Scenario: Check double change operator manual
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check that operator "Viettel" selected correct
        And click element "Operator button" on "topup mobile" page
        And select operator "vinaphone"
        Then check that operator "vinaphone" selected correct
        And click element "Operator button" on "topup mobile" page
        And select operator "Viettel"
        Then check that operator "Viettel" selected correct

    @ProductBlock
    Scenario: Check sorting of products and auto select first product
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        Then check that first product is auto selected
        Then check sorts of products by price

    @ProductBlock
    Scenario: Check switching product tab
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "01258594593" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And select tab "Code"

    @Debug @ProductBlock
    Scenario: Check reload product block after change operator
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "01258594593" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And select tab "Code"
        And select product with number 2
        And click element "Operator button" on "topup mobile" page
        And select operator "Viettel"
        Then check that product "₫50,000" was selected

    @ProductBlock
    Scenario: Check change product
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "01258594593" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And select product with name "₫100,000"
        Then check that product "₫100,000" was selected

    @VaucherBlock
    Scenario: enter correct voucher
        Given open Chrome mobile browser
        Given open page "https://member-m.lazada.vn/user/login?"
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And select product with name "₫100,000"
        And type to input with name "Voucher input" text: "testmai" on "topup mobile" page
        And click element "Voucher apply" on "topup mobile" page
        Then check that voucher "testmai" was applied
        Then check that total price is "₫96,200"

    @VaucherBlock
    Scenario: delete correct voucher
        Given open Chrome mobile browser
        Given open page "https://member-m.lazada.vn/user/login?"
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And select product with name "₫100,000"
        And type to input with name "Voucher input" text: "testmai" on "topup mobile" page
        And click element "Voucher apply" on "topup mobile" page
        Then check that voucher "testmai" was applied
        Then click element "Remove Voucher" on "topup mobile" page
        Then check that element "Voucher input" is on "topup mobile" page

    @VaucherBlock
    Scenario: check redirect to login page after apply voucher
        Given open Chrome mobile browser
        Given open topup page on M-site
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And type to input with name "Voucher input" text: "testmai" on "topup mobile" page
        And click element "Voucher apply" on "topup mobile" page
        Then verify that page with url which contains "member-m.lazada" is opened

    @VaucherBlock
    Scenario: check apply incorrect voucher
        Given open Chrome mobile browser
        Given open page "https://member-m.lazada.vn/user/login?"
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Voucher input" text: "testdesctop" on "topup mobile" page
        And click element "Voucher apply" on "topup mobile" page
        Then check value in input "Voucher input" should be "testdesctop" on "topup mobile" page
        Then check that element "Voucher error" is on "topup mobile" page

    @VaucherBlock
    Scenario: check apply incorrect voucher as guest
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And type to input with name "Voucher input" text: "WrongVoucher" on "topup mobile" page
        And click element "Voucher apply" on "topup mobile" page
        Then verify that page with url which contains "member-m.lazada" is opened
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Then verify that page with url which contains "mobilerecharge" is opened
        Then check value in input "Voucher input" should be "WrongVoucher" on "topup mobile" page
        Then check that element "Voucher error" is on "topup mobile" page


    @TopupNow
    Scenario: check redirect from topup page to checkout page, after click topup now for user, is working
        Given open Chrome mobile browser
        Given open page "https://member-m.lazada.vn/user/login?"
        And type to input with name "Email" text: "topuplazadatests@gmail.com" on "login mobile" page
        And type to input with name "Password" text: "rock4you" on "login mobile" page
        And click element "Login button" on "login mobile" page
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And select product with name "₫50,000"
        And click element "Topup now button" on "topup mobile" page
        Then verify that page with url which contains "checkout-m" is opened

    @TopupNow
    Scenario: check redirect from topup page to login page, after click topup now for guest user, is working
        Given open Chrome mobile browser
        Given open page "https://www.lazada.vn/mobilerecharge.html?"
        And type to input with name "Phone input" text: "0982521223" on "topup mobile" page
        And press enter to "Phone input" on "topup mobile" page
        And select product with name "₫50,000"
        And click element "Topup now button" on "topup mobile" page
        Then verify that page with url which contains "member-m.lazada" is opened









