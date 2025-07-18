package loja.model;

import loja.service.ItemService;

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

            ItemService.atualizarQuantidade(carrinho[index],carrinho[index].getQuantidade() + item.getQuantidade());

            }
        
        }else{

            System.out.println("Produto sem estoque");

        }


    }

    public void addItem(Produto produto, int qtd){

        Item item = ItemService.criarItem(produto, qtd);

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

                    ItemService.atualizarQuantidade(carrinho[i],carrinho[i].getQuantidade()-item.getQuantidade());
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

        
        

    }



}


