package edu.appstate.cs.BooneBauchery.scenes.mainmenu;

/**
 * Example of how we can use enums to store our data. Can add a lot of special attributes to them.
 */
public enum CHARACTERS {
    RED("assets/Characters/.png"),
    ADVENTURER2("assets/Characters/.png"),
    KNIGHT("assets/Characters/.png"),
    SAMURAI("assets/Characters/.png");


    private String urlCharacter;

    private CHARACTERS(String urlCharacter)
    {
       this.urlCharacter = urlCharacter;
    }

    public String getUrl()
    {
        return this.urlCharacter;
    }

}
