package fireResort;

public class BusinessPass extends Pass
{
    /**
     * A Torist fireResort.Pass has an id number, name, a luxury rating,
     * number of credits and journey points.
     *
     * It is created with specified luxury rating and credits (determined by parameters)
     *
     * It includes citizenship for the pass
     *
     * @author (Harry Smith)
     * @version
     */

    private double loyaltyPoints;

    public BusinessPass(int passId, String name, int luxuryRating)
    {
        super(passId, name, luxuryRating);
        this.credits = 30;
        this.loyaltyPoints = 20;
    }

    /**
     * when using the ferry, credits are deducted by 3, and loyalty points are increased by 2
     */
    @Override
    public void useFerry()
    {
        this.credits -= 3;
        this.loyaltyPoints += 2;
    }


    public double getLoyaltyPoints()
    {
        return this.loyaltyPoints;
    }


    /**
     * converts loyalty points to credits, 3 loyaltyPoint = 1 credit
     * @return the loyalty points amount in credits
     */
    public double convertLoyaltyPoints()
    {
        return this.loyaltyPoints/3;
    }

    @Override
    public String toString()
    {
        return "*******************************\nPASS INFO\n\npassId: " + this.passId + "\nname: " + this.name +
                "luxuryRating: " + this.luxuryRating + "\ncredits: " + this.credits + "\nloyaltyPoints: "
                + this.loyaltyPoints + "\ncredits: " + this.credits;
    }

}
