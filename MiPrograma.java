public class MiPrograma {
  public static void main(String[] args) {
    System.out.println("Este es el método main");
    otroMetodo();
  }

  public static void otroMetodo() {
    System.out.println("Este es otro método");
    main(new String[]{"arg1", "arg2"});
  }
}
