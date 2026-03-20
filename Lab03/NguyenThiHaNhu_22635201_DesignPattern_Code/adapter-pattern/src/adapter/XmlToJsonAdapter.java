package adapter;

import target.JsonTarget;
import adaptee.XmlAdaptee;

public class XmlToJsonAdapter implements JsonTarget {

    private XmlAdaptee xmlSystem;

    public XmlToJsonAdapter(XmlAdaptee xmlSystem) {
        this.xmlSystem = xmlSystem;
    }

    @Override
    public void requestData(String json) {
        System.out.println("Client gửi JSON: " + json);

        // Convert JSON -> XML
        String xml = convertJsonToXml(json);
        System.out.println("Chuyển sang XML: " + xml);

        // Gọi hệ thống cũ
        String xmlResponse = xmlSystem.getXmlData();
        System.out.println("XML từ hệ thống cũ: " + xmlResponse);

        // Convert XML -> JSON
        String jsonResponse = convertXmlToJson(xmlResponse);
        System.out.println("Chuyển lại JSON cho client: " + jsonResponse);
    }

    // UML yêu cầu
    private String convertXmlToJson(String xml) {
        return "{ \"data\": \"Converted from XML\" }";
    }

    private String convertJsonToXml(String json) {
        return "<data>Converted from JSON</data>";
    }
}