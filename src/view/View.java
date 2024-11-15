package view;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class View {

	private String	_name;
	private short	_width;
	private short	_height;

	public View(String name, short width, short height) { 
		this._name = name;
		this._width = width;
		this._height = height;
	}

	public void start() throws Exception {
		try {
			while (true) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("O");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
