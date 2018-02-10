package saxparser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pojos.LaptopBean;
import pojos.Product;
import pojos.TabletBean;

public class ProductParser extends DefaultHandler  {

	
	private LaptopBean laptop;
	private TabletBean tablet;
	private static Map<String, Product> productmap;
	private String productFilename;
	private String elementValueRead;
	
	private boolean lname;
	private boolean lprice;
	private boolean lretailer;
	
	private boolean tname;
	private boolean tprice;
	private boolean tretailer;
	
	private boolean price;
	private boolean retailer;
	
    public ProductParser(String productFilename) {
    this.productFilename = productFilename;
	System.out.println(productFilename);
    productmap = new HashMap<String, Product>();
    parseDocument();
 
    }    
    
    public Map<String, Product> getProductMap()
    {  return productmap;
    }
    
    public void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(productFilename, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }

   

    
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("laptop")) {
        	laptop = new LaptopBean();
        	System.out.println("Laptop is"+laptop);
        	laptop.setProductId(attributes.getValue("id"));
        	System.out.println("id for laptop is "+ attributes.getValue("id"));
        	lretailer=true;
        	lprice= true;
        	tretailer=false;
        	tprice= false;
        }
        	
        else if(elementName.equalsIgnoreCase("retailer")) {
        	//System.out.println("setting flag for retailer element");	
        	retailer=true;
        	price=false;
        	/*System.out.println("lretailer is" + lretailer);
        	System.out.println("lprice is " + lprice);
        	System.out.println("tretailer is" + tretailer);
        	System.out.println("tprice is " + tprice);*/
        	
        		}
        	
        	else if(elementName.equalsIgnoreCase("price")) {
        		//System.out.println("setting flag for price element");	
        		retailer=false;
        		price=true;
        		/*System.out.println("lretailer is" + lretailer);
            	System.out.println("lprice is " + lprice);
            	System.out.println("tretailer is" + tretailer);
            	System.out.println("tprice is " + tprice);*/
            	}
    
    
        	
       
        	else if(elementName.equalsIgnoreCase("tablet")) {
        	tablet = new TabletBean();
        	tablet.setProductId(attributes.getValue("id"));
        	System.out.println("id for tablets is"+ tablet.getProductId());
        	tretailer=true;
        	tprice= true;
        	lretailer=false;
        	lprice= false;
        	}	
        	
        	
  
        
        
    }

   
    public void endElement(String str1, String str2, String element) throws SAXException {
 
    	System.out.println("end element is" +element);
        if (element.equalsIgnoreCase("laptop")) {
        	
        	productmap.put(laptop.getProductId(), laptop);
        	System.out.println("product map is"+productmap);
        	System.out.println("added laptop2 to the map, map is" + productmap);
        	System.out.println("length of map is"+productmap.size());
	   
        }
        else if (element.equalsIgnoreCase("tablet")) {
            productmap.put(tablet.getProductId(), tablet);
        	System.out.println("product map is"+productmap);
            System.out.println("added tablet to the map, map is" + productmap);
        	System.out.println("length of map is"+productmap.size());
	   
        }   
       
    }

   
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
        //System.out.println("element value1 read is "+ elementValueRead);
        
        if( lretailer&&retailer)
        {
        	laptop.setProductRetailer(elementValueRead);
        	System.out.println("setting retailer for laptop"+ elementValueRead);
        	retailer=false;
        	lretailer=false;
        }
        else if (lprice&& price)
        {
        	laptop.setProductPrice(Double.parseDouble(elementValueRead));
        	System.out.println("setting price for laptop....."+ Double.parseDouble(elementValueRead));
        	price=false;
        	lprice=false;
        }
        
        else if(tretailer && retailer)
        {
        	laptop.setProductRetailer(elementValueRead);
        	System.out.println("setting retailer for tablet....."+ elementValueRead);
        	tretailer=false;
        	retailer=false;
        }
        else if (tprice && price)
        {
        	laptop.setProductPrice(Double.parseDouble(elementValueRead));
        	System.out.println("setting price for tablet........."+ Double.parseDouble(elementValueRead));
        	tprice=false;price=false;
        }
        
    }

  //  public static void main(String[] args) {
  //      new SaxParser4BestDealRetail("ProductCatalog.xml");

  //  }

}

	
	
	
	
	
	
	
	
	

