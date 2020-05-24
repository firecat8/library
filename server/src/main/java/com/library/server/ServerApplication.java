package com.library.server;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdimitrova
 *
 */
public class ServerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

    private RestServer restServer;

    public ServerApplication() {
        restServer = new RestServer();
    }

    public void startServer() {
        restServer.start();
    }

    public void stopServer() {
        restServer.stop();
    }

    /**
     * Prints the commands list to the standard output
     */
    public static void printHelp() {
        System.out.println("\n\nCommands list :");
        System.out.println("start - starts the web server");
        System.out.println("stop - stops the web server");
        System.out.println("exit - stops the web server and exits");
        System.out.println("help - prints this help");
    }

    public static void main(String[] args) {
        ServerApplication app = new ServerApplication();
        printHelp();
        try (Scanner input = new Scanner(System.in);) {
            boolean isRunning = true;
            System.out.println("\nfirst isRunning " + isRunning);
            while (isRunning) {
                if(!isRunning){
                    input.close();
                }
                System.out.println("\n\nin isRunning " + isRunning);
                if (input.hasNextLine()) {
                    String command = input.nextLine();

                    System.out.println("\n\tisRunning " + isRunning);
                    switch (command) {
                        case "start":
                            app.startServer();
                            break;
                        case "stop":
                            app.stopServer();
                            isRunning = false;
                            break;
                        case "help":
                            printHelp();
                            break;
                        case "exit":
                            app.stopServer();
                            isRunning = false;
                            break;
                    }
                }
            }
        }
    }
}
