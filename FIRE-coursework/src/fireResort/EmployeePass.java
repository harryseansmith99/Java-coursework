package fireResort;

public class EmployeePass extends Pass
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

    private int empNo;
    private String jobDescription;
    private int journeyScore;

    public EmployeePass(int passId, String name, int empNo, String jobDescription)
    {
        super(passId, name);
        this.empNo = empNo;
        this.jobDescription = jobDescription;
        this.credits = 0;
        this.luxuryRating = 10;
    }

    /**
     * override of useFerry() method in fireResort.Pass class
     * journey score incremented by 1, nothing else
     */
    @Override
    public void useFerry()
    {
        this.journeyScore += 1;
    }

    /**
     *
     * @return employee number of pass
     */
    public int getEmpNo()
    {
        return this.empNo;
    }

    /**
     *
     * @return job description of pass
     */
    public String getJobDescription()
    {
        return this.jobDescription;
    }

    @Override
    public String toString()
    {
        return "*******************************\nPASS INFO\n\npassId: " + this.passId + "\nname: " + this.name +
                "\ncredits: " + this.credits + "\nluxuryRating: " + this.luxuryRating + "\nempNo: " + this.empNo +
                "\njobDescription: " + this.jobDescription + "\njourneyScore: " + this.journeyScore;
    }


}
