package sample;

public class LastPath extends Path {
    /** Implements the path for LastPath
     *
     * <p> The last path of the player </p>
     *
     */
    public LastPath ()
    {
        /** constructor of the Last Path
         *
         * <p> Initializes Fixed Spaces of the Last Path </p>
         */
        int i;
        OrangeSpace OS;
        GreenSpace GS;
        RetirementSpace RS = new RetirementSpace();
        for (i = 0; i < 34; i++)
        {
            OS = new OrangeSpace();
            GS = new GreenSpace();
            switch(i)
            {
                case 0, 1, 2, 7, 9, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 27 : spaces.add(OS);
                case 3, 4, 6, 8, 10, 13, 22, 23, 24, 25, 26, 28, 29, 30 : spaces.add(GS);
                case 31 : spaces.add(RS);
            }
        }
    }
}


