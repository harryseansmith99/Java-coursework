package fireResort;

import fireResort.*;

import java.util.*;

/**This class implements the fireResort.FIRE interface
 *
 * @author A.A.Marczyk & Harry Smith
 * @version
 **/
public class Resort implements FIRE   // do not change this header
{

    private String location;
    // Other fields (including collections)
    private ArrayList<Island> islands = new ArrayList<>();
    private ArrayList<Ferry> ferries = new ArrayList<>();
    private ArrayList<Pass> passes = new ArrayList<>();
//    private List<Object> passes2 = new ArrayList<>()

    /** constructor
     * Some code has been provided 
     */
    public Resort(String location)
    {
        this.location = location;
        loadIslandsAndFerries();
        loadPasses();
    }

    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString()
    {
        return "Location: " + this.location + "\n" + getAllPassesOnAllIslands();
    }

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands()
    {
        String s = "\nFinding passes...\n";
        for (Island i : this.islands)
        {
            String name = i.getIslandName();
            if (name.equals("No passes found"))
            {
                name = "No passes";
            }
            s += getAllPassesOnIsland(name);
        }
        return s;
    }


    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd -the id of the pass
     * @return the name of the fireResort.Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd)
    {
        for (Island island : this.islands)
        {
            Pass search = island.findPassId(cd);
            if (search != null)
            {
                return island.getIslandName();
            }
        }
        return "Not found";
    }

    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd)
    {
        for (Pass p : this.passes)
        {
            if (p.getPassId() == cd)
            {
                return p.toString();
            }
        }
        return "Not found";
    }

    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        for (Island i : this.islands)
        {
            String temp = i.getIslandName();
            if (isl.equals(temp))
            {
                return i.getIslandId();
            }
        }
        return -1;
    }

    /**Returns a String representation of all passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl)
    {
        String s = "\nPasses on " + isl +":";
        for (Island i : this.islands)
        {
            String temp = i.getIslandName();
            if (isl.equals(temp))
            {
                s += i.getRegister();
                return s;
            }
        }
        return "No passes found";
    }


    /**Returns true if a fireResort.Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the pass >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island 
     * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {
        try
        {
            // collect pass object from passes ArrayList
            Pass pass = null;   // initialise as null
            for (Pass p : this.passes)
            {
                if (p.getPassId() == cdId)
                {
                    pass = p;   // wherever we are in the ArrayList, if the id matches, this is now our pass
                }
            }

            // loop through ferries ArrayList
            for (Ferry f : this.ferries)
            {
                String search = f.getFerryCode();
                if (ferCode.equals(search))
                {
                    assert pass != null;    // we need to have a valid pass object to use travelCheck() method
                    if (f.travelCheck(pass))    // if travelCheck() returns true, the pass can travel
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        // if exception returned due to pass being null (meaning the pass does not exist), method will return false
        catch (NullPointerException e)
        {
            return false;
        }
    }

    /**Returns the result of a pass requesting to journey by fireResort.Ferry.
     * A journey will be successful if:  
     * the luxury rating of the pass  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. fireResort.Pass
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPassId, String ferCode)
    {   // initialise our String and fireResort.Pass objects
        String s = "";
        Pass pass = null;

        // loop through passes ArrayList<> to get pass correct object
        for (Pass p : this.passes)
        {
            if (p.getPassId() == pPassId)
            {
                pass = p;   // grab the correct pass object
            }
        }

        // loop through ferries ArrayList<>
        for (Ferry f : this.ferries)
        {
            String search = f.getFerryCode();
            if (ferCode.equals(search))
            {
                assert pass != null;
                String verdict = f.makeJourney(pass); // verdict will return the string message from makeJourney method
                s += verdict;   // add the verdict to our initialise String object from earlier, will tell us if pass can travel or not
            }
        }
        return s;
    }

    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds)
    {
        for (Pass p : this.passes)
        {
            if (p.getPassId() == id)
            {
                p.addCredits(creds);
            }
        }
    }

    /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id)
    {
        for (Pass p : this.passes)
        {
            if (p.getPassId() == id)
            {
                double jPointsConversion = p.jpointsToCredits(); // get amount of converted journeyPoints as credits
                p.addCredits(jPointsConversion); // add this amount to the current credits of the pass
                p.resetJourneyPoints(); // reset journeyPoints to zero
            }
        }
    }

    //***************private methods**************
    private void loadPasses()
    {
        // creating pass objects
        Pass lynn  = new Pass(1000, "Lynn", 5, 10);
        Pass may = new Pass(1001, "May", 3, 30);
        Pass nils = new Pass(1002, "Nils", 10, 0);
        Pass olek = new Pass(1003, "Olek", 1, 12);
        Pass pan = new Pass(1004, "Pan", 3, 3);
        Pass quin = new Pass(1005, "Quin", 1, 30);
        Pass raj = new Pass(1006, "Raj", 4, 5);
        Pass sol = new Pass(1007, "Sol", 7, 20);
        Pass tel = new Pass(1008, "Tel", 6, 30);

        Pass maximus = new TouristPass(2000, "Maximus", 1, 10, "GB");
        Pass claudius = new BusinessPass(3000, "Claudius", 20);
        Pass augustus = new EmployeePass(4000, "Augustus", 5, "Restroom Attendant");

        // putting all pass objects into array
        this.passes.add(lynn);
        this.passes.add(may);
        this.passes.add(nils);
        this.passes.add(olek);
        this.passes.add(pan);
        this.passes.add(quin);
        this.passes.add(raj);
        this.passes.add(sol);
        this.passes.add(tel);
        this.passes.add(maximus);
        this.passes.add(claudius);
        this.passes.add(augustus);


        // adding pass objects to fireResort.Island base
        for (Island i : this.islands)
        {
            if (i.getIslandId() == 0)
            {
                for (Pass p : this.passes)
                {
                    i.enter(p);
                }
            }
        }
    }

    private void loadIslandsAndFerries()
    {
        // creating island objects
        Island base = new Island(0, "Base", 0, 100);
        Island yorkie = new Island(1, "Yorkie", 1, 100);
        Island bounty = new Island(2, "Bounty", 3, 10);
        Island twirl = new Island(3, "Twirl", 5, 2);
        Island aero = new Island(4, "Aero", 1, 1);

        // creating ferry objects
        Ferry abc1 = new Ferry("ABC1", base, yorkie);
        Ferry bcd2 = new Ferry("BCD2", yorkie, base);
        Ferry cde3 = new Ferry("CDE3", yorkie, bounty);
        Ferry def4 = new Ferry("DEF4", bounty, yorkie);
        Ferry jkl8 = new Ferry("JKL8", bounty, twirl);
        Ferry efg5 = new Ferry("EFG5", twirl, yorkie);
        Ferry ghj6 = new Ferry("GHJ6", yorkie, aero);
        Ferry hjk7 = new Ferry("HJK7", aero, yorkie);

        // adding island objects to ArrayList<> islands
        this.islands.add(base);
        this.islands.add(yorkie);
        this.islands.add(bounty);
        this.islands.add(twirl);
        this.islands.add(aero);

        // adding ferry objects to ArrayList<> ferries
        this.ferries.add(abc1);
        this.ferries.add(bcd2);
        this.ferries.add(cde3);
        this.ferries.add(def4);
        this.ferries.add(jkl8);
        this.ferries.add(efg5);
        this.ferries.add(ghj6);
        this.ferries.add(hjk7);
    }

    /** Returns the pass with the pass id specified by the parameter
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id)
    {
        return null;
    }


    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        return null;
    }

    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
        return null;
    }
}