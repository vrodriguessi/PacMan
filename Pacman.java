import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Pacman extends Personagem{
    private int vidas;
    private boolean estaVivo;
    
    /**
     * Cria um Pacman com velocidade fixa de 3.
     */
    public Pacman(){
        super(6);
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
    
    /**
     * Método que verifica se o PacMan encostou em um fantasma
     */
    private void encostarNoFantasma(){
        if(estaVivo){
        Actor fantasma = getOneIntersectingObject(Fantasma.class);
        if (fantasma != null) {
            int x = Greenfoot.getRandomNumber(600);
            int y = Greenfoot.getRandomNumber(400);
            setLocation(580, 380); //Volta o pacman para a posição inicial
            mortes();
            removerCoracao();
            }
        }
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
     * Método que contabiliza as mortes do PacMan
     */
    private void mortes(){
        vidas--;
        if(vidas == 0){
            estaVivo = false;
            Greenfoot.playSound("morreu.mp3");
            Cenario cenario = (Cenario) getWorld();
            cenario.fimDeJogo();
        }
    }
    
    /**
     * Método para realizar a movimentação do PacMan
     */
    
    public int moverPacman(){
        int opcao = 0;
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
            encostarNoFantasma();
        }
    }
}
