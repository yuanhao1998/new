package service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadXML {
    private static ReadXML xml = new ReadXML();

    private static Document getXml(String xmlPath)
    {
        Document document = null;
        SAXReader reader = new SAXReader();
        try {
            document = reader.read(xml.getClass().getClassLoader().getResourceAsStream(xmlPath));       //读取xml文件
        } catch (DocumentException e) {
            System.out.println("获取xml文件失败"+xmlPath);
            e.printStackTrace();
        }
        return  document;
    }
    public static String getSql(String xmlPath, String src)
    {
        List list = getXml(xmlPath).selectNodes("template/sqltemplate");                             //查询xml文件所有节点的key
        String sql = null;
        if (list != null){
            //遍历key
            for (Object objects : list){
                Element element = (Element) objects;
                String key = element.attributeValue("key");                              //key
                //如果key和传入的src相同，返回xml文件中key对应的sql
                if (key.equals(src)) {
                    sql = element.getTextTrim();                                           //sql
                    break;
                }
                else {
                    sql="error";
                }
            }
        }
        return  sql;
    }
}