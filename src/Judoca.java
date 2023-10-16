public class Judoca extends Lutador implements Judo{

	public Judoca(String nome) {
		super(nome);
		
	}
	public void atacar(Combatente adversario) {
		int escolhaAtaque = (int) (Math.random()*2);
		
		switch(escolhaAtaque) {
		case 0:
			nageNoKata(adversario);
			break;
		case 1:
			katameNoKata(adversario);
			break;
		}
		
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	    }
	}
	
	@Override
	public void nageNoKata(Combatente adversario) {
		System.out.println(this.nome + " acertou um NAGE-NO-KATA ->DANO [20]<-");
		adversario.defender(20);
	}

	@Override
	public void katameNoKata(Combatente adversario) {
		System.out.println(this.nome + " acertou um KATAME-NO-KATA ->DANO [30]<-");
		adversario.defender(30);
	}

	public String toString() {
		return ("Judoca " + this.nome + " [" + this.nivelEnergia + "]");	
	}
	

}