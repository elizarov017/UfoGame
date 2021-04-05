//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class PW11 extends GraphicsProgram {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private static final double UFO_WIDTH = 60.0D;
	private static final double UFO_HEIGHT = 60.0D;
	private static final int UFO_SPEED = 2;
	private static final int BULLET_SPEED = 10;
	private static final int BULLET_DIAM = 10;
	private static final int DELAY = 10;
	private int numberOfTargets = 6;
	private int complexity = 3;
	private double width1;
	private double targetWidth;
	private boolean targetToLeft;
	private GImage targetMoving;
	private GImage background;
	private GImage ufo;
	private GOval bullet;
	private boolean ufoToLeft;

	public PW11() {
		this.width1 = (double)(600 / (this.numberOfTargets - 1));
		this.targetWidth = this.width1 / (double)this.complexity;
	}

	public void run() {
		this.setSize(600, 600);
		this.background = new GImage("Background.png", 0.0D, 0.0D);
		this.background.setSize(600.0D, 600.0D);
		this.add(this.background);
		this.background.sendToBack();
		this.setup();

		while(!this.gameOver()) {
			this.moveUFO();
			this.moveBullet();
			this.moveTarget();
			this.checkForCollisions();
			this.pause(10.0D);
		}

		GImage youWin;
		if (this.ufo != null && !(this.ufo.getY() >= 540.0D)) {
			if (this.numberOfTargets == 0) {
				youWin = new GImage("youwin.png", 150.0D, 150.0D);
				youWin.setSize(300.0D, 300.0D);
				this.add(youWin);
			}
		} else {
			youWin = new GImage("gameover.png", 150.0D, 150.0D);
			youWin.setSize(300.0D, 300.0D);
			this.add(youWin);
		}

	}

	private void setup() {
		this.ufo = new GImage("ufo.png", 600.0D, 0.0D);
		this.ufo.setSize(60.0D, 60.0D);
		this.add(this.ufo);
		this.createTargets();
		this.ufoToLeft = true;
		this.targetToLeft = true;
		this.addMouseListeners();
	}

	private boolean gameOver() {
		return this.numberOfTargets == 0 | this.ufo == null;
	}

	public void mousePressed(MouseEvent e) {
		if (this.numberOfTargets > 0 && this.bullet == null) {
			this.bullet = new GOval(10.0D, 10.0D);
			this.bullet.setFilled(true);
			this.bullet.setColor(Color.RED);
			this.add(this.bullet, this.ufo.getX() + 30.0D, this.ufo.getY() + 60.0D);
		}

	}

	private void moveUFO() {
		if (this.ufoToLeft) {
			this.ufo.move(-2.0D, 0.0D);
			if (this.ufo.getX() <= 0.0D) {
				this.ufoToLeft = false;
				this.ufo.move(0.0D, 60.0D);
			}
		} else {
			this.ufo.move(2.0D, 0.0D);
			if (this.ufo.getX() >= (double)this.getWidth() - 60.0D) {
				this.ufoToLeft = true;
				this.ufo.move(0.0D, 60.0D);
			}
		}

	}

	private void moveBullet() {
		if (this.bullet != null) {
			this.bullet.move(0.0D, 10.0D);
		}

	}

	private void checkForCollisions() {
		this.collideWithUFO();
		this.moveOffScreen();
	}

	private void collideWithUFO() {
		GObject collObj;
		if (this.bullet != null) {
			collObj = this.getElementAt(this.bullet.getX(), this.bullet.getY());
			if (collObj != null && collObj != this.ufo && collObj != this.background) {
				this.remove(this.bullet);
				--this.numberOfTargets;
				this.destroy(collObj);
				this.bullet = null;
			}
		}

		if (this.ufo != null) {
			collObj = this.getElementAt(this.ufo.getX(), this.ufo.getY());
			if (collObj != null && collObj != this.ufo) {
				this.destroy(this.ufo);
				System.out.println(this.ufo);
				this.ufo = null;
			}
		}

	}

	private void destroy(GObject a) {
		double width = a.getWidth() + 90.0D;
		double height = a.getHeight() + 90.0D;
		double x = a.getX() - 45.0D;
		double y = a.getY() - 45.0D;
		int count = 0;
		int p = 5;
		GImage boom = null;
		this.remove(a);
		a = null;

		while(count < 9 * p) {
			this.pause(10.0D);
			if (count == 0) {
				boom = new GImage("boom1.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 1 * p) {
				this.remove(boom);
				boom = new GImage("boom2.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 2 * p) {
				this.remove(boom);
				boom = new GImage("boom3.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 3 * p) {
				this.remove(boom);
				boom = new GImage("boom4.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 4 * p) {
				this.remove(boom);
				boom = new GImage("boom5.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 5 * p) {
				this.remove(boom);
				boom = new GImage("boom6.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 6 * p) {
				this.remove(boom);
				boom = new GImage("boom7.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 7 * p) {
				this.remove(boom);
				boom = new GImage("boom8.png", x, y);
				boom.setSize(width, height);
				this.add(boom);
			} else if (count == 8 * p) {
				this.remove(boom);
			}

			if (a != this.ufo && this.ufo != null) {
				this.moveUFO();
				this.moveBullet();
				this.moveTarget();
				++count;
			}
		}

	}

	private void moveTarget() {
		if (this.targetToLeft) {
			this.targetMoving.move(-5.0D, 0.0D);
			if (this.targetMoving.getX() <= 0.0D) {
				this.targetToLeft = false;
			}
		} else {
			this.targetMoving.move(5.0D, 0.0D);
			if (this.targetMoving.getX() >= (double)this.getWidth() - this.targetWidth) {
				this.targetToLeft = true;
			}
		}

	}

	private void moveOffScreen() {
		if (this.bullet != null && this.bullet.getY() >= (double)this.getWidth()) {
			this.remove(this.bullet);
			this.bullet = null;
		}

	}

	private void createTargets() {
		for(int i = 1; i < this.numberOfTargets; ++i) {
			GImage target = new GImage("target.png", this.width1 * (double)i - this.width1 / 2.0D - this.targetWidth / 2.0D, 520.0D);
			target.setSize(this.targetWidth, this.targetWidth);
			this.add(target);
		}

		this.targetMoving = new GImage("target.png", 0.0D, 240.0D);
		this.targetMoving.setSize(this.targetWidth, this.targetWidth);
		this.add(this.targetMoving);
	}

	private int random(int min, int max) {
		int n = (int)(Math.random() * (double)(max - min + 1) + (double)min);
		return n;
	}
}