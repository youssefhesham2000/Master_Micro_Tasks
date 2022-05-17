package topology;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NetList {
    /**
     * array list of existing Nodes in the netlist.
     */
    private ArrayList<Node> netList;

    /**
     * initialize the arrayList.
     */
    public NetList() {
        this.netList = new ArrayList<>();
    }

    /**
     *
     * @return arrayList of nodes in the netList.
     */
    public ArrayList<Node> getNetList() {
        return netList;
    }

    /**
     *
     * @param node
     */
    public void addToNetList(final Node node) {
        boolean add = this.netList.add(node);
    }

    /**
     *
     * @return JSONArray instance of the netList.
     */
    public JSONArray toJsonArray() {
        JSONArray netListJson = new JSONArray();
        for (int i = 0; i < netList.size(); i++) {
            JSONObject tempNode = netList.get(i).toJson();
            netListJson.add(tempNode);
        }
        return netListJson;

    }

    /**
     *
     * @return a set of the nodes ids in the netlist.
     */
    public Set<String> getNodesIds() {
        Set<String> ids = new HashSet<>();
        for (int i = 0; i < netList.size(); i++) {
            ids.add(netList.get(i).getTo());
        }
        return ids;
    }
}
