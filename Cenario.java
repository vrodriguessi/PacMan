import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cenario do jogo PacMan
 * 
 * @author (Veronica Rodrigues da Silva França, Petrus Damasceno, João Pedro Dos Reis Moura) 
 * @version (2023.10.31)
 */
public class Cenario extends World
{
    private Placar placar;
    private int qtdComida = 0;
    // Constante para definir a distância mínima permitida
    private static final double DISTANCIA_MINIMA = 50;
    
    /**
     * Mapa usado para definir onde as paredes irão ficar
     */
    String[] mapa = {
        "************",
        "*..**...****",
        "*.**.**..***",
        "*..**...****",
        "**..*****..*",
        "*.**..***..*",
        "*.***..**..*",
        "**..***...**",
        "************",
    };
    /**
     * Construtor do cenário
     */
    public Cenario(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage backgroundColor = new GreenfootImage(1,1);
        backgroundColor.setColor(Color.WHITE);
        prepare();
    }
    
    private void tocarSomAmbiente(){
        GreenfootSound somAmbiente = new GreenfootSound("ambiente.mp3");
        somAmbiente.setVolume(50);
        somAmbiente.playLoop();
    }
    
    private void adicionarPacman(){
        Pacman pacman = new Pacman();
        addObject(pacman,580,375);
    }
    
    /**
     * Metodo para adicionar fantasmas depois de verificar se eles não estão muito próximos ao
     * local onde o PacMan nasce
     */
    private void adicionarFantasmas(int numFantasmas) {
        for (int i = 0; i < numFantasmas; i++) {
            Fantasma fantasma = new Fantasma();
            int[] posicao = gerarPosicaoAleatoria();
    
            // Verificar se a posição gerada está muito próxima de (580, 375)
            while (distanciaEntrePontos(posicao[0], posicao[1], 580, 375) < DISTANCIA_MINIMA) {
                posicao = gerarPosicaoAleatoria();
            }

            addObject(fantasma, posicao[0], posicao[1]);
        }
    }

    // Método para calcular a distância entre dois pontos
     private double distanciaEntrePontos(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    
    private void exibirVidas(int numVidas, int X, int Y){
        for (int i = 0; i < numVidas; i++) {
            Vidas vidas = new Vidas();
            addObject(vidas, X, Y);
            X += 20;
        }
    }
    
    private void adicionarPlacar(){
        placar = new Placar();
        addObject(placar,50,10);
    }
    
        /**
     * Prepara o cenário
    */
    private void prepare(){
        desenharMapa();
        tocarSomAmbiente();
        adicionarPacman();
        adicionarFantasmas(6);
        preencherMapaComComidas();
        adicionarPlacar();
        exibirVidas(3,100,10);
    }
    
    /**
     * O método gerarPosicaoAleatoria gera uma posição no cenário que não
     * contenha paredes. Inicialmente ao fazer o cenário colocando os fantasmas
     * em posição aleatória sem usar esse método, ocorria de fantasmas
     * serem inicializados nas paredes, e, por consequância, não se mexiam
     */
    private int[] gerarPosicaoAleatoria() {
        int x, y;
        do {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
        } while (getObjectsAt(x, y, Parede.class).size() > 0);
        int[] posicao = {x, y};
        return posicao;
    }

    /**
     * Método que desenha o mapa de acordo com a String mapa, cada * é o local
     * onde deve ser colocada uma parede.
     */
    private void desenharMapa(){
        for(int i = 0; i <mapa.length; i++){
            String linhaDoMapa = mapa[i];
            for(int j = 0; j <linhaDoMapa.length(); j++){
                char caracteresDoMapa = linhaDoMapa.charAt(j);
                int y = i * 50;
                int x = j * 50;
                switch(caracteresDoMapa){
                    case '*':
                        addObject(new Parede(),x, y);
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    private void preencherMapaComComidas(){
        for (int j = 30; j < 598; j += 50){
            for(int k = 30; k < 400; k += 50){
                Comida comida = new Comida();
                addObject(comida,1,1);
                comida.setLocation(j,k);
                qtdComida++;
            }
        }
    }
    
    /**
     * Método que, ao comer toda a comida do mapa, reproduz um som.
     */
    public void contarComida(){
        qtdComida=placar.contar(qtdComida);
        if(qtdComida == 0){
            Greenfoot.playSound("venceu.mp3");
        }
    }
    
    public void fimDeJogo(){
        addObject(new GameOver(), getWidth()/2, getHeight()/2);
    }
}
