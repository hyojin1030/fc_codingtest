public class Items implements Comparable<Items>{
    private String label;
    private int price;

    public Items(String label, int price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Items item) {
        if (this.getPrice() < item.getPrice()) return 1;
        else return -1;
    }
}
