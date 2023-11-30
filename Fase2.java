import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fase1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fase2 extends Cenario{
    private static String[] mapa = {"************",
                            "**......****",
                            "*..*.**..***",
                            "*..**...****",
                            "**..*****..*",
                            "*.**..***..*",
                            "*...**.**..*",
                            "**..***...**",
                            "************"};
    private int quantidadeDeFantasmas = 7;
    public Fase2(){
        prepare(mapa, quantidadeDeFantasmas);
        FantasmaFofo fantasmaFofo = new FantasmaFofo();
        addObject(fantasmaFofo,15, 220);
    }
}