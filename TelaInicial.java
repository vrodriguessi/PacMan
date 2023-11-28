import greenfoot.*;

public class TelaInicial extends World {
    private BotaoStart botaoStart;

    public TelaInicial() {    
        super(600, 400, 1); 
        botaoStart = new BotaoStart();
        addObject(botaoStart, getWidth() / 2, getHeight() / 2);
    }

    public class BotaoStart extends Actor {
        public void act() {
            if (Greenfoot.mouseClicked(this)) {
                App app = new App();
                app.iniciarFase1();
            }
        }
    }
}
