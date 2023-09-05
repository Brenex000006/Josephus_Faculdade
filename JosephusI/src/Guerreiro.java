
public class Guerreiro  {

    boolean guerreiro;
    
    /**
     * Construtor da classe Guerreiro. Inicializa os objetos, métodos e funções
     * que serão utilizados
     */
    Guerreiro(){
          guerreiro = true;  
    }
    
    /**
     * Método getGuerreiro
     * Pega um guerreiro em específico que for desejado
     *
     * @return O valor de retorno será o status de vida deste guerreiro
     */
    public boolean getGuerreiro(){
        return this.guerreiro;
    }
    
    /**
     * Método setGuerreiro
     * Define um status de vida para este guerreiro
     *
     * @param guerreiro Um parâmetro do tipo booleano que contém o status
     * de vida deste guerreiro em específico
     */
    public void setGuerreiro(boolean guerreiro){
        this.guerreiro = guerreiro;
    }
    
    public String toString(){
        return "Guerreiro Vivo " ; 
        //return(conteudo.toString());
    }
}


