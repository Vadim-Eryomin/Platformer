package ru.coistem.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.coistem.game.Objects.Box;
import ru.coistem.game.Objects.HUD.HpAndXpBar;
import ru.coistem.game.Objects.Hero;

public class Stage extends com.badlogic.gdx.scenes.scene2d.Stage {
    World world = new World(new Vector2(0, -500), true);
    Box2DDebugRenderer renderer = new Box2DDebugRenderer();
    Hero hero = new Hero();
    HpAndXpBar bar = new HpAndXpBar();
    BitmapFont font = new BitmapFont(Gdx.files.internal("font.fnt"));

    public Stage() {
        super();
        bar.create(hero);
        createLevel();
    }

    @Override
    public void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(), 1000, 600);
        super.draw();
        renderer.render(world, getCamera().combined);
        getCamera().translate(hero.body.getPosition().x - getCamera().position.x, hero.body.getPosition().y - getCamera().position.y, getCamera().position.z);
        bar.draw((SpriteBatch) getBatch(), getCamera());
        if (!hero.weapons.isEmpty())
            for (int i = 0; i < hero.weapons.size(); i++) {
                hero.weapons.get(i).draw(getBatch());
            }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        bar.act();
        if (!hero.weapons.isEmpty())
            for (int i = 0; i < hero.weapons.size(); i++) {
                hero.weapons.get(i).act();
            }
    }

    public void createLevel() {
        hero.create(new Texture(Gdx.files.internal("hero.png")), world, 25, 50);
        addActor(hero);
        for (int i = 0; i < 10; i++) createBox(25 + 50 * i, 25);
        for (int i = 0; i < 10; i++) createBox(525, 25 + 50 * i);
        for (int i = 0; i < 5; i++) createBox(525 + 50 * i, 525);
        for (int i = 0; i < 20; i++) createBox(625 + 50 * i, 125);
        for (int i = 0; i < 20; i++) createBox(-25, 25 + i * 50);
    }

    public void createBox(int x, int y) {
        Box box = new Box();
        box.create(new Texture(Gdx.files.internal("box.png")), world, x, y);
        addActor(box);
    }
}
