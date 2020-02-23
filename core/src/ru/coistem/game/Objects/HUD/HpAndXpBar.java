package ru.coistem.game.Objects.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.coistem.game.Objects.GameObject;
import ru.coistem.game.Objects.Person;

public class HpAndXpBar extends HUDBar{
    Sprite frame;
    Sprite hpBar;
    Sprite xpBar;
    @Override
    public void create(Person person) {
        frame = new Sprite(new Texture(Gdx.files.internal("HUDs/frame.png")));
        hpBar = new Sprite(new Texture(Gdx.files.internal("HUDs/hp.png")));
        xpBar = new Sprite(new Texture(Gdx.files.internal("HUDs/xp.png")));
        this.person = person;
        this.hp = person.hp;
        this.maxHp = person.maxHp;
        this.level = person.level;
        this.needXp = person.needXp;
        this.xp = person.xp;
    }

    @Override
    public void act() {
        this.hp = person.hp;
        this.maxHp = person.maxHp;
        this.level = person.level;
        this.needXp = person.needXp;
        this.xp = person.xp;
    }

    @Override
    public void draw(SpriteBatch batch, Camera camera) {
        batch.begin();
        batch.draw(frame.getTexture(), camera.position.x-camera.viewportWidth/2, camera.position.y+camera.viewportHeight/2-25);
        batch.draw(frame.getTexture(), camera.position.x-camera.viewportWidth/2, camera.position.y+camera.viewportHeight/2-50);
        batch.draw(hpBar.getTexture(), camera.position.x-camera.viewportWidth/2+1, camera.position.y+camera.viewportHeight/2-24, (int)(hp / maxHp * 198), 21);
        batch.draw(xpBar.getTexture(), camera.position.x-camera.viewportWidth/2+1, camera.position.y+camera.viewportHeight/2-49, (int)(xp / needXp * 198), 21);
        batch.end();
    }
}
