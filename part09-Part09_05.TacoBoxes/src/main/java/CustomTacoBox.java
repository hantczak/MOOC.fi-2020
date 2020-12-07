public class CustomTacoBox implements TacoBox {
    private int tacos;

    public CustomTacoBox(int initialTacos) {
        this.tacos = initialTacos;
    }

    public int tacosRemaining() {
        return tacos;
    }

    public void eat() {
        if (tacos >= 1) {
            tacos--;
        }
    }
}

