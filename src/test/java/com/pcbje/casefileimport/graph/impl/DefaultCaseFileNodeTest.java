package com.pcbje.casefileimport.graph.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import com.pcbje.casefileimport.CaseFileException;
import com.pcbje.casefileimport.graph.CaseFileNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 *
 * @author pcbje
 */
public class DefaultCaseFileNodeTest {

    @Test(expected = CaseFileException.class)
    public void testInvalidNodeTypeFormatGivesException() {
        new DefaultCaseFileNode("id", "Group", "type", "oldlabel");
    }

    @Test(expected = CaseFileException.class)
    public void testNodeTypeWithSpaceFormatGivesException() {
        new DefaultCaseFileNode("id", "Group", "maltego.type a", "oldlabel");
    }

    @Test
    public void testNodeMergeAttributes() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.type", "oldlabel");
        first.addAttribute("key 1", "value 1");
        first.addAttribute("key 2", "value 2");

        CaseFileNode second = new DefaultCaseFileNode("id", "Group", "maltego.type", "newlabel");
        first.addAttribute("key 1", "value 3");
        first.addAttribute("key 3", "value 4");

        first.mergeWith(second);

        assertEquals("value 3", first.getAttribute("key 1"));
        assertEquals("value 2", first.getAttribute("key 2"));
        assertEquals("value 4", first.getAttribute("key 3"));
    }

    @Test(expected = CaseFileException.class)
    public void testNodeIdImmutable() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.type", "label");
        CaseFileNode second = new DefaultCaseFileNode("different id", "Group", "maltego.type", "label");

        first.mergeWith(second);
    }

    @Test
    public void testNodeLabelMutable() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.type", "label");
        CaseFileNode second = new DefaultCaseFileNode("id", "Group", "maltego.type", "different label");

        first.mergeWith(second);

        assertEquals("different label", first.getLabel());
    }

    @Test(expected = CaseFileException.class)
    public void testNodeGroupImmutable() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group1", "maltego.type", "label");
        CaseFileNode second = new DefaultCaseFileNode("id", "Group2", "maltego.type", "label");

        first.mergeWith(second);
    }

    @Test(expected = CaseFileException.class)
    public void testNodeTypeImmutable() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.type", "label");
        CaseFileNode second = new DefaultCaseFileNode("id", "Group", "maltego.differenttype", "label");

        first.mergeWith(second);
    }

    @Test
    public void testThatTypeDisplayNameIsCorrect() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.Type", "label");

        assertEquals("Group", first.getGroupDisplayName());
    }

    @Test
    public void testThatTypeNameIsCorrect() {
        CaseFileNode first = new DefaultCaseFileNode("id", "Group", "maltego.Type", "label");

        assertEquals("group", first.getGroupName());
    }

    @Test
    public void testGetNodeGraphML() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            CaseFileNode node = new DefaultCaseFileNode("node id", "Group", "maltego.nodetype", "node label");

            Element graphML = node.getGraphML(doc);
            assertNotNull(graphML);
            assertEquals("node id", graphML.getAttribute("id"));
            Element data = (Element) graphML.getElementsByTagName("data").item(0);
            assertNotNull(data);
            assertNotNull(data.getAttribute("key"));

            Element maltegoEntity = (Element) data.getElementsByTagName("mtg:MaltegoEntity").item(0);
            assertNotNull(maltegoEntity);
            assertEquals("http://maltego.paterva.com/xml/mtgx",
                    maltegoEntity.getAttribute("xmlns:mtg"));
            assertEquals("maltego.nodetype",
                    maltegoEntity.getAttribute("type"));

            Element properties = (Element) maltegoEntity.getElementsByTagName("mtg:Properties").item(0);
            assertNotNull(properties);

            Element labelProperty = (Element) properties.getElementsByTagName("mtg:Property").item(0);
            assertNotNull(labelProperty);
            assertNotNull(labelProperty.getAttribute("displayName"));
            assertNotNull(labelProperty.getAttribute("hidden"));
            assertNotNull(labelProperty.getAttribute("name"));
            assertNotNull(labelProperty.getAttribute("nullable"));
            assertNotNull(labelProperty.getAttribute("readonly"));
            assertNotNull(labelProperty.getAttribute("type"));

            Element labelPropertyValue = (Element) labelProperty.getElementsByTagName("mtg:Value").item(0);
            assertNotNull(labelPropertyValue);
            assertEquals("node label", labelPropertyValue.getTextContent());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DefaultCaseFileNodeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
