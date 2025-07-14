package loja.model;

public class Item{

    private Produto Produto;

    private int qtd;


    public Item(Produto Produto, int qtd){

        if(qtd > 0){

            this.Produto = Produto;
            if(qtd <= this.Produto.getEstoque()){
            
                this.qtd = qtd;
            
            }else{

                this.qtd = this.Produto.getEstoque(); 
                System.out.printf("Estoque insuficiente, %s possui %d unidades\n",this.Produto.getNome(),this.Produto.getEstoque());

            }

        }else System.out.println("Erro, impossivel gerar item.");

    }

    public void setCodigo(String codigo){

        this.Produto.setCodigo(codigo);
    }

    public void setProduto(Produto Produto){

        this.Produto = Produto;
    }

    public void setQuantidade(int qtd){
        
        if(qtd > 0){

           
        if(qtd <= this.Produto.getEstoque()){
           
            this.qtd = qtd;
        
        }else{

            this.qtd = this.Produto.getEstoque(); 
            System.out.printf("Estoque insuficiente, %s possui %d unidades\n",this.Produto.getNome(),this.Produto.getEstoque());

        }

        }return;
        
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