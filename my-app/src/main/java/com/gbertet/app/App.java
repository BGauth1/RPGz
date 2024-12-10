package com.gbertet.app;

import java.io.File;

import src.control.InputListener;
import src.render.Window;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
		try {
			InputListener inputListener = new InputListener();
			while (!inputListener.current_command.equals("exit")) {
				Window win = new Window(128, 32);
				win.show();
				inputListener.listen();
				// System.err.println(inputListener.current_command);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("huh");
		}
		// System.out.println("File path: " + new File("Your file name").getAbsolutePath());
}
}
