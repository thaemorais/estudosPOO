public class Gladiador extends Lutador {
    private Arma arma;

    public Gladiador(String nome, String descricaoArma) {
        super(nome);
        this.arma = new Arma(descricaoArma);
    }
	
	public void atacar(Combatente adversario) {
		if (arma.getDescricao().equals("Pistola")) {
            arma.atirar(this, adversario);
        } else if (arma.getDescricao().equals("Lança")) {
            arma.perfurar(this, adversario);
        } else if (arma.getDescricao().equals("Gás")) {
            arma.explodir(this, adversario);
        } else {
            System.out.println("Arma não disponível");
        }
		
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	    }
	}
	
	@Override
	public void roubarArma(Gladiador adversario) {
	    System.out.println(this.nome + " roubou a arma de " + adversario.nome);
	    this.arma = adversario.arma; // Rouba a arma do adversário
//	    adversario.arma = null; // Remove a arma do adversário
	}

    @Override
    public Arma getArma() {
        return arma;
    }
	
	public String toString() {
		return ("Gladiador(a) " + this.nome + " [" + this.nivelEnergia + "] com " + arma.getDescricao());	
	}
}