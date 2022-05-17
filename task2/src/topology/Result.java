package topology;

public class Result {

    /**
     *
     * @param processStatusCode the status of the operation
     * @return the associated msg of the status code.
     */
    public String getResult(final String processStatusCode) {
        System.out.println(processStatusCode);
        switch (processStatusCode) {
            case "zero":
                return "added to memory successfully";
            case "one":
                return "removed successfully";
            case "two":
                return "parsing error try again";
            case "three":
                return "topology with the associated id not found";
            case "four":
                return "json file is not found";
            case "five":
                return "removing failed";
            case "six":
                return "json file is not found";
            case "seven":
                return "topology with the associated id is not in memeory ";
            case "eight":
                return "write process failed";
            case "nine":
                return "operation is done successfully";
            default:
                return null;
        }

    }
}
