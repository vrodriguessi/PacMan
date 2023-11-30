import greenfoot.*;

/**
 * 
 */
public class App {
    private Cenario cenarioAtual;
    private World world;
    private TelaInicial telaInicial;

    public App() {
        iniciar();
    }
    
    /**
     * Metodo para iniciar o jogo
     */
    private void iniciar()
    {
        telaInicial = new TelaInicial();
        world = telaInicial;
        Greenfoot.setWorld(world);
        cenarioAtual = new Fase1();
        iniciarFase1();
    }

    /**
     * Método para iniciar a primeira fase
     */ 
    protected void iniciarFase1() 
    {
        world = cenarioAtual;  
        Greenfoot.setWorld(world); 
    }

    /**
     * Método para avançar para a próxima fase
     */
    private void avancarNoJogo() {
        
    }

    /**
     * Método para reiniciar a fase atual
     */
    private void reiniciarFaseAtual() {
        world = cenarioAtual;
        Greenfoot.setWorld(world);
    }
    
    public void verificarFimDeJogo() {
        if (cenarioAtual.obterPacman().obterVidas() == 0) {
            fimDeJogo(world);
        }
    }

    public void fimDeJogo(World world){
        GameOver gameOver = new GameOver();
        world.addObject(gameOver, world.getWidth() / 2, world.getHeight() / 2);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
