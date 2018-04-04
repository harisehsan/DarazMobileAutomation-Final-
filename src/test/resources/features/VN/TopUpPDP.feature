@TopUpPdpVN
Feature: TopUp testing on live environment for Guest and logIn user

    @CheckOperator @VN @Pre-live @Viettel
    Scenario: Checking autodetect Viettel
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "0983736450"
        Then I check operator "Viettel"

    @CheckOperator @VN @Pre-live @Mobifone
    Scenario: Checking autodetect Mobifone
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "0906572298"
        Then I check operator "Mobifone"

    @CheckOperator @VN @Pre-live @Vinaphone
    Scenario: Checking autodetect Vinaphone
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "01258594593"
        Then I check operator "vinaphone"

    @CheckProducts @VN @Pre-live @Vinaphone
    Scenario: Checking transition to chekoutpage
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "01258594593"
        And I check operator "vinaphone"
        Then I Select product "Mã Thẻ Vinaphone 50.000 VND"

    @CheckTransitionToChekout @VN @Pre-live @Vinaphone
    Scenario: Checking autodetect Vinaphone and go to chekout page
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "01258594593"
        And I check operator "vinaphone"
        And I Select product "Mã Thẻ Vinaphone 50.000 VND"
        Then I Push top-up now

    @CheckProducts @VN @Pre-live @Vinaphone
    Scenario: Checking switching product menu
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Enter number "01258594593"
        And I check operator "vinaphone"
        And I Select product "Mã Thẻ Vinaphone 50.000 VND"
        And I Select product tab "Nạp tiền"
        And I Select product "Nạp tiền trực tiếp Vinaphone 50.000 VND"
        And I Select product tab "Mã thẻ"
        Then I Select product "Mã Thẻ Vinaphone 50.000 VND"

    @CheckOperatorSelecting @VN @Pre-live
    Scenario: Guest go to topUp page and select operator
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        Then I Select operator

    @CheckLogin @VN
    Scenario: Checking sigin from topup page
        When I go to topup page "http://lazada.vn/mobilerecharge.html"
        And I Log in from TopUp page, account: "topuplazadatests@gmail.com", password: "rock4you"
        Then I check after login
