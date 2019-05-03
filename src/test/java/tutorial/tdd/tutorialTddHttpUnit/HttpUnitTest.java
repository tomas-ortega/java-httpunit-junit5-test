package tutorial.tdd.tutorialTddHttpUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

public class HttpUnitTest {
	
	@BeforeAll
	public static void init() {
	    HttpUnitOptions.setScriptingEnabled(false);
	}

	@Test
	public void test() throws IOException, SAXException {

		WebConversation webconversation = new WebConversation();
	    WebResponse response = null;
	        
        try {
            response = webconversation.getResponse("http://www.google.com");
        }catch (Exception ex) {
            System.out.println(ex);
        }
	        
        assertEquals(200, response.getResponseCode());
	        
        WebForm[] formularios = response.getForms();
        
        assertTrue(formularios.length == 1);
	        
        assertEquals("Buscar con Google",response.getForms()[0].getParameter("q").getControls()[0].getTitle());
	}
}
