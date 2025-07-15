package loja.model;

public class Item{

    private Produto Produto;

    private int qtd;


    public Item(Produto Produto, int qtd){

        this.Produto = Produto;
        this.qtd = qtd;
            
    }

    public void setCodigo(String codigo){

        this.Produto.setCodigo(codigo);
    }

    public void setProduto(Produto Produto){

        this.Produto = Produto;
    }

    public void setQuantidade(int qtd){
           
        this.qtd = qtd;
        
    }


    public String getCodigo(){

        return this.Produto.getCodigo();

    }

    public Produto getProduto(){

        return this.Produto;

    }

    public int getQuantidade(){
        
        return this.qtd;

    }

    public float valorTotal(){

        return this.Produto.getPrecoVenda() * this.qtd;

    }

    @Override
    public boolean equals(Object obj){

        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Item outro = (Item) obj;

        return this.getCodigo().equals(outro.getCodigo());

    }

    public String toString(){

        return String.format(
            "Produto    : %s\n" +
            "Codigo     : %s\n" +
            "Quantidade : %d unidades\n" +
            "Valor      : R$ %.2f\n",
            this.Produto.getNome(), this.Produto.getCodigo(), qtd, this.valorTotal()
            );
    }

    public void exibir(){

        System.out.println(this);
    
    }


}