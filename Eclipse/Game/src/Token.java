import java.awt.Graphics;

import javax.swing.JPanel;


class Token extends JPanel {
	int id;
	int position;

	public Token() {
		id = 1;
		position = 0;
	}

	public Token(int p) {
		id = 1;
		position = p;
	}

	public void draw(Graphics g) {
		// super.paint(g);
		if (position == 0) {
			g.drawRect(20, 20, 20, 20);
		} else {
			g.fillRect(50, 50, 20, 20);
		}

	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int x) {
		position = x;
	}
}