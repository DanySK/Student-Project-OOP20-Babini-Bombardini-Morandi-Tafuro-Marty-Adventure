package edu.unibo.martyadventure.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

class GameOverScreen extends StaticScreen {

    private static final int ZOOM = 50;

    private static final String BACKGROUND_PATH = "menu/gameover.png";
    private static final float TITLE_FONT_SCALE = 1.10f;
    private static final Vector2 TITLE_POSITION = new Vector2(100, 650);
    private static final Vector2 MENU_BUTTON_POSITION = new Vector2(30, 40);

    private static final String WON_TEXT = "Hai vinto!";
    private static final String LOSE_TEXT = "Hai perso, vuoi riprovare?";

    private final Label titleLabel;
    private final TextButton menuButton;


    private Label getLabel() {
        final Label label = new Label("", super.uiSkin, "title");
        label.setPosition(TITLE_POSITION.x, TITLE_POSITION.y);
        label.setFontScale(TITLE_FONT_SCALE);
        return label;
    }

    public GameOverScreen(final ScreenManager manager) {
        super(manager, BACKGROUND_PATH, ScreenManager.VIEWPORT.X_VIEWPORT * ZOOM,
                ScreenManager.VIEWPORT.Y_VIEWPORT * ZOOM);
        this.titleLabel = getLabel();

        this.menuButton = getStandardTextButton("Ritornare al menu?", MENU_BUTTON_POSITION, () -> {
            screenManager.loadMenuScreen();
        });

        super.stage.addActor(this.titleLabel);
        super.stage.addActor(this.menuButton);
    }

    /**
     * Set the appropriate text to the player winning.
     *
     * @param playerWon if the player has won the game or not.
     */
    public void setPlayerWon(final boolean playerWon) {
        this.titleLabel.setText(playerWon ? WON_TEXT : LOSE_TEXT);
    }

    @Override
    public void show() {
        resize(Gdx.app.getGraphics().getWidth(), Gdx.app.getGraphics().getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.getBatch().begin();
        stage.getBatch().draw(this.background, 0.0f, 0.0f);
        stage.getBatch().end();
        stage.draw();
    }
}
