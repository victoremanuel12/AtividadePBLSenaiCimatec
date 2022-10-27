import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        Alimento alimento = new Alimento();
        alimento.setTipo(JOptionPane.showInputDialog("Informe a Tipo do alimento: "));
        alimento.setNome(JOptionPane.showInputDialog("Informe o Nome do alimento: "));
        alimento.setQuantidadeEmEstoque(Integer.parseInt(JOptionPane.showInputDialog("Informe a Quantidade  de alimento(s) sendo cadastrados:")));
        alimento.setPrecoDeCompraDoProduto(JOptionPane.showInputDialog("Informe o preco que cada alimento foi comprado: "));
        alimento.setPrecoUnitarioDeVendaDoProduto(JOptionPane.showInputDialog("Informe o preco que cada alimento será vendido: "));
        alimento.setDiasParaVencimento(Integer.parseInt(JOptionPane.showInputDialog("Informe quantos dias faltam para data de vencimento do produto:")));
        alimento.venda(
            Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de itens sendo vendidos: ")),
            Integer.parseInt(JOptionPane.showInputDialog("Quantos dias se passaram após entrada do produto no estoque? : "))
        );

        JOptionPane.showMessageDialog(null,
                "\n O  tipo do Alimento é: " +alimento.getTipo() + 
                "\n O nome do alimento é:  " +alimento.getNome() + 
                "\n Preco total de produtos em estoque R$: " + alimento.getPrecoTotalDeProdutosEmEstoque() + 
               "\n Preço de  compra de cada produto é: R$"  + alimento.getPrecoDeCompraDoProduto() +
               "\n Preço de venda de cada  produto é: R$" + alimento.getPrecoUnitarioDeVendaDoProduto()  + 
                alimento.getQuantidadeEmEstoqueAposVenda() +
               "\n Lucro da venda por unidade  é: R$" + alimento.getLucro() +
               "\n" + alimento.getLucroTotal() + 
               "\n" + alimento.getMensagemVenda()
                );

    }
}
