package com.rocha.tacio.ffmpeg;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ffmpeg")
public class FFmpegConfiguration {

    private String path;

}
