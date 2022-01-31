import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void givenTree_whenCreatingOneBranch_thenReturnBranchNumber() {
        Tree leafTree = new LeafTree();
        Branch branch = new Branch();
        List<Branch> branchList = new ArrayList<Branch>();
        branchList.add(branch);
        leafTree.getTreeTrunk().setBranchList(new ArrayList<Branch>(branchList));
        Assert.assertEquals(1, leafTree.getTreeTrunk().getBranchList().size());

    }

    @Test
    public void givenTreeParameters_whenCreatingNewParameterTree_thenReturnBranchNumber(){
        LeafTree leafTree = new LeafTree();
        leafTree.generateParameterTree(LeafType.LEAF, 4, 20);
        Assert.assertEquals(4, leafTree.numberOfBranches());
    }

    @Test
    public void givenTreeParameters_whenCreatingNewParameterTree_thenReturnLeafNumberInEveryBranch(){
        LeafTree leafTree = new LeafTree();
        leafTree.generateParameterTree(LeafType.LEAF, 4, 20);
        Assert.assertEquals(20, leafTree.getTreeTrunk().getBranchList().get(0).getLeafList().size());
    }
    @Test
    public void givenTreeParameters_whenCreatingNewParameterTree_thenReturnLeafType(){
        ConiferTree coniferTree = new ConiferTree();
        coniferTree.generateParameterTree(LeafType.CONIFER, 4, 20);
        Assert.assertEquals(LeafType.CONIFER, coniferTree.getTreeTrunk().getBranchList().get(0).getLeafList().get(0).getLeafType());
    }
}
