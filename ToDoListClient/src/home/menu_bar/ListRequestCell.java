/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.menu_bar;

import Entity.User;
import home.Notifications;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Aml Sakr
 */
public class ListRequestCell extends ListCell<Notifications> {
    @Override
    protected void updateItem(Notifications not, boolean empty) {
        super.updateItem(not, empty);
        setWrapText(true);
        Button accept = new Button();
        Button reject = new Button();
        accept.setTextFill(Paint.valueOf("white"));
        accept.setBackground(new Background(new BackgroundFill(Paint.valueOf("#6F4CBB"), new CornerRadii(5), Insets.EMPTY)));
        reject.setTextFill(Paint.valueOf("black"));
        reject.setBackground(new Background(new BackgroundFill(Paint.valueOf("#E3D9F8"), new CornerRadii(5), Insets.EMPTY)));
        Label txt = new Label();
        txt.setMaxWidth(180);
        txt.setWrapText(true);
        txt.setAlignment(Pos.CENTER);
        txt.setTextAlignment(TextAlignment.JUSTIFY);
        txt.setTextFill(Paint.valueOf("black"));
         accept.setVisible(false);
         reject.setVisible(false);
        if (not != null) {
            if (not.getStatus() == null) {
                setBackground(new Background(new BackgroundFill(Paint.valueOf("C2B5DE"), new CornerRadii(5), Insets.EMPTY)));
                txt.setText(not.getFromUserId() + " sends you a request to Collaborate in List : " + not.getData());
                accept.setText("Accept");
                reject.setText("Reject");
                 accept.setVisible(true);
                reject.setVisible(true);
            } else {
                setBackground(new Background(new BackgroundFill(Paint.valueOf("white"), new CornerRadii(5), Insets.EMPTY)));
                accept.setVisible(false);
                reject.setVisible(false);
                if (not.getStatus() == "1") {
                    txt.setText("you accepted a Collaboration with " + not.getFromUserId() + " in List : " + not.getData());
                }
                if (not.getStatus() == "0") {
                    txt.setText("you rejected a Collaboration with " + not.getFromUserId() + " in List : " + not.getData());
                }
            }
        }
        HBox buttonBox = new HBox(10,accept,reject);
        VBox box = new VBox(5,txt,buttonBox);
        setGraphic(box);
    }
}
