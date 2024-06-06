public class Carta {
    private String name;
    private String color;
    private int strength;
    private int resistance;

    public Carta(String name, String color, int strength, int resistance) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.resistance = resistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "\nCarta{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", strength=" + strength +
                ", resistance=" + resistance +
                '}';
    }
}

