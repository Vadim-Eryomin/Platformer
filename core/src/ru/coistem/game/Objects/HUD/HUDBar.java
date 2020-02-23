package ru.coistem.game.Objects.HUD;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.coistem.game.Objects.GameObject;
import ru.coistem.game.Objects.Person;

public abstract class HUDBar {
    Person person;
    double hp = 0;
    double maxHp = 0;
    int level = 0;
    double xp = 0;
    double needXp = 0;
    public abstract void create(Person person);
    public abstract void act();
    public abstract void draw(SpriteBatch batch, Camera camera);
}
