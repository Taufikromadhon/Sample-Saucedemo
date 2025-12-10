Feature: Sukses Login

  Scenario Outline: Sukses Login
    Given User navigates to saucedemo.com
    When Input valid <username> on username field
    And Input valid <password> on password field
    And Click Login Button
    Then Berhasil Login dibuktikan dengan evidence

    Examples: 
      | username      | password     |
      
      | standard_user | secret_sauce |
      | visual_user | secret_sauce |
