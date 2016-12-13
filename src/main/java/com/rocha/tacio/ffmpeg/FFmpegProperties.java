package com.rocha.tacio.ffmpeg;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ffmpeg")
public class FFmpegProperties {

    private String path;

    private String outputDir;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
}
