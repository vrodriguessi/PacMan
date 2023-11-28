import greenfoot.*; 
public class FantasmaFofo extends Fantasma {
    private PoderMagico poderMagico;

    public FantasmaFofo() {
        super();
        this.poderMagico = new PoderMagico();
        setImage("fantasma-fofo.png");
    }
    
    /**
     * Metodo para que o fantasma fofo atire sempre que o numero randomico for maior que 50.
     */
    public void atirar() {
        if (Greenfoot.getRandomNumber(100) < 50) {
            getWorld().addObject(poderMagico, getX(), getY());
        }
    }

    public void act() {
        super.act();
        atirar();
    }
    
    /**
     * Metodo sobrescrito da classe Fantasma, que decrementa a vida do Pacman se encostar no PoderMagico
     */
    protected void encostarNoPacman() {
        Pacman pacman = (Pacman) getOneIntersectingObject(Pacman.class);
        if (pacman != null && poderMagico.atingiu(pacman)) {
            pacman.decrementaVida();
        }
    }

}