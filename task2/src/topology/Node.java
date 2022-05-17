package topology;

import org.json.simple.JSONObject;

public class Node {
    /**
     * connection from name.
     */
    private String from;
    /**
     * connection to name.
     */
    private String to;

    /**
     *
     * @param nodeFrom
     * @param nodeTo
     */
    public Node(final String nodeFrom, final String nodeTo) {
        this.from = nodeFrom;
        this.to = nodeTo;
    }

    /**
     *
     * @return String from
     */
    public String getFrom() {
        return from;
    }

    /**
     *
     * @return String to
     */
    public String getTo() {
        return to;
    }

    /**
     *
     * @param nodeTo
     */
    public void setTo(final String nodeTo) {
        this.to = nodeTo;
    }

    /**
     *
     * @param nodeFrom
     */
    public void setFrom(final String nodeFrom) {
        this.from = nodeFrom;
    }

    /**
     *
     * @return JSONObject instance of the node.
     */
    public JSONObject toJson() {
        JSONObject tempNode = new JSONObject();
        tempNode.put(this.from, this.to);
        return tempNode;
    }
}
