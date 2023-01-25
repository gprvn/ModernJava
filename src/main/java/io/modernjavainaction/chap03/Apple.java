package io.modernjavainaction.chap03;

class Apple {
    private int weight = 0;
    private Color color;

    private Integer slot;

    public Apple() {}

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight, Color color, Integer slot){
        this.weight = weight;
        this.color = color;
        this.slot = slot;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}