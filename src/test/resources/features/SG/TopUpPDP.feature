@TopUpPdpSG
Feature: TopUp testing on pre-live environment for Guest and LogIn user

    @CheckNumberField @SG
    Scenario: Guest go to topUp page and enter number
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        Then I Enter number "83573125"

    @CheckOperator @SG
    Scenario: Guest go to topUp page, enter number and select product
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        And I Enter number "83573125"
        Then I Select product "$5 hi! Top-up Card"

    @CheckProductSelection @SG
    Scenario: Guest go to topUp page, selecting product from other tabs
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        And I Enter number "83573125"
        And I Select product "$5 hi! Top-up Card"
        And I Select product tab "Data"
        And I Select product "Singtel Data Package- 1GB (7 days)"
        And I Select product tab "Balance"
        And I Select product "$5 hi! Top-up Card"
        Then I Push top-up now

    @CheckOperatorSelecting @SG
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        Then I Select operator

    @CheckListOfNumber @SG
    Scenario: Logged go to topup page and select number from list
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        And I Log in from TopUp page, account: "tangsi.hwt@taobao.com", password: "hello1234"
        Then I check after login

    @CheckListOfNumber2 @SG
    Scenario: Logged go to topup page and select number from list, enter other number and select number again
        When I go to topup page "http://pdpdesc-m.lazada.sg/mobilerecharge.html"
        And I Log in from TopUp page, account: "tangsi.hwt@taobao.com", password: "hello1234"
        And I check after login
        And I select phone number from list
        And I Enter number "83573125"
        Then I select phone number "88888888" in list

