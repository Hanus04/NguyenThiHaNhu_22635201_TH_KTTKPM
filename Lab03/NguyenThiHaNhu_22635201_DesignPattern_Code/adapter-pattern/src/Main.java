import target.JsonTarget;
import service.JsonWebService;
import adapter.XmlToJsonAdapter;
import adaptee.XmlAdaptee;

public class Main {

    public static void main(String[] args) {

        // Case 1: Hệ thống mới (JSON native)
        JsonTarget jsonService = new JsonWebService();
        jsonService.requestData("{ \"name\": \"Alice\" }");

        System.out.println("---------------");

        // Case 2: Hệ thống cũ (XML) nhưng dùng Adapter
        XmlAdaptee xmlSystem = new XmlAdaptee();
        JsonTarget adapter = new XmlToJsonAdapter(xmlSystem);

        adapter.requestData("{ \"name\": \"Bob\" }");
    }
}