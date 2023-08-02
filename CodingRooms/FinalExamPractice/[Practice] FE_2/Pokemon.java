public class Pokemon implements Comparable<Pokemon> {
    private String name;
    private boolean aggressive;
    private int attack;
    private int defense;

    public Pokemon(String name, boolean aggressive, int attack, int defense) {
        this.name = name;
        this.aggressive = aggressive;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int sumAttackDef() {
        return attack + defense;
    }

    @Override
    public int compareTo(Pokemon other) {
        if (this.isAggressive() && !other.isAggressive()) {
            return this.sumAttackDef() - other.getDefense();
        } else if (!this.isAggressive() && other.isAggressive()) {
            return this.getDefense() - other.sumAttackDef();
        } else {
            return this.getDefense() - other.getDefense();
        }
    }
}
