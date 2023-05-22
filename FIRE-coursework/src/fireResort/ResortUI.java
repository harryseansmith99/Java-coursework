package fireResort;

import java.util.*;

/**
 * Class containing UI elements for the fireResort.Resort class.
 * Methods in this class are provided as a wrapper for methods in the fireResort.Resort class.
 *
 * @author (Harry Smith)
 * @version (a version number or a date)
 */
public class ResortUI
{
    private Scanner reader = new Scanner(System.in);
    private FIRE fortunate = new Resort("Fortunate Islands");


    /** implements getOption() method of fireResort.ResortUI class
     *
     *
     */
    private void runUI()
    {
        int choice = getOption();
        while (choice != 0)
        {
            // process choice
            if      (choice == 1) {listAllResort();}
            else if (choice == 2) {listAllPasses();}
            else if (choice == 3) {listOneIsland();}
            else if (choice == 4) {findLocationOfPass();}
            else if (choice == 5) {tryTravel();}
            else if (choice == 6) {travelNow();}
            else if (choice == 7) {viewPass();}
            else if (choice == 8) {updateCredits();}
            else if (choice == 9) {convertPts();}

            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }

    /**
     * presents options to the user, passes the result to runUI method of fireResort.ResortUI class
     * @return the input, if input is 0 then the program exits
     */
    private int getOption()
    {
        System.out.println("What would you like to do?");
        System.out.println("0 -> Quit");
        System.out.println("1 -> List all resort details");
        System.out.println("2 -> List all passes on all islands");
        System.out.println("3 -> List all passes on one island");
        System.out.println("4 -> Find location of pass");
        System.out.println("5 -> Say if pass can move by ferry");
        System.out.println("6 -> Move a pass by ferry");
        System.out.println("7 -> View pass");
        System.out.println("8 -> Top up credits");
        System.out.println("9 -> Convert points to credits ");

        System.out.println("Enter your choice:");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    /**
     * prints out all resorts using toString() method inherited from fireResort.Resort class
     */
    private void listAllResort()
    {
        System.out.println(fortunate.toString());
    }

    /**
     * prints out info of all passes on islands, in order of islands
     * uses getAllPassesOnAllIslands() method inherited from fireResort.Resort class
     */
    private void listAllPasses()
    {
        System.out.println(fortunate.getAllPassesOnAllIslands());
    }

    /**
     * gets user input, user chooses an island and method prints information of passes on that particular island.
     * Inherits getAllPassesOnIsland() method from fireResort.Resort class
     */
    private void listOneIsland()
    {
        // prompt
        System.out.println("Please enter the id number of the island of the island:\n");
        System.out.println("Base    ->  enter 0");
        System.out.println("Yorkie  ->  enter 1");
        System.out.println("Bounty  ->  enter 2");
        System.out.println("Twirl   ->  enter 3");
        System.out.println("Aero    ->  enter 4");
        System.out.println("Or press q to quit\n");

        // key is user input, value is name of island
        HashMap<Integer, String> options = new HashMap<>();

        options.put(0, "Base");  options.put(1, "Yorkie");  options.put(2, "Bounty");  options.put(3, "Twirl");
        options.put(4, "Aero");

        while (true)
        {
            String input = reader.nextLine();
            try
            {
                if (input.equalsIgnoreCase("q"))    // quit condition, allow input to be 'q' or 'Q'
                {
                    System.out.println("\nYou have quit, thanks\n");
                    return;     // breaks out of method
                }
                else
                {
                    int inputInt = Integer.parseInt(input);   // attempt to convert input to int
                    if (options.containsKey(inputInt))      // if option is a key in hashmap 'options', then the value is the correct island name
                    {
                        System.out.println(fortunate.getAllPassesOnIsland(options.get(inputInt)) + "\n");
                        return;
                    }
                    else
                    {
                        // if wrong input, such as incorrect int or String input, loop will start again
                        System.out.println("\nInvalid input, please pick again\n");
                        System.out.println("Base    ->  enter 0");
                        System.out.println("Yorkie  ->  enter 1");
                        System.out.println("Bounty  ->  enter 2");
                        System.out.println("Twirl   ->  enter 3");
                        System.out.println("Aero    ->  enter 4");
                        System.out.println("Or press q to quit\n");
                    }
                }
            }
            catch (Exception e)
            {
                // if any other input, such as double, loop will start again
                System.out.println("Base    ->  enter 0");
                System.out.println("Yorkie  ->  enter 1");
                System.out.println("Bounty  ->  enter 2");
                System.out.println("Twirl   ->  enter 3");
                System.out.println("Aero    ->  enter 4");
                System.out.println("Or press q to quit\n");
            }
        }
    }

    /**
     * gets user input, user chooses which pass to view and method prints what island that pass is located at.
     * inherits findPassLocation() method from fireResort.Resort class.
     */
    private void findLocationOfPass()
    {
        System.out.println("Enter pass id");
        System.out.println("Lynn (number 1000) ->  enter 0");
        System.out.println("May  (number 1001) ->  enter 1");
        System.out.println("Nils (number 1002) ->  enter 2");
        System.out.println("Olek (number 1003) ->  enter 3");
        System.out.println("Pan  (number 1004) ->  enter 4");
        System.out.println("Quin (number 1005) ->  enter 5");
        System.out.println("Raj  (number 1006) ->  enter 6");
        System.out.println("Sol  (number 1007) ->  enter 7");
        System.out.println("Tel  (number 1008) ->  enter 8");
        System.out.println();
        int trav = reader.nextInt();
        String ww = fortunate.findPassLocation(trav);
        if (ww != null)
        {
            System.out.println(ww);
            System.out.println();
        }
        else
        {
            System.out.println("No such pass");
        }
    }

    /**
     * gets user input, user enters pass id and method prints true if it can travel, false if it cant
     * inherits canTravel() method from fireResort.Resort class
     */
    private void tryTravel()
    {
        System.out.println("Enter pass id");
        System.out.println("Lynn (number 1000) ->  enter 0");
        System.out.println("May  (number 1001) ->  enter 1");
        System.out.println("Nils (number 1002) ->  enter 2");
        System.out.println("Olek (number 1003) ->  enter 3");
        System.out.println("Pan  (number 1004) ->  enter 4");
        System.out.println("Quin (number 1005) ->  enter 5");
        System.out.println("Raj  (number 1006) ->  enter 6");
        System.out.println("Sol  (number 1007) ->  enter 7");
        System.out.println("Tel  (number 1008) ->  enter 8");
        System.out.println();

        int trav = reader.nextInt();
        reader.nextLine();

        System.out.println("Enter ferry code");
        System.out.println("ABC1 (base to yorkie)    ->  enter 0");
        System.out.println("BCD2 (yorkie to base)    ->  enter 1");
        System.out.println("CDE3 (yorkie to bounty)  ->  enter 2");
        System.out.println("DEF4 (bounty to yorkie)  ->  enter 3");
        System.out.println("EFG5 (twirl to yorkie)   ->  enter 4");
        System.out.println("GHJ6 (yorkie to aero)    ->  enter 5");
        System.out.println("HJK7 (aero to yorkie)    ->  enter 6");
        System.out.println("JKL8 (bounty to twirl)   ->  enter 7");
        System.out.println();

        String ferry = reader.nextLine();
        System.out.println(fortunate.canTravel(trav, ferry));
    }

    /**
     * method to get user input for pass ID, this method is passed into travelNow() and
     * updateCredits() methods of fireResort.ResortUI class.
     * Includes exception handling to prevent user from entering wrong number or invalid input.
     * @return id input from the user (range from 0 to 8), if user enters "q" to quit it returns -1
     */
    private int getIdInput()
    {
        // present options to user
        System.out.println("Lynn (number 1000)  ->  enter 0");
        System.out.println("May  (number 1001)  ->  enter 1");
        System.out.println("Nils (number 1002)  ->  enter 2");
        System.out.println("Olek (number 1003)  ->  enter 3");
        System.out.println("Pan  (number 1004)  ->  enter 4");
        System.out.println("Quin (number 1005)  ->  enter 5");
        System.out.println("Raj  (number 1006)  ->  enter 6");
        System.out.println("Sol  (number 1007)  ->  enter 7");
        System.out.println("Tel  (number 1008)  ->  enter 8");
        System.out.println("Maximus (number 2000)  ->  enter 9");
        System.out.println("Claudius (number 3000) ->  enter 10");
        System.out.println("Augustus (number 4000) ->  enter 11");
        System.out.println("\nor press q to quit\n");

        while (true)
        {
            try
            {
                String input = reader.nextLine();
                if (input.equalsIgnoreCase("q")) // exit condition, can be 'q' or 'Q'
                {
                    System.out.println("\n\nThanks, you have quit\n\n");
                    return -1;     // this will break out of the method all together, since you need both pass id and ferry code to make a journey
                }
                else
                {
                    // cast input to int
                    int inputInt = Integer.parseInt(input);
                    if (inputInt >= 0 && inputInt < 9)    // options range from 0 to 11
                    {
                        return inputInt + 1000;
                    }
                    else if (inputInt == 9)
                    {
                        return 2000;
                    }
                    else if (inputInt == 10)
                    {
                        return 3000;
                    }
                    else if (inputInt == 11)
                    {
                        return 4000;
                    }
                    else
                    {
                        // happens if wrong String or int input
                        System.out.println("\nInvalid input, try again\n");
                        System.out.println("Lynn (number 1000) ->  enter 0");
                        System.out.println("May  (number 1001) ->  enter 1");
                        System.out.println("Nils (number 1002) ->  enter 2");
                        System.out.println("Olek (number 1003) ->  enter 3");
                        System.out.println("Pan  (number 1004) ->  enter 4");
                        System.out.println("Quin (number 1005) ->  enter 5");
                        System.out.println("Raj  (number 1006) ->  enter 6");
                        System.out.println("Sol  (number 1007) ->  enter 7");
                        System.out.println("Tel  (number 1008) ->  enter 8");
                        System.out.println("Maximus (number 2000)  ->  enter 9");
                        System.out.println("Claudius (number 3000) ->  enter 10");
                        System.out.println("Augustus (number 4000) ->  enter 11");
                        System.out.println("\nor press q to quit\n");
                    }
                }
            }
            catch (Exception e)
            {
                // happens if any other invalid input, i.e. double
                System.out.println("\nInvalid input, try again\n");
                System.out.println("Lynn (number 1000) ->  enter 0");
                System.out.println("May  (number 1001) ->  enter 1");
                System.out.println("Nils (number 1002) ->  enter 2");
                System.out.println("Olek (number 1003) ->  enter 3");
                System.out.println("Pan  (number 1004) ->  enter 4");
                System.out.println("Quin (number 1005) ->  enter 5");
                System.out.println("Raj  (number 1006) ->  enter 6");
                System.out.println("Sol  (number 1007) ->  enter 7");
                System.out.println("Tel  (number 1008) ->  enter 8");
                System.out.println("Maximus (number 2000)  ->  enter 9");
                System.out.println("Claudius (number 3000) ->  enter 10");
                System.out.println("Augustus (number 4000) ->  enter 11");
                System.out.println("\nor press q to quit\n");
            }
        }
    }

    /**
     * gets user input, user enters options to choose pass ID and ferry code, uses these items to process
     * a ferry joruney with travel() method inherited from fireResort.Resort class.
     * Implements getIdInput() method to retrieve passId.
     */
    private void travelNow()
    {
        // ask user to choose pass
        System.out.println("Please select which pass you wish to make the ferry journey:\n");
        int passId = getIdInput();  // init passId, will be assigned within the loop

        // if getIdInput results in quit condition, we can quit from this method
        if (passId == -1)
        {
            return;
        }

        // get ferry code input from user
        System.out.println("\nThanks, now for the ferry code. The options below show the ferry code with the source island to destination island in brackets:\n");
        System.out.println("\n[ QUICK NOTE - make sure you take note of the source and destination islands ]\n");
        System.out.println("ABC1 (base to yorkie)    ->  enter 0");
        System.out.println("BCD2 (yorkie to base)    ->  enter 1");
        System.out.println("CDE3 (yorkie to bounty)  ->  enter 2");
        System.out.println("DEF4 (bounty to yorkie)  ->  enter 3");
        System.out.println("EFG5 (twirl to yorkie)   ->  enter 4");
        System.out.println("GHJ6 (yorkie to aero)    ->  enter 5");
        System.out.println("HJK7 (aero to yorkie)    ->  enter 6");
        System.out.println("JKL8 (bounty to twirl)   ->  enter 7");
        System.out.println("\nor press q to quit\n");

        // hashmap holding options from above
        HashMap<Integer, String> options = new HashMap<>();

        // putting items in above map
        options.put(0, "ABC1");   options.put(1, "BCD2");   options.put(2, "CDE3");   options.put(3, "DEF4");
        options.put(4, "EFG5");   options.put(5, "GHJ6");   options.put(6, "HJK7");   options.put(7, "JKL8");

        String ferryCode; // hold code, will be assigned in below while loop

        while (true)
        {
            try
            {
                String input = reader.nextLine();

                // if user presses "q" to quit then we can break out of the method all together
                if (input.equalsIgnoreCase("q"))
                {
                    System.out.println("\n\nThanks, you have quit\n\n");
                    return;
                }
                else
                {
                    int inputInt = Integer.parseInt(input);

                    // if the user input is any of the keys in the hashmap, ferryCode is assigned the value of that key
                    if (options.containsKey(inputInt))
                    {
                        ferryCode = options.get(inputInt);
                        break;
                    }
                    else
                    {
                        // if user inputs the wrong int or invalid String
                        System.out.println("\nInvalid input, options are:\n");
                        System.out.println("ABC1 (base to yorkie)    ->  enter 0");
                        System.out.println("BCD2 (yorkie to base)    ->  enter 1");
                        System.out.println("CDE3 (yorkie to bounty)  ->  enter 2");
                        System.out.println("DEF4 (bounty to yorkie)  ->  enter 3");
                        System.out.println("EFG5 (twirl to yorkie)   ->  enter 4");
                        System.out.println("GHJ6 (yorkie to aero)    ->  enter 5");
                        System.out.println("HJK7 (aero to yorkie)    ->  enter 6");
                        System.out.println("JKL8 (bounty to twirl)   ->  enter 7");
                        System.out.println("\nor press q to quit\n");
                    }
                }
            }
            catch (Exception e)
            {
                // if the user inputs any other invalid input (i.e. double)
                System.out.println("\nInvalid input, options are:\n");
                System.out.println("ABC1 (base to yorkie)    ->  enter 0");
                System.out.println("BCD2 (yorkie to base)    ->  enter 1");
                System.out.println("CDE3 (yorkie to bounty)  ->  enter 2");
                System.out.println("DEF4 (bounty to yorkie)  ->  enter 3");
                System.out.println("EFG5 (twirl to yorkie)   ->  enter 4");
                System.out.println("GHJ6 (yorkie to aero)    ->  enter 5");
                System.out.println("HJK7 (aero to yorkie)    ->  enter 6");
                System.out.println("JKL8 (bounty to twirl)   ->  enter 7");
                System.out.println("\nor press q to quit\n");
            }
        }

        // print out which pass is travelling on which ferry, then call method to process the journey
        System.out.println("\nfireResort.Pass - " + passId + ", travelling on ferry - " + ferryCode + "\n");
        fortunate.travel(passId, ferryCode);
    }


    /**
     * gets user input to retrieve pass id, uses viewAPass() method from fireResort.Resort class to view information related to user input pass
     */
    private void viewPass()
    {
        int cId = getIdInput();
        System.out.println(fortunate.viewAPass(cId) + "\n\n");
    }

    /**
     * gets user input, user chooses a pass ID and then chooses how many credits to add to this pass,
     * uses these values with topUpCredits() method inherited from fireResort.Resort class.
     */
    private void updateCredits()
    {
        // ask the user choose the pass
        System.out.println("\nPlease enter the pass you want to top up credits for:\n");
        int passId = getIdInput();

        // if quit condition is met then we can break out of the method
        if (passId == -1)
        {
            System.out.println("\n\nThanks, you have quit\n\n");
            return;
        }

        System.out.println("\nThanks, now enter the amount you wish to top up the credits. Can only be an integer (AKA whole number). \nOr q to quit\n");
        int topUp;  // amount we will top up by, is assigned in the below while loop

        while (true)
        {
            try
            {
                String input = reader.nextLine();

                // if user enters "q" to quit then we can break out of the method
                if (input.equalsIgnoreCase("q"))
                {
                    System.out.println("\n\nThanks, you have quit\n\n");
                    return;
                }
                else
                {
                    // user enters the amount they want to top up by
                    int inputInt = Integer.parseInt(input);

                    // input must be positive or else there is no point to the method
                    if (inputInt >= 0)
                    {
                        topUp = inputInt;  // assign amount to topUp
                        break;
                    }
                    else
                    {
                        // if user enters negative number or invalid String
                        System.out.println("\nInput cannot be negative, try again\n");
                    }
                }
            }
            catch (Exception e)
            {
                // if user enters any other invalid input (i.e. double)
                System.out.println("\nInvalid input, try again\n");
            }
        }
        // process method to top up credits for specified pass
        System.out.println("\npassId - " + passId + ", updating credits by - " + topUp + "\n");
        fortunate.topUpCredits(passId, topUp);
    }


    /**
     * gets user input, converts the journeyPoints belonging to a pass and then converts it to credits using
     * convertPoints() method inherited from fireResort.Resort class
     */
    private void convertPts()
    {
        System.out.println("Enter pass ID number");
        System.out.println("Lynn (number 1000) ->  enter 0");
        System.out.println("May  (number 1001) ->  enter 1");
        System.out.println("Nils (number 1002) ->  enter 2");
        System.out.println("Olek (number 1003) ->  enter 3");
        System.out.println("Pan  (number 1004) ->  enter 4");
        System.out.println("Quin (number 1005) ->  enter 5");
        System.out.println("Raj  (number 1006) ->  enter 6");
        System.out.println("Sol  (number 1007) ->  enter 7");
        System.out.println("Tel  (number 1008) ->  enter 8");
        System.out.println("Maximus (number 2000)  ->  enter 9");
        System.out.println("Claudius (number 3000) ->  enter 10");
        System.out.println("Augustus (number 4000) ->  enter 11");

        int cId = reader.nextInt();
        fortunate.convertPoints(cId);
        System.out.println("\n");
    }


    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
