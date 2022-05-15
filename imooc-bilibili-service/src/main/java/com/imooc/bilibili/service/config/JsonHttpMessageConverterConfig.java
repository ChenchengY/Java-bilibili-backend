package com.imooc.bilibili.service.config;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;

@Configuration
public class JsonHttpMessageConverterConfig {

  @Bean
  @Primary
  public HttpMessageConverters fastJsonHttpMessageConvertes() {
    FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");

    fastJsonConfig.setSerializerFeatures(
            SerializerFeature.PrettyFormat,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.MapSortField,
            SerializerFeature.DisableCircularReferenceDetect
    );

    fastConverter.setFastJsonConfig(fastJsonConfig);
    return new HttpMessageConverters(fastConverter);

  }
}
