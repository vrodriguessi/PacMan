import greenfoot.*; 

public class Fantasma extends Personagem{
    int timer = 100;
    int intervaloMudanca = 10; // Intervalo de tempo para a mudança de direção (ajuste conforme necessário)
    int direcao;
    
    public Fantasma(){
        super(8);
        String[] coresFantasmas = {"azul", "laranja", "vermelho"};
        int corIndex = Greenfoot.getRandomNumber(coresFantasmas.length);
        String cor = coresFantasmas[corIndex];
        setImage("fantasma-" + cor + ".png");
    }
    
    /**
     * Método para configurar a ação do fantasma
     */
    public void act() {
        timer++;
    
        if (timer >= intervaloMudanca) {
            direcao = Greenfoot.getRandomNumber(5); 
            timer = 0; 
        }
        
        mover(direcao);
    }
}