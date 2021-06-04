package sample;
/** constructor of the Career Path
 *
 *
 */
public class CareerPath extends Path {
    private MagentaSpace MS;
    private OrangeSpace OS;
    /** constructor of the CareerPath
     *
     * <p> Initializes Fixed Spaces </p>
     */
        public CareerPath ( ) {
            int i;
            for (i = 0; i < 23; i++)
            {
                if (i == 17)
                {
                    MS = new MagentaSpace("Get Married");
                    spaces.add(MS);
                }
                else
                {
                    OS = new OrangeSpace();
                    spaces.add(OS);
                }
            }
            setPath("career");
        }
    }

