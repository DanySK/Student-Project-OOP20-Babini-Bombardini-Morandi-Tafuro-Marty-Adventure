package edu.unibo.martyadventure.view.character;

import java.util.concurrent.ExecutionException;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import edu.unibo.martyadventure.model.character.EnemyCharacter;
import edu.unibo.martyadventure.model.weapon.WeaponFactory;
import edu.unibo.martyadventure.view.Toolbox;

public class EnemyCharacterView extends CharacterView {

    private static EnemyCharacter enemy = new EnemyCharacter(WeaponFactory.createRandomMeleeWeapon("Mazza"), "Biff", 800, WeaponFactory.createRandomMeleeWeapon("Schiaffo") );
    private static final String ENEMY_PATH = "Characters/Biff/BiffMove (1).png";
    public static final int FRAME_WIDTH = 140;
    public static final int FRAME_HEIGHT = 148;
    private WeaponView dropWeapon;

    public EnemyCharacterView(Vector2 initialPosition, String enemy_path, EnemyCharacter enemy, WeaponView weapon, WeaponView dropWeapon)
            throws InterruptedException, ExecutionException {
        super(initialPosition, MAX_ACCELERATION, ACCELERATION_FACTOR, MAX_SPEED, new TextureRegion(new Texture(enemy_path)), FRAME_WIDTH, FRAME_HEIGHT, weapon);
        this.enemy = enemy;
        this.dropWeapon = dropWeapon;
    }

    private static TextureRegion loadTexture() throws InterruptedException, ExecutionException {
        Texture texture = Toolbox.getTexture(ENEMY_PATH);
        TextureRegion textureFrames = new TextureRegion(texture);
        return textureFrames;
    }
}
