package edu.appstate.cs.BooneBauchery.display;

import edu.appstate.cs.BooneBauchery.scenes.mainmenu.CHARACTERS;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CharacterPicker extends VBox {

    private ImageView buttonimage;
    private ImageView characterimage;

    private String squareUnchecked = "assets/Buttons/UIBttn/UI_Flat_Button01a_1.png";
    private String squareChecked = "assets/Buttons/UIBttn/UI_Flat_ButtonCheck01a_1.png";

    private CHARACTERS character;
    private boolean isSquareChosen;

    public CharacterPicker(CHARACTERS character)
    {
        buttonimage = new ImageView(squareUnchecked);
        characterimage = new ImageView(character.getUrl());
        this.character = character;
        isSquareChosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(buttonimage);
        this.getChildren().add(characterimage);
    }

    public boolean getIsSquareChosen()
    {
        return isSquareChosen;
    }

    /**
     *  sets the box to either checked, or unchecked
     */
    public void setIsSquareChosen(boolean isSquareChosen)
    {
        String imageToSet = "";
        this.isSquareChosen = isSquareChosen;
        if (this.isSquareChosen)
        {
            imageToSet = squareChecked;
        }
        else
        {
            imageToSet = squareUnchecked;
        }
       buttonimage.setImage(new Image(imageToSet));
    }


}
