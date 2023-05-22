package fireResort;

/**
 * interface fireResort.FIRE specifies requirements for 5COM2007 Cwk 3 - Nov 2022
 *
 * @author A.Marczyk
 * @version 05/11/22
 */
public interface FIRE
{
    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString();

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands();


    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd - the id of the pass
     * @return the name of the island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd);

    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd);


    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl);


    /**Returns a String representation of all the passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl);


    /**Returns true if a fireResort.Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the pass  >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island 
     * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode);


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
    public String travel(int pPassId, String ferCode );

    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds);


    /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id);

}