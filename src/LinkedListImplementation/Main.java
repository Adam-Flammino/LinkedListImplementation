package LinkedListImplementation;
/**
 * @Course: SDEV 350 ~ Java Programming II
 * @Author Name: Flammino
 * @Assignment Name: aflammino_week11
 * @Date: Apr 20, 2017
 * @Description: GUI interface for adding and removing values to a linked list
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
    LinkedList<Object> list = new LinkedList();

    @Override
    public void start(Stage primaryStage) throws Exception{
         /* Define panes */
        BorderPane bPane = new BorderPane();
        VBox topBox = new VBox();
        GridPane leftGrid = new GridPane();
        GridPane rightGrid = new GridPane(); // Needed for margins
        HBox bottomBox = new HBox(15);

        /* Set VBox attributes */
        topBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        topBox.setAlignment(Pos.CENTER);

        /* Set HBox attributes */
        bottomBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        bottomBox.setAlignment(Pos.CENTER);

        /* Set GridPane Attributes */
        leftGrid.setAlignment(Pos.CENTER_LEFT);
        leftGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        leftGrid.setHgap(5.5);
        leftGrid.setVgap(5.5);
        rightGrid.setAlignment(Pos.CENTER_LEFT);
        rightGrid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        rightGrid.setHgap(5.5);
        rightGrid.setVgap(20);

        /* Add panes to BorderPanes, set borderpane attributes */
        bPane.setTop(topBox);
        bPane.setLeft(leftGrid);
        bPane.setBottom(bottomBox);

        /* Declare top vBox components */
        Text banner = new Text("Linked List Implementation");
        banner.setFont(Font.font("Bodoni MT Black", FontWeight.BOLD,
                FontPosture.ITALIC, 28));
        Text instructions = new Text("Enter anything in the value box, its desired position up to the " +
                "current length of the list\nThen click enter.");
        instructions.setTextAlignment(TextAlignment.CENTER);
        topBox.getChildren().add(banner);
        topBox.getChildren().add(instructions);

        /* Add left GridPane components */
        Label lblNode0 = new Label("Node 0");
        TextField txtNode0 = new TextField();
        txtNode0.setEditable(false);
        Label lblNode1 = new Label("Node 1");
        TextField txtNode1 = new TextField();
        txtNode1.setEditable(false);
        Label lblNode2 = new Label("Node 2");
        TextField txtNode2 = new TextField();
        txtNode2.setEditable(false);
        Label lblNode3 = new Label("Node 3");
        TextField txtNode3 = new TextField();
        Label lblNode4 = new Label("Node 4");
        TextField txtNode4 = new TextField();
        txtNode4.setEditable(false);
        Label lblNode5 = new Label("Node 5");
        TextField txtNode5 = new TextField();
        txtNode5.setEditable(false);
        Label lblNode6 = new Label("Node 6");
        TextField txtNode6 = new TextField();
        txtNode6.setEditable(false);
        Label lblNode7 = new Label("Node 7");
        TextField txtNode7 = new TextField();
        txtNode7.setEditable(false);
        Label lblNode8 = new Label("Node 8");
        TextField txtNode8 = new TextField();
        txtNode8.setEditable(false);
        Label lblNode9 = new Label("Node 9");
        TextField txtNode9 = new TextField();
        txtNode9.setEditable(false);
        leftGrid.add(lblNode0, 0, 0);
        leftGrid.add(lblNode1, 1, 0);
        leftGrid.add(lblNode2, 2, 0);
        leftGrid.add(lblNode3, 3, 0);
        leftGrid.add(lblNode4, 4, 0);
        leftGrid.add(txtNode0, 0, 1);
        leftGrid.add(txtNode1, 1, 1);
        leftGrid.add(txtNode2, 2, 1);
        leftGrid.add(txtNode3, 3, 1);
        leftGrid.add(txtNode4, 4, 1);
        leftGrid.add(lblNode5, 0, 2);
        leftGrid.add(lblNode6, 1, 2);
        leftGrid.add(lblNode7, 2, 2);
        leftGrid.add(lblNode8, 3, 2);
        leftGrid.add(lblNode9, 4, 2);
        leftGrid.add(txtNode5, 0, 3);
        leftGrid.add(txtNode6, 1, 3);
        leftGrid.add(txtNode7, 2, 3);
        leftGrid.add(txtNode8, 3, 3);
        leftGrid.add(txtNode9, 4, 3);

        /* Add bottom hBox components */
        Label lblValue = new Label("Value:");
        TextField txtValue = new TextField();
        Label lblPos = new Label("Node:");
        TextField txtPos = new TextField();
        Button btnEnter = new Button("Enter");
        Button btnRemove = new Button ("Remove");
        Button btnClear = new Button("Clear");
        Button btnExit = new Button("Exit");
        bottomBox.getChildren().add(lblValue);
        bottomBox.getChildren().add(txtValue);
        bottomBox.getChildren().add(lblPos);
        bottomBox.getChildren().add(txtPos);
        bottomBox.getChildren().add(btnEnter);
        bottomBox.getChildren().add(btnRemove);
        bottomBox.getChildren().add(btnClear);
        bottomBox.getChildren().add(btnExit);

        /* Creates scene, sets stage */
        Scene scene = new Scene(bPane);
        primaryStage.setTitle("Sorter");
        primaryStage.setScene(scene);
        primaryStage.show();

        Validation v = new Validation();



        btnEnter.setOnAction((ActionEvent e) ->{
            String input;
            int pos;
            boolean fill = false;
            if (v.emptyTextField(txtValue)){
                noValue(txtValue, "value");
                txtValue.requestFocus();
            }
            else if (list.size() == 10){
                tooLong(txtPos);
            }
            else if (v.emptyTextField(txtPos)) {
                input = txtValue.getText();
                list.add(input);
                fill = true;
            }
            else {
                try{
                    // Shifts position to match node so it matches labels more clearly
                    pos = Integer.valueOf(txtPos.getText()) + 1;
                    if(pos > list.size() || pos < 1){
                        tooHigh(txtPos);
                    }
                    else{
                        input = txtValue.getText();
                        list.add(input, pos);
                        fill = true;
                    }
                }
                catch(NumberFormatException ex){
                    notInt(txtPos);
                }
            }
            if (fill){
                fillFields(txtNode0, txtNode1, txtNode2, txtNode3, txtNode4, txtNode5, txtNode6, txtNode7, txtNode8, txtNode9);
                txtValue.clear();
                txtPos.clear();
            }
        });

        btnRemove.setOnAction((ActionEvent e) ->{
            int pos;
            boolean clear = false;
            boolean refill = false;
            if (v.emptyTextField(txtPos)){
                noValue(txtPos, "position");
            }
            else if (list.size() == 0 || list.checkNull() == null){
                empty();
            }
            else{
                try{
                    pos = Integer.valueOf(txtPos.getText()) ;
                    if(pos >= list.size() || pos < 0){
                        tooHigh(txtPos);
                    }
                    else{
                        if (list.size() == 1){
                            list.clear(1);
                            clear = true;
                        }
                        else{
                            try{
                                list.remove(pos);
                                clear = true;
                                refill = true;
                            }
                            catch(NullPointerException ex){
                                tooHigh(txtPos);
                            }
                        }
                    }
                }
                catch(NumberFormatException ex){
                        notInt(txtPos);
                }
                if(clear){
                    clear(txtNode0, txtNode1, txtNode2, txtNode3, txtNode4, txtNode5, txtNode6, txtNode7, txtNode8, txtNode9);
                    txtPos.clear();
                }
                    if(refill){
                        fillFields(txtNode0, txtNode1, txtNode2, txtNode3, txtNode4, txtNode5, txtNode6, txtNode7, txtNode8, txtNode9);
                    }
            }

        });

        btnClear.setOnAction((ActionEvent e) ->{
            clear(txtNode0, txtNode1, txtNode2, txtNode3, txtNode4, txtNode5, txtNode6, txtNode7, txtNode8, txtNode9);
            txtValue.clear();
            txtPos.clear();
            if (list.size() != 0) {
                list.clear(list.size());
            }
        });

        btnExit.setOnAction((ActionEvent e) ->{
            Alert exit = new Alert(Alert.AlertType.CONFIRMATION);
            exit.setTitle("Goodbye!");
            exit.setContentText("Really quit?");
            Optional<ButtonType> result = exit.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                System.exit(0);
            }
        });
    }

    /**
     * Displays a warning to instruct user to enter a required value
     * @param txtValue
     */
    private void noValue(TextField txtValue, String type){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("No " + type + " found!");
        alert.setContentText("Please enter a " + type + " in the box marked " + type);
        alert.showAndWait();
    }

    /**
     * Warns user if list is full
     * @param txtPos
     */
    private void tooLong(TextField txtPos){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Too long!");
        alert.setContentText("List is too long! Remove a value and try again.");
        txtPos.requestFocus();
        alert.showAndWait();
    }

    /**
     * Warns user if a non-integer is entered into position box
     * @param txtPos
     */
    private void notInt(TextField txtPos){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Not an Integer!");
        alert.setContentText("Enter an integer in the position box and try again");
        txtPos.requestFocus();
        alert.showAndWait();
    }

    /**
     * Warns user if position is invalid
     * @param txtPos
     */
    private void tooHigh(TextField txtPos){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Invalid!");
        alert.setContentText("Please enter an integer between 0 and the length of the list in the position box " +
                "into either place a value in or remove a value from that node.");
        txtPos.requestFocus();
        alert.showAndWait();
    }

    /**
     * Warns about attempting to remove a node from an empty list
     */
    private void empty(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Can't remove items from an empty list!");
        alert.setContentText("Please add an item to the list before trying to remove something.");
        alert.showAndWait();
    }

    /**
     * Populates TextFields from list using nested if statements based on length of list
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @param g
     * @param h
     * @param i
     * @param j
     */
    private void fillFields(TextField a, TextField b, TextField c, TextField d, TextField e, TextField f, TextField g,
                            TextField h, TextField i, TextField j){
        int len = list.size();
        a.setText((String) list.get(0));
        len --;
        if(len > 0){
            b.setText((String) list.get(1));
            len--;
            if(len > 0){
                c.setText((String) list.get(2));
                len--;
                if(len > 0){
                    d.setText((String) list.get(3));
                    len--;
                    if(len > 0){
                        e.setText((String) list.get(4));
                        len--;
                        if(len > 0){
                            f.setText((String) list.get(5));
                            len--;
                            if(len > 0){
                                g.setText((String) list.get(6));
                                len--;
                                if(len > 0){
                                    h.setText((String) list.get(7));
                                    len--;
                                    if(len > 0){
                                        i.setText((String) list.get(8));
                                        len--;
                                        if(len > 0){
                                            j.setText((String) list.get(9));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    /**
     * Clears text fields
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @param g
     * @param h
     * @param i
     * @param j
     */
    private void clear (TextField a, TextField b, TextField c, TextField d, TextField e, TextField f, TextField g,
                        TextField h, TextField i, TextField j){
        a.clear();
        b.clear();
        c.clear();
        d.clear();
        e.clear();
        f.clear();
        g.clear();
        h.clear();
        i.clear();
        j.clear();
    }
    }

