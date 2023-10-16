public class Civil extends Combatente {	
		
	public Civil(String nome) {
		super(nome);
		this.nivelEnergia = 100;
	}
	
	public boolean isAlive() {
		return nivelEnergia > 0;
	}
		
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
			tapa(adversario);
			break;
		case 3:
			atirar(adversario);
			break;
		}
		
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	        System.out.println("Vencedor: " + this.getNome());
	    }
	}
	
	public void tapa(Combatente adversario) {
		System.out.println(this.nome + " acertou um TAPA ->DANO [10]<-");
		adversario.defender(10);
	}
	
	public void socar(Combatente adversario) {
		System.out.println(this.nome + " acertou um SOCO ->DANO [20]<-");
		adversario.defender(20);
	}
	
	public void chutar(Combatente adversario) {
		System.out.println(this.nome + " acertou um CHUTE ->DANO [30]<-");
		adversario.defender(30);
	}
	
	public void atirar(Combatente adversario) {
		System.out.println(this.nome + " ATIROU ->DANO [50]<-");
		adversario.defender(50);
	}
	
	public void defender(int poderAtaque) {
		int escolhaDefesa = (int) (Math.random()*4);
		
		switch(escolhaDefesa) {
		case 0:
			colete(poderAtaque);
			break;
		case 1:
			guarda(poderAtaque);
			break;
		case 2:
			System.out.println(this.nome + " NÃO FEZ NADA ->DANO COMPLETO<-");
			nivelEnergia -= poderAtaque;
			break;
		}		
	}
	
	public void colete(int poderAtaque) {
		System.out.println(this.nome + " ESTAVA DE COLETE ->DANO FOI PARA [" + (poderAtaque*0.5)+ "]<-");
		nivelEnergia -= (int)(poderAtaque*0.5);
	}
	
	public void guarda(int poderAtaque) {
		System.out.println(this.nome + " FECHOU GUARDA ->DANO FOI PARA [" + (poderAtaque*0.9)+ "]<-");
		nivelEnergia -= (int)(poderAtaque*0.9);
	}
	
	public String toString() {
		return ("Civil " + this.nome + " [" + this.nivelEnergia + "]");
		
	}
}