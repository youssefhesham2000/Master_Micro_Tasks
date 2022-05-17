package test;

import org.junit.Test;
import topology.API;
import topology.FileManager;
import topology.Topology;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class APITestWirteRead {

    /**
     * test case for successful reading   json and adding a topology to memory.
     */
    @Test

    public void testSuccessfulReadJson() {
        API api = new API();
        String fileName = "./topology.json";
        assertEquals("added to memory successfully", api.readJson(fileName));
    }
    /**
     * test wrong path
     */
    @Test

    public void testWrongPathReadJson() {
        API api = new API();
        String fileName = "./wrongFilePath.json";
        assertEquals("json file is not found", api.readJson(fileName));
    }

    /**
     *testing parse error
     */
    @Test

    public void testWrongParsingReadJson() {
        API api = new API();
        String fileName = "./worngparsingtopology.json";
        assertEquals("parsing error try again", api.readJson(fileName));
    }

    /**
     *testing parse error.
     */
    @Test

    public void testSuccessfulGetTopologyFromMemory() {
        API api = new API();
        FileManager fileManager = new FileManager();
        String fileName = "./topology.json";
        Map<String, Topology> expected = new HashMap<>();
        api.readJson(fileName);
        Topology expectedTopology = fileManager.readJsonTopology("./topology.json");
        String id = "top1";
        expected.put(id, expectedTopology);
        Map<String, Topology> returned = api.getTopologyMemeory();

        Iterator<String> itr  = returned.keySet().iterator();
        String returnedId = itr.next();
        assertEquals(id, returnedId);
        assertEquals(1, returned.size());
    }


    /**
     * test case for write topology to json.
     */
    @Test
    public void testWriteJson() {
        API api = new API();
        FileManager fileManager = new FileManager();
        String fileName = "./topology.json";
        Map<String, Topology> expected = new HashMap<>();
        api.readJson(fileName);
        String id = "top1";
        assertEquals("operation is done successfully", api.writeJson(id));

    }
    /**
     * test case for write topology to json with wrong id.
     */
    @Test
    public void testWrongIdWriteJson() {
        API api = new API();
        FileManager fileManager = new FileManager();
        String fileName = "./topology.json";
        Map<String, Topology> expected = new HashMap<>();
        api.readJson(fileName);
        String id = "top";
        assertEquals("topology with the associated id is not in memeory ",
                api.writeJson(id));

    }



}
