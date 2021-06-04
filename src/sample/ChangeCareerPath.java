package sample;
/** Implements the path for change career path
 *
 * <p> Path from a Junction </p>
 *
 */
public class ChangeCareerPath extends Path {
    /** constructor of the ChangeCareerPath
     *
     * <p> Initializes Fixed Spaces </p>
     */
    public ChangeCareerPath ()
    {
        OrangeSpace OS;
        BlueSpace BS;
        GreenSpace GS;
        int i;
        for (i = 0; i < 19; i++)
        {
            OS = new OrangeSpace();
            BS = new BlueSpace();
            GS = new GreenSpace();

            switch(i)
            {
                case 1, 2, 5, 7, 9, 10, 13, 16, 17, 19 : spaces.add(OS);
                case 3 : spaces.add(BS);
                case 4, 6, 8, 12, 14, 15, 18 : spaces.add(GS);
            }

        }
        setPath("changecareer");
    }
}
