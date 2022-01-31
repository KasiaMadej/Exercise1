import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeTrunk {
    private List<Branch> branchList;

    public List<Branch> getBranchList() {
        return branchList;
    }

    public TreeTrunk(List<Branch> branchList) {
        this.branchList = branchList;
        Map<Branch, Integer> map = new HashMap<Branch, Integer>() {{
            for (int i = 0; i < branchList.size(); i++) {
                put(branchList.get(i), branchList.get(i).getLeafList().size());
            }
        }};
        System.out.println("Hashmap below presents branches with number of their leaves");
        System.out.println(map);
    }

    public TreeTrunk() {
        this.branchList = new ArrayList<>();
        Map<Branch, Integer> map = new HashMap<Branch, Integer>() {{
            for (int i = 0; i < branchList.size(); i++) {
                put(branchList.get(i), branchList.get(i).getLeafList().size());
            }
        }};

    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}
