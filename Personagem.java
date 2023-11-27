import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe geral com características e métodos comuns aos personagens
 */
public class Personagem extends Actor{
    private int velocidade;
    
    public Personagem(int velocidade){
        this.velocidade = velocidade;
    }
    
    /**
     * Rotaciona o Pacman, verifica se há uma parede e caso negativo,
     * move para cima
     */
    private void moverCima(){
        int novoX = getX();
        int novoY = getY() - velocidade;
        if (!existeParede(getX(),getY()-20)) {
            setLocation(novoX, novoY);
        }
    }
    
    /**
     * Rotaciona o Pacman, verifica se há uma parede e caso negativo,
     * move para direita
     */
    private void moverDireita(){
        int novoX = getX() + velocidade;
        int novoY = getY();
        if (!existeParede(getX()+20, getY())) {
            setLocation(novoX, novoY);
        }
    }
    
    /**
     * Rotaciona o Pacman, verifica se há uma parede e caso negativo,
     * move para baixo
     */
    private void moverBaixo(){
        int novoX = getX();
        int novoY = getY() + velocidade;
        if (!existeParede(getX(), getY()+20)) {
            setLocation(novoX, novoY);
        }
    }
    
    /**
     * Rotaciona o Pacman, verifica se há uma parede e caso negativo,
     * move para esquerda
     */
    private void moverEsquerda(){
        int novoX = getX() - velocidade;
        int novoY = getY();
        if (!existeParede(getX()-20, getY())) {
            setLocation(novoX, novoY);
        }
    }

    /**
     * Verifica se há uma parede na próxima posição
     */
    private boolean existeParede(int x, int y){
        Actor parede = getOneObjectAtOffset(x - getX(), y - getY(), Parede.class);
        if(parede!=null){
            return true;
        }
        return false;
    }

    /**
     * Chama o metodo equivalente direção que o personagem irá andar.
     */
    public void mover(int opcao){
        if(opcao == 1){
            moverCima();
        }
        else if(opcao == 2){
            moverDireita();
        }
        else if(opcao == 3){
            moverBaixo();
        }
        else if(opcao == 4){
            moverEsquerda();
        }
    }
}