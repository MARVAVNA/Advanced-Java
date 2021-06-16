package Lesson_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XML {
    public static void main(String[] args) {
        ObjectMapper mapper = new XmlMapper();
        Human human1 = new Human("Arman", 1986);
        String xml = "";
        try {
            xml = mapper.writeValueAsString(human1);
            System.out.println(xml);
        } catch (Exception e) {

        }

        XmlMapper xmlMapper = new XmlMapper();
        try {
            Human value = xmlMapper.readValue(xml, Human.class);
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
