package Software;

import Cliente.Pessoa;

import java.util.List;
//preciso transformar isso banco de verdade
public class BancoBrasil {
    private int valorBanco = 20000;
    private List<Pessoa> listaCadastro;
    private int valorTotal;

    public BancoBrasil(List<Pessoa> listaCadastro, int valorTotal) {
        this.listaCadastro = listaCadastro;
        this.valorTotal = valorTotal;
    }

    public void pagarDivida(Pessoa p1){
        if(p1.getDividaBanco() >= 100){
            p1.setCreditosBanco(p1.getCreditosBanco() + 100);
            System.out.println("Seu creditos aumentou : " + p1.getCreditosBanco() +"$");
        }

        if(p1.getDinheiro() >= p1.getDividaBanco()){
            p1.setDinheiro(p1.getDinheiro() - p1.getDividaBanco());
            p1.setDividaBanco(0);
            System.err.println("Divida paga!");
        }else {
            System.out.println("Dinheiro insuficiente! | Dívida atual : "+ p1.getDividaBanco()+"$");
        }
    }

    public int fazerEmprestimo(Pessoa p1,int valor){
        if(valor <= valorBanco && p1.getCreditosBanco() >= valor && p1.getDividaBanco() < valor){
            valorBanco = valorBanco - valor;
            p1.setDinheiro(p1.getDinheiro() + valor);

            int conta = ((valor * 30) / 100) + valor;
            p1.setDividaBanco(conta);

            System.out.println("Você fez emprestimo de : " + valor+"$" + " [ Valor atual banco : " + valorBanco + " ] " + " [ Sua dívida : " + p1.getDividaBanco() + " ] ");
            System.err.print("( digite !pay, para paga a dívida ) \n");
            return valorBanco;
        }
        System.err.println("Emprestimo falho! [ Valor máximo banco " + valorBanco +"$"+" ]" + " [ Limite créditos : " + p1.getCreditosBanco()+"$" + " ]");
        return valorBanco;
    }

    // adiciona a listaCadastro
    public void adicionarPessoa(Pessoa p,int id){
        listaCadastro.add(id,p);
    }

    public void acessarLista(){
        for (Pessoa pessoa : listaCadastro) {
            System.out.println(pessoa);
        }
    }
}
