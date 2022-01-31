public class Leaf {
    private LeafType leafType;


    public LeafType getLeafType() {
        return leafType;
    }

    public void setLeafType(LeafType leafType) {
        this.leafType = leafType;
    }
    public Leaf(){

    }
    public Leaf(LeafType leafType) {
        this.leafType = leafType;
    }

}
