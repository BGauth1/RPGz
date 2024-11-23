package src.control;

import java.util.Scanner;

public class InputListener {

	public String current_command;
	private Scanner _scanner;

	public void listen() {
		System.out.print("> ");
		current_command = _scanner.nextLine();
	}
	
	public InputListener() {
		_scanner = new Scanner(System.in);
		current_command = "";
    }

	@Override
	protected void finalize() {
    	try {
        	_scanner.close();
    	} catch (Exception e) {
        	e.printStackTrace();
   		}
}

}