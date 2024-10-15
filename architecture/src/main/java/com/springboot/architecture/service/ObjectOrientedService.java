package com.springboot.architecture.service;

import com.springboot.architecture.controller.allArchitecture.demo1.demo2.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ObjectOrientedService implements ArchitectureService{

    @Override
    public String getDescription() {
        return "在面向对象体系结构中，软件工程的模块化、信息隐藏、抽象和重用原则得到了充分的体现。" +
                "在这种体系结构中，数据表示和相关原语操作都被封装在抽象数据类型中。" +
                "在这种风格中，对象是构件，也成为抽象数据类型的实例。" +
                "对象与对象之间，通过函数调用和过程调用来进行交互。";
    }

    @Override
    public String getCodeExample() {
        return "关键函数:\n" +
                "public static void main(String[] args) {\n" +
                "    Input input = new Input();\n" +
                "    input.input(\"E:\\\\input.txt\");\n" +
                "    Shift shift = new Shift(input.getLineTxt());\n" +
                "    shift.shift();\n" +
                "    Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "    alphabetizer.sort();\n" +
                "    Output output = new Output(alphabetizer.getKwicList());\n" +
                "    output.output(\"E:\\\\output.txt\");\n" +
                "}";
    }
    public void runCode(File inputFile, File outputFile) throws IOException {
        // 创建 Input 对象并读取输入文件
        Input input = new Input();
        input.input(inputFile.getAbsolutePath());

        // 创建 Shift 对象并进行位移操作
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();

        // 创建 Alphabetizer 对象并进行排序
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();

        // 创建 Output 对象并输出结果到文件
        Output output = new Output(alphabetizer.getKwicList());
        output.output(outputFile.getAbsolutePath());
    }
}
