public class Main {

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("pikachu", false, 6, 7);
        Pokemon bulbasaur = new Pokemon("bulbasaur", false, 5, 7);

        Pokemon lucario = new Pokemon("lucario", true, 8, 8);
        Pokemon mewtwo = new Pokemon("mewtwo", true, 10, 9);

        System.out.println("is Lucario greater that mewtwo? " + lucario.compareTo(mewtwo));
        System.out.println("is pikachu greater that bulbasaur? " + pikachu.compareTo(bulbasaur));
        System.out.println("is bulbasaur greater that pikachu? " + bulbasaur.compareTo(pikachu));
    }

}
