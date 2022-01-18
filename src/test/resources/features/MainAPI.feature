Feature: Check universities list across the countries

#  @regression
#  Scenario Outline: Get all the univerisities in United states
#    Given user executes "<http>" request api "<endpint>" with params "<paramsList>" headers "<headersList>" and payload "<payloadName>"
#    When response code is "<ResponseCODE>"
#    Then Verifies that "<Unviverstity>" is present in the response
#    Examples:
#      | http | endpint | paramsList             | headersList | payloadName | ResponseCODE | Unviverstity   |
#      | GET  | /search | country=United States# |             |             | 200          | lindenwood.edu |

  @regression
  Scenario Outline: create a post record
    Given user executes "<http>" request api "<endpint>" with params "<paramsList>" headers "<headersList>" and payload "<payloadName>"
    When response code is "<ResponseCODE>"
#    Then Verifies that "<message>" is present in the response
    Examples:
      | http | endpint        | paramsList | headersList | payloadName      | ResponseCODE |
      | POST | /api/v1/create |            |             | API_POST_PAYLOAD | 200          |
      | GET  | /api/v1/create |            |             | API_POST_PAYLOAD | 404          |

