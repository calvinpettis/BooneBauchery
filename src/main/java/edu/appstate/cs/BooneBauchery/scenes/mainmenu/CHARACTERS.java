package edu.appstate.cs.BooneBauchery.scenes.mainmenu;

public enum CHARACTERS {
    //TODO: Add character previews
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
