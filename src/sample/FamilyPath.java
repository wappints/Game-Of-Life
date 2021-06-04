package sample;
/** Implements the path for family path
 *
 * <p> Path from a Junction </p>
 *
 */
public class FamilyPath extends Path {
    /** constructor of the Family Path
     *
     * <p> Initializes Fixed Spaces of the  Family Path </p>
     */
    FamilyPath () {
        OrangeSpace OS;
        BlueSpace BS = new BlueSpace();
        MagentaSpace MS1 = new MagentaSpace("Get Married");
        MagentaSpace MS2 = new MagentaSpace("Buy a House");
        MagentaSpace MS3 = new MagentaSpace("Have Child");
        this.setPath("family");
        int i;

        for (i = 0; i < 27; i++)
        {
            OS = new OrangeSpace();
            switch(i)
            {
                case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 16, 17, 18, 19, 20, 22, 23, 24, 26 : spaces.add(OS);
                case 11 : spaces.add(BS);
                case 14 : spaces.add(MS1);
                case 21 : spaces.add(MS2);
                case 25 : spaces.add(MS3);
            }
        }
    }
}
