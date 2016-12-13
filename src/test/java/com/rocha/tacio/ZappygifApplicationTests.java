package com.rocha.tacio;

import com.rocha.tacio.ffmpeg.FFmpeg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Path;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZappygifApplicationTests {


    @Autowired
    private FFmpeg fFmpeg;

	@Test
	public void contextLoads() {
	}

	@Test
	public void convertTest() throws IOException, InterruptedException {
//		Path gif = fFmpeg.convert("/Users/tacio/dev/repos/gif/video.mov");
		Path gif2 = fFmpeg.convert("/Users/tacio/Desktop/IMG_0648.MOV.m4v");
	}

}
