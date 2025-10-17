package legecy.panda.Email;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Display extends GridPane
{
  private Button btnConnect, btnSend, btnClose;
  private Label lblHostName, lblPortNumber, lblSender, lblReceiver, lblSubject, lblMessage, lblStatus, lblMe;
  private TextField txtHostName, txtPortNumber, txtSender, txtReceiver, txtSubject, txtStatus;
  private TextArea txtMessage;
  private HBox hboxHostName, hboxPortNumber, hboxSender, hboxReceiver, hboxStatus;

  private SMTP smtp;

  public Display()
  {
    setUpUI();
    actions();
    makeResponsive();
  }

  private void setUpUI()
  {
    this.smtp = null;

    btnConnect = new Button("Connect");
    btnSend = new Button("Send");
    btnClose = new Button("Close");

    lblHostName = new Label("Host Name: ");
    lblPortNumber = new Label("Port Number: ");
    lblSender = new Label("Sender: ");
    lblReceiver = new Label("Receiver: ");
    lblSubject = new Label("Subject: ");
    lblMessage = new Label("Message: ");
    lblStatus = new Label("Status: ");
    lblMe = new Label("Property of Josh \"LegecyPanda\" Masunda @ 2025");

    txtHostName = new TextField();
    txtPortNumber = new TextField();
    txtSender = new TextField();
    txtReceiver = new TextField();
    txtSubject = new TextField();
    txtStatus = new TextField();

    txtStatus.setEditable(false);

    txtMessage = new TextArea();
    txtMessage.setWrapText(true);

    // Add CSS IDs for specific styling
    btnConnect.setId("btnConnect");
    btnSend.setId("btnSend");
    btnClose.setId("btnClose");
    lblStatus.setId("lblStatus");
    txtStatus.setId("txtStatus");

    hboxHostName = new HBox();
    hboxPortNumber = new HBox();
    hboxSender = new HBox();
    hboxReceiver = new HBox();
    hboxStatus = new HBox();

    hboxHostName.getChildren().addAll(lblHostName, txtHostName);
    hboxPortNumber.getChildren().addAll(lblPortNumber, txtPortNumber);
    hboxSender.getChildren().addAll(lblSender, txtSender);
    hboxReceiver.getChildren().addAll(lblReceiver, txtReceiver);
    hboxStatus.getChildren().addAll(lblStatus, txtStatus);

    // Configure GridPane
    this.setPadding(new Insets(20));
    this.setHgap(15);
    this.setVgap(10);
    this.setAlignment(Pos.TOP_CENTER);

    // Row 0: Host Name
    this.add(lblHostName, 0, 0);
    this.add(txtHostName, 1, 0);
        
    // Row 1: Port Number
    this.add(lblPortNumber, 0, 1);
    this.add(txtPortNumber, 1, 1);
        
    // Row 2: Connect Button
    this.add(btnConnect, 0, 2, 2, 1); // Span 2 columns
        
    // Row 3: Sender
    this.add(lblSender, 0, 3);
    this.add(txtSender, 1, 3);
        
    // Row 4: Receiver
    this.add(lblReceiver, 0, 4);
    this.add(txtReceiver, 1, 4);
        
    // Row 5: Subject
    this.add(lblSubject, 0, 5);
    this.add(txtSubject, 1, 5);
        
    // Row 6: Message Label
    this.add(lblMessage, 0, 6);
        
    // Row 7: Message TextArea (spans both columns)
    this.add(txtMessage, 0, 7, 2, 1); // Column span 2, row span 1
        
    // Row 8: Send Button
    this.add(btnSend, 0, 8, 2, 1); // Span 2 columns
        
    // Row 9: Status
    this.add(lblStatus, 0, 9);
    this.add(txtStatus, 1, 9);
        
    // Row 10: Close Button
    this.add(btnClose, 0, 10, 2, 1); // Span 2 columns

    Label emptyLabel = new Label("");
    this.add(emptyLabel, 0, 11, 2, 1);

    this.add(lblMe, 0, 12, 2, 1); // Span 2 columns

    // Set column constraints for responsive design
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(30); // 30% for labels
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(70); // 70% for input fields
        
    this.getColumnConstraints().addAll(col1, col2);

    // Make the grid pane use all available vertical space
    GridPane.setVgrow(emptyLabel, Priority.ALWAYS);
    GridPane.setVgrow(lblMe, Priority.NEVER); // Don't grow the label itself

    // Add style classes to HBox containers
    hboxHostName.getStyleClass().add("hbox");
    hboxPortNumber.getStyleClass().add("hbox");
    hboxSender.getStyleClass().add("hbox");
    hboxReceiver.getStyleClass().add("hbox");
    hboxStatus.getStyleClass().add("hbox");

    //lblMe.getStyleClass().add("lblMe");

    // Add style class to the main GridPane
    this.getStyleClass().add("grid-pane");
  }

  private void actions()
  {
    btnClose.setOnAction(e ->
    {
      close();
    });

    btnConnect.setOnAction(e ->
    {
      connect();
    }
    );

    btnSend.setOnAction(e ->
    {
      send();
    });
  }

  private void makeResponsive()
  {
    // Make text areas and fields grow with window size
    txtHostName.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
    txtPortNumber.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
    txtSender.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
    txtReceiver.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
    txtSubject.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
    txtStatus.prefWidthProperty().bind(this.widthProperty().multiply(0.6));
        
    // Make text area responsive
    txtMessage.prefWidthProperty().bind(this.widthProperty().multiply(0.9));
    txtMessage.prefHeightProperty().bind(this.heightProperty().multiply(0.3));
        
    // Make buttons responsive
    btnConnect.prefWidthProperty().bind(this.widthProperty().multiply(0.5));
    btnSend.prefWidthProperty().bind(this.widthProperty().multiply(0.5));
    btnClose.prefWidthProperty().bind(this.widthProperty().multiply(0.5));
  }

  private void connect()
  {
    String hostName = txtHostName.getText().trim();
    String portText = txtPortNumber.getText().trim();
    
    if(hostName.isEmpty() || portText.isEmpty())
    {
      txtStatus.setText("Please enter host and port");
      return;
    }
    
    try
    {
      int portNumber = Integer.parseInt(portText);
      smtp = new SMTP(hostName, portNumber);
      txtStatus.setText("Connected");
    }
    catch(NumberFormatException ex)
    {
      txtStatus.setText("Invalid port number");
    }
    catch(Exception ex)
    {
      txtStatus.setText("Connection Failed: " + ex.getMessage());
    }

    if(smtp != null) 
    {
      // Add connected style
      txtStatus.getStyleClass().add("connected");
      txtStatus.getStyleClass().remove("error");
    }else 
    {
      // Add error style
      txtStatus.getStyleClass().add("error");
      txtStatus.getStyleClass().remove("connected");
    }
  }

  private void send()
  {
    if(smtp == null)
    {
      txtStatus.setText("Please connect first");
      return;
    }
    
    String strSender = txtSender.getText();
    String strReceiver = txtReceiver.getText();
    String strSubject = txtSubject.getText();
    String strMessage = txtMessage.getText();
    String strHost = txtHostName.getText();
    
    try
    {
      String response = smtp.send(strHost, strReceiver, strSender, strMessage, strSubject);
      txtStatus.setText(response);
    }
    catch(IOException ex)
    {
      txtStatus.setText("Sending Email failed: " + ex.getMessage());
    }
  }

  private void close()
  {
    if (smtp == null)
    {
      txtStatus.setText("No connection to close");
      return;
    }
    
    try
    {
      smtp.close();
      txtStatus.setText("Connection Closed");
      smtp = null;
    }
    catch(IOException ex)
    {
      txtStatus.setText("Closing Connection Failed: " + ex.getMessage());
    }
  }
}
