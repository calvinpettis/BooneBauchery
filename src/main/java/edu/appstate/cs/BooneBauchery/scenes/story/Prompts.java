package edu.appstate.cs.BooneBauchery.scenes.story;

/**
 * Using this class to hold all of our scripts.
 */
public class Prompts {

        //start intro --> belk1,        belk2,          sandford 
        public static final String belkintro = "You head out into the hallway.\n\n" +
            "Do you:\nHead outside?\nExplore Belk Hall's Computer Science Department?";
        //intro choices
            public static final String[] introchoices = {"EXPLORE", "GO OUTSIDE"};

// //////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////
        // belk1 (encounter) --> approach       attack
        public static final String belk1 = "As you walk by a classroom, you notice that there is a cloaked figure\n"+
            "hanging upside down from the ceiling. It appears to be asleep." +
            "\n\nDo you:\n" +
            "Approach the creature?\n" +
            "Or attack it?";
        //belk1 choices 
        public static final String[] belk1choice = {"APPROACH", "ATTACK"};    
        // -----------------------------------------------------------------
        //belk1 appraoch      -->   dptChair Dialouge 
        public static final String belk1response1 = "As you walk closer, the creature awakes. " +
            "Oh, hi professor!\n" +
            "It was just a teacher taking a break from a long day of grading.\n\nYou travel onwards.";
        public static final String[] travelOnward = {"TRAVEL ONWARD"};
        
        
        //belk1 attack          --> canceled
        public static final String belk1response2 = "Your first strike was ineffective, and the beast awakes and lunges at you.\n"
            + "He manages to get a chunk of your left shoulder.\n"+
            "Luckily, a strong jab to the achille's did the trick and\nbrings the monster to a whimpering pile on the floor.\n" +
            "You further examine the body";
        public static final String[] examine = {"EXAMINE"};
        
        //belk canceled         --> GAME OVER
        public static final String belkCanceled = "When you look down at the mangled creature you recoil in horror!\n" +
                "You mistook your Software Engineering teacher as a monster...\n"+
                "You are canceled by all of your class mates and no one will ever like you again.\n\n" +
                "Slowly, you walk outside never to return.\n for the pain of being canceled is to great.";
        public static final String[] choiceCancled = {"WALK AWAY"};
        
// ========================================================================
        //belk2                 --> Run         ATTACK
        public static final String belk2 = "As you walk through the hallways, a smell akin to onions grows stronger\nand stronger." +
            "When you turn the corner, you realize it is a feral CS student!\nHe spots you and begins to growl.\n\n" +
            "Do you:\n" +
            "Run around and avoid him?\n" +
            "Or attack?\n";
        //belk2 choices
        public static final String[] belk2choice = {"RUN AWAY", "ATTACK"};
        // -----------------------------------------------------------------
        //FeralRun               -->   (go outside) belkWindow
        public static final String belk2response1= "As you run by, the CS ghoul shrieks a REEEE\n" +
        "that disorients you and takes you to the floor!" +
            "\nYou manage to get up in the nick of time and escape him by running and\n"+
            "jumping through a window, the ghoul's only weakness.\nThe sunlight causes the feral student to recoil in pain!";
            // ?? where tf to use this ??
        public static final String belk2response2 = "You manage to escape the ghoul by running by a window emitting"+ 
                " sunlight, the ghoul's only weakness.";

        // belkWindow           --> sandford
        public static final String[] belk2sanford = {"You wake up outside, it is a sunny day, and your head is bleeding.\n"+
                "There are large groups of people standing under EZ-UPs\nand around a man with a megaphone."};

        // feralATK
        public static final String feralAtk = "Being utterly disturbed by the shreiking CS ghoul,\n" +
                "You swiftly spear hand the deranged ghoul in the throat\n"
                + "This causes the ghoul to flail violently, until it stops,\n its face stuck in an evil smile.\n\n" +
                "Do you:\nSneak out of the building?\nLeave out of the front door?";
        //feralATK choices
        public static final String[] feralAtkChoice = {"SNEAK","LEAVE"};
        // -----------------------------------------------------------------
        //
        // ========================================================================
        //sandford1             --> DODGE              REASON
        public static final String sanford1 = "As you were walking by, a man with a sign about Jesus lunges at you!\n" +
        "Do you:\n" +
        "Sidestep the man\n" +
        "Or try to reason with him?";
        public static final String[] sanford1choice = {"DODGE", "REASON"};

        public static final String sanford1response1 = "As you lunge away from the attack, the man stumbles and falls to the ground.\n" +
                "The students shrieking at him previously jump on top of him\n" +
                "and he disappears under the pile of bodies.";

        public static final String sanford1response2 = "As you ask for the old man to sit and talk, he calms down.\n" +
                "The more you talk to him, the more schizo you realize he is.\n" +
                "You back away and walk off in order to preserve your brain cells.";
// ========================================================================
        //sandford2             --> ??  ??
        public static final String sanford2 = "As you were walking by, a rabid pack of sorority girls emerge from under an EZ-UP.\n" +
        "Noticing that you are not one of the Greek Brothers,\n" +
        "they begin casting astrology runes at you.\n" +
        "Do you:\n" +
        "Run away?\n" +
        "Or defend yourself?";
        public static final String[] sanford2choice = {"RUN AWAY", "DEFEND"};
        public static final String sanford2response1 = "As you run, the group is distracted by a rival sorority and a battle begins between the two tribes.";
        public static final String sanford2response2 = "You cast your Common Sense shield against the Astrology runes, blocking all attacks.\n" +
                "You do not feel like fighting women today, so when they take a moment to recharge you take a chance and escape.";

// ========================================================================
        public static final String[] sanford2peacock = {"You limp past the courtyard and towards Peacock Hall."};
// ========================================================================
        //Peacock1      --> APPROACH CADET        DODGE       
        //These will get us in trouble but its alright
        public static final String peacock1 = "Walking by the business school, you notice a man hop out of the bushes\n" +
        "and he starts running towards you with a knife!\n\n"
            + "Do you:\n"
            + "Run towards the nearby App State Cadet?\n"
            + "Or sidestep the stabber?";

        public static final String[] peacock1choice = {"APP CADET", "DODGE"};

// ========================================================================
        //Peacock2              --> INVEST      DECLINE
        public static final String peacock2 = "As you walk by the business school, a small finance bro in a blazer & tie begins asking\n" +
        "you to invest in his crypto business.\n\n"
            + "Do you:\n"
            + "Listen to him and invest?\n" +
            "Or decline his offer?";
        public static final String[] peacock2choice = {"INVEST", "DECLINE"};

// ========================================================================
        //peacockInvest         --> 
        public static final String peacock2response1 = "As soon as you invested, there was a rug pull on AppCoin and you lost all of your savings! Hope you enjoy ramen.";
    public static final String peacock2response2 = "Wise move. Crypto is for dummies.";
}
