package fireResort;

/**
 * A fireResort.Pass has an id number, name, a luxury rating,
 * number of credits and journey points
 *
 * @author (Harry Smith)
 * @version
 */
public class Pass
{
    protected int passId;
    protected String name;
    protected int luxuryRating;
    protected double credits;
    protected double journeyPoints = 0;

    public Pass(int passId, String name, int luxuryRating, double credits)
    {
        this.passId = passId;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.credits = credits;
    }

    // use in fireResort.BusinessPass class
    public Pass(int passId, String name, int luxuryRating)
    {
        this.passId = passId;
        this.name = name;
        this.luxuryRating = luxuryRating;
    }

    public Pass(int passId, String name)
    {
        this.passId = passId;
        this.name = name;
    }

    /**
     * @return retrieves pass id of fireResort.Pass object - int
     */
    public int getPassId()
    {
        return this.passId;
    }

    /**
     *
     * @return retrieves name of fireResort.Pass object (as in the user the pass belongs to) - String
     */
    public String getName()
    {
        return this.name;
    }

    /**
     *
     * @return retrieves luxury rating belonging to that pass - int
     */
    public int getluxuryRating()
    {
        return this.luxuryRating;
    }

    /**
     *
     * @return credits associated with the pass - double
     */
    public double getCredits()
    {
        return this.credits;
    }

    /**
     *
     * @return journey points associated with the pass - double
     */
    public double getJourneyPoints()
    {
        return this.journeyPoints;
    }

    /**
     * mutator method to add credits to the pass
     * @param creditsAmount amount you want to add credits by - double
     */
    public void addCredits(double creditsAmount)
    {
        this.credits += creditsAmount;
    }

    /**
     * mutator method to deduct credits for the pass
     * @param creditsAmount amount to deduct credits by - double
     */
    public void deductCredits(double creditsAmount)
    {
        this.credits -= creditsAmount;
    }

    /**
     * processes a ferry journey for a pass
     * deducts 3 credits
     * adds 1 journey point
     */
    public void useFerry()
    {
        /* method to take a ferry, deducts 3 credits and increments journeyPoints by 1 */
        this.credits -= 3;
        this.journeyPoints += 1;

    }

    /**
     * converts journey points to credits, conversion rate:
     * 5 journey points = 1 credit
     * @return journeyPoints / 5
     */
    public double jpointsToCredits()
    {
        return this.journeyPoints/5;
    }

    /**
     * journeyPoints are initialised at 0 but will increase when the useFerry() method is used in the fireResort.Island class
     *
     * This method resets journeyPoints to 0 after we convert journeyPoints to credits in fireResort.Resort class,
     * more explicit to have its own method
     */
    public void resetJourneyPoints()
    {
        this.journeyPoints = 0;
    }

    @Override
    public String toString()
    {
        return "*******************************\nPASS INFO\n\npassId: " + this.passId + "\nname: " + this.name +
                "\nluxuryRating: " + this.luxuryRating + "\ncredits: " + this.credits +
                "\njourneyPoints: " + this.journeyPoints + "\n";
    }

}
