package src.render;

public class GameView extends View {
    public GameView(Window win, String name, String color, int width, int height, int x, int y) throws Exception {
        super(win, name, color, width, height, x, y);
    }

    @Override
	public void	show() {
		if (!_visible)
			return;
		
        showBorders();
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
