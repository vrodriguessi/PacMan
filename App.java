import greenfoot.*;

/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App  
{
    private Cenario cenarioAtual;
    private World world;  // Adiciona uma instância de World para manipular o mundo
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
    }
    
    /**
     * Método para iniciar a primeira fase
     */ 
    private void iniciarFase1() {
        cenarioAtual = new Cenario();
        world = cenarioAtual;  // Define 'world' como o mundo atual
        Greenfoot.setWorld(world);  // Define o mundo no Greenfoot
    }

    /**
     * Método para avançar para a próxima fase
     */
    private void avancarNoJogo() {
        
    }

    private void iniciarFase2() {
        cenarioAtual = new Cenario2();
        world = cenarioAtual;  
        Greenfoot.setWorld(world);
    }

    /**
     * Método para reiniciar a fase atual
     */
    private void reiniciarFaseAtual() {
        cenarioAtual = new Cenario();
        world = cenarioAtual;
        Greenfoot.setWorld(world);
    }

    /**
     * Método para lidar com o fim do jogo
     */
    public void fimDeJogo(){
        world.addObject(new GameOver(), world.getWidth() / 2, world.getHeight() / 2);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
