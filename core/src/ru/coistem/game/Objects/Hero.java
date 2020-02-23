package ru.coistem.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

public class Hero extends Person {
    int type = 1;
    final int ASSASSIN = 1;
    int COEF = 1000000000;

    public ArrayList<Weapon> weapons;

    @Override
    public void create(Texture texture, World world, float x, float y) {
        weapons = new ArrayList<>();
        sprite = new Sprite(texture);
        shape.setAsBox(sprite.getWidth() / 2, sprite.getHeight() / 2);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);
        body.setTransform(x, y, 0);
        fixture = body.createFixture(shape, 1f);
        if (type == ASSASSIN) {

        }
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            Sprite sprites = new Sprite(new Texture(Gdx.files.internal("sword.png")));
            BodyDef def = new BodyDef();
            def.type = BodyDef.BodyType.DynamicBody;
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(sprites.getWidth() / 2, sprites.getHeight() / 2);

            weapons.add(new Weapon(sprites, shape, def, body.getWorld()));

            Filter f = new Filter();
            f.groupIndex = -1;
            fixture.setFilterData(f);
            weapons.get(weapons.size()-1).fixture.setFilterData(f);
            weapons.get(weapons.size()-1).body.setTransform(body.getPosition().x, body.getPosition().y, weapons.get(weapons.size()-1).sprite.getRotation());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W) && isGrounded()) {
            yImpl = 2000000;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            xImpl -= 200000 * (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) ? 10000 : 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            xImpl += 200000 * (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) ? 10000 : 1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) System.exit(0);
        body.setLinearVelocity(xImpl * (yImpl >= 0 ? 5 : 1), yImpl);
        xImpl = 0;
        yImpl -= yImpl >= 0 ? 50000 : 0;
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        body.setFixedRotation(true);

        if (type == ASSASSIN) {
//            weapon.body.setTransform(body.getPosition().x + sprite.getWidth(), body.getPosition().y, weapon.body.getAngle());
            if (!weapons.isEmpty())
                for (int i = 0; i < weapons.size(); i++) {
                    weapons.get(i).sprite.setRotation((float) Math.toDegrees(weapons.get(i).body.getAngle()));
                }
        }
    }

    public boolean isGrounded() {
        for (int i = 0; i < body.getWorld().getContactCount(); i++) {
            if (body.getWorld().getContactList().get(i).getFixtureA().getBody().equals(body) || body.getWorld().getContactList().get(i).getFixtureB().getBody().equals(body)) {
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
