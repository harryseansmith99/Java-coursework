package fireResort;

import fireResort.Pass;

public class TouristPass extends Pass
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

    private final String citizenship;

    public TouristPass(int passId, String name, int luxuryRating, double credits, String citizenship)
    {
        super(passId, name, luxuryRating, credits);
        this.citizenship = citizenship;
    }

    @Override
    public void useFerry()
    {
        this.credits -= 4;
        this.journeyPoints += 1;
    }

    public String getCitizenship()
    {
        return this.citizenship;
    }

    @Override
    public String toString()
    {
        return "*******************************\nPASS INFO\n\npassId: " + this.passId + "\nname: " + this.name
                + "\nluxuryRating: " + this.luxuryRating + "\ncredits: " + credits + "\ncitizenship: "
                + this.citizenship + "\njourneyPoints: " + this.journeyPoints;
    }

}
