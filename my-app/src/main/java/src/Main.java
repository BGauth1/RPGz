import view.View;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			View ter = new View("ter1", (short) 12, (short) 3);
			ter.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("huh");
		}
	}
	}

