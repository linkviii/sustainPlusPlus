package extraLarge;

import java.math.BigDecimal;
import java.util.*;

public class Life {

    private static int globalLifeCount = 0;

    public final UUID id;
    public final String label;

    public Life() {
        id = UUID.randomUUID();

        /* Hack to preserve sustainPlusPlus */
        if (globalLifeCount == 0) {
            label = "Me";
        } else if (globalLifeCount == 1) {
            label = "You";
        } else {
            label = "<NO_NAME>";
        }
        globalLifeCount++;

    }

    @Override
    public String toString() {
        return label + " [" + id.toString() + "]";
    }

    /* -------------------------- */

    public void addPhysicalAttribute(String attr) {
    }

    static class LifeProperty {
        public int searchByType(String propertyName, String propertyValue) {
            return -1;
        }
    }

    static public LifeProperty getFetishes() {

        return null;
    }

    public void addToMemory(Life other) {
    }

    static class LifeMemory {
        public double getLove() {
            return 0;
        }
    }

    /**
     * Map a current life to our memory of their life.
     * 
     * @param life
     * @return
     */
    public LifeMemory getMemory(Life life) {
        return null;
    }

    public LifeMemory getMemory(Life life, String kind) {
        return null;
    }

    // Oh no... what does it mean. How is it different?
    public LifeMemory getMemories(Life life) {
        return null;
    }

    public void setMemory(String kind, LifeMemory target) {
    }

    public void setMemory(Life life, Object o) {
    }

    /**
     * Store a nickname to the memory of a life.
     * 
     * @param life
     * @param name
     */
    public void setNicknameFor(LifeMemory life, String name) {
    }

    public String codeMessage(String txt, String key) {
        return null;
    }

    public String decodeMessage(String txt, String key) throws InsufficientIntelligenceQuotientException {
        return null;
    }

    public void announce(String msg) {
    }

    static class Thoughts extends ArrayList<Object> {

    }

    public Thoughts getThoughts() {
        return null;
    }

    public void sayTo(Thoughts thoughts, Life reciever) throws TooMuchOfAPussyException {

    }

    // Saying words is easier than saying thoughts
    public void sayTo(String words, Life reciever) {
    }

    public void clearThoughts() {

    }

    void transferThoughs(Life other) {
    }

    void transferAttributes(Life other) {
    }

    public void fight(Life other) {
    }

    public void command(Life life, String cmd) {
    }

    public void ask(Life life, String q) {
    }

    public void ask(World world, String q) {
    }

    public BigDecimal getFinanceProperties() {
        return null;
    }

    public void pay(Life life, BigDecimal ammount, String reason) {
    }

    public void love(Life life) {
    }

    public void praise(Life life, String msg) {
    }

    public void gift(Life life, String item) {
    }

    public void consumeLast() {
    }

    public void addFamily(Life life) {
    }

    public void removeFamily(Life life) {
    }

    public void setParents(Life[] parents) {
    }

    public boolean isHappy() {
        return false;
    }

    public void throwTantrum() {

    }

    public Life[] getDreamParents() {
        return null;
    }

    void callFor(Life other) {
    }

    public void setVocabulary(String[] vocab) {
    }

    public void disorient(Life life) {
    }

    public List<War> getOngoingFights() {
        return null;
    }

    public void listenTelepathically(Life life, World world) throws NotAMindReaderException {

    }

    public void ignoreCommands() {

    }

    public void setMessages(Object o) {
    }

    public void manipulate(Life life, String method) {

    }
}
