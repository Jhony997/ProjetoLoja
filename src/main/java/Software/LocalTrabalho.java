package Software;

import Cliente.Pessoa;

public class LocalTrabalho {
    private final double[] salario = {1,3,5,8,12,20,25};
    private final String[] cargos = {"Empilhador de Caixa","Repositor","Vendedor","Balconista","Arquiteto","Programador","Apreciador"};
    private Pessoa pessoa;

    public LocalTrabalho(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void entregarSalario(Pessoa pessoa){
        System.out.println(pessoa.getNome() + " Cargo "+cargos[pessoa.getCargoIndex()] + " | Saldo Atual : " + pessoa.getDinheiro());
        pessoa.setDinheiro(pessoa.getDinheiro() + salario[pessoa.getCargoIndex()]);

        pessoa.setExperienciaTrabalho(pessoa.getExperienciaTrabalho() + 1);

        if(pessoa.getExperienciaTrabalho() >= 10 && pessoa.getCargoIndex() < 6){
            System.out.println("Você conseguiu experiencia o suficiente para um emprego melhor!!");
            pessoa.setCargoIndex(pessoa.getCargoIndex() + 1);
            pessoa.setExperienciaTrabalho(0);
            System.out.println("Conquista : " + cargos[pessoa.getCargoIndex()] + " " + salario[pessoa.getCargoIndex()]+"$");
        }
        if(pessoa.getDividaBanco() > 0){
            int conta = (int)(salario[pessoa.getCargoIndex()] * 60) / 100;
            pessoa.setDinheiro(pessoa.getDinheiro() - conta);
            System.err.println("Banco cobrou dívida!" + "[ -"+conta+"$"+" ]");
        }
    }
}
