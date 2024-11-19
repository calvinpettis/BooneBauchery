package edu.appstate.cs.BooneBauchery.scenes.story;

/**
 * Using this class to hold all of our scripts.
 */
public class Prompts {
// //////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////
        public static final String[] gameOver = {"GAME OVER"};
        public static final String[] gameOver2 = {"GAME OVER........"};


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
        public static final String belk1response1 = "As you walk closer, the creature awakes.\n" +
            "Oh, hi professor!\n" +
            "It was just a teacher taking a break from a long day of grading.\n\nYou travel onwards.";
        public static final String [] chilProf = {"You walk outside of the building.\nPondering glorious lectures about data structures.", 
                "When you get outside you see quite a commotion unfolding..."};
        public static final String[] travelOnward = {"TRAVEL ONWARD"};
        
        
        //belk1 attack          --> canceled
        public static final String belk1response2 = "Your first strike was ineffective, and the beast awakes and lunges at you.\n"
            + "He manages to get a chunk of your left shoulder.\n"+
            "Luckily, a strong jab to the achille's did the trick and\nbrings the monster to a whimpering pile on the floor.\n" +
            "You further examine the body";
        public static final String[] examine = {"EXAMINE"};
        
        //belk canceled         --> GAME OVER
        public static final String[] belkCanceled = {"When you look down at the mangled creature you recoil in horror!\n" ,
                "You mistook your Software Engineering teacher taking a nap from grading as a monster...\n",
                "You are canceled by all of your class mates \nand no one will ever like you again.",
                "Slowly, you walk outside never to return.\n for the pain of being canceled is too great."};
        public static final String[] choiceCancled = {"WALK AWAY"};
        
        public static final String belkGameOver = "You walk off into the sunset. Pondering life, \n and all the connotations of being an outcast." + 
                        "\nYou never return to class and in turn fail the semester...";
// ========================================================================
        //belk2                 --> Run         ATTACK
        public static final String belk2 = "As you walk through the hallways, a smell akin to onions grows stronger\nand stronger." +
            " When you turn the corner, you realize it is a feral CS student!\nHe spots you and begins to growl.\n\n" +
            "Do you:\n" +
            "Run around and avoid him?\n" +
            "Or attack?\n";
        //belk2 choices
        public static final String[] belk2choice = {"RUN AWAY", "ATTACK"};
        // -----------------------------------------------------------------
        //FeralRun               -->   (go outside) belkWindow
        public static final String belk2response1= "As you run by, the CS ghoul shrieks a REEEE that disorients you\n" +
                "and takes you to the floor!" +
            "\nYou manage to get up in the nick of time and escape him by running and\n"+
            "jumping through a window towards the outdoors, the ghoul's only weakness.\nThe sunlight causes the feral student to recoil in pain!";
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
        
        public static final String[] leaveFront = {"Not thinking even once about your violent actions,\nyou walk outside with swagger and pride.", 
                "This macho facade quickly crumbles upon seeing a swarm of people\nsurrounding a man holding a sign.\nThe man's sign says 'SINNERS WILL BURN'",
                "The exessivly large crowd is blocking the way you normally walk to get home.\nYou are forced to cut through a tunnel to get back towards your home."};

        public static final String phoneORWalk = "When you are walking down the road to get home your\nphone starts to ring." +
                " You look and see its one of your classmates calling you.\n\nDo you:\nPick up the phone\nDecline the call and keep walking";
        public static final String[] walkingChoices = {"PICK UP","KEEP WALKING"};
        
        public static final String[] pickup = {"When you pick the phone up your class mate sounds estatic.",
                "'HEY MAN! I didn't thikk you were going to pick up.', he says with cheer.",
                "'Now hear me out bud.. I just bought one million beers and I help drinking them!'",
                "As you hear his words you think you are misunderstanding.",
                "You rush over to your friends house and drink one million beers with him XD !!!"};
        
        public static final String onemil = "You and your friend drink one million beers together.\nIt is quit epic to drink so much beer and you feel complete\nGOOD ENDING 'One Million Beers' "; 
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
        public static final String sanford2response1 = "As you run, the group is distracted by a rival sorority and a battle begins\n" +
                "between the two tribes.";
        public static final String sanford2response2 = "You cast your Common Sense shield against the Astrology runes,\n" +
                "blocking all attacks.\n" +
                "when they take a moment to recharge, you take a chance and escape.";

// ========================================================================
        public static final String[] sanford2peacock = {"You shuffle past Sanford Mall.\nMaking your way to the college of business, Peacock.",
                "As you walk up to the building you see\nvarious business admisitration majors eating crayons\nand smoking electronic cigarettes."};
// ========================================================================
        //Peacock1      --> APPROACH CADET        DODGE       
        //These will get us in trouble but its alright
        public static final String peacock1 = "Walking by the business school, you notice a man hop out of the bushes\n" +
        "and he starts running towards you with a VERY sharp pencil!\n\n"
            + "Do you:\n"
            + "Run towards the nearest App State campus Police Officer?\n"
            + "Or sidestep the stabber?";

        public static final String[] peacock1choice = {"RUN TO COP", "SIDESTEP"};

// ========================================================================
        //Peacock2              --> INVEST      DECLINE
        public static final String peacock2 = "As you walk by the business school, a small finance bro in a blazer & tie begins asking\n" +
        "you to invest in his crypto business.\n\n"
            + "Do you:\n"
            + "Listen to him and invest?\n" +
            "Or decline his offer?";
        public static final String[] peacock2choice = {"INVEST", "DECLINE"};
        public static final String peacock2response1 = "As soon as you invested, there was a rug pull on AppCoin\nand you lost all of your savings!\nHope you enjoy ramen.";
        public static final String peacock2response2 = "Wise move. Crypto is for dummies.";
        
        public static final String [] rugpuledPeacock = {"The founder of App coin realized someone was dumb\nenough to invest money into his crypto scam.",
                "You have no money now. All of it disapearing into a cryptic void.", "Uncontrollably you begin to cry.\nYou now have NO MONEY FOR BOOZE!"};
        public static final String nomoney = "You lost everything you owned and now you can't pay tuition for college.\n"+
                        "You cry every day while remembering how much you\njust wanted to be able to drink and party.\nGAME OVER (No money for booze BAD ENDING)";

// =======================================================================
        public static final String peacock2kingst[] = {"You muster every ounce of strength you have and walk towards the bustling King Street."};

// ======================MINIGAMES==========================================
        public static final String hurricanePrompt[] = {"As you are walking, a dark cloud appears overhead.\n" +
        "A torrential downpour starts, it is a hurricane!!!\n" +
        "The water starts pooling around your feet."};

        public static final String hurricaneDirections = "You must stay out of the water! Press space to jump\n" +
                "to stay on top of the cars and logs.";


}

