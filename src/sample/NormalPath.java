package sample;
/** Implements the path for NormalPath
 *
 * <p> The supposed path of the player if they decide not to change </p>
 *
 */
public class NormalPath extends Path {
    /** constructor of the Normal Path
     *
     * <p> Initializes Fixed Spaces of the Normal Path </p>
     */
        public NormalPath()
        {
            int i;
            OrangeSpace OS;
            MagentaSpace MS;
            for (i = 0; i < 18; i++)
            {
                if (i < 17) {
                    OS = new OrangeSpace();
                    spaces.add(OS);
                }
                else if (i == 17)
                {
                    MS = new MagentaSpace("Which path");
                    spaces.add(MS);
                }
            }
        }

}
