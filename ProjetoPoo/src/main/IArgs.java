package main;

/**
 * The Args interface represents the command line arguments passed to the program.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 * @see Args
 */
public interface IArgs {
    /**
     * Checks if the program is in file mode.
     *
     * @return true if the program is in file mode, false otherwise
     */
    boolean fileMode();

    /**
     * Checks if the program is in read mode.
     *
     * @return true if the program is in read mode, false otherwise
     */
    boolean readMode();
}