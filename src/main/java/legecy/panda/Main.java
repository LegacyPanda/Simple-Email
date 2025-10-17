package legecy.panda;

import legecy.panda.Email.Display;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application
{
    public static void main( String[] args )
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Display display = new Display();
        
        Scene scene = new Scene(display, 1000, 700);

        // External CSS file for styling
        scene.getStylesheets().add(getClass().getResource("/legecy/panda/styles/styles.css").toExternalForm());

        // Setting the application icon
        try
        {
            Image icon = new Image(getClass().getResourceAsStream("/legecy/panda/images/app.ico"));
            stage.getIcons().add(icon);
        }catch(Exception ex)
        {
            System.err.println("Could not load application icon: " + ex.getMessage());
        }

        stage.setScene(scene);
        stage.setTitle("Simple Email Client");

        // Set window size constraints
        stage.setMinWidth(600);
        stage.setMinHeight(500);
        stage.setMaxWidth(1600);
        stage.setMaxHeight(1200);

        // Center the stage on the screen
        stage.centerOnScreen();

        stage.fullScreenProperty().addListener((obs, oldVal, newVal) -> 
        {
            if(newVal) 
            {
                scene.getRoot().getStyleClass().add("full-screen");
            }else 
            {
                scene.getRoot().getStyleClass().remove("full-screen");
            }
        });

        stage.show();
    }
}
