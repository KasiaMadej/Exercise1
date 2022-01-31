import java.util.ArrayList;
import java.util.List;

public class Branch {
    private List<Leaf> leafList;

    public List<Leaf> getLeafList() {
        return leafList;
    }

    public void setLeafList(List<Leaf> leafList) {
        this.leafList = leafList;
    }

    public Branch() {
        this.leafList = new ArrayList<>();
    }

    public Branch(List<Leaf> leafList) {
        this.leafList = leafList;

    }


}
