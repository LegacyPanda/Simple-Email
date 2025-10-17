package legecy.panda.Email;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.IOException;

public class SMTP 
{
  private Socket socket;
  private PrintWriter out;  
  private BufferedReader in;

  public SMTP(String host, int port) throws IOException
  {
    this.socket = new Socket(host, port);
    this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    this.out = new PrintWriter(this.socket.getOutputStream(), true);
  }

  public String send(String initiator, String to, String from, String body, String subject) throws IOException
  {
    command("HELO " + initiator);
    command("MAIL FROM:<" + from + ">");
    command("RCPT TO:<" + to + ">");
    command("DATA");

    this.out.println("From: " + from);
    this.out.println("To: " + to);
    this.out.println("Subject: " + subject);
    this.out.println();
    this.out.println(body);
    this.out.println(".");
    this.out.flush();

    command("QUIT");

    return this.in.readLine();
  }

  private String command(String command) throws IOException
  {
    this.out.println(command);
    this.out.flush();

    return this.in.readLine();
  }

  public String close() throws IOException
  {
    this.out.close();
    this.in.close();
    this.socket.close();

    return "Connection closed.";
  }
}
