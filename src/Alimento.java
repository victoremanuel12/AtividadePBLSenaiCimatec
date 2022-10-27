public class Alimento {
   private String Nome;
   private String Tipo;
   private double PrecoDeCompraDoProduto;
   private double PrecoUnitarioDeVendaDoProduto;
   private int QuantosDiasParaOVencimento;
   private double precoTotalDeProdutosEmEstoque;
   private int DiasQueSePassaramAposCadastro;
   private int QuantidadeEmEstoque;
   private int QuantidadeEmEstoqueAposVenda;
   private boolean vendaConcluida;
   private boolean produtoVencido;
   private boolean estoqueZerado;
   private double precoFinalDaVenda;
   private double LucroPorUnidade;
   private double LucroTotal;

   public void setNome(String nome) {
      this.Nome = nome;
   }

   public String getNome() {
      return Nome;
   }

   public void setTipo(String frutaOuVerdura) {
      this.Tipo = frutaOuVerdura;
   }

   public String getTipo() {
      return Tipo;
   }

   public void setQuantidadeEmEstoque(int quantidadeDeProdutos) {
      this.QuantidadeEmEstoque = quantidadeDeProdutos;
   }

   public int getQuantidadeEmEstoque() {
      return QuantidadeEmEstoque;
   }

   public void setPrecoDeCompraDoProduto(String precoItem) {
      double precoUnitarioDeCompra = Double.parseDouble(precoItem);
      this.precoTotalDeProdutosEmEstoque = precoUnitarioDeCompra * QuantidadeEmEstoque;
      this.PrecoDeCompraDoProduto = precoUnitarioDeCompra;
   }

   
   public double getPrecoTotalDeProdutosEmEstoque() {
      return precoTotalDeProdutosEmEstoque;
   }


   public void setPrecoUnitarioDeVendaDoProduto(String precoItem) {
      double precoUnitario = Double.parseDouble(precoItem);
      this.PrecoUnitarioDeVendaDoProduto = precoUnitario;
   }


   public double getPrecoUnitarioDeVendaDoProduto() {
      return PrecoUnitarioDeVendaDoProduto;
   }


   public double getPrecoDeCompraDoProduto() {
      return PrecoDeCompraDoProduto;
   }

   public void setDiasParaVencimento(int dias) {
      this.QuantosDiasParaOVencimento = dias;
   }
    
   public void venda(int quantidadeVendida, int diasQuePassaram) {
       int porcentagem = 100;
       int desconto10 = 10;
       double precoComDesconto;
       int vencimento =  QuantosDiasParaOVencimento - diasQuePassaram ;


       if (vencimento < 0 || quantidadeVendida > this.QuantidadeEmEstoque ){
         this.vendaConcluida = false;
         this.produtoVencido = true;

       }else if( vencimento == 1 && quantidadeVendida < this.QuantidadeEmEstoque ){ 
         this.QuantidadeEmEstoqueAposVenda = this.QuantidadeEmEstoque - quantidadeVendida; 
         precoComDesconto = this.PrecoUnitarioDeVendaDoProduto - (this.PrecoUnitarioDeVendaDoProduto * desconto10 / porcentagem) ;
         LucroPorUnidade = precoComDesconto - this.PrecoDeCompraDoProduto;
         this.PrecoUnitarioDeVendaDoProduto = precoComDesconto;
         this.vendaConcluida = true;

        
         

        } else if (  vencimento == 1 && quantidadeVendida == QuantidadeEmEstoque) {


         this.QuantidadeEmEstoqueAposVenda = QuantidadeEmEstoque - quantidadeVendida;
         precoComDesconto = this.PrecoUnitarioDeVendaDoProduto - (this.PrecoUnitarioDeVendaDoProduto * desconto10 / porcentagem);
         this.precoFinalDaVenda = quantidadeVendida * precoComDesconto;
         this.LucroPorUnidade = this.precoFinalDaVenda / this.precoTotalDeProdutosEmEstoque * quantidadeVendida;  
         this.vendaConcluida = true;
         this.estoqueZerado = true;

   

       }else if(quantidadeVendida < this.QuantidadeEmEstoque ){
         this.QuantidadeEmEstoqueAposVenda = this.QuantidadeEmEstoque - quantidadeVendida;   
         double VendaParcialDoEstoque = this.QuantidadeEmEstoque - this.QuantidadeEmEstoqueAposVenda; 
         this.precoFinalDaVenda = VendaParcialDoEstoque * this.PrecoUnitarioDeVendaDoProduto; 
         this.LucroPorUnidade = this.precoFinalDaVenda / VendaParcialDoEstoque; 
         this.vendaConcluida = true;


      }else if(quantidadeVendida == this.QuantidadeEmEstoque){

         this.QuantidadeEmEstoqueAposVenda = this.QuantidadeEmEstoque - quantidadeVendida;
         this.precoFinalDaVenda = quantidadeVendida * this.PrecoUnitarioDeVendaDoProduto; 
         this.LucroPorUnidade = (this.precoFinalDaVenda - this.precoTotalDeProdutosEmEstoque ) / quantidadeVendida ; 
         this.vendaConcluida = true;
         this.estoqueZerado = true;
      }
      this.LucroTotal = this.LucroPorUnidade * quantidadeVendida; 

   }



   public String getQuantidadeEmEstoqueAposVenda(){
      String MensagemEstoque;
      if(this.estoqueZerado){
         MensagemEstoque = " \n O estoque está zerado";
      }else{
         MensagemEstoque = "\n Restaram no estoque " + this.QuantidadeEmEstoqueAposVenda + " produtos";

      }
      return MensagemEstoque;
   }

   public String getMensagemVenda(){
      String MensagemVenda;
      if(this.vendaConcluida){
         MensagemVenda = "Venda concluida com sucesso";
      }else{
         MensagemVenda = "O produto está vencido ou estoque está vazio, compra não realizada!";

      }
      return MensagemVenda;
   }

   public double getLucro() {
      return this.LucroPorUnidade ;
   }
   public String getLucroTotal() {
      String MensagemLucroTotal = " O lucro total com essa venda foi: " + this.LucroTotal;
      return MensagemLucroTotal;
   }
  

}

