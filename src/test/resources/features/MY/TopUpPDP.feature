@TopUpPdpMY
Feature: TopUp testing on live environment for Guest and logIn user

    @CheckOperator @MY @Pre-live @Digi
    Scenario: Checking autodetect Digi
        When I go to topup page "http://lazada.com.my/mobilerecharge.html"
        And I Enter number "0162875976"
        Then I check operator "Digi"

    @CheckProducts @MY @Pre-live
    Scenario: Checking autodetect Digi and product
        When I go to topup page "http://lazada.com.my/mobilerecharge.html"
        And I Enter number "0162875976"
        And I check operator "Digi"
        Then I Select product "Digi RM10"

    @CheckTransitionToChekout @MY @Pre-live
    Scenario: Checking transition to chekoutpage
        When I go to topup page "http://lazada.com.my/mobilerecharge.html"
        And I Enter number "0162875976"
        And I check operator "Digi"
        And I Select product "Digi RM10"
        Then I Push top-up now

    @CheckOperatorSelecting @MY @Pre-live
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://lazada.com.my/mobilerecharge.html"
        Then I Select operator

    @CheckLogin @MY
    Scenario: Checking sigin from topup page
        When I go to topup page "http://lazada.com.my/mobilerecharge.html"
        And I Log in from TopUp page, account: "topuplazadatests@gmail.com", password: "rock4you"
        Then I check after login
