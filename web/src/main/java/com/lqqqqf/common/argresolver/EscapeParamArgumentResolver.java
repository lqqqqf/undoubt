package com.lqqqqf.common.argresolver;

import com.lqqqqf.common.Escape;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Created by apple on 16/6/25.
 */
public class EscapeParamArgumentResolver extends ModelAttributeMethodProcessor {

    /**
     * @param annotationNotRequired if "true", non-simple method arguments and
     *                              return values are considered model attributes with or without a
     *                              {@code @ModelAttribute} annotation
     */
    public EscapeParamArgumentResolver(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        return parameter.hasParameterAnnotation(Escape.class)&& Serializable.class.isAssignableFrom(parameterType);
    }


    @Override
    protected Object createAttribute(String attributeName, MethodParameter parameter, WebDataBinderFactory binderFactory, NativeWebRequest webRequest) throws Exception {
        Class<?> parameterType = parameter.getParameterType();
        if (String.class.isAssignableFrom(parameterType)) {
            return HtmlUtils.htmlEscape(webRequest.getParameter(parameter.getParameterName()));
        }
        Escape escape = parameter.getMethodAnnotation(Escape.class);
        String[] spels = escape.value();
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(BeanUtils.instantiate(parameter.getParameterType()));
        for (String spel: spels) {
            String param = spel.replace(".*[\\.]([^\\.]*)$", "$1");
            parser.parseExpression(spel).setValue(context, webRequest.getParameter(param));
        }
        return context.getRootObject().getValue();
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        ((ServletRequestDataBinder) binder).bind((ServletRequest) request.getNativeRequest());
    }
}
