public class Node {
    private String from;
    private String to;

    /**
     *
     * @param from
     * @param to
     */
    public Node(String from,String to){
        this.from=from;
        this.to=to;
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
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     *
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }
}
