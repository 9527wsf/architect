package com.springboot.architecture.service;

import com.springboot.architecture.controller.allArchitecture.demo1.demo3.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EventDrivenService implements ArchitectureService{

    @Override
    public String getDescription() {
        return "事件驱动就是在当前系统的基础之上，根据事件声明和发展状况来驱动整个应用程序运行。"+
                "事件驱动体系结构的基本思想是：系统对外部的行为表现可以通过它对事件的处理来实现。" +
                "在这种体系结构中，构件不再直接调用过程，而是声明事件。" +
                "系统其他构件的过程可以在这些事件中进行注册。当触发一个事件的时候，系统会自动调用这个事件中注册的所有过程。" +
                "因此，触发一个事件会引起其他构件的过程调用。";
    }

    @Override
    public String getCodeExample() {
        return "关键函数:\n" +
                "public static void main(String[] args) {\n" +
                "    //创建主题\n" +
                "    KWICSubject kwicSubject = new KWICSubject();\n" +
                "    //创建观察者\n" +
                "    Input input = new Input(\"E:\\\\input.txt\");\n" +
                "    Shift shift = new Shift(input.getLineTxt());\n" +
                "    Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "    Output output = new Output(alphabetizer.getKwicList(), \"E:\\\\output.txt\");\n" +
                "    // 将观察者加入主题\n" +
                "    kwicSubject.addObserver(input);\n" +
                "    kwicSubject.addObserver(shift);\n" +
                "    kwicSubject.addObserver(alphabetizer);\n" +
                "    kwicSubject.addObserver(output);\n" +
                "    // 逐步调用各个观察者\n" +
                "    kwicSubject.startKWIC();\n" +
                "}";
    }

    public void runCode(File inputFile, File outputFile) throws IOException {
        // 创建输入观察者
        Input inputObserver = new Input(inputFile.getAbsolutePath());

        // 创建Shift观察者，传入Input的文本
        Shift shiftObserver = new Shift(inputObserver.getLineTxt());

        // 创建Alphabetizer观察者，传入Shift的结果
        Alphabetizer alphabetizerObserver = new Alphabetizer(shiftObserver.getKwicList());

        // 创建输出观察者，传入Alphabetizer的结果
        Output outputObserver = new Output(alphabetizerObserver.getKwicList(), outputFile.getAbsolutePath());

        // 创建KWIC主题并添加观察者
        KWICSubject kwicSubject = new KWICSubject();
        kwicSubject.addObserver(inputObserver);
        kwicSubject.addObserver(shiftObserver);
        kwicSubject.addObserver(alphabetizerObserver);
        kwicSubject.addObserver(outputObserver);

        // 启动KWIC处理
        kwicSubject.startKWIC();
    }

}
