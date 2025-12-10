Feature: Validasi Invalid Login

  Scenario Outline: Validasi Invalid Login
    Given User navigates to saucedemo.com untuk invalid login
    When Input invalid <username> on username field
    And Input invalid <password> on password field
    And Click Login Button untuk mentriger notif invalid
    Then Tidak berhasil Login, dimunculkan notif dibuktikan dengan evidence

    Examples: 
      | username      | password     |
      
      | invalid_user1 | secret_sauce |
      | visual_user | invalid_pass |
      | invalid_user2 | invalid_pass2 |
