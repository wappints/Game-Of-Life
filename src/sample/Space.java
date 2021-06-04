package sample;

import java.util.ArrayList;
/** Abstract Class Space
 *
 * <p> Spaces inherit these protected attributes </p>
 *
 */
abstract public class Space {

    protected String color;
    protected String eventName;
    protected int spaceNum;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String event) {
        this.eventName = event;
    }

    public int getSpaceNum() {
        return this.spaceNum;
    }

    public void setSpaceNum(int spaces) {
        this.spaceNum = spaces;
    }

    /** Trigger the Event for Orange Space (3 Players)
     */
    public void triggerEvent(ArrayList<Player> players, ActionCardDeck ActionDeck, int curr, int other1, int other2, Bank bank) {}
    /** Trigger the Event for Blue Space (3 Players)
     */
    public void triggerEvent (ArrayList<Player> players,  BlueCardDeck BlueDeck, int curr, int other1, int other2, Bank bank) {}
    /** Trigger the Event for Blue Space (2 Players)
     */
    public void triggerEvent (ArrayList<Player> players, BlueCardDeck BlueDeck, int curr, int other1, Bank bank) {}
    /** Trigger the Event for Retirement Space (Both apply to 2 - 3 Players)
     */
    public void triggerEvent(Player player, Bank bank, int i) { }
    /** Trigger the Event for Green Space (Both apply to 2 - 3 Players)
     */
    public void triggerEvent(Player player, Bank bank) {}
    /** Trigger the Event for Orange Space (2 Players)
     */
    public void triggerEvent(ArrayList<Player> players, ActionCardDeck ActionDeck, int curr, int other1, Bank bank) {}
    /** Trigger the Event for Magenta Space
     */
    public void triggerEvent(Player player) {
    }
}