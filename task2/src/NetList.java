import java.util.ArrayList;

public class NetList {
    private ArrayList<Node> nelList;

    public NetList() {
        this.nelList =new ArrayList<>();
    }

    public ArrayList<Node> getNelList() {
        return nelList;
    }
    public void addToNetList(Node node){
        this.nelList.add(node);
    }
}
