package battleship;

public abstract class AttackGenerator {

    public abstract Point getAttackPoint();

    public void notifyHit() {}
}
