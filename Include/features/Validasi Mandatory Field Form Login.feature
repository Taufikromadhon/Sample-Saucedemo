Feature: Validasi Mandatory Field Form

  Scenario: Validasi Mandatory Field Form
    Given User navigates to saucedemo.com untuk triger Validasi Mandatory Field Form Login
    When Kosongkan field username "" pada form login
    And Kosongkan field password "" pada form login
    And Click Login Button untuk triger Validasi Mandatory Field Form Login
    Then Berhasil menampilkan Validasi Mandatory Field Form Login dibuktikan dengan evidence
