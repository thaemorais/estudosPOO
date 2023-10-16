public class Karateca extends Lutador implements Karate {

	public Karateca(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	public void atacar(Combatente adversario) {
		int escolhaAtaque = (int) (Math.random()*2);
		
		switch(escolhaAtaque) {
		case 0:
			maeHijiAte(adversario);
			break;
		case 1:
			yokoHijiAte(adversario);
			break;
		}
		
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	    }
	}
	
	@Override
	public void maeHijiAte(Combatente adversario) {
		System.out.println(this.nome + " acertou um MAE HIJI ATE ->DANO [20]<-");
		adversario.defender(20);
	}

	@Override
	public void yokoHijiAte(Combatente adversario) {
		System.out.println(this.nome + " acertou um YOKO HIJI ATE ->DANO [30]<-");
		adversario.defender(30);
	}
	
	public String toString() {
		return ("Karateca " + this.nome + " [" + this.nivelEnergia + "]");	
	}

}
