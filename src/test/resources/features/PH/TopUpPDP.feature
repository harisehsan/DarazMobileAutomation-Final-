@TopUpPdpPH
Feature: TopUp testing on live environment for Guest and logIn user

    @CheckOperator @PH @Pre-live @Smart
    Scenario: Checking autodetect Smart
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09206456107"
        Then I check operator "Smart"

    @CheckOperator @PH @Pre-live @Globe
    Scenario: Checking autodetect Globe
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09955023756"
        Then I check operator "GlOBE"

    @CheckOperator @PH @Pre-live @Sun
    Scenario: Checking autodetect Sun
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09232441430"
        Then I check operator "SUN"

    @CheckOperator @PH @Pre-live @TNT
    Scenario: Checking autodetect TNT
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09480203560"
        Then I check operator "TNT"

    @CheckProducts @PH @Pre-live @TNT
    Scenario: Checking transition to chekoutpage
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09480203560"
        And I check operator "TNT"
        Then I Select product "TNTREGLOAD15"

    @CheckTransitionToChekout @PH @Pre-live @TNT
    Scenario: Checking autodetect TNT and go to chekout page
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09480203560"
        And I check operator "TNT"
        And I Select product "TNTREGLOAD15"
        Then I Push top-up now

    @CheckProducts @PH @Pre-live @TNT
    Scenario: Checking switching product menu
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Enter number "09480203560"
        And I check operator "TNT"
        And I Select product "TNTREGLOAD15"
        And I Select product tab "Data"
        And I Select product "TNTGARENAPINS100"
        And I Select product tab "Balance"
        Then I Select product "TNTREGLOAD15"

    @CheckOperatorSelecting @PH @Pre-live
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        Then I Select operator

    @CheckLogin @PH
    Scenario: Checking sigin from topup page
        When I go to topup page "http://lazada.com.ph/mobilerecharge.html"
        And I Log in from TopUp page, account: "topuplazadatests@gmail.com", password: "rock4you"
        Then I check after login