package loja.app;

import loja.model.Item;
import loja.model.Produto;
import loja.model.Venda;

public class Main {

    public static void main(String[] args){

        Produto cafe = new Produto("023","cafe",25,5.60f,10.0f);
        
        Produto feijao = new Produto("025","feijao",15,3.60f,5.4f);
        
        Venda v1 = new Venda();

        Item c1 = new Item(cafe, 6);

        Item c2 = new Item(feijao, 2);
        
        Item c3 = new Item(feijao, 5);

        v1.addItem(c1);

        v1.addItem(c2);
        
        v1.addItem(c3);

        v1.exibir();

    }

}
