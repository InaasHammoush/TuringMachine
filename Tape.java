package turing;

/**
 * this class represents a tape in a Turing Machine.
 */
public class Tape {
	
	Cell currentCell = new Cell(); // represents the cell that the machine will operate on each time.
	
	/**
	 * constructor. when a tape is created it sets the content of the current cell to blank space.
	 */
	public Tape() {
		currentCell.content = ' ';
	}
/**
 * a getter method that returns the pointer to the current cell
 * @return pointer to current cell
 */
	public Cell getCurrentCell() {
		return currentCell;
	}
/**
 * this method returns the content in the current cell
 * @return character in the content of the current cell
 */
	public char getContent() {
		return currentCell.content;
	}
/**
 * a setter method that sets the content of the current cell 
 * to the character given as a parameter
 * @param ch of type character to be set as the content of current cell
 */
	public void setContent(char ch) {
		currentCell.content = ch;
	}
/**
 * moves the pointer of the current cell to the left/previous cell.
 * if the current cell is the leftmost cell then it creates a new cell
 * and places it to the left and sets the current cell pointer to
 * point to it.
 */
	public void moveLeft() {
		if (currentCell.prev == null) { // if the current cell is the leftmost cell.
			Cell newLeftCell = new Cell();
			currentCell.prev = newLeftCell;
			newLeftCell.next = currentCell; // the new cell must also point to the current cell 
			newLeftCell.content = ' ';
		}

		currentCell = currentCell.prev; // move the current cell to the new/already existing left cell
	}
/**
 * moves the pointer of the current cell to the right/next cell.
 * if the current cell is the rightmost cell then it creates a new cell
 * and places it to the right and sets the current cell pointer to
 * point to it.
 */
	public void moveRight() {
		if (currentCell.next == null) { // if the current cell is the rightmost cell.
			Cell newRightCell = new Cell();
			currentCell.next = newRightCell;
			newRightCell.prev = currentCell; // the new cell must also point to the current cell 
			newRightCell.content = ' ';
		}

		currentCell = currentCell.next; // move the current cell to the new/already existing right cell
	}
/**
 * this method returns a the contents of the tape as a string consisting of 
 * the characters in the cells in order from left to right and ignores the
 * white spaces at the beginning and the end of the tape.
 * if the tape is empty a NullPointerException is caught and an error message
 * is printed out.
 * @return string of the tape's contents
 */
	public String getTapeContents() {
		Cell pointer = currentCell; // new pointer that will move along the cells when creating the string
		StringBuilder str = new StringBuilder(); // this will contain the string to be returned
		while (pointer.prev != null) { //while we haven't reached the leftmost character
			pointer = pointer.prev;
		}
		if (pointer.content == ' ') {
			pointer = pointer.next; // a blank space in the first cell should be ignored
		}
		try {
			while (pointer.next != null) { //while we haven't reached the last leftmost cell
				str.append(pointer.content);
				pointer = pointer.next; // move to the right
			}
			if (str.charAt(str.length()-1) == ' ') {
				str.deleteCharAt(str.length()-1); // if the last character in the string is a blank
												// space it must be ignored.
			}
		}
		catch (NullPointerException e) {
			System.out.println("The tape is empty!");
		}
		
		return str.toString();
	}

}
