
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed. Before
 * beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other
 * components go in which panels.
 * 
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	// student Task #2:
	// declare five buttons, a label, and a textfield
	Button b1, b2, b3, b4, b5;
	Label label;
	TextField text;
	// declare two HBoxes
	HBox hBox1;
	HBox hBox2;

	// student Task #4:
	// declare an instance of DataManager
	DataManager data;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach. Remember
	 * to wait to add a component to its containing component until the container
	 * has been created. This is the only constraint on the order in which the
	 * following statements appear.
	 */
	FXMainPane() {
		// student Task #2:
		// instantiate the buttons, label, and textfield
		b1 = new Button("Hello");
		b2 = new Button("Howdy");
		b3 = new Button("Chinese");
		b4 = new Button("Clear");
		b5 = new Button("Exit");

		b1.setOnAction(new ButtonHandler());
		b2.setOnAction(new ButtonHandler());
		b3.setOnAction(new ButtonHandler());
		b4.setOnAction(new ButtonHandler());
		b5.setOnAction(new ButtonHandler());

		label = new Label("Feedback");

		text = new TextField();
		// instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();

		hBox1.setMargin(b1, new Insets(5, 5, 5, 5));
		hBox1.setMargin(b2, new Insets(5, 5, 5, 5));
		hBox1.setMargin(b3, new Insets(5, 5, 5, 5));
		hBox1.setMargin(b4, new Insets(5, 5, 5, 5));
		hBox1.setMargin(b5, new Insets(5, 5, 5, 5));

		hBox2.setMargin(label, new Insets(5, 5, 5, 5));
		hBox2.setMargin(text, new Insets(5, 5, 5, 5));

		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);

		// student Task #4:
		// instantiate the DataManager instance
		data = new DataManager();
		// set margins and set alignment of the components

		// student Task #3:
		// add the buttons to the other HBox
		hBox1.getChildren().addAll(b1, b2, b3, b4, b5);
		// add the label and textfield to one of the HBoxes
		hBox2.getChildren().addAll(label, text);

		// add the HBoxes to this FXMainPanel (a VBox)
		this.getChildren().addAll(hBox1, hBox2);
	}

	// Task #4:
	// create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

			// ActionEvent event = new ActionEvent();
			EventTarget selection = event.getTarget();

			if (selection == b1) {
				text.setText(data.getHello());
			} else if (selection == b2) {
				text.setText(data.getHowdy());
			} else if (selection == b3) {
				text.setText(data.getChinese());
			} else if (selection == b4) {
				text.setText("");
			} else if (selection == b5) {
				Platform.exit();
				System.exit(0);
			}

		}

	}
}
