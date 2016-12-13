package com.rocha.tacio.ffmpeg;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaletteUseCommand extends FFmpegCommand {

    private final Path pallete;
    private final String gifName;

    public PaletteUseCommand(Path video, Path pallete, FFmpegProperties config) {
        super(video, config);
        this.pallete = pallete;
        this.gifName = generateGifName();
    }

    public String getGifName() {
        return this.gifName;
    }

    @Override
    public List<String> buildCommandLine() {
        List<String> command = new ArrayList<>();
        // ./ffmpeg -i video.mov -i palette.png -filter_complex "fps=10,scale=320:-1:flags=lanczos[x];[x][1:v]paletteuse" output.gif
        command.add(ffmpegPath.toString());
        command.add("-y");
        command.add("-i");
        command.add(video.toString());
        command.add("-i");
        command.add(pallete.toString());
        command.add("-filter_complex");
        command.add("fps=10,scale=320:-1:flags=lanczos[x];[x][1:v]paletteuse");
        command.add(gifName);
        return command;
    }

    private String generateGifName() {
        return new StringBuilder()
                .append(FilenameUtils.getBaseName(video.getFileName().toString()))
                .append(".gif").toString();
    }

}
