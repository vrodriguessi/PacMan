import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Placar extends Actor{
    private int pontos;
    private int pontosPorComida=10;
    public Placar(){
        pontos=0;
        setImage(new GreenfootImage("Pontos: " + pontos, 20, Color.WHITE, null));
    }
    
    public int contar(int qtdComida){
        pontos+=pontosPorComida;
        setImage(new GreenfootImage("Pontos: " + pontos, 20, Color.WHITE, null));
        return --qtdComida;
    }
}
