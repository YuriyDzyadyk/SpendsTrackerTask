# SpendsTrackerTask
#Application overview
Personal expenses management application that allows users to
track how much money have they spent.

#Application supports following commands:
\n-- add 2017-04-25 10.2 USD Jogurt — adds expense entry to the list
of user expenses where:
2017-04-25 — is the date when expense occurred (should be in format YYYY-MM-DD)
10.2 — is an amount of money spent (can be in integer or double format)
USD — the currency in which expense occurred (case insensitive)
Jogurt — is the name of product purchased (case sensitive, can be one or more than one word. If name contains more than one word - this name should  be taken into quotes)
-- list — shows the list of all expenses sorted by date
-- clear 2017-04-25 — removes all expenses for specified date,
-- total PLN — this command take a list of exchange rates from http://fixer.io, calculate the total amount of money spent and
present it to user in specified currency, where PLN — (case insensitive) is the currency in which total amount of expenses should
be presented
