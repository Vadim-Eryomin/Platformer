package ru.coistem.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Hero extends GameObject {
    @Override
    public void create(Texture texture, World world, float x, float y) {
        sprite = new Sprite(texture);
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);
        body.setTransform(x, y, 0);
        fixture = body.createFixture(shape, 1f);
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && isGrounded()) {
            yImpl += 1000000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            xImpl -= 50000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            xImpl += 50000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) System.exit(0);

        body.applyLinearImpulse(xImpl, yImpl, body.getPosition().x, body.getPosition().y, true);
        xImpl = 0;
        yImpl = 0;
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        body.setFixedRotation(true);
    }

    public boolean isGrounded(){
        for (int i = 0; i < body.getWorld().getContactCount(); i++) {
            if (body.getWorld().getContactList().get(i).getFixtureA().getBody().equals(body) || body.getWorld().getContactList().get(i).getFixtureB().getBody().equals(body)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }
}
