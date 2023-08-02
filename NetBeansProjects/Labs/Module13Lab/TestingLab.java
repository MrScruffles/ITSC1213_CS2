package NetBeansProjects.Labs.Module13Lab;

public class TestingLab {
    public static void main(String[] args) {
        StringAnalyzer wa = new StringAnalyzer();

        System.out.println("----------------------------------------");
        System.out.println("Testing firstRepeatedCharacter()...");

        String k = "aardvark";
        char result = wa.firstRepeatedCharacter(k);
        System.out.println("Test 1 firstRepeatedCharacter: " + validate('a', result));

        k = "roommate";
        result = wa.firstRepeatedCharacter(k);
        System.out.println("Test 2 firstRepeatedCharacter: " + validate('o', result));

        k = "mate";
        result = wa.firstRepeatedCharacter(k);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('0', result));

        System.out.println("----------------------------------------");
        System.out.println("Testing firstMultipleCharacter()...");

        String s = "apple";
        char result2 = wa.firstMultipleCharacter(s);
        System.out.println("Test 1 firstMultipleCharacter: " + validate('0', result2));

        s = "baboon";
        result2 = wa.firstMultipleCharacter(s);
        System.out.println("Test 2 firstMultipleCharacter: " + validate('b', result2));

        s = "hello";
        result2 = wa.firstMultipleCharacter(s);
        System.out.println("Test 3 firstMultipleCharacter: " + validate('l', result2));

        s = "balance";
        result2 = wa.firstMultipleCharacter(s);
        System.out.println("Test 4 firstMultipleCharacter: " + validate('e', result2));

        System.out.println("----------------------------------------");
        System.out.println("Testing countRepeatedCharacters()...");

        String b = "test";
        int CountResults = wa.countRepeatedCharacters(b);
        System.out.println("Test 1 countRepeatedCharacters: " + validate(0, CountResults));

        b = "mississippiii";
        CountResults = wa.countRepeatedCharacters(b);
        System.out.println("Test 2 countRepeatedCharacters: " + validate(4, CountResults));

        b = "aabbcdaaaabbb";
        CountResults = wa.countRepeatedCharacters(b);
        System.out.println("Test 3 countRepeatedCharacters: " + validate(5, CountResults));
        System.out.println("----------------------------------------");

    }

    public static String validate(char expected, char result) {
        if (result != expected) {
            return ("The result " + result + " does not match the expected value " + expected + " -->> FAILED");
        } else {
            return ("The result " + result + " matches the expected value: " + expected + " -->> OK");
        }
    }

    public static String validate(int expected, int result) {
        if (result != expected) {
            return ("The result " + result + " does not match the expected value " + expected + " -->> FAILED");
        } else {
            return ("The result " + result + " matches the expected value: " + expected + " -->> OK");
        }
    }
}
