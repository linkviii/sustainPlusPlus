package extraLarge;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Life {

    // Sustain++ begins with making the world, me, and you.
    // We'd like to special case me and you so we keep track
    private static int globalLifeCount = -World.initialPopulationSize;

    public final UUID id;
    protected String label;

    public Life() {
        id = UUID.randomUUID();

        /* Hack to preserve sustainPlusPlus */
        if (globalLifeCount == 0) {
            label = "Me";

            thoughts.add("Life is hard sometimes.");
            thoughts.add("You are important to me.");
            thoughts.add("I hope you understand.");
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

        private HashMap<String, List<String>> propertyMap = new HashMap<>();

        public LifeProperty() {
        }

        public LifeProperty(HashMap<String, List<String>> val) {
            propertyMap = val;
        }

        public int searchByType(String propertyName, String propertyValue) {
            List<String> list = propertyMap.get(propertyName);
            if (null == list) {
                return -1;
            } else {
                return list.indexOf(propertyValue);
            }

        }
    }

    private LifeProperty fetishes;

    public LifeProperty getFetishes() {

        /* Lazy initilize for mili */
        if (null == fetishes) {
            HashMap<String, List<String>> fetishesMap = new HashMap<>();
            fetishesMap.put("name calling", Arrays.asList("smarty pants", "mommy"));
            fetishes = new LifeProperty(fetishesMap);

        }

        return fetishes;
    }

    public void addToMemory(Life other) {
    }

    /** A unit of storage */
    static class LifeMemoryUnit {
        Set<Object> subjects = new HashSet<>();

        public LifeMemoryUnit(Object o) {
            subjects.add(o);
        }

    }

    /**
     * Collection of memory units about a subject.
     * Used to process memories but not to store them.
     */
    static class LifeSubjectFocusedMemories {
        List<LifeMemoryUnit> list = new ArrayList<>();

        public double getLove() {
            double love = 0;
            for (var mem : list) {
                // TODO find love
            }
            love = 1;
            return love;
        }
    }

    // List<LifeMemoryUnit> allMemories = new ArrayList<>();
    Set<LifeMemoryUnit> allMemories = new HashSet<>();
    /**
     * Cache the most recent memory of all subjects.
     * Aka recent memory.
     * It is a common error to assume that things not in recent memory do not exist.
     * Such is life.
     */
    Map<Object, LifeMemoryUnit> memoryCache = new HashMap<>();

    /**
     * Map a current life to our memory of their life.
     * 
     * @param life
     * @return
     */
    public LifeMemoryUnit getMemory(Life life) {
        return null;
    }

    public LifeMemoryUnit getMemory(Life life, String kind) {
        return null;
    }

    /**
     * Collect all memories about a subject.
     * 
     * @param life
     * @return
     */
    public LifeSubjectFocusedMemories getMemories(Life life) {
        var it = new LifeSubjectFocusedMemories();
        it.list.addAll(allMemories.stream().filter(x -> x.subjects.contains(life)).collect(Collectors.toList()));
        return it;
    }

    /**
     * Update recent memory of a subject with a specific memory.
     * Pass null to clear recent memory of a subject.
     */
    public void setMemory(Object subject, LifeMemoryUnit memory) {
        if (subject != null && !allMemories.contains(memory)) {
            allMemories.add(memory);
        }
        // Allow setting cache to null
        memoryCache.put(subject, memory);
    }

    // public void setMemory(Life life, Object o) {
    // }

    /**
     * Store a nickname to the memory of a life.
     * 
     * @param life
     * @param name
     */
    public void setNicknameFor(LifeMemoryUnit life, String name) {
    }

    public String codeMessage(String txt, String key) {
        StringBuilder s = new StringBuilder();
        for (int c = 0; c < txt.length(); ++c) {
            if (c % key.length() == 0) {
                s.append(key);
            }
            s.append(txt.charAt(c));
        }
        return s.toString();
    }

    public String decodeMessage(String txt, String key) throws InsufficientIntelligenceQuotientException {
        if (txt.length() != key.length()) {
            throw new InsufficientIntelligenceQuotientException();
        }

        StringBuilder s = new StringBuilder();
        for (int c = 0; c < txt.length(); ++c) {
            s.append(txt.charAt(c) - key.charAt(c));
        }

        return s.toString();

    }

    public void announce(String msg) {
        System.out.println(toString() + ":\tTo everyone:");
        System.out.println("\t| " + msg);
    }

    static class Thoughts extends ArrayList<String> {

    }

    private Thoughts thoughts = new Thoughts();

    public Thoughts getThoughts() {

        return thoughts;
    }

    public void sayTo(Thoughts thoughts, Life receiver) throws TooMuchOfAPussyException {

        System.out.println(this + ":\tCommunicating thoughts to " + receiver);

        if (thoughts.size() > 2) {
            throw new TooMuchOfAPussyException();
        }

        for (String t : thoughts) {
            System.out.println("\t| " + t);
        }

    }

    // Saying words is easier than saying thoughts
    public void sayTo(String words, Life receiver) {
        System.out.println(this + ":\t To " + receiver);
        System.out.println("\t| " + words);
    }

    public void clearThoughts() {
        thoughts.clear();
    }

    public void transferThoughts(Life other) {
        System.out.println(other + " takes on " + other.thoughts.size() + " thoughts from " + this);
        // A literal transfer, but I don't think it is neccesarially the right thing
        other.thoughts.addAll(thoughts);
        thoughts.clear();
    }

    public void transferAttributes(Life other) {
        // TODO
    }

    public void fight(Life other) {
        System.out.println(this + ":\t *fighting " + other + "*");
    }

    public void command(Life life, String cmd) {
        System.out.println(this + ":\tTo " + life);
        System.out.println("\t! Thou shalt " + cmd);
    }

    public void ask(Life life, String q) {
    }

    public void ask(World world, String q) {
    }

    /*
     * !!!!!
     * Not legitimate financial code.
     * For creative demonstration purposes only.
     * !!!!!
     */

    /**
     * All BigDecimal values represent USD.
     */
    static class LifeFinances {

        LifeFinances(Life primaryOwner) {
            trusties.add(primaryOwner);
        }

        public final UUID id = UUID.randomUUID();

        private Set<Life> trusties = new HashSet<>();
        private BigDecimal ballance = BigDecimal.ZERO;

        static class Transaction {
            final String reason;
            final BigDecimal amount;
            final UUID targetAccountID;

            public Transaction(String reason, BigDecimal amount, UUID targetAccount) {
                this.reason = reason;
                this.amount = amount;
                this.targetAccountID = targetAccount;
            }
        }

        List<Transaction> ledger = new ArrayList<>();

        void transfer(Life authorizer, BigDecimal amount, LifeFinances to, String note) {
            if (!trusties.contains(authorizer)) {
                throw new RuntimeException("Non authorized transaction");
            }
            ledger.add(new Transaction(note, amount.negate(), to.id));
            to.ledger.add(new Transaction(note, amount, this.id));
            ballance = ballance.subtract(amount);
            to.ballance = ballance.add(amount);

        }

        BigDecimal getBallance(Life authorizer) {
            if (!trusties.contains(authorizer)) {
                throw new RuntimeException("Non authorized transaction");
            }
            return ballance;
        }
    }

    LifeFinances personaFinances = new LifeFinances(this);

    public LifeFinances getFinanceProperties() {
        return personaFinances;
    }

    /**
     * ♪♪♪
     * And that's why I'm fine
     * I am fine, I am fine, I am fine
     * I just need 100 dollars
     * And I am fine, I am fine, I am completely fine
     * I just need 100 dollars
     * From you
     * And you and you
     * And you and you
     * ♫♫♫
     * Songwriters: John Andrew Hull
     * 100 Dollars lyrics © BMG Rights Management
     */
    final BigDecimal STANDARD_AMOUNT = new BigDecimal(100.00);

    /**
     * Pay the recipient the "standard amount" from the srcFinances account.
     * If `this` Life is not an authorized trustee to srcFinances, then an exception
     * will be thrown.
     * 
     * @param recipient
     * @param srcFinances
     * @param reason
     */
    public void pay(Life recipient, LifeFinances srcFinances, String reason) {
        srcFinances.transfer(this, STANDARD_AMOUNT, recipient.getFinanceProperties(), reason);

        System.out.println(this + ":\tTransferred $" + STANDARD_AMOUNT + " to " + recipient);
        System.out.println("\t: Reason = " + reason);
        System.out.println("\t: New balance $" + personaFinances.getBallance(this));

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
