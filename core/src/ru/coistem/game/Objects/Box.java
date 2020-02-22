package ru.coistem.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Box extends GameObject {
    @Override
    public void create(Texture texture, World world, float x, float y) {
        sprite = new Sprite(texture);
        def.type = BodyDef.BodyType.StaticBody;
        shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);
        body = world.createBody(def);
        body.setTransform(x, y, 0);
        fixture = body.createFixture(shape, 1f);
        sprite.setPosition(body.getPosition().x - sprite.getWidth()/2, body.getPosition().y - sprite.getHeight()/2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
}
