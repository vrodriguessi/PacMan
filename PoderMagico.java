import greenfoot.*;

public class PoderMagico extends Actor {
    private int velocidadeX = 3;

    public PoderMagico() {
        super();
        setImage("poder-magico.png");
    }

    public void act() {
        mover();
        encostarNoPacman();
        }

    private void mover() {
        setLocation(getX() + velocidadeX, getY());
    }
    
    /**
     * Metodo que decrementa a vida do Pacman se encostar no PoderMagico
     */
    protected void encostarNoPacman() {
        Pacman pacman = (Pacman) getOneIntersectingObject(Pacman.class);
        if (pacman != null) {
            pacman.decrementaVida();
        }
    }
}
