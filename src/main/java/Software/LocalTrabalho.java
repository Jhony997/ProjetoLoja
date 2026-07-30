package Software;

import Cliente.Pessoa;

public class LocalTrabalho {
    private final double[] salario = {1,20,50,100,200,450,800};
    private final String[] cargos = {"Empilhador de Caixa","Repositor","Vendedor","Balconista","Arquiteto","Programador","Apreciador"};
    private Pessoa pessoa;
    private int index = 0;

    public LocalTrabalho(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void entregarSalario(Pessoa pessoa){
        System.out.println(pessoa.getNome() + " Cargo "+cargos[index]);
        pessoa.setDinheiro(pessoa.getDinheiro() + salario[index]);

        pessoa.setExperienciaTrabalho(pessoa.getExperienciaTrabalho() + 5);

        if(pessoa.getExperienciaTrabalho() >= 40 && index < 6){
            System.out.println("Você conseguiu experiencia o suficiente para um emprego melhor!!");
            index ++;
            pessoa.setExperienciaTrabalho(0);
            System.out.println("Conquista : " + cargos[index] + " " + salario[index]+"$");
        }
    }
}
