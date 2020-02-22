package ru.coistem.game.Objects.HUD;

import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.coistem.game.Objects.GameObject;
import ru.coistem.game.Objects.Person;

public class HpAndXpBar extends HUDBar{

    @Override
    public void create(Person person) {

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
    public void draw() {

    }
}
