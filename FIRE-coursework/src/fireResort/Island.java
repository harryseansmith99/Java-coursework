package fireResort;

import java.util.*;
/**
 * An island is part of a fireResort.FIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can be on the
 * island at any one time. Each island must maintain a list of all people (passes)
 * currently on the island. These lists are updated whenever passes enter or leave
 * an island,so that it is always possible to say which passes are on the island
 *
 *
 * @author (Harry Smith)
 * @version (a version number or a date)
 */


public class Island
{

    private int islandId;
    private String islandName;
    private int luxuryRating;
    private int capacity;
    private ArrayList<Pass> register;   // fireResort.Pass objects currently on the island

    public Island(int islandId, String islandName, int luxuryRating, int capacity)
    {
        this.islandId = islandId;
        this.islandName = islandName;
        this.luxuryRating = luxuryRating;
        this.capacity = capacity;
        this.register = new ArrayList<>();
    }

    /**
     *
     * @return island id
     */
    public int getIslandId()
    {
        return this.islandId;
    }

    /**
     *
     * @return name of island
     */
    public String getIslandName()
    {
        return this.islandName;
    }

    /**
     *
     * @return luxury rating of fireResort.Island
     */
    public int getLuxuryRating()
    {
        return this.luxuryRating;
    }

    /**
     *
     * @return capacity of island, this is the total number of Passes that can be present on the island at one time
     */
    public int getCapacity()
    {
        return this.capacity;
    }

    /**
     *
     * @return  number of passes on that island at current moment, using the amount of entries in the
     *       ArrayList register belonging to fireResort.Island class (which holds all passes of the island)
     */
    public int noOfPasses()
    {
        return this.register.size();
    }

    /**
     * mutator method that adds a pass to the ArrayList register, this simulates a fireResort.Pass entering the island
     * after taking the ferry
     * @param p fireResort.Pass object that will enter the island
     */
    public void enter(Pass p)
    {
        this.register.add(p);
    }

    /**
     *
     * @param p id number for the pass
     * @return fireResort.Pass object by using the id number as a parameter. If the id does not match any fireResort.Pass in the system
     *         then the method will return null.
     */
    public Pass findPassId(int p)
    {
        // search through ArrayList<fireResort.Pass>  (which is 'capacity')

        for (int i=0; i< register.size(); i++)
        {
            Pass temp = register.get(i);
            if (temp.getPassId() == p)
            {
                return temp;
            }
        }
        return null;
    }

    /**
     * mutator method that removes a fireResort.Pass from the register for the island, this simulates when a fireResort.Pass takes a ferry
     * so thus would not be on the source island anymore. Takes id of fireResort.Pass as a param.
     * @param p id number of the pass
     */
    public void leave(int p)
    {
        Pass temp = findPassId(p);
        if (temp != null)
        {
            this.register.remove(temp);
        }
    }

    /**
     * checks register to see if the amount of passes is equal to the specified capacity of the island
     * @return true if island is full
     */
    public boolean checkIfFull()
    {
        if (this.register.size() >= this.capacity)
        {
            return true; // if full
        }
        return false; // if not full
    }

    /**
     *
     * @return toString() of all passes on the island, if the register is empty it returns "No passes"
     */
    public String getRegister()
    {
        String str = "";
        if (this.register.size() > 0)
        {
            for (Pass p : this.register)
            {
                str += "\n" + p.toString();
            }
            return str;
        }
        return "\nNo passes\n";
    }

    /**
     * boolean method to search the register of island to check if certain pass is present.
     * @param passId id of given fireResort.Pass
     * @return true if pass is present, false otherwise
     */
    public boolean checkIfPresent(int passId)
    {
        for (Pass p : this.register)
        {
            if (p.getPassId() == passId)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "*******************\nislandId: " + islandId + "\nislandName: " + islandName +
                "\nluxuryRating: " + luxuryRating + "\ncapacity: " + capacity +
                "\npassList: " + getRegister();
    }

}
