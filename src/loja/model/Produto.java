package loja.model;

public class Produto{

    private String codigo;

    private String nome;

    private int estoque;

    private float precoCusto;

    private float precoVenda;

    public Produto(String codigo, String nome, int estoque, float precoCusto, float precoVenda){

        this.codigo = codigo;

        this.nome = nome;

        this.estoque = estoque;

        this.precoCusto = precoCusto;

        if(precoVenda >= this.precoCusto){

            this.precoVenda = precoVenda;

        }else this.precoVenda = precoCusto;

    }

    public void setCodigo(String codigo){

        this.codigo = codigo;
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public void setEstoque(int estoque){

        this.estoque = estoque;
    }

    public void setPrecoCusto(float precoCusto){

        this.precoCusto = precoCusto;
    }

    public void setPrecoVenda(float precoVenda){
        
        if(precoVenda >= this.precoCusto){

            this.precoVenda = precoVenda;

        }else System.out.println("Erro, valor menor que o custo.");
    }

    public String getCodigo(){

        return this.codigo;

    }

    public String getNome(){

        return this.nome;

    }

    public int getEstoque(){

        return this.estoque;

    }

    public float getPrecoCusto(){

        return this.precoCusto;

    }

    public float getPrecoVenda(){

        return this.precoVenda;

    }

    public float calcularMargemLucro(){

        return (this.precoVenda - this.precoCusto)/this.precoVenda;

    }

    public String toString(){

        return String.format(
            "Produto        : %s\n" +
            "Codigo         : %s\n" +
            "Estoque        : %d unidades\n" +
            "Preco Custo    : R$ %.2f\n" +
            "Preco Venda    : R$ %.2f\n" +
            "Margem de Lucro: %.1f%%\n",
            nome, codigo, estoque, precoCusto, precoVenda,this.calcularMargemLucro()*100
            );
    }

    public void exibir(){

        System.out.println(this);
    
    }

}