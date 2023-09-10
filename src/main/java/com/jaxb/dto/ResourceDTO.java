package com.jaxb.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
@Builder
@Data
public class ResourceDTO {

    private Resource resource;

    private MediaType mediaType;
}
