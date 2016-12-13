package com.rocha.tacio.ffmpeg;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class FFmpegCommand {

    private FFmpegProperties config;
    protected Path ffmpegPath;
    protected Path video;
    protected Path outputDir;

    public FFmpegCommand(Path video, FFmpegProperties config) {
        this.config = config;
        this.ffmpegPath = Paths.get(config.getPath());
        this.video = video;
        this.outputDir = Paths.get(config.getOutputDir());
    }

    public int execute() throws InterruptedException, IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(buildCommandLine());
        processBuilder.directory(outputDir.toFile());
        processBuilder.inheritIO();
        return processBuilder.start().waitFor();
    }

    public abstract List<String> buildCommandLine();

}
