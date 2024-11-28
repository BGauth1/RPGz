package src.render;

public class View extends Object {

	public View(Window win, String name, String color, int width, int height, int x, int y) throws Exception {
		super(win, name, color, width, height, x, y);

		if (this._width < 3 || this._width > 200)
			throw new Exception("Object " + _name +  "-> Width outside of 3-200 range: " + _width);
		else if (this._height < 3 || this._height > 200)
			throw new Exception("Object " + _name +  "-> Height outside of 3-200 range: " + _height);
	}

	// private int startStr(String str) {
	// 	int start = _width / 2 - str.length() / 2 - 1 + _x;
	// 	for (Object object : objs) {
	// 		if (start >= object._x && start <= object._width + object._x && _y + 2 >= object._y && _y + 2 <= object._y + object._height) {
	// 			System.out.println("str start collided with object " + object._name);
	// 			start = object._width + object._x + 2;
	// 		}
	// 	}

	// 	if (start > _width)
	// 		return -1;
	// 	return start;
	// }

	// private int endStr(String str) {
	// 	int end = _x + _width / 2 - str.length() / 2 - 2 + str.length();
	// 	for (Object object : objs) {
	// 		if (end >= object._x && end <= object._width + object._x && _y + 2 >= object._y && _y + 2 <= object._y + object._height) {
	// 			System.out.println("str end collided with object " + object._name);
	// 			end = object._x - 2;
	// 		}
	// 	}

	// 	if (end < 0)
	// 		return -1;
	// 	return end;
	// }

	@Override
	public void	show() {
		if (!_visible)
			return;
		
		for (int x = 0; x < _width; x++) {
			_win.setChar(x + _x, _y, ' ', "white");
			_win.setChar(x + _x, _height - 1, ' ', "white");
		}
		for (int y = 0; y < _height; y++) {
			_win.setChar(_x, y + _y, ' ', "white");
			_win.setChar(_width - 1, y + _y, ' ', "white");
		}

		String tmp;
		if (_name.length() > _width)
			tmp = _name.substring(0, _width - 3) + "...";
		else
			tmp = _name;

		// int start = startStr(tmp);
		// int end = endStr(tmp);

		// if (start > end || start == -1 || end == -1) {
		// 	return;
		// }
		// System.out.println(_name + ": " + start + " " + end + " " + tmp);;

		int len = tmp.length();

		for (int i = 0, x = _width / 2 - len / 2 - 1 + _x; i < len; i++, x++)
			_win.setChar(x, _y + 2, tmp.charAt(i), _color);

		for (Object object : objs)
			object.show();
	}
}
