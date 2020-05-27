package com.library.server;

import java.util.Scanner;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gdimitrova
 *
 */
public class ServerApplication implements AutoCloseable {

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
        System.out.println("help - prints this help\n");
    }

    public static void main(String[] args) {
        try (ServerApplication app = new ServerApplication();) {
            printHelp();
            try (Scanner input = new Scanner(System.in);) {
                boolean isRunning = true;
                while (isRunning) {
                    if (input.hasNextLine()) {
                        switch (input.nextLine()) {
                            case "start":
                                app.startServer();
                                System.out.println("");
                                break;
                            case "stop":
                                app.stopServer();
                                System.out.println("");
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
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        System.err.println("\n\nEXITED");
    }

    @Override
    public void close() throws Exception {
        System.err.println("\n\nServer stop");
    }
}
