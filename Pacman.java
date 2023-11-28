import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Pacman extends Personagem{
    private int vidas;
    private boolean estaVivo;
    
    /**
     * Cria um Pacman com velocidade fixa de 6.
     */
    public Pacman(){
        super(4);
        estaVivo = true;
        vidas = 3;
    }
    
    /**
     * Remove a comida do mapa e conta à medida que o Pacman passa por elas.
     */
    private void comer(){
        Actor comida = getOneIntersectingObject(Comida.class);
        if(comida!=null){
            Greenfoot.playSound("comer.mp3");
            Cenario cenario = (Cenario) getWorld();
            cenario.removeObject(comida);
            cenario.contarComida();
         }
    }
    
    public void voltarPosicaoInicial() {
        setLocation(580, 375);
    }
    
    public int obterVidas()
    {
        return vidas;
    }
    
    /**
     * Metodo para decrementar a vida do pacman
     */
    public void decrementaVida() {
        morreu();
        removerCoracao();
        voltarPosicaoInicial();
    }
    
    /**
     * Método para remover as imagens de coração(vidas) quando o pacman toca
     * o fantasma
     */
    private void removerCoracao(){
        if(vidas >= 0){
            Vidas coracao = (Vidas) getWorld().getObjects(Vidas.class).get(vidas);
            if (coracao != null) {
                getWorld().removeObject(coracao);
            }
        }
    }
    
    /**
     * Método que contabiliza as mortes
     */
    private void morreu(){
        vidas--;
        if(vidas == 0){
            estaVivo = false;
        }
    }
    
    /**
     * Metodo para fazer a movimentação
     */
    public int moverPacman(){
        if(Greenfoot.isKeyDown("up")){
            setRotation(-90);
            return 1;
        }
        else if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            return 2;
        }
        else if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            return 3;
        }        
        else if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            return 4;
        }
        return 0;
    }
    
    public void act(){
        if(estaVivo){
            mover(moverPacman());
            comer();
        }
    }
}
