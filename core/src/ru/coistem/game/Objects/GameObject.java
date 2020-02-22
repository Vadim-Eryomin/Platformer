package ru.coistem.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {
    Sprite sprite;
    public Body body;
    BodyDef def = new BodyDef();
    PolygonShape shape = new PolygonShape();
    Fixture fixture;
    float xImpl = 0;
    float yImpl = 0;

    public GameObject(){}
    public abstract void create(Texture texture, World world, float x, float y);
}
