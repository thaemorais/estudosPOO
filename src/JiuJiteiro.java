public class JiuJiteiro extends Lutador implements JiuJitsu {

	public JiuJiteiro(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}
	
	public void atacar(Combatente adversario) {
		int escolhaAtaque = (int) (Math.random()*2);
		
		switch(escolhaAtaque) {
		case 0:
			arkLock(adversario);
			break;
		case 1:
			mataLeao(adversario);
			break;
		}
		
		if (adversario.getNivelEnergia() <= 0) {
	        adversario.setNivelEnergia(0);
	    }
	}
	
	@Override
	public void arkLock(Combatente adversario) {
		System.out.println(this.nome + " acertou um ARK LOCK ->DANO [20]<-");
		adversario.defender(20);		
	}

	@Override
	public void mataLeao(Combatente adversario) {
		System.out.println(this.nome + " acertou um MATA LEÃO ->DANO [30]<-");
		adversario.defender(30);
	}

	public String toString() {
		return ("Jiujiteiro " + this.nome + " [" + this.nivelEnergia + "]");	
	}
}