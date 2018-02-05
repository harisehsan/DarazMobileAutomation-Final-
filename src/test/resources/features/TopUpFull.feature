@TopupFull
Feature: TopUp testing on daily environment for logIn user

    @ChecklogIn
    Scenario: Logged go to topup page
        When I go to topup daily page
        And I Log in from TopUp page, account: "test.topup.lazada@gmail.com", password: "rock4you"
        And I check after login

    @CheckPay
    Scenario: Logged go to topup page
        When I go to topup daily page
        And I Enter number "83573125"
        And I Select product "M1- $50 hi! Top-up Card"
        And I Push top-up now
        And I select credit card payment method
        And I open new card
        And I enter card data number:"4111111111111111", name:"Test", date:"0925", cvv:"023"
        And I don't save card
        And I confirm pay
        And I wait loader, waiting:"320"
        And I check pending

    @CheckSavePhoneNumber
    Scenario: checking save phone number
        When I go to topup daily page
        And I Enter number "83573126"
        And I Select product "M1- $50 hi! Top-up Card"
        And I Push top-up now
        And I select credit card payment method
        And I open new card
        And I enter card data number:"4176661000001015", name:"Test", date:"0925", cvv:"023"
        And I don't save card
        And I confirm pay
        And I wait loader, waiting:"320"
        And I check pending
        And I go to topup daily page
        And I select phone number from list by number: "83573126"













