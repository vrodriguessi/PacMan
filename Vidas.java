import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vidas extends Actor{
    private int vidas;
    public Vidas(){
        vidas = 3;
        for(int i = 0; i < vidas; i++){
            setImage(new GreenfootImage("coracao.png"));
        }
    }
}