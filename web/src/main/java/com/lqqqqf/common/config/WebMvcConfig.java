package com.lqqqqf.common.config;

import com.lqqqqf.common.argresolver.EscapeParamArgumentResolver;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

/**
 * Created by apple on 16/6/25.
 */
@Configuration
public class WebMvcConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new EscapeParamArgumentResolver(true));
        super.addArgumentResolvers(argumentResolvers);
    }
}
