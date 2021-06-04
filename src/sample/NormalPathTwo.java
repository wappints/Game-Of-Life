package sample;
/** Implements the path for NormalPathTwo
 *
 * <p> The supposed path of the player if they decide not to change </p>
 *
 */
public class NormalPathTwo extends Path {
    /** constructor of the Normal Path Two
     *
     * <p> Initializes Fixed Spaces of the Normal Path Two </p>
     */
    public NormalPathTwo ()
    {
        int i;
        OrangeSpace OS;
        MagentaSpace MS= new MagentaSpace("Which path");;
        GreenSpace GS;
        for (i = 0; i < 34; i++)
        {
            OS = new OrangeSpace();
            GS = new GreenSpace();
            switch(i)
            {
                case 0, 2, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 19, 20, 22, 23, 24, 25, 26, 28, 29, 30, 32 : spaces.add(OS);
                case 1, 3, 5, 17, 21, 27, 31, 33, 34 : spaces.add(GS);
                case 16 : spaces.add(MS);
            }
        }
    }
}
