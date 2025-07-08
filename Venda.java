public class Venda{

    private int tamanho;
   
    private Item[] carrinho;

    public Venda(){

        tamanho = 0;

        carrinho =  new Item[10];

    }

    private int procurarIndexItem(Item item){
        
        for(int i = 0; i < tamanho; i++){

            if(carrinho[i].equals(item)){
                
                return i;

            }
            
        }

        return -1;

    }

    private void redimensionarCarrinho(){

        Item[] aux = new Item[tamanho + 10];

        for(int i = 0; i < carrinho.length ; i++){

            aux[i] = carrinho[i];

        }

        carrinho = aux;

    }

    private void auxAddItem(Item item){

        int index = procurarIndexItem(item);

        if(tamanho == carrinho.length){

            redimensionarCarrinho();

        }

        if(index == -1){

            carrinho[tamanho] = item;

            tamanho ++;

        }else{

            carrinho[index].setQuantidade(carrinho[index].getQuantidade() + item.getQuantidade());

        }

    }

    public void addItem(Item item){

        auxAddItem(item);

    }

    public void addItem(Produto produto, int qtd){

        Item item = new Item(produto, qtd);

        auxAddItem(item);


    }

    public void addItem(Item[] itens){

        for(int i = 0; i < itens.length; i++){

            auxAddItem(itens[i]);

        }

    }

    public float valorTotal(){

        float n = 0;

        for(int i = 0; i < tamanho; i++){

            n += carrinho[i].valorTotal();
            
        }
        return n;

    }
    
    public void exibir(){

        for(int i = 0; i < tamanho; i++){

            carrinho[i].exibir();
        }
        System.out.printf("Valor Total: R$ %.2f\n\n",this.valorTotal());
    }
    
     public void vender(){
        
        //this.Produto.setEstoque(this.Produto.getEstoque() - this.qtd);

    }


    



    public static void main(String [] args){

        Produto cafe = new Produto("023","cafe",25,5.60f,10.0f);
        
        Produto feijao = new Produto("025","feijao",15,3.60f,5.4f);
        
        Venda v1 = new Venda();

        Venda v2 = new Venda();

        Item c1 = new Item(cafe,3);

        Item c2 = new Item(feijao, 2);
        
        Item c3 = new Item(feijao, 5);

        Item[] list = {c1,c2,c3};

        v1.addItem(c1);

        v1.addItem(c2);
        
        v1.addItem(c3);

        v2.addItem(cafe, 10);

        v2.addItem(list);

        v1.exibir();

        v2.exibir();
        

    }



}
class Produto{

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

class Item{

    private Produto Produto;

    private int qtd;


    public Item(Produto Produto, int qtd){


        this.Produto = Produto;
        if(qtd <= this.Produto.getEstoque()){
           
            this.qtd = qtd;
        
        }else{

            this.qtd = this.Produto.getEstoque(); 
            System.out.printf("Estoque insuficiente, esse produto possui %d unidades\n",this.Produto.getEstoque());

        }

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