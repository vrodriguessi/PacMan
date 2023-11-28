import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor
{
    /**
     * Método que coloca a imagem de "Game Over" na tela.
     */
    public GameOver() {
        setImage("gameover.png");
        Greenfoot.playSound("morreu.mp3");
    }
}
