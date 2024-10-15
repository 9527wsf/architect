package com.springboot.architecture.service;

import com.springboot.architecture.controller.allArchitecture.demo1.demo4.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PipeAndFilterService implements ArchitectureService{

    @Override
    public String getDescription() {
        return "主要包括过滤器和管道两种元素。" +
                "在这种结构中，构件被称为过滤器，负责对数据进行加工处理。" +
                "每个过滤器都有一组输入端口和输出端口，从输入端口接收数据，经过内部加工处理之后，传送到输出端口上。" +
                "数据通过相邻过滤器之间的连接件进行传输，连接件可以看作输入数据流和输出数据流之间的通路，这就是管道。";
    }

    @Override
    public String getCodeExample() {
        return "关键函数:\n" +
                "public static void main(String[] args) throws IOException {\n" +
                "    File inFile = new File(\"E:\\\\input.txt\");\n" +
                "    File outFile = new File(\"E:\\\\output.txt\");\n" +
                "    Pipe pipe1 = new Pipe();\n" +
                "    Pipe pipe2 = new Pipe();\n" +
                "    Pipe pipe3 = new Pipe();\n" +
                "    Input input = new Input(inFile, pipe1);\n" +
                "    Shift shift = new Shift(pipe1, pipe2);\n" +
                "    Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\n" +
                "    Output output = new Output(outFile, pipe3);\n" +
                "    input.transform();\n" +
                "    shift.transform();\n" +
                "    alphabetizer.transform();\n" +
                "    output.transform();\n" +
                "}";
    }

    public void runCode(File inputFile, File outputFile) throws IOException {
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inputFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outputFile, pipe3);

        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
    }
}
