class Item {
    String name;
    int weight;

    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item name: " + name + ", item weight: " + weight + "\n";
    }
}
