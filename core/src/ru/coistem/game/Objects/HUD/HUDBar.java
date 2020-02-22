package ru.coistem.game.Objects.HUD;

import ru.coistem.game.Objects.GameObject;
import ru.coistem.game.Objects.Person;

public abstract class HUDBar {
    Person person;
    int hp = 0;
    int maxHp = 0;
    int level = 0;
    int xp = 0;
    int needXp = 0;
    public abstract void create(Person person);
    public abstract void act();
    public abstract void draw();
}
