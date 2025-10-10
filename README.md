# Charles Schwab Java API

Provides access to Charles Schwab account management, trading, and market data via their REST API.  Currently supports all API for Account Management and Market Data.  Minimal dependencies. Only depends on the Jackson library for JSON parsing and Java-Websocket for streaming. Fully concurrent. Designed to be lightweight, fast, and easy to use.

## Installation
This project is configured as a Maven project developed with Eclipse.  The easiest way to set it up is to simply copy the .jar or .jar with dependencies (if your project does not already use Jackson Databind) into your project and reference it.  Alternatively, import the project into your development environment as a Maven project and use Maven to build it.

## Setup

To use the Schwab API, you will need an App Key and Secret key.  You can set that up and link it to your Schwab account here:  https://developer.schwab.com/.  Use https://127.0.0.1 when prompted for the Callback URL.

You will need to apply for "Accounts and Trading" as well as "Market Data" to use the full API.  It might take a few days for approval.  This library will need access to the App Key and Secret key for authentication.  Copy the file ./resources/client_secrets.json into a folder called ".schwab" in home directory.  The home directory is the location pointed to by Java property "user.home".  It's probably C:/Users/yourusername/ on windows or /home/yourusername/ on Linux/Mac.  The client_secrets.json contains:

```json
{
    "app_key": "",
    "app_secret": "",
    "redirect_uris": "https://developer.schwab.com/oauth2-redirect.html",
    "auth_uri": "https://api.schwabapi.com/v1/oauth/authorize",
    "token_uri": "https://api.schwabapi.com/v1/oauth/token"
}
```

Update with your app_key and app_secret.

The library maintains both an active and refresh token.  The active token expires after 30 minutes and the refresh token is valid for 7 days currently.  Once the active token expires, the library will use the refresh token to generate a new active token.  If the refresh token is expired or does not exist (which will be the case the first time an API is called), then you will receive a prompt to sign in using your Schwab trading account credentials.  The library should automatically open a browser to the sign-on page.  (If not, the link will be on a pop-up.)  After sign-on, your browser should take you to a webpage starting with the Callback URL entered earlier (https://127.0.0.1).  Copy the entire link and paste it into the text-field of the pop-up window.  The library will extract the active and refresh tokens as well as the expiration time from that.  It will store the active key in memory, but will write the refresh token and expiration as a serialized Token object to the .schwab folder in your home directory.  Since the refresh key expires after 7 days, you should only have to submit your login credentials every 7 days.

## Usage

See Tests/UnitTests.java for examples of how to use all currently available API.  As an example, all available options chains for AAPL can be pulled with 3 lines of code:

```java
SchwabAPI api = new SchwabAPI();
OptionsChainQuery query = new OptionsChainQuery("AAPL");
OptionChain optionschain = api.getOptionsChains(query);
```

Quotes for AAPL, AMD, and MSFT can be pulled using this:

```java
SchwabAPI api = new SchwabAPI();
QuoteQuery query = new QuoteQuery("AAPL,AMD,MSFT");
QuoteResponse quotes = api.getQuotes(query);
```

OptionChain and QuoteResponse are Java objects that map directly to the JSON schema defined on the Schwab Developer Portal: https://developer.schwab.com/home

## Legal
Code is provided as is.  Not responsible for outcomes that may result from bugs or unintended events.