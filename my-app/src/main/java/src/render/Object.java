package src.render;

import java.util.ArrayList;
import java.util.List;

public class Object {
	protected Window		_win;

	protected String	_name;
	protected String	_color;
	protected int		_width;
	protected int		_height;
	protected int		_x;
	protected int		_y;

	protected boolean	_visible;
	List<Object>		objs;

	public String	getName() { return _name; }
	public String	getColor() { return _color; }
	public int		getWidth() { return _width; }
	public int		getHeight() { return _height; }
	public int		getX() { return _x; }
	public int		getY() { return _y; }
	public boolean	isVisible() { return _visible; }

	public void		setName(String name) { _name = name; }
	public void		setColor(String color) { _color = color; }
	public void		setWidth(int width) { _width = width; }
	public void		setHeight(int height) { _height = height; }
	public void		setX(int x) { _x = x; }
	public void		setY(int y) { _y = y; }
	public void		setVisibility(boolean b) { _visible = b; }

	public void addObject(Object obj) {
		if (obj._width > _width)
			obj._width = _width;
		if (obj._height > _height)
			obj._height = _height;
		// if (obj._x < _x || obj._x + obj._width > _x + _width)
		// 	obj._x = _x;
		// if (obj._y + obj._height > _y + _height)
		// 	obj._y = _y + _height - obj._height;
		// if (obj._y < _y || )
		// 	obj._y = _y;
		
		objs.add(obj);
	}

	public void removeObject(Object obj) {
		objs.remove(obj);
	}

	public void	show() {};

	public Object(Window win, String name, String color, int width, int height, int x, int y) {
		_win = win;
		_name = name;
		_color = color;
		_width = width;
		_height = height;
		_x = x;
		_y = y;
		_visible = true;
		objs = new ArrayList<>();
	}

	public Object(Window win, String name, int width, int height, int x, int y) {
		_win = win;
		_name = name;
		_color = "none";
		_width = width;
		_height = height;
		_x = x;
		_y = y;
		_visible = true;
		objs = new ArrayList<>();
	}
}
