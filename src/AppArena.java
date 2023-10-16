import java.util.Random;

public class AppArena {
	private int qtdCombatentes;
	Combatente[] combatentes;
	
	
	GeradorNomes geraNome = new GeradorNomes();
	
	public AppArena(int qtdCombatentes) {
        this.qtdCombatentes = qtdCombatentes;
        combatentes = new Combatente[qtdCombatentes];
        
        Random random = new Random();
        
        String[] armas = {"Pistola", "Lança", "Gás"};
        
        for (int i = 0; i < combatentes.length; i++) {
            String nome;
            boolean nomeJaExiste;

            do {
                nome = geraNome.gerarNome();
                nomeJaExiste = false;

                // Verifica se o nome já existe no vetor de combatentes
                for (int j = 0; j < i; j++) {
                    if (nome.equals(combatentes[j].nome)) {
                        nomeJaExiste = true;
                        break;
                    }
                }
            } while (nomeJaExiste);
            
            // MODO DE JOGO 1: Luta entre Lutadores e Civis
//            Combatente novoCombatente;
//            if (random.nextBoolean()) {
//                novoCombatente = new Lutador(nome);
//            } else {
//                novoCombatente = new Civil(nome);
//            }
//            combatentes[i] = novoCombatente;
           

            // MODO DE JOGO 2: Luta entre Judocas, Karatecas, Jiujiteiros e Civis
//            Combatente novoCombatente;
//            int tipoCombatente = random.nextInt(4);
//
//            switch (tipoCombatente) {
//                case 0:
//                    novoCombatente = new Judoca(nome);
//                    break;
//                case 1:
//                    novoCombatente = new Karateca(nome);
//                    break;
//                case 2:
//                    novoCombatente = new JiuJiteiro(nome);
//                    break;
//                default:
//                    novoCombatente = new Civil(nome);
//                    break;
//            }

            // MODO DE JOGO 3: Luta entre Gladiadores
            // Escolhe aleatoriamente uma arma da lista
            String armaEscolhida = armas[random.nextInt(armas.length)];
            Combatente novoCombatente;
            novoCombatente = new Gladiador(nome, armaEscolhida);          
            combatentes[i] = novoCombatente;
        }
    }
	
	public String realizarLuta() {
	    Combatente[] vencedores = combatentes.clone(); // Clona o vetor inicial de combatentes
	    
	    while (vencedores.length > 1) {
	        System.out.println("\nIniciando fase...");
	        vencedores = realizarFase(vencedores);
	        System.out.println("Vencedores da fase: ");
	        imprimirNomes(vencedores);
	        System.out.println("\n---------------------------------------------");
	    }

	    return "\nVencedor Final: " + vencedores[0];
	}

	private Combatente[] realizarFase(Combatente[] participantes) {
	    int tamanho = participantes.length;
	    Combatente[] vencedores = new Combatente[(tamanho + 1) / 2]; // Garante que haja espaço para um vencedor ímpar

	    for (int i = 0; i < tamanho; i += 2) {
	        Combatente lutador1 = participantes[i];
	        Combatente lutador2 = (i + 1 < tamanho) ? participantes[i + 1] : null;
	        System.out.println("\n\nRealizando luta entre " + lutador1 + " e " + ((lutador2 != null) ? lutador2 : "BYE"));

	        while (lutador1.isAlive() && (lutador2 == null || lutador2.isAlive())) {
	            lutador1.atacar((lutador2 != null) ? lutador2 : null);
	            System.out.println("Resultado do ataque: " + lutador2.nome + " [" + lutador2.nivelEnergia + "]\n");

	            // Verificar se lutador1 venceu
	            if (!lutador2.isAlive()) {
	                System.out.println(lutador2.nome + " foi derrotado(a). " + lutador1 + " é o(a) vencedor(a)!\n");
	                if (lutador1 instanceof Gladiador && lutador2 instanceof Gladiador) {
	                    ((Gladiador) lutador1).roubarArma((Gladiador) lutador2);
	                }
	                break;
	            }

	            if (lutador2 != null) {
	                lutador2.atacar(lutador1);
	                System.out.println("Resultado do contra-ataque: " + lutador1.nome + " [" + lutador1.nivelEnergia + "]\n");
	            }

	            // Verificar se lutador2 venceu
	            if (!lutador1.isAlive()) {
	                System.out.println(lutador1.nome + " foi derrotado(a). " + lutador2 + " é o(a) vencedor(a)!\n");
	                if (lutador1 instanceof Gladiador && lutador2 instanceof Gladiador) {
	                    ((Gladiador) lutador2).roubarArma((Gladiador) lutador1);
	                }
	                break;
	            }
	        }


	        Combatente vencedor = (lutador1.isAlive()) ? lutador1 : lutador2;
	        vencedores[i / 2] = vencedor;
	    }


	    System.out.println("Fase encerrada.");

	    // Atualiza o array original com os vencedores
	    System.arraycopy(vencedores, 0, participantes, 0, vencedores.length);

	    return vencedores;
	}


	private void imprimirNomes(Combatente[] combatentes) {
	    for (Combatente combatente : combatentes) {
	        System.out.print(combatente.nome + " ");
	    }
	    System.out.println();
	}
	
	public void imprimeCombatentes(){
  		for(int i=0; i<combatentes.length; i++) {
			System.out.println(combatentes[i]);
		}
	}

	public static void main(String[] args) {		
		AppArena arena = new AppArena(8);
		
		// verifica se a quantidade de combatentes determinada é uma potencia de 2
        if ((arena.qtdCombatentes > 0) && ((arena.qtdCombatentes & (arena.qtdCombatentes - 1)) == 0)) {
        	System.out.println("Apresentando os combatentes...");
        	arena.imprimeCombatentes();
        	
        	System.out.println(arena.realizarLuta());	
        }
        else {
        	System.out.println("Quantidade de combatentes inválida.");
        }
		
	}

}