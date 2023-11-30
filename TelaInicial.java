import greenfoot.*;
public class TelaInicial extends World {
    private BotaoStart botaoStart;
    private Instrucoes instrucoes;
    private Titulo titulo;
    public TelaInicial() {    
        super(600, 400, 1); 
        GreenfootImage backgroundColor = new GreenfootImage(1,1);
        backgroundColor.setColor(Color.BLACK);
        titulo = new Titulo();
        botaoStart = new BotaoStart();
        instrucoes = new Instrucoes();
        addObject(botaoStart, getWidth() / 2, getHeight() / 2);
        addObject(instrucoes, getWidth() / 2, getHeight() / 2 + 100);
        addObject(titulo, 300,40);
    }

    public class BotaoStart extends Actor {
        public BotaoStart(){
            setImage("newgame.png");
        }
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                App app = new App();
                app.iniciarFase1();
            }
        }
    }
    
    public class Titulo extends Actor{
        public Titulo(){
            setImage("tittle.png ");
        }
    }

    public class Instrucoes extends Actor {
        public Instrucoes() {
            setImage(new GreenfootImage("instrucoes.png"));
        }
    }
}
