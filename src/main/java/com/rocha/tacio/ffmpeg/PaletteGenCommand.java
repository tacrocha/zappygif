package com.rocha.tacio.ffmpeg;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaletteGenCommand extends FFmpegCommand {

    private final String paletteName;

    public PaletteGenCommand(Path video, FFmpegProperties config) {
        super(video, config);
        this.paletteName = generatePaletteName();
    }

    public String getPaletteName() {
        return paletteName;
    }

    @Override
    public List<String> buildCommandLine() {
        // ./ffmpeg -y -i video.mov -vf fps=10,scale=320:-1:flags=lanczos,palettegen palette.png
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath.toString());
        command.add("-y");
        command.add("-i");
        command.add(video.toString());
        command.add("-vf");
        command.add("fps=10,scale=320:-1:flags=lanczos,palettegen");
        command.add(paletteName);
        return command;
    }

    private String generatePaletteName() {
        return new StringBuilder()
                .append(FilenameUtils.getBaseName(video.getFileName().toString()))
                .append(".png").toString();
    }

}
