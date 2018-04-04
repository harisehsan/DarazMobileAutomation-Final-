@TopUpPdpTH
Feature: TopUp testing on live environment for Guest and logIn user

    @CheckOperator @TH @Pre-live @One-2-Call
    Scenario: Checking autodetect One-2-Call
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0878464552"
        Then I check operator "1-2-Call!"

    @CheckOperator @TH @Pre-live @dtac-Happy
    Scenario: Checking autodetect dtac-Happy
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0894012486"
        Then I check operator "dtac online"

    @CheckOperator @TH @Pre-live @TRUEMOVE
    Scenario: Checking autodetect TRUEMOVE
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0647753690"
        Then I check operator "TRUEMOVE"

    @CheckOperator @TH @Pre-live @my-by-cat
    Scenario: Checking autodetect my by cat
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0806521219"
        Then I check operator "my by cat"

    @CheckProducts @TH @Pre-live
    Scenario: Checking autodetect my by cat and product
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0806521219"
        And I check operator "my by cat"
        Then I Select product "my by CAT 100 THB Topup"

    @CheckTransitionToChekout @TH @Pre-live
    Scenario: Checking transition to chekoutpage
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Enter number "0806521219"
        And I check operator "my by cat"
        And I Select product "my by CAT 100 THB Topup"
        Then I Push top-up now

    @CheckOperatorSelecting @TH @Pre-live
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        Then I Select operator

    @CheckLogin @TH
    Scenario: Checking sigin from topup page
        When I go to topup page "http://lazada.co.th/mobilerecharge.html"
        And I Log in from TopUp page, account: "topuplazadatests@gmail.com", password: "rock4you"
        Then I check after login
