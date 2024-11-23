package src.render;

public class TextBox extends Object {

	public TextBox(Window win, String name, String color, int width, int height, int x, int y) {
		super(win, name, color, width, height, x, y);
	}

	@Override
	public void	show() {
		if (!_visible)
			return;

		String tmp;
		System.out.println("Trying to put " + _name + " between " + _x + " and " + (_x + _width));
		if (_name.length() > _width)
			tmp = _name.substring(0, _width - 3) + "...";
		else
			tmp = _name;
		
		for (int i = 0, x = _x; i < tmp.length(); i++, x++)
			_win.setChar(x, _y, tmp.charAt(i), _color);

		System.out.println(tmp);
		for (Object object : objs)
			object.show();
	}
}
