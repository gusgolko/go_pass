package src;

/**
 * Password Generator facade.
 */
public class GeneratorFacade {
	
	private Generator generator;
	
	public GeneratorFacade() {
		generator = new Generator();
	}
	
	public String genPw() {
		return generator.generatePassword();
	}

}
