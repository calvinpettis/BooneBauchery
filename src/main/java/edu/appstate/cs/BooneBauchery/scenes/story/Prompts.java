package edu.appstate.cs.BooneBauchery.scenes.story;

/**
 * Using this class to hold all of our scripts.
 * 
 * -H B
 * I humbly apologize for the lack of consistency in code style 
 * sometimes a little smelly code is comforting thing. 
 * like smelling your under arms after a good workout!  
 * -H B
 */
public class Prompts {
// /// AUX TEXT /////////////////////////////////////////////////////////

        // aux singlton to display art and more context to user
        public static final String[] gameOver = {"GAME OVER"};
        public static final String[] gameOver2 = {"GAME OVER........"};
        public static final String[] travelOnward = {"TRAVEL ONWARD"};
        public static final String[] examine = {"EXAMINE"};

// //// INTRO TEXT ////////////////////////////////////////////////////////////
        //start intro --> (belk1 || belk2)   ,  sandford 
        public static final String belkintro = "You head out into the hallway.\n\n" +
            "Do you:\nHead outside?\nExplore Belk Hall's Computer Science Department?";
        //intro choices
            public static final String[] introchoices = {"EXPLORE", "GO OUTSIDE"};


// ///// Story grouped by relevance  //////////////////////////////////////////////////////////////
        // belk1 (spooky prof encounter) --> approach       attack
        public static final String belk1 = "As you walk by a classroom, you notice that there is a cloaked figure\n"+
            "hanging upside down from the ceiling. It appears to be asleep." +
            "\n\nDo you:\n" +
            "Approach the creature?\n" +
            "Or attack it?";
        //belk1 choices 
        public static final String[] belk1choice = {"APPROACH", "ATTACK"};    
        
// -----------------------------------------------------------------
        // belk1 appraoch      -->  HEAD OUTSIDE TO SANFORD 
        public static final String belk1response1 = "As you walk closer, the creature awakes.\n" +
            "Oh, hi professor!\n" +
            "It was just a teacher taking a break from a long day of grading.\n\nYou travel onwards.";
        public static final String[] chilProf = {"You walk outside of the building.\nPondering glorious lectures about data structures.", 
                "When you get outside you see quite a commotion unfolding..."};
        
// -----------------------------------------------------------------
        // belk1 attack          --> canceled --> GAME OVER
        public static final String belk1response2 = "Your first strike was ineffective, and the beast awakes and lunges at you.\n"
            + "He manages to get a chunk of your left shoulder.\n"+
            "Luckily, a strong jab to the achille's did the trick and\nbrings the monster to a whimpering pile on the floor.\n" +
            "You further examine the body";
        
        
// -----------------------------------------------------------------
        //belk canceled         --> CANCELED ARTWORK --> MAIN MENU
        public static final String[] belkCanceled = {"When you look down at the mangled creature you recoil in horror!\n" ,
                "You mistook your Software Engineering teacher taking a nap from grading as a monster...\n",
                "You are canceled by all of your class mates \nand no one will ever like you again.",
                "Slowly, you walk outside never to return.\n for the pain of being canceled is too great."};
        public static final String[] choiceCancled = {"WALK AWAY"};
        
        public static final String belkGameOver = "You walk off into the sunset. Pondering life, \n and all the connotations of being an outcast." + 
                        "\nYou never return to class and in turn fail the semester...";
        
// ---------------------------------------------------------------------------
        //belk2 feral cs                 -->  >> Run    , >> ATTACK
        public static final String belk2 = "As you walk through the hallways, a smell akin to onions grows stronger\nand stronger." +
            " When you turn the corner, you realize it is a feral CS student!\nHe spots you and begins to growl.\n\n" +
            "Do you:\n" +
            "Run around and avoid him?\n" +
            "Or attack?\n";
        //belk2 choices
        public static final String[] belk2choice = {"RUN AWAY", "ATTACK"};
        
// -----------------------------------------------------------------
        // FeralRun               -->   (go outside belkWindow) leads to sanfordmall?  
        public static final String belk2response1= "As you run by, the CS ghoul shrieks a REEEE that disorients you\n" +
                "and takes you to the floor!" +
            "\nYou manage to get up in the nick of time and escape him by running and\n"+
            "jumping through a window towards the outdoors, the ghoul's only weakness.\nThe sunlight causes the feral student to recoil in pain!";
// --------- FOLOWING AUX text FOR BELK -----------------------------------
            // N U -----------------------------------------------------------------
            // ????
        public static final String belk2response2 = "You manage to escape the ghoul by running by a window emitting"+ 
                " sunlight, the ghoul's only weakness.";

        // belkWindow NU          --> sandford
        public static final String[] belk2sanford = {"You wake up outside, it is a sunny day, and your head is bleeding.\n"+
                "There are large groups of people standing under EZ-UPs\nand around a man with a megaphone."};
        // N U -----------------------------------------------------------------
// -----------------------------------------------------------------

        // feralATK     --> >>sneak out back  ,  >> leave out front  
        public static final String feralAtk = "Being utterly disturbed by the shreiking CS ghoul,\n" +
                "You swiftly spear hand the deranged ghoul in the throat\n"
                + "This causes the ghoul to flail violently, until it stops,\n its face stuck in an evil smile.\n\n" +
                "Do you:\nLeave out of the front door?\nSneak out of the building?";
        //feralATK choices
        public static final String[] feralAtkChoice = {"SNEAK","LEAVE"};
        
// -----------------------------------------------------------------
        // sneaking out of the back        --> see bar
        public static final String sneaking = "You slowly sneak through the building, trying not to draw\nattention to yourself."
        + "Working your way lower through each floor of Belk Hall,\nyou end up finding a secluded exit.";

        public static final String[] sneak2walking = {"You successfully snuck through the building and found a quiet road to walk on.", 
                "You avoided all unwanted attention as you were trying to leave.\nSeeing that you have practically assaulted a CS student...",
                "This does cause you to take a path home you have not travelled before."}; 

// -----------------------------------------------------------------
        // see a bar    -->  >> keep walking (sleepy home) , >> Go to bar (chilvibs ending)

        public static final String seebar = "Since you are walking a path you have not traveled,\nyou see a new bar you have not been to before."
                +"\nThe bar, radiates with the smell of booze and debauchery.\n\n" 
                + "Do you:\nKeep Walking and head home?\nGo inside of the Bar?";

        public static final String[] seeBarChoices = {"Keep Walking", "Go to Bar"};

// -----------------------------------------------------------------
        // (go to bar) chilling in a bar    -->     >> made chill vodka redbull vibes (party and drink ending)
        public static final String[] chillinginbar = {"You make your way inside of the bar, and it is more vibrant\n than than you could have imagined.",
                "You begin to scan the crowd and see plenty of fun people to talk to.",
                "Eventually you begin to settle in at the bar and mingle with the crowd."};
                
        public static final String atbar = "You get a vodka redbull and you begin to enjoy the night.\nYou drink vodka redbulls until your tummy hurts and the room spins"
                + "\nTonight was pretty epic XD\n(CHILL VIBEz BAR ENDING)"; 
        // -----------------------------------------------------------------
        // (feralATK -> [leave front]) -> walking down side street then get a call from friend, transition 
        public static final String[] leaveFront = {"Not thinking even once about your violent actions,\nyou walk outside with swagger and pride.", 
                "This macho facade quickly crumbles upon seeing a swarm of people\nsurrounding a man holding a sign.\nThe man's sign says 'SINNERS WILL BURN'",
                "The excessively large crowd is blocking the way you normally walk to get home.\nYou are forced to cut through a tunnel to get back towards your home."};
        
        //get a call -->    >> Pick up (one mill beers) , >> keep walking (sleepy home)
        public static final String phoneORWalk = "When you are walking down the road to get home your\nphone starts to ring." +
                " You look and see its one of your classmates calling you.\n\nDo you:\nPick up the phone\nDecline the call and keep walking";
        public static final String[] walkingChoices = {"PICK UP","KEEP WALKING"};
        
// -----------------------------------------------------------------
        // (pickup) one mill beers  transition 
        public static final String[] pickup = {"When you pick the phone up your class mate sounds estatic.",
                "'HEY MAN! I didn't thikk you were going to pick up.', he says with cheer.",
                "'Now hear me out. I just bought one million beers and I need help drinking them!'",
                "As you hear his words you think you are misunderstanding.",
                "You rush over to your friends house and drink one million beers with him XD !!!"};
        // (pickup) one mill beers ending -> main menu
        public static final String onemil = "You and your friend drink one million beers together.\nIt"
                + "is quit epic to drink so much beer and you feel complete\nGOOD ENDING 'One Million Beers' "; 

// -----------------------------------------------------------------
        // (decline friend call) sleepy home ending -> main menu
        public static final String[] walk2sleepy = {"You looked at the phone ringing and determined you\nare simply very tired. You do not care about going out tonigh.",
                "After a brisk walk you finally arive at your off campus appartment.\nYou feel that the activities of the day have drained you, and you are sleepy."};


        // (sneak back of belk) [keep walking], take back road home --> sleepy home ending (no booze ending) -> main menu
        public static final String[] walkfrombar2sleep = {"Simply you are just to tired to party tonight.\nYou saw a bar, and decided to walk away.",
                "As you reflect on the day you guess you never really cared to pary anyway.",
                "You wind up getting home safe and sound, with no booze,\nand a lot of sleep you need to catch up on."};


        // sleepy home ending scene (sleepy art) --> main menu
        public static final String sleepyprompt = "You get into a comfortable mood and change into PJ's.\nYou get into bed only caring to sleep." + 
        "\n(SLEEPY ENDING YOU DONT DRINK BOOZE JUST SLEEP ZZZzzz.....)";
// ---------------------------------------------------------------------------
        //sandford1   (jesus man)          --> >> DODGE   ,  >> REASON
        public static final String sanford1 = "As you were walking by, a man with a sign about Jesus lunges at you!\n" +
        "Do you:\n" +
        "Sidestep the man\n" +
        "Or try to reason with him?";
        public static final String[] sanford1choice = {"DODGE", "REASON"};

// ---------------------------------------------------------------------------
        //you dodge crazy zealot  atk --> he gets dogpilled --> end up in peacock section
        public static final String sanford1response1 = "As you lunge away from the attack, the man stumbles and falls to the ground.\n" +
                "The students shrieking at him previously jump on top of him\n" +
                "and he disappears under the pile of bodies.";

// ---------------------------------------------------------------------------
        // (jesus reason) -> he actualy cray cray -> run away HE IS FOLLOWING YOU
        public static final String sanford1response2 = "As you ask for the old man to sit and talk, he calms down.\n" +
                "The more you talk to him, the more schizo you realize he is.\n" +
                "You back away and walk off in order to preserve your brain cells.";
 
        public static final String[] crazymantransition = {"You eventually just walk away from the religious zealot\n"+
        "He absolutely did not like this, and is angered further by it", "As you expect he breaks out in a full sprint after you following you off campus."};
        
        // crazy man folloing you and you see a bar -->  >>keep running , >> rest inside
        public static final String jesusfollow = "At this point you consider this man as absolutely mental\n" 
                +"He has chased you all the way off of campus,\nand you begin to feel yourself running out of steam\n"
                +"Luckily you spot a bar in the distance!\n\nDo you:\nKeep running past it?\nStop inside to rest?";

        public static final String[] followChoices =  {"KEEP RUNNING","STOP INSIDE"};
// ---------------------------------------------------------------------------
        // (crazy man following, pass by bar) wondering on -->  >> you continue to wonder on. and on.. and on.... ending
        public static final String[] wonderingon = {"You kept wondering on past the bar, mainly because you are frightened\nby the crazy zealot that has been chasing you for what seems to be miles.",
                "Eventually you lose him, seeing that App State is mainly woods\nand it is pretty much dark out now.",
                "You keep on wondering deeper into the woods."};

        public static final String verylost = "After all of that running you realize you have not been paying attention.\n"
                +"You realize you have become very, VERY lost.\nThis is not good... but what else is there to do other than press forward?\n"
                +"(you did not drink booze AND managed to get lost... CREEPY FOREST ENDING)";
                
// ---------------------------------------------------------------------------
        // (rest in bar) hip bar --> get a cool drank --> hipster bar ending 
        public static final String[] hipbar = {"You slip inside the bar!\nCausing the zealot to lose pursuit of you.",
        "You look around and realize you have never been into this bar before.\nThere is a chill guy serving cool looking drinks, you aproach curiously"};
        
        public static final String hipsterbar = "You ask the chill hipster bartender for his 'Most exotic drink'\n"
                +"He serves you something you have never before in your life seen!\n"
                +"'That right there,' he says 'is a Lychee Ginger Cooler'\n"
                +"A drink so tasty with such a high ABV? THIS CANT BE!! You drink LGC's all night!\n"
                +"(CHILL HIPSTER BAR ENDING)";

// ---------------------------------------------------------------------------
        //sandford2 (sorority girls)     -->    >> DEFEND (they tell u of a party)  ,     >> RUN (??)
        public static final String sanford2 = "As you were walking by, a rabid pack of sorority girls emerge from under an EZ-UP.\n" +
        "Noticing that you are not one of the Greek Brothers,\n" +
        "they begin casting astrology runes at you.\n" +
        "Do you:\n" +
        "Run away?\n" +
        "Or defend yourself?";
        public static final String[] sanford2choice = {"RUN AWAY", "DEFEND"};
        public static final String sanford2response1 = "As you run, the group is distracted by new gossip being disscussed.\n" +
                "A gossip ring begins amongst the sorority girls.";
        public static final String sanford2response2 = "You cast your Common Sense shield against the Astrology runes,\n" +
                "blocking all attacks.\n" +
                "When they take a moment to recharge, you take a chance and escape.";

        public static final String[] girlslikethat = {"Apparently the sorority girls have never seen such powerful runes before.\nThey completly dig the Common Sense spellz xD",
                "You recognize this newfound possible opportunity\nand extend out of your comfort zone",
                "You ask the group of girls if there are any parties happening in town tonight."};

        public static final String impresedgirls = "The group of impressed sorority girls give you thier numbers\nSCORE."
                +"They say they will call you later on that night\nwith the address of a chill frat party they will be at.\n\n"
                +"When the sorority girls call later on that night, will you:\n"
                +"Pick up the phone and go party?\nDecline the call and stay inside";

        public static final String[] partyaddychoice = {"PICK UP","STAY INSIDE"}; 

        public static final String[] going2frat = {"The sorority DID call back! They were not playing around either\n"
                +"because you can barely hear what they are saying.","You put on the coolest pair of kicks you own\n"
                +"And fit as much cash into your pocket as possible."};

        public static final String chillfratparty = "The party is jumping! Theres booze everywhere,\nLil Uzi Vert is playing, and you could not be more happy.\n"
                +"You eventually find the girls from before inside of the frat party.\nThey ask you to drink 1 million beers with them\nMy how great this life is...\n"
                +"(drink one million beers with greek life ending)";

        public static final String[] declinesorority = {"Bad mistake buddy... Turns out the girls really wanted you there!",
                "Directly after hitting the decline button you get the worst case of FOMO...\nYou decide maybe some sleep would be best insted of tasty booze."};

        public static final String[] runfromsorority = {"The Astrological runes the sorority girls were casting terrify you!",
                "You run away in fear.\nMainly becasue you have a irrational fear of superstitions",
                "Your fear of these astrological hexes keep you running for what seems miles."};
// ---------------------------------------------------------------------------
        public static final String[] sanford2peacock = {"You shuffle past Sanford Mall.\nMaking your way to the college of business, Peacock.",
                "As you walk up to the building you see\nvarious business admisitration majors eating crayons\nand smoking electronic cigarettes."};
// ---------------------------------------------------------------------------
        //Peacock1      --> APPROACH CADET        DODGE       
        //These will get us in trouble but its alright
        public static final String peacock1 = "Walking by the business school, you notice a man hop out of the bushes\n" +
        "and he starts running towards you with a VERY sharp pencil!\n\n"
            + "Do you:\n"
            + "Run towards the nearest App State campus Police Officer?\n"
            + "Or sidestep the stabber?";

        public static final String[] peacock1choice = {"RUN TO COP", "SIDESTEP"};

// ---------------------------------------------------------------------------
        //Peacock2              --> INVEST      DECLINE
        public static final String peacock2 = "As you walk by the business school, a small finance bro in a blazer & tie begins asking\n" +
        "you to invest in his crypto business.\n\n"
            + "Do you:\n"
            + "Listen to him and invest?\n" +
            "Or decline his offer?";
        public static final String[] peacock2choice = {"INVEST", "DECLINE"};
        public static final String peacock2response1 = "As soon as you invested, there was a rug pull on AppCoin\nand you lost all of your savings!\nHope you enjoy ramen.";
        public static final String peacock2response2 = "Wise move. Crypto is for dummies.";
        
        public static final String[] rugpuledPeacock = {"The founder of App coin realized someone was dumb\nenough to invest money into his crypto scam.",
                "You have no money now. All of it disapearing into a cryptic void.", "Uncontrollably you begin to cry.\nYou now have NO MONEY FOR BOOZE!"};
        public static final String nomoney = "You lost everything you owned and now you can't pay tuition for college.\n"+
                        "You cry every day while remembering how much you\njust wanted to be able to drink and party.\nGAME OVER (No money for booze BAD ENDING)";

// ---------------------------------------------------------------------------
        public static final String[] peacockDecline = {"You decline the offer thinking this is the right choice.\n However, you develop a deep 'Fear Of Missing out.\nF.O.M.O.", 
                                "Eventual you check in on AppCoin in order to see how it is doing\nYou see the value of AppCoin skyrocket to the MOON!", };

        public static final String fomoCoin = "Upon Checking in on AppCoin's value. You realize you made a mistake!\nYou invest all of your money.\n"
                                                + "The second your money is transfered out of your bank you\nsee the live value of App coin CRASH!"
                                                + "Unfortunatly you still lose all of your money. Crypto is dumb.\nBAD ENDING (YOU ARE BROKE AND HAVE NO MONEY TO PARTY)";                                

// ---------------------------------------------------------------------------
        //pencil sidestepping 
        public static final String[] copslikeyou = {"The cops see the man armed with a pencil, and you in distress.",
        "Swiftly they move to asail the man with the pencil.", "Once the cops taze the suspect enough times\nfor you to"
        +" be able to smell his hair burning,\nthey ask you what you will be doing later that night."};

        public static final String copsrswag = "After the on-campus cops help you subdue the pencil stabber they tell you\nthat there is a cop party going on at a bar. "
                +"They ask if you would want to\ncome slam around one million beers with your newfound cop friends.\nThis intrigues you completely and you drop everything\nyou are doing for one million beers.\n"
                +"Eventually you end up at the cop party,\nready to drink one million beers!!\n(DRINK BEER WITH COPS ENDING)";

        public static final String[] sidestepPencil = {"You get so freaked out by a man running at you with a pencil\nthat you simply ignore the cops for help and run straight for the hills",
                "The man with the pencil is hot on your tail.\nBut the fear you feel drives you farther and faster than any man has ever ran."};             

        public static final String pencilfear = "Running away from such a scary encounter, you are now traumatized.\nYou never recover from feeling intense irrational fear from seeing pencils."
                +"\nYou live in constant fear... forever...\n(PTSD ENDING you hate pencils now and it is debilitating)";

// ---------MINIGAMES-------------------------------------------
        public static final String hurricanePrompt[] = {"As you are walking, a dark cloud appears overhead.\n" +
        "A torrential downpour starts, it is a hurricane!!!\n" +
        "The water starts pooling around your feet."};

        public static final String hurricaneDirections = "You must stay out of the water! Press space to jump\n" +
                "to stay on top of the cars and logs.";


}

