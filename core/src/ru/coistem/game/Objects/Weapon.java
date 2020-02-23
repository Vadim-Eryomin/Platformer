package ru.coistem.game.Objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public class Weapon {
    Sprite sprite;
    Body body;
    Fixture fixture;
    PolygonShape shape;
    BodyDef def;
    double rotation = 0;

    public Weapon(Sprite sprite, PolygonShape shape, BodyDef def, World world) {
        this.sprite = sprite;
        this.body = world.createBody(def);
        this.fixture = body.createFixture(shape,1f);
        this.shape = shape;
        this.def = def;

        Filter f  = new Filter();
        f.groupIndex = 100;

        fixture.setFilterData(f);


        body.applyLinearImpulse(100000000000f, 1000000000f, body.getPosition().x, body.getPosition().y, true);
    }
    public void act(){
        rotation+=0.5;
        sprite.rotate((int)rotation);
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        body.setTransform(body.getPosition().x, body.getPosition().y, (int)rotation);
    }

    public void draw(Batch batch){
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }
}
