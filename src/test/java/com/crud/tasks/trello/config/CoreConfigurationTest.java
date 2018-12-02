package com.crud.tasks.trello.config;

import com.crud.tasks.config.CoreConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

@RunWith(MockitoJUnitRunner.class)
public class CoreConfigurationTest {

    @InjectMocks
    private CoreConfiguration coreConfiguration;

    @Test
    public void restTemplate() {
    }

    @Test
    public void api() {
    }

    @Test
    public void configurePathMatch() {
        coreConfiguration.configurePathMatch(mock(PathMatchConfigurer.class));
    }

    @Test
    public void configureContentNegotiation() {
        coreConfiguration.configureContentNegotiation(mock(ContentNegotiationConfigurer.class));

    }

    @Test
    public void configureAsyncSupport() {
        coreConfiguration.configureAsyncSupport(mock(AsyncSupportConfigurer.class));
    }

    @Test
    public void configureDefaultServletHandling() {
        coreConfiguration.configureDefaultServletHandling(mock(DefaultServletHandlerConfigurer.class));
    }

    @Test
    public void addFormatters() {
        coreConfiguration.addFormatters(mock(FormatterRegistry.class));
    }

    @Test
    public void addInterceptors() {
        coreConfiguration.addInterceptors(mock(InterceptorRegistry.class));
    }


    @Test
    public void addCorsMappings() {
        coreConfiguration.addCorsMappings(mock(CorsRegistry.class));
    }

    @Test
    public void addViewControllers() {
        coreConfiguration.addViewControllers(mock(ViewControllerRegistry.class));
    }

    @Test
    public void configureViewResolvers() {
        coreConfiguration.addViewControllers(mock(ViewControllerRegistry.class));
    }

    @Test
    public void addArgumentResolvers() {

        coreConfiguration.addArgumentResolvers(mock(List.class));
    }

    @Test
    public void addReturnValueHandlers() {
        coreConfiguration.addReturnValueHandlers(mock(List.class));
    }

    @Test
    public void configureMessageConverters() {
        coreConfiguration.configureMessageConverters(mock(List.class));
    }

    @Test
    public void extendMessageConverters() {
        coreConfiguration.configureMessageConverters(mock(List.class));
    }

    @Test
    public void configureHandlerExceptionResolvers() {
        coreConfiguration.configureHandlerExceptionResolvers(mock(List.class));
    }

    @Test
    public void extendHandlerExceptionResolvers() {
        coreConfiguration.extendHandlerExceptionResolvers(mock(List.class));
    }

    @Test
    public void getValidator() {
        coreConfiguration.getValidator();
    }

    @Test
    public void getMessageCodesResolver() {
        coreConfiguration.getMessageCodesResolver();

    }
}