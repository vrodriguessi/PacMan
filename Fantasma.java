import greenfoot.*; 

public class Fantasma extends Personagem{
    int timer = 100;
    int intervaloMudanca = 50; // Intervalo de tempo para a mudança de direção.
    int direcao;
    
    public Fantasma(){
        super(1);
    }
    
    /**
     * Metodo para verificar se o fantasma encostou no pacman e, caso positivo, decrementar a vida do pacman.
     */
    protected void encostarNoPacman() {
        Actor pacman = getOneIntersectingObject(Pacman.class);
        if (pacman != null) {
            ((Pacman) pacman).decrementaVida();
        }
    }
    
    /**
     * Método para configurar a ação do fantasma
     */
    public void act() {
        timer++;
    
        if (timer >= intervaloMudanca) {
            direcao = Greenfoot.getRandomNumber(4); 
            timer = 0; 
        }
        
        mover(direcao);
        encostarNoPacman();
    }
}