@TopupMobileSmokeSG
Feature: Smoke tests for topup mobile page

  @PhoneInput
  Scenario: Enter number
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573111" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check value in input "Phone input" should be "8357 3111" on "topup mobile" page

  @PhoneInput
  Scenario: Enter number with country code
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "+6583573111" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check value in input "Phone input" should be "8357 3111" on "topup mobile" page

  @PhoneInput
  Scenario: Enter wrong number
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "00000" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that element "Phone input error" is on "topup mobile" page

  @PhoneInput
  Scenario: Check list with previous numbers
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    Then check value in input "Phone input" should be "8357 3111" on "topup mobile" page
    And click element "Phone input" on "topup mobile" page
    Then check correct of list with previous numbers

  @PhoneInput
  Scenario: Choice number from list with previous numbers
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    Then check value in input "Phone input" should be "8357 3111" on "topup mobile" page
    And click element "Phone input" on "topup mobile" page
    Then check correct of list with previous numbers
    And select "83573222" row from "Previous phone list" on "topup mobile" page
    Then check value in input "Phone input" should be "8357 3222" on "topup mobile" page

  @OperatorBlock
  Scenario: Check change operator manual
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that operator "https://sg-live-02.slatic.net/original/890ca878746af7af2d37501522db6683.jpg" selected correct
    And click element "Operator button" on "topup mobile" page
    And select operator "M1"
    Then check that operator "https://sg-live-02.slatic.net/p/18/m1-5-top-up-5828-33279171-a9c351baee95698d581c58b0fb47b223-catalog.jpg" selected correct

  @OperatorBlock
  Scenario: Check double change operator manual
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that operator "https://sg-live-02.slatic.net/original/890ca878746af7af2d37501522db6683.jpg" selected correct
    And click element "Operator button" on "topup mobile" page
    And select operator "M1"
    Then check that operator "https://sg-live-02.slatic.net/p/18/m1-5-top-up-5828-33279171-a9c351baee95698d581c58b0fb47b223-catalog.jpg" selected correct
    And click element "Operator button" on "topup mobile" page
    And select operator "Singtel"
    Then check that operator "https://sg-live-02.slatic.net/original/890ca878746af7af2d37501522db6683.jpg" selected correct

  @ProductBlock
  Scenario: Check sorting of products and auto select first product
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    Then check that first product is auto selected
    Then check sorts of products by price

  @ProductBlock
  Scenario: Check switching product tab
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select tab "Data"

  @ProductBlock
  Scenario: Check change products
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select product with name "SGD50.00"
    Then check that product "SGD50.00" was selected

  @ProductBlock
  Scenario: Check change product list after change operator
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select product with name "SGD50.00"
    And click element "Operator button" on "topup mobile" page
    And select operator "Starhub"
    And select product with name "SGD8.00"
    Then check that product "SGD8.00" was selected

  @VoucherBlock
  Scenario: enter correct voucher
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And select product with name "SGD10.00"
    And type to input with name "Voucher input" text: "CorrectVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then check that voucher "CorrectVoucher" was applied
    Then check that total price is "SGD9.99"

  @VoucherBlock
  Scenario: delete correct voucher
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And select product with name "SGD10.00"
    And type to input with name "Voucher input" text: "CorrectVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then check that voucher "CorrectVoucher" was applied
    And click element "Remove Voucher" on "topup mobile" page
    Then check that element "Voucher input" is on "topup mobile" page

  @VoucherBlock
  Scenario: check redirect to login page after apply voucher for guest user
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And type to input with name "Voucher input" text: "CorrectVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then verify that page with url which contains "member" is opened

  @VoucherBlock
  Scenario: check apply right voucher after apply voucher as guest user
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573222" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And type to input with name "Voucher input" text: "CorrectVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then verify that page with url which contains "member" is opened
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Then verify that page with url which contains "mobilerecharge" is opened
    Then check that voucher "CorrectVoucher" was applied

  @VoucherBlock
  Scenario: check apply incorrect voucher
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Voucher input" text: "WrongVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then check value in input "Voucher input" should be "WrongVoucher" on "topup mobile" page
    Then check that element "Voucher error" is on "topup mobile" page

  @VoucherBlock
  Scenario: check apply incorrect voucher as guest
    Given open Chrome mobile browser
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573999" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And type to input with name "Voucher input" text: "WrongVoucher" on "topup mobile" page
    And click element "Voucher apply" on "topup mobile" page
    Then verify that page with url which contains "member" is opened
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Then verify that page with url which contains "mobilerecharge" is opened
    Then check value in input "Voucher input" should be "WrongVoucher" on "topup mobile" page
    Then check that element "Voucher error" is on "topup mobile" page

  @TopupNow
  Scenario: check redirect from topup page to checkout page, after click topup now for user, is working
    Given open Chrome mobile browser
    Given open page "https://member-m.lazada.sg/user/login"
    And type to input with name "Email" text: "topup.auto@lazada.com" on "login mobile" page
    And type to input with name "Password" text: "rock4you" on "login mobile" page
    And click element "Login button" on "login mobile" page
    Given open page "https://my-m.lazada.sg/mobilerecharge"
    And type to input with name "Phone input" text: "83573999" on "topup mobile" page
    And press enter to "Phone input" on "topup mobile" page
    And select product with name "SGD5.00"
    And click element "Topup now button" on "topup mobile" page
    Then verify that page with url which contains "checkout" is opened
