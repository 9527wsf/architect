package com.springboot.architecture.service;

import com.springboot.architecture.controller.allArchitecture.demo1.demo1;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MainProgramService implements ArchitectureService {

    @Override
    public String getDescription() {
        return "1. 主程序（Main Program）：" +
                "• 控制中心：主程序作为整个应用程序的入口点和控制中心，负责程序的整体流程控制，包括初始化、数据准备、调用子程序、处理子程序返回结果以及最终的清理工作。" +
                "• 协调者：主程序不直接处理复杂业务逻辑，而是通过调用相应的子程序来完成具体任务，扮演着协调和调度的角色。" +
                "2. 子程序（Subroutines）：" +
                "• 功能模块：子程序是完成特定功能的独立代码块，每个子程序通常聚焦于解决一个具体的编程问题或执行一项明确的任务。" +
                "• 可重用性：子程序设计的目标之一是通用性和可重用性，以便在多个上下文中调用，减少代码重复。" +
                "• 封装性：子程序通过参数传递接收输入数据，执行内部逻辑后通过返回值或全局变量（在某些语言中）向主程序返回结果，内部细节对外部隐藏，增强了代码的封装性。";
    }

    @Override
    public String getCodeExample() {
        return "关键函数:\n" +
                "public static void main(String[] args) {\n" +
                "    demo1 kwic = new demo1();\n" +
                "    kwic.input(\"E:\\\\input.txt\");\n" +
                "    kwic.shift();\n" +
                "    kwic.alphabetizer();\n" +
                "    kwic.output(\"E:\\\\output.txt\");\n" +
                "}";
    }

    public void runCode(File inputFile, File outputFile) {
        demo1 kwic = new demo1();

        // 调用 demo1 类的方法
        kwic.input(inputFile.getAbsolutePath());
        kwic.shift();
        kwic.alphabetizer();
        kwic.output(outputFile.getAbsolutePath());
    }

}
