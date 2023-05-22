# Java-coursework
Code for coursework that I wrote in Java for my Principles and Practices of Large-Scale Programming module. We have to implement code for a fake luxury resort company.


## The premise of the course work:

The FIRE organisation manages a number of luxury resorts. Each resort consists of a group of small
islands with a range of leisure facilities. Each island is connected by a ferry to one of more of the other
islands of the resort. When guests arrive, they get a Pass (like a credit/debit card) which they can use for
making payments at the resort. A Pass records a number of credits. We are concerned with using Passes
to pay for ferry journeys. FIRE want to track people at their resorts and they have decided to use the
Passes to do this. This project will be implemented at the Fortunate Islands Resort (then rolled out to other
resorts).


## System Requirements

FIRE will locate people (guests and staff) by tracking their Passes

### A. The following basic functional requirements have been established for the proposed system:

- Display details of the whole resort
- List all Passes on all islands of the resort and Passes currently on a specified island
- Find the current location of a Pass
- Authorise a ferry journey, if it meets the required conditions
- Manage credits on a Pass, including convert journey points to credits


### B. The following data requirements have been established:

- Pass – the resort has a collection of Passes used by people at the resort for travelling
Information stored on Passes includes: a Pass ID number, person's name, a luxury rating, a number
of credits and journey points
The luxury rating (1 to 10) determines the islands which the person is allowed to visit e.g. a Pass
with a rating of 3 is allowed to visit to all islands rated 3 or below. A Pass is created with an initial
number of credits which are decremented when its owner makes a ferry journey. People may top up
their credits at any time.

Financial aspects of buying credits is outside the scope of this assignment

- Island – a resort has a network of islands
Each island has an id number, a name, a rating and a capacity (the maximum number of people
(Passes) that can be on the island at any one time). Each island should maintain a list of all Passes
currently on that island. These lists should be updated whenever a Pass enters or leaves a island,
so that it is always possible to say who is currently on a island and to find the island location of a
person as specified by their Pass

- Ferry journey– connects two islands of the resort
Each ferry journey has a journey code and connects a source island to a destination island. It
represents a journey in one direction only. and there is a standard price of 3 credits for all jouneys.
To make a ferry journey, certain conditions must be met. If these conditions are met, the system
allows the person onto the ferry to travel to the destination island. It updates its records to show that
a Pass has left the source island and has travelled to the destination island. It also updates the
Pass's credits and other information, as appropriate.

A request by someone(Pass) to make a ferry journey will produce one of the following results:
- Refusal to enter the ferry, because :
    - the Pass's luxury rating is lower than the rating of the destination island.
    - the arrival of the Pass would exceed the maximum capacity of the destination island.
    - the Pass does not have enough credits for the ferry journey
    - the Pass is not listed in the source island for the ferry
    - Successful entry, because none of the above conditions is true
    - Also, if either the Pass, or the ferry do not exist in the system, the journey will not be allowed
    - 
- Resort – implements the FIRE interface
Each resort has a network of islands joined by ferries. A resort must always have a “Base” island
which stores the Passes for everyone who arrives. Its name MUST always be "Base" and it MUST
have a rating of 0 and a large maximum capacity. All Passes registered at a resort are initially
added to this “Base” island.


## Project

The project consists of classes Pass, Island, Ferry, Resort, ResortUI, BusinessPass, TouristPass, EmployeePass. The Resort class implements the FIRE interface.

ResortUI is a simple print to console class that presents options to use methods from the Resort class, which itself uses objects of Pass/Island/Ferry.
