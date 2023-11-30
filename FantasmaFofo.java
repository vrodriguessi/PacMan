import greenfoot.*;

public class FantasmaFofo extends Fantasma {
    private PoderMagico poderMagico;

    public FantasmaFofo() {
        super();
        poderMagico = new PoderMagico();
        setImage("fantasma-fofo.png");
    }

    public void atirar() 
    {
        getWorld().addObject(poderMagico, getX(), getY());
    }

    public void removerPoderMagico() {
        if (poderMagico != null && poderMagico.getX() >= getWorld().getWidth() - 1) {
            getWorld().removeObject(poderMagico);
            poderMagico = new PoderMagico();
        }
    }

    public void act() {
        super.act();
        atirar();
        removerPoderMagico();
    }
}