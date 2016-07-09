package com.lqqqqf.common.viewresolver;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.inject.Named;
import java.util.Locale;

/**
 * Created by apple on 16/6/24.
 */
@Named
public class XmlViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        MarshallingView view = new MarshallingView();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.lqqqqf.domain");
        view.setMarshaller(marshaller);
        return view;
    }

}
