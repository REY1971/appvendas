package loja.model;

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

    public void addItem(Item item){

        if(item.getProduto().getEstoque() > 0){
           
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
        
        }else{

            System.out.println("Produto sem estoque");

        }


    }

    public void addItem(Produto produto, int qtd){

        Item item = new Item(produto, qtd);

        addItem(item);


    }

    public void addItem(Item[] itens){

        for(int i = 0; i < itens.length; i++){

            addItem(itens[i]);

        }

    }

    public void removeItem(Item item){

        for(int i = 0; i < tamanho; i++){

            if(carrinho[i].equals(item)){
                
                if(carrinho[i].getQuantidade() - item.getQuantidade() > 0){

                    carrinho[i].setQuantidade(carrinho[i].getQuantidade()-item.getQuantidade());
                    return;

                }else{

                    for(int j = i; j < tamanho; j++){

                        carrinho[j] = carrinho[j+1];

                    }

                    tamanho--;
                    return;

                }

            } 

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
    

   public static void main(String [] args){

        Produto cafe = new Produto("023","cafe",25,5.60f,10.0f);
        
        Produto feijao = new Produto("025","feijao",15,3.60f,5.4f);
        
        Venda v1 = new Venda();

        Item c1 = new Item(cafe,3);

        Item c2 = new Item(feijao, 2);
        
        Item c3 = new Item(feijao, 5);

        v1.addItem(c1);

        v1.addItem(c2);
        
        v1.addItem(c3);

        v1.exibir();

        v1.removeItem(c3);
        v1.removeItem(c2);

        v1.exibir();
        

    }



}


