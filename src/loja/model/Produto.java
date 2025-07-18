package loja.model;

public class Produto{

    private String codigo;

    private String nome;

    private int estoque;

    private float precoCusto;

    private float precoVenda;

    private float icms;

    private static int ultimo = 1;

    public Produto(String nome, int estoque, float icms,float precoCusto, float precoVenda){

        this.codigo = String.format("%04d", ultimo++);

        this.nome = nome;

        this.estoque = estoque;

        this.precoCusto = precoCusto;

        this.precoVenda = precoVenda;
        
        this.icms = icms;
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
        
        this.precoVenda = precoVenda;

    }

    public void setIcms(float icms){this.icms = icms;}
    
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

    public float getIcms(){

        return icms;

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
            "Icms           : R$ %.2f\n" +
            "Margem de Lucro: %.1f%%\n",
            nome, codigo, estoque, precoCusto, precoVenda,icms,this.calcularMargemLucro()*100
            );
    }

    public void exibir(){

        System.out.println(this);
    
    }

}