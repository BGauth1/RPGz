package src.render;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Window {

	private int		_width;
	private int		_height;
	private String	_content[][];
	Map<String, String> _colors;
	List<Object>		objs;

	public Window(int width, int height) throws Exception { 
		this._width = width;
		this._height = height;

		if (this._width < 3 || this._width > 200)
			throw new Exception("Window -> Width outside of 3-200 range: " + _width);
		else if (this._height < 3 || this._height > 200)
			throw new Exception("Window -> Height outside of 3-200 range: " + _height);
			
		this.initColors();
		_content = new String[_width][_height];
		this.fillContent();
		this.initObjects();
	}
		
	
	public void show() throws Exception {
		try {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			for (int y = 0; y < _height; y++) {
				for (int x = 0; x < _width; x++)
					System.out.print(_content[x][y]);
					System.out.print("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initColors() {
		_colors = new HashMap<>();

		_colors.put("black", "\u001B[40m");
        _colors.put("red", "\u001B[41m");
        _colors.put("green", "\u001B[42m");
        _colors.put("yellow", "\u001B[43m");
        _colors.put("blue", "\u001B[44m");
        _colors.put("magenta", "\u001B[45m");
        _colors.put("cyan", "\u001B[46m");
        _colors.put("white", "\u001B[47m");
        _colors.put("reset", "\u001B[0m");
		_colors.put("none", "");
	}
	
	public void setChar(int x, int y, char c, String color) {
		_content[x][y] = _colors.get(color) + c + _colors.get("reset");
	} 

	public void fillContent() {
		for (int x = 0; x < _width; x++) {
			setChar(x, 0, ' ', "white");
			setChar(x, _height - 1, ' ', "white");
		}
		for (int y = 0; y < _height; y++) {
			setChar(0, y, ' ', "white");
			setChar(_width - 1, y, ' ', "white");
		}
		for (int y = 1; y < _height - 1; y++) {
			for (int x = 1; x < _width - 1; x++)
				setChar(x, y, ' ', "black");
		}
	}

	public void initObjects() throws Exception {
		objs = new ArrayList<>();
		View v1 = new View(this, "Character overview", "yellow", _width / 4, _height, 0, 0);
		View v2 = new View(this, "Time & date", "none", _width / 4, _height,  _width - _width / 4, 0);
		TextBox t1 = new TextBox(this, "Name: Warrior#W", "none", 100, 1, v1.getX() + 2, v1.getY() + 4);
		TextBox t2 = new TextBox(this, "Skills : STR+1,...", "none", 100, 1, t1.getX(), t1.getY() + 4);
		v1.addObject(t1);
		v1.addObject(t2);
		// v1.addObject(v2);
		v1.show();
		v2.show();
	}
}
