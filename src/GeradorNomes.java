
public class GeradorNomes {
	public String[] nomes = {
            "Wihara", "Alexia", "Thaelen", "Julio", "Josekelly",
            "Victor", "Vitor", "Jesus", "Amanda", "Marcia",
            "Lucas", "Isabela", "Ricardo", "Camila", "Felipe",
            "Gabriel", "Mariana", "Eduardo", "Ana", "Carlos",
            "Larissa", "Renato", "Monica", "Bruno", "Laura",
            "Gustavo", "Carolina", "Vinicius", "Letícia", "Fernando",
            "Vanessa", "Rafael", "Tatiane", "Diego", "Aline",
            "Matheus", "Fernanda", "Pedro", "Jessica", "Rafaela",
            "Sergio", "Elaine", "Leandro", "Daniela", "Anderson",
            "Thais", "Alan", "Carla"
    };
	
	public String gerarNome() {
		int indiceSorteado = (int) (Math.random()*nomes.length);
		
		return nomes[indiceSorteado];
	}
}
