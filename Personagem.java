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
        if (!existeParede(1, getX(),getY()-15)) {
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
        if (!existeParede(2, getX()+15, getY())) {
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
        if (!existeParede(3, getX(), getY()+15)) {
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
        if (!existeParede(4, getX()-15, getY())) {
            setLocation(novoX, novoY);
        }
    }

    /**
     * Verifica se há uma parede na próxima posição
     */
    private boolean existeParede(int opcao, int x, int y){
        Actor parede = getOneObjectAtOffset(x - getX(), y - getY(), Parede.class);
        if(parede!=null){
            return true;
        }
        else{
            switch(opcao){
                case 1:
                    for(int i=-15; i<=15; i++){
                        Actor paredeLateral = getOneObjectAtOffset(x-getX()+i,y-getY()-5-velocidade, Parede.class);
                        if(paredeLateral!=null){
                            return true;
                        }
                    }
                    break;
                    
                case 2:
                    for(int i=-15; i<=15; i++){
                        Actor paredeLateral = getOneObjectAtOffset(x-getX()+5+velocidade,y-getY()+i, Parede.class);
                        if(paredeLateral!=null){
                            return true;
                        }
                    }
                    break;
                
                case 3:
                    for(int i=-15; i<=15; i++){
                        Actor paredeLateral = getOneObjectAtOffset(x-getX()+i,y-getY()+5+velocidade, Parede.class);
                        if(paredeLateral!=null){
                            return true;
                        }
                    }
                    break;
                    
                case 4:
                    for(int i=-15; i<=15; i++){
                        Actor paredeLateral = getOneObjectAtOffset(x-getX()-5-velocidade,y-getY()+i, Parede.class);
                        if(paredeLateral!=null){
                            return true;
                        }
                    }
                    break;
                    
                default:
                    break;
            }
        }
        return false;
    }

    /**
     * Chama o metodo equivalente à seta do teclado para mover o Pacman.
     */
    public void mover(int opcao){
        switch(opcao){
            case 0:
                moverCima();
                break;
                
            case 1:
                moverDireita();
                break;
                
            case 2:
                moverBaixo();
                break;
                
            case 3:
                moverEsquerda();
                break;
                
            default:
                break;
        }
    }
}