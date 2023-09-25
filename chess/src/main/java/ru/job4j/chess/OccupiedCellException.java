package ru.job4j.chess;

public class OccupiedCellException extends Exception {
    public OccupiedCellException() {
        super();
    }

    public OccupiedCellException(String message) {
        super(message);
    }
}
