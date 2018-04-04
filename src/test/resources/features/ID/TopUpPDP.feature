@TopUpPdpID
Feature: TopUp testing on live environment for Guest and logIn user

    @CheckOperator @ID @Pre-live @Telkomsel
    Scenario: Checking autodetect Telkomsel
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "081291756662"
        Then I check operator "Telkomsel"

    @CheckOperator @ID @Pre-live @Indosat
    Scenario: Checking autodetect Indosat
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "085691349167"
        Then I check operator "Indosat"

    @CheckOperator @ID @Pre-live @Xl
    Scenario: Checking autodetect Xl
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "087855123335"
        Then I check operator "Xl"

    @CheckOperator @ID @Pre-live @Axis
    Scenario: Checking autodetect Axis
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "083830211115"
        Then I check operator "Axis"

    @CheckOperator @ID @Pre-live @TRI
    Scenario: Checking autodetect TRI
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "08999812283"
        Then I check operator "TRI"

    @CheckOperator @ID @Pre-live @Bolt
    Scenario: Checking autodetect Bolt
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "09991120942"
        Then I check operator "Bolt"

    @CheckProducts @ID @Pre-live
    Scenario: Checking autodetect Telkomsel and product
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "081291756662"
        And I check operator "Telkomsel"
        Then I Select product "Paket Data Telkomsel 25.000"

    @CheckTransitionToChekout @ID @Pre-live
    Scenario: Checking transition to chekoutpage
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "081291756662"
        And I check operator "Telkomsel"
        And I Select product "Paket Data Telkomsel 25.000"
        Then I Push top-up now

    @CheckProducts @ID @Pre-live @Telkomsel
    Scenario: Checking switching product menu
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Enter number "081291756662"
        And I check operator "Telkomsel"
        And I Select product "Pulsa Telkomsel 25.000"
        And I Select product tab "Paket Data"
        And I Select product "Paket Data Telkomsel 25.000"
        And I Select product tab "Pulsa"
        Then I Select product "Pulsa Telkomsel 25.000"

    @CheckOperatorSelecting @ID @Pre-live
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        Then I Select operator

    @CheckLogin @ID
    Scenario: Checking sigin from topup page
        When I go to topup page "http://lazada.co.id/mobilerecharge.html"
        And I Log in from TopUp page, account: "topuplazadatests@gmail.com", password: "rock4you"
        Then I check after login
