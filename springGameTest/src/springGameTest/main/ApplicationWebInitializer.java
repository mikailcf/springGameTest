package springGameTest.main;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class ApplicationWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
    	XmlWebApplicationContext appContext = new XmlWebApplicationContext();

    	ServletRegistration.Dynamic dispatcher =
    			container.addServlet("game", new DispatcherServlet(appContext));
    	dispatcher.setLoadOnStartup(1);
    	dispatcher.addMapping("*.html");
  }
}
