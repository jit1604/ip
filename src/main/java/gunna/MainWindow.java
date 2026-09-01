package gunna;

import gunna.gui.DialogBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Gunna gunna;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image gunnaImage = new Image(this.getClass().getResourceAsStream("/images/DaGunna.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Gunna instance */
    public void setGunna(Gunna g) {
        gunna = g;
    }

    /** Shows the welcome message */
    public void showWelcomeMessage() {
        String welcome = gunna.getWelcomeMessage();
        dialogContainer.getChildren().add(
                DialogBox.getGunnaDialog(welcome, gunnaImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Gunna's reply
     * and then appends them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = gunna.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getGunnaDialog(response, gunnaImage)
        );
        userInput.clear();
    }
}
