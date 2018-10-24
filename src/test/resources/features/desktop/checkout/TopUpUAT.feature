@TopupUAT
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