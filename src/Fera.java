public class Fera extends Combatente {

    static int sequencialNome = 1;
	
	public Fera(String nome) {
		super(nome);
		this.nivelEnergia = 100;
	}

	public Fera() {
		this("Fera Gigante " + sequencialNome++);
		this.nivelEnergia = Math.random() * 200;
	}
	
	
	public boolean estaVivo() {
		if (super.nivelEnergia <= 0) return false;

		return true;
	}


	public void atacar(Combatente adversario) {
		int tipoAtaque = (int) (Math.random() * 2);

		if (tipoAtaque == 0) morder(adversario);
		else if (tipoAtaque == 1) usarGarra(adversario);

	}


	public void defender(double poderAtaque) {
		int tipoDefesa = (int) (Math.random() * 2);

		if (tipoDefesa == 0) pular(poderAtaque);
		else if (tipoDefesa == 1) correr(poderAtaque);
		else {
			nivelEnergia = nivelEnergia - poderAtaque;
		}
	}


	public void morder(Combatente adversario) {
		adversario.defender(10);
	};

	public void usarGarra(Combatente adversario) {
		adversario.defender(20);
	};

	public void pular(double poderAtaque) {
		nivelEnergia = nivelEnergia - (poderAtaque * 0.01);
	};

	public void correr(double poderAtaque) {
		nivelEnergia = nivelEnergia - (poderAtaque * 0.05);;
	};

}