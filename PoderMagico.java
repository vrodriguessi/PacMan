import greenfoot.*;

public class PoderMagico extends Actor {
    private boolean acertou;
    private int velocidadeX = 3;

    public PoderMagico() {
        this.acertou = false;
    }

    public void act() {
        if (!acertou) {
            mover();
        }
    }

    private void mover() {
        setLocation(getX() + velocidadeX, getY());
    }

    public boolean atingiu(Actor actor) {
        if (this.isTouching(actor.getClass())) {
            this.acertou = true;
            return true;
        }
        return false;
    }
}
