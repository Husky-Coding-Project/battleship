package textInterface;

import battleship.BoardView;

import java.util.Scanner;

/**
 * The TextInterfaceView class represents a view that allows a user to interact
 * with the command line.
 */
public class TextInterfaceView implements View {

    // This class does not represent an ADT

    private InputHandler inputHandler;
    private Scanner input;

    private boolean active;

    public TextInterfaceView() {
        active = true;
        input = new Scanner(System.in);
    }

    @Override
    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public void begin() {
        if (inputHandler == null) {
            throw new IllegalStateException("No InputHandler has been provided to respond "
                                            + "to user input");
        }
        while (active) {
            inputHandler.handleInput(nextInput());
        }
    }

    private String nextInput() {
        String nextInput = input.nextLine();
        System.out.println();
        return nextInput;
    }

    @Override
    public void exit() {
        active = false;
        input.close();
    }

    @Override
    public void startMenu() {
        System.out.println("Welcome to Battleship");
        System.out.print("Would you like to play against the computer or "
                           + "or against another player? ");
    }

    @Override
    public void drawBoard(BoardView board) {
        // TODO
    }

    @Override
    public void setupPrompt() {
        // TODO
    }

    @Override
    public void attackPrompt() {
        System.out.print("Position to attack: ");
    }

    @Override
    public void placeShipPrompt() {
        System.out.print("Ship placement on board: ");
    }

    @Override
    public void shipOrientationPrompt() {
        System.out.print("Ship orientation: ");
    }

    @Override
    public void shipLengthPrompt() {
        System.out.print("Ship length: ");
    }

    @Override
    public void showErrorUnknownCommand() {
        System.out.println("Unknown option");
    }

    @Override
    public void showErrorInvalidPosition() {
        System.out.println("Invalid board position");
    }
}