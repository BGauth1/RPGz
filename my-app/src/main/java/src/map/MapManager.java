package src.map;

import src.render.Window;
import src.render.GameView;

public class MapManager {
	Window		_win;
	GameView	_view;
	
	
	public MapManager(Window win, GameView view) {
		_win = win;
		_view = view;
	}
}
