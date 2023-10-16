public abstract class Lutador extends Combatente implements ArteMarcial {
	
	public Lutador(String nome) {
		super(nome);
		this.nivelEnergia = 100;
	}
	
	public boolean isAlive() {
		return nivelEnergia > 0;
	}
	
	@Override
	public void atacar(Combatente adversario) {
		int escolhaAtaque = (int) (Math.random()*4);
		
		switch(escolhaAtaque) {
		case 0:
			socar(adversario);
			break;
		case 1:
			chutar(adversario);
			break;
		case 2:
			gancho(adversario);
			break;
		case 3:
			giroMortal(adversario);
			break;
		}
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	    }
	}
	
	public void socar(Combatente adversario) {
		System.out.println(this.nome + " acertou um SOCO ->DANO [10]<-");
		adversario.defender(10);
	}
	
	public void chutar(Combatente adversario) {
		System.out.println(this.nome + " acertou um CHUTE ->DANO [20]<-");
		adversario.defender(20);
	}
	
	public void gancho(Combatente adversario) {
		System.out.println(this.nome + " acertou um GANCHO ->DANO [30]<-");
		adversario.defender(30);
	}
	
	public void giroMortal(Combatente adversario) {
		System.out.println(this.nome + " acertou um GIRO MORTAL ->DANO [50]<-");
		adversario.defender(50);
	}
	
	@Override
	public void defender(int poderAtaque) {
		int escolhaDefesa = (int) (Math.random()*4);
		
		switch(escolhaDefesa) {
		case 0:
			esquivar(poderAtaque);
			break;
		case 1:
			abaixar(poderAtaque);
			break;
		case 2:
			guarda(poderAtaque);
			break;
		case 3:
			nivelEnergia -= poderAtaque;
			System.out.println(this.nome + " NÃO FEZ NADA ->DANO COMPLETO<-");
			break;
		}		
	}
	
	public void esquivar(int poderAtaque) {
		System.out.println(this.nome + " SE ESQUIVOU ->DANO FOI PARA [" + (poderAtaque*0.7)+ "]<-");
		nivelEnergia -= (int)(poderAtaque*0.7);
		if (this.nivelEnergia <= 0) {
            this.nivelEnergia = 0;
        }
	}
	
	public void abaixar(int poderAtaque) {
		// se socar, ao abaixar, não haverá quase nenhum efeito
		if (poderAtaque == 10) {
			System.out.println(this.nome + " ABAIXOU ->DANO FOI PARA [" + (poderAtaque*0.5)+ "]<-");
			nivelEnergia -= (int)(poderAtaque*0.5);
		}
		else{
			System.out.println(this.nome + " ABAIXOU ->DANO FOI PARA [" + (poderAtaque*0.8)+ "]<-");
			nivelEnergia -= (int)(poderAtaque*0.8);
		}
	}
	
	public void guarda(int poderAtaque) {
		System.out.println(this.nome + " FECHOU GUARDA ->DANO FOI PARA [" + (poderAtaque*0.5)+ "]<-");
		nivelEnergia -= (int)(poderAtaque*0.5);
	}
	
	@Override
	//criado somente para poder implementar em Gladiador
	public abstract void roubarArma(Gladiador adversario);
    public abstract Arma getArma();

	public String toString() {
		return ("Lutador " + this.nome + " [" + this.nivelEnergia + "]");	
	}

}