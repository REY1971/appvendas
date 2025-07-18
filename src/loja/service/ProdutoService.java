package loja.service;

import loja.model.Produto;

public class ProdutoService {

    private float margem;
    private float icms;

    public ProdutoService(Float margem , Float icms){

        this.margem = (margem != null) ? margem : 0.30f;
        this.icms = (icms != null) ? icms : 0.18f;
            
    }

    public void setMargem(Float margem){

        this.margem = (margem != null) ? margem : 0.30f;
    }

    public void setIcms(Float icms){

        this.icms = (icms != null) ? icms : 0.18f;

    }

    public float getMargem(){

        return margem;

    }

    public float getIcms(){

        return icms;
    }


    public Produto criarProduto(String nome, int estoque, float precoCusto){

        if(estoque >= 0){
            
            return new Produto(nome, estoque,precoCusto/(1-margem) *icms ,precoCusto, precoCusto/(1-margem));

        }else return new Produto(nome, 0 , precoCusto/(1-margem)*icms,precoCusto, precoCusto/(1-margem));

    }

    public Produto criarProduto(String nome, int estoque, float precoCusto, float precoVenda){
    
        
        if(estoque >= 0){

            if(precoVenda >= precoCusto/(1-margem)){
    
                return new Produto(nome, estoque,precoVenda *icms ,precoCusto, precoVenda);
    
             }else return new Produto(nome, estoque,precoCusto* icms ,precoCusto, precoCusto);
            

        }else{

            if(precoVenda >= precoCusto/(1-margem)){
    
                return new Produto(nome, 0,precoVenda *icms ,precoCusto, precoVenda);
    
             }else return new Produto(nome, 0,precoCusto* icms ,precoCusto, precoCusto);

        }


    }

    public static void main(String[] args){

        ProdutoService ps = new ProdutoService(null, null);

        Produto p1 = ps.criarProduto("cafe", 10, 10.5f);
        Produto p2 = ps.criarProduto("arroz", 10, 25.5f);
        p1.exibir();
        p2.exibir();
    }
}
