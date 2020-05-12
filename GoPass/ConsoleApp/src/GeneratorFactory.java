package src;

/**
 * Password Generator factory.
 */
public class GeneratorFactory {

    /**
     * Use getGenerator() to get objects of this type.
     */
    public Generator getGenerator(String genType) {

        if (genType == null){
            return null;
        } else if (genType.equals("console")){
            return new ConsoleGenerator();
        } else if (genType.equals("gui")){
            //return new GuiGenerator();
            System.out.println("Coming soon!");
        }
        return null;
    }

}
