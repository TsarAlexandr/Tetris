package by.bntu.fitr.povt.TsarAlexandr.view.lwjglmodule;

import java.awt.Font;
import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import by.bntu.fitr.povt.TsarAlexandr.controller.GamePlay;

public class LWJGLMenu {
	Texture texture, textureEX;

	private void initGL(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public void init() {

		try {

			texture = TextureLoader.getTexture("PNG", ResourceLoader
					.getResourceAsStream("src/by/bntu/fitr/povt/TsarAlexandr/controller/start.png"));
			textureEX = TextureLoader.getTexture("PNG", ResourceLoader
					.getResourceAsStream("src/by/bntu/fitr/povt/TsarAlexandr/controller/exit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void renderText(int score) {
		Color.white.bind();
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		TrueTypeFont font = new TrueTypeFont(awtFont, true);
		font.drawString(2, 80, ("Your score is  " + score));
		font.drawString(227, 560, "Created by Tsar Alexandr");
		Font awt1Font = new Font("Times New Roman", Font.BOLD, 60);
		TrueTypeFont font1 = new TrueTypeFont(awt1Font, true);
		font1.drawString(120, 10, "TETRIS", Color.red);

	}

	public void render() {
		Color.white.bind();
		texture.bind();

		float x = 100, y = 150;
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(x + texture.getTextureWidth(), y);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(x + texture.getTextureWidth(), y + texture.getTextureHeight());
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(x, y + texture.getTextureHeight());
		GL11.glEnd();
		textureEX.bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(100, 450);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(100 + textureEX.getTextureWidth(), 450);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(100 + textureEX.getTextureWidth(), 450 + textureEX.getTextureHeight());
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(100, 450 + textureEX.getTextureHeight());
		GL11.glEnd();
	}

	public void start(GamePlay game) {
		initGL(500, 600);
		init();

		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			render();
			renderText(game.score);

			
			if (Mouse.getX() > 106 && Mouse.getX() < 395 && Mouse.getY() > 160 && Mouse.getY() < 440
					&& Mouse.isButtonDown(0)) {
				break;
			}
			if ((Mouse.getX() > 105 && Mouse.getX() < 389 && Mouse.getY() > 40 && Mouse.getY() < 142
					&& Mouse.isButtonDown(0)) || Display.isCloseRequested())

			{
				Display.destroy();
				System.exit(0);
			}

			Display.update();
			Display.sync(100);
		}

		Display.destroy();
		game.play();
		start(game);
		System.exit(-1);

	}

}
