// Classe Arma
class Arma implements Fogo, Perfurante, EfeitoMoral {
    private String descricao;

    public Arma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void atirar(Gladiador atacante, Combatente adversario) {
        System.out.println(atacante.getNome() + " ATIROU ->DANO [30]<-");
        adversario.defender(30);
    }

    @Override
    public void perfurar(Gladiador atacante, Combatente adversario) {
        System.out.println(atacante.getNome() + " PERFUROU ->DANO [40]<-");
        adversario.defender(40);
    }

    @Override
    public void explodir(Gladiador atacante, Combatente adversario) {
        System.out.println(atacante.getNome() + " EXPLODIU ->DANO [20]<-");
        adversario.defender(20);
    }
}