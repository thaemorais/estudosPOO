public abstract class Combatente {
	protected double nivelEnergia;
	protected String nome;

	public Combatente(String nome) {
		this.nome = nome;
	}
	
	public double getNivelEnergia() {
		return nivelEnergia;
	}
	public void setNivelEnergia(double nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public abstract boolean isAlive();
	
	public abstract void atacar(Combatente adversario);
	
	public abstract void defender(int poderOfensivo);

	//criado somente para poder implementar em Gladiador
	public abstract void roubarArma(Gladiador adversario);
	
}