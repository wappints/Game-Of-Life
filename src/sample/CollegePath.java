package sample;
/** Implements the path for change career path
 *
 * <p> Path from a Junction </p>
 *
 */
public class CollegePath extends Path {

    private MagentaSpace MS;
    private OrangeSpace OS;
    /** constructor of the College Path
     *
     * <p> Initializes fixed spaces of the path </p>
     */
    public CollegePath()
    {
        int i;
        for (i = 0; i < 23; i++)
        {
            if (i  == 8)
            {
                MS = new MagentaSpace("Graduation Day");
                spaces.add(MS);
            }
            else if (i == 17)
            {
                MS = new MagentaSpace("College Career Choice");
                spaces.add(MS);
            }
            else
            {
                OS = new OrangeSpace();
                spaces.add(OS);
            }



        }
    }


}

