package ru.coistem.game.Objects;

public abstract class Person extends GameObject{
    public int hp = 100;
    public int xp = 0;
    public int level = 0;

    public int maxHp = 100;
    public int needXp = 1;
}
