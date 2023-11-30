import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fase1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaseFinal extends Cenario{
    private static String[] mapa = {"************",
                            "............",
                            "............",
                            "............",
                            "............",
                            "............",
                            "............",
                            "............",
                            "************"};
    private int quantidadeDeFantasmas = 6;
    public FaseFinal(){
        prepare(mapa, quantidadeDeFantasmas);
    }
}