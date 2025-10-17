# Simple Email Client

- A JavaFX-based desktop application for sending emails via SMTP protocol. This lightweight email client provides a simple and intuitive interface for composing and sending emails.

## Features
- Simple SMTP Connection: Connect to any SMTP server using hostname and port
  Email Composition: Compose emails with sender, receiver, subject, and message body  
- Real-time Status Updates: Get immediate feedback on connection and sending status
- Clean JavaFX Interface: Modern, user-friendly graphical interface
- Error Handling: Robust error handling and user feedback

## Technologies used
- JavaFX 21.0.1: GUI framework for the user interface
  - javafx-controls: UI controls (buttons, text fields, etc.)
  - javafx-fxml: FXML support for UI design
  - javafx-graphics: Graphics rendering
- Jakarta Mail 2.0.1: Email sending functionality (SMTP protocol)
- Maven 3.x: Build automation and dependency management
- JUnit 5: Testing framework

## Prerequisites
- Papercut SMTP(Required for Testing)
  - Papercut SMTP is a simple SMTP server for testing email functionality locally without actually sending emails to real addresses.
  - Download Papercut
    - Windows: https://github.com/ChangemakerStudios/Papercut-SMTP
  - SMTP server will start on localhost:25 by default

## Setup
- Before running on the application:
  1. Launch Papercut SMTP
  2. Verify it's running on the default port:
    - Papercut: localhost:25
  3. Configure SMTP setting in the actual application:
    - Host Name: localhost
    - Port Number: 25
    - Sender: Any email address
    - Receiver: Any email address

## Usage
1. Connect to SMTP Server
- Enter Host Name: localhost
- Enter Port Number: 25 (or 2525 for smtp4dev)
- Click Connect
- Status should show "Connected"

2. Compose Email
- Enter Sender email address
- Enter Receiver email address
- Enter Subject
- Type your Message in the text area

3. Send Email
- Click Send button
- Check status for confirmation
- Open Papercut/smtp4dev to view the "sent" email

4. Close Connection
- Click Close button when done
- Status should show "Connection Closed"

## Testing with Papercut
- Why Use Papercut?
  Papercut is a local SMTP server that:
  - Captures all outgoing emails without sending them
  - Perfect for development and testing
  - No risk of accidentally sending test emails to real addresses
  - Provides a simple UI to view captured emails
- Viewing Captured Emails
  - Keep Papercut running in the background
  - Send an email using the application
  - Switch to Papercut window
  - You'll see the email appear in the inbox
  - Click on it to view the full email content

## Project Structure
Simple-Email/
|---jdeploy/
|    |---publish/
|        |---package.json
|        |---README.md
|        |---jdeploy-bundle/
|            |---icon.png
|            |---jar-runner.jar
|            |---jdeploy.js
|            |---Simple-Email-Client.jar
|---jdeploy-bundle/
|    |---icon.png
|    |---jar-runner.jar
|    |---jdeploys.js
|    |---Simple-Email-Client.jar
|---node_modules/
|---target/
|    |---Simple-Email-1.0-SNAPSHOT.jar
|    |---Simple-Email-Client.jar
|---src/
|    |---main/
|    |    |---java/
|    |    |    |---legecy/
|    |    |        |---panda/
|    |    |            |---Main.java
|    |    |            |---Email/
|    |    |                |---Display.java
|    |    |                |---SMTP.java
|    |    |---resources/
|    |        |---legecy/
|    |            |---panda/
|    |                |---styles/
|    |                    |---styles.css
|    |                |---images/
|    |                    |---app.ico
|    |                    |---icon.png
|    |---test/
|        |---java/
|           |---legecy/
|               |---panda/
|                   |---AppTest.java
|                       |---Email/
|                           |---SMTPTest.java
|---pom.xml
|---README.md
|---package.json
|---package-lock.json

- Key Classes:
  - Main.java: JavaFX application entry point, lauched the GUI
  - Display.java: Contains the UI layout and actions
  - SMTP.java: Handles SMTP protocol communication with the mail server

## Troubleshooting
- Common Issues

1. "Connection Failed" Error
  - Cause: Papercut/SMTP server is not running or wrong port
  - Solution:
    Verify Papercut is running
    Check the port number (25 for Papercut, 2525 for smtp4dev)
    Try telnet localhost 25 to test connectivity
2. Port Already in Use
  - Cause: Another application is using port 25
  - Solution:
    Use a different port (e.g., 2525)
    Stop other SMTP services
    Use smtp4dev instead of Papercut

- Getting Help
  If you encounter issues:
  - Check that all prerequisites are installed
  - Verify Papercut is running
  - Check the status messages in the application

## Download
- https://www.jdeploy.com/~simple-email-client

## Author
- Josh T. "Legecy Panda" Masunda

## Acknowledgements
- JavaFX team for the excellent GUI framework
- Jakarta Mail fofr SMTP functionality
- Papercut team for the testing SMTP server
- Maven community for the build automation

## Note
- This application is for educational and testing purposes. For production use with real SMTP servers, additional security features should be implemented.

## From me
- Thank you for your support and trust in my abilities. I hope we can work together again.

## Contact me
- Github: https://github.com/LegacyPanda
- Facebook: https://www.facebook.com/profile.php?id=100091230646761
- Fiverr: https://www.fiverr.com/users/josh_t_masunda
- Upwork: https://www.fiverr.com/users/josh_t_masunda
- Phone: +27 71 164 9220
- Website: Coming Soon

