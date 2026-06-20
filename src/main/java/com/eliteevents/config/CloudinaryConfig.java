package com.eliteevents.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(
                "cloudinary://983133492617583:-ESPLrBEAlMAGh3EH4fNFe04e_k@dduwbup2d"
        );
    }
}