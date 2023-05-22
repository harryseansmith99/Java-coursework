package fireResort;

import java.util.*;
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 *
 * @author (Harry Smith)
 * @version (a version number or a date)
 */
public class Ferry
{
    private String ferryCode;
    private Island sourceIsland;
    private Island destination;


    public Ferry(String ferryCode, Island sourceIsland, Island destination)
    {
        this.ferryCode = ferryCode;
        this.sourceIsland = sourceIsland;
        this.destination = destination;
    }

    /**
     * retrieves ferry code
     * @return String ferryCode
     */
    public String getFerryCode()
    {
        return this.ferryCode;
    }

    /**
     * retrieves source island (island that the ferry is coming from)
     * @return String sourceIsland
     */
    public Island getSourceIsland()
    {
        return this.sourceIsland;
    }

    /**
     * retrives destination island (island the ferry is headed to)
     * @return String destination
     */
    public Island getDestination()
    {
        return this.destination;
    }

    /**
     * checks if a pass can travel on a certain ferry, requires that pass to have:
     *      - more than 3 credits
     *      - more than or equal amount of luxury points to the destination island
     *      - pass also needs to be on the system
     *
     *
     * @param p is the fireResort.Pass object to be checked
     * @return true if the above conditions are met
     */
    public boolean travelCheck(Pass p)
    {
        double pCredits = p.getCredits();
        int pLuxuryRating = p.getluxuryRating();
        int pId = p.getPassId();

        if (pCredits < 3)
        {
            return false;
        }
        else if (pLuxuryRating < this.destination.getLuxuryRating())
        {
            return false;
        }
        else if (this.destination.checkIfFull()) // checkIfFull() returns true if island is full
        {
            return false;
        }
        else if (this.sourceIsland.findPassId(pId) == null) // this will check if the pass is even on the system, as passes can only come from one place - the sourceIsland
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * processes a fireResort.Pass to make a journey on a ferry, will only work if the pass meets travel criteria:
     *      - more than or equal to 3 credits
     *      - more than or equal amount of luxury points to destination island
     *      - pass must be on the system
     *
     *
     * @param p is the fireResort.Pass object to make the journey
     * @return String saying welcome message if it can travel, and possible reasons for rejections if otherwise
     */
    public String makeJourney(Pass p)
    {
        int pId = p.getPassId();
        if (travelCheck(p))
        {
            p.useFerry();
            this.sourceIsland.leave(pId);
            this.destination.enter(p);
            return "Welcome aboard the ferry!";
        }

        return "Sorry, you cannot travel. Make sure that:\n- your pass has enough ferry credits"
                + "\n- your pass has a high enough luxury rating";
    }

    @Override
    public String toString()
    {
        return "***************\nferryCode: " + this.ferryCode
                + "\nsourceIsland: " + this.sourceIsland
                + "\ndestination: " + this.destination;
    }

}
