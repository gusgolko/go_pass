package src;

/**
 * Password Generator facade.
 */
public class GeneratorFacade {
	
	private Generator generator;
	
	/**
	 * Create new generator.
	 */
	public GeneratorFacade() {
		generator = new Generator();
	}
	
	/**
	 * Call the generatePassword() method.
	 * @return generated password
	 */
	public String genPw() {
		return generator.generatePassword();
	}

}
