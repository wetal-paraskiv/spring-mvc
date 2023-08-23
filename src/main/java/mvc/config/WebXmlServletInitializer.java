package mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXmlServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// services and data sources
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	// controller, view resolver, handler mapping
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext aServletContext) throws ServletException {
		super.onStartup(aServletContext);
		registerHiddenFieldFilter(aServletContext);
	}

	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true,
				"/*");
	}
}