package com.rocha.tacio.ffmpeg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@EnableConfigurationProperties(FFmpegProperties.class)
public class FFmpeg {

    @Autowired
    private FFmpegProperties config;

    public Path convert(String input) throws IOException, InterruptedException {
        Path video = Paths.get(input);
        Path pallete = palleteGen(video);
        return palleteUse(video, pallete);
    }

    private Path palleteGen(Path video) throws IOException, InterruptedException {
        PaletteGenCommand command = new PaletteGenCommand(video, config);
        int code = command.execute();
        return command.outputDir.resolve(command.getPaletteName());
    }

    private Path palleteUse(Path video, Path pallete) throws IOException, InterruptedException {
        PaletteUseCommand command = new PaletteUseCommand(video, pallete, config);
        int code = command.execute();
        return command.outputDir.resolve(command.getGifName());
    }

}
