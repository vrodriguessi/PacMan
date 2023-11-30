import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Fase1 extends Cenario{
    private static String[] mapa = {
            "************",
            "***...****..",
            "***..**..***",
            "...****.****",
            "..*******...",
            "***...***..*",
            "*..**..**..*",
            "**..****..**",
            "************",
    };
    private int quantidadeDeFantasmas = 6;
    
    public Fase1(){
        prepare(mapa, quantidadeDeFantasmas);
    }
}