package br.com.unisul.osbutils;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class XmlJsonConverter {
	
	private XmlJsonConverter() {
		
	}
		 
    /**
     * Converte string JSON para string XML
     * @param elementoRaiz elemento que será a raiz do XML convertido
     * @param json string que representa o JSON a ser convertido
     * @return nulo ou a string que contém o XML
     */
    public static String converterJsonParaXml(String elementoRaiz, String json) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setRootName(elementoRaiz);
        
        JSON jsonSerializado = JSONSerializer.toJSON(json);
        return xmlSerializer.write(jsonSerializado);
    }
 
    /**
     * Converte string XML para string JSON
     * @param xml string que representa o XML a ser convertido
     * @return nulo ou a string que contém o JSON
     */
    public static String convertXmlParaJson(String xml) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setTypeHintsEnabled(false);

        JSONObject json = (JSONObject) xmlSerializer.read(xml);
        
        return json.toString();
    }	    
}
