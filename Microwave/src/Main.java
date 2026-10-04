//Microwave class module

public static class Microwave {
    private int power = 1;
    private int time = 0;

    public void add_30() {
      time += 30;
      System.out.println(time + "seconds");
    };

    public void toggle_power() {
        if (power==1) {
            power += 1;
        }
        else {
            power -= 1;
        }
        System.out.println("Power level: " + power);
    };

    public void start() {
        System.out.println("Cooking for " + time + " seconds at level " + power + "...");
    };

    public void restart() {
        power = 1;
        time = 0;
        System.out.println("Microwave restarted.");
    };
}

void main() {
    Microwave microwave = new Microwave();
    microwave.add_30();
    microwave.add_30();
    microwave.toggle_power();
    microwave.toggle_power();
    microwave.start();
    microwave.restart();
}
