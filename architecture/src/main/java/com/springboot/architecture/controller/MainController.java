package com.springboot.architecture.controller;

import com.springboot.architecture.service.ArchitectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class MainController {
    @Autowired
    private ArchitectureService mainProgramService;

    @Autowired
    private ArchitectureService objectOrientedService;

    @Autowired
    private ArchitectureService eventDrivenService;

    @Autowired
    private ArchitectureService pipeAndFilterService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/main-program")
    public String mainProgram(Model model) {
        model.addAttribute("description", mainProgramService.getDescription());
        model.addAttribute("codeExample", mainProgramService.getCodeExample());
        return "main_program";
    }

    @GetMapping("/object-oriented")
    public String objectOriented(Model model) {
        model.addAttribute("description", objectOrientedService.getDescription());
        model.addAttribute("codeExample", objectOrientedService.getCodeExample());
        return "object_oriented";
    }

    @GetMapping("/event-driven")
    public String eventDriven(Model model) {
        model.addAttribute("description", eventDrivenService.getDescription());
        model.addAttribute("codeExample", eventDrivenService.getCodeExample());
        return "event_driven";
    }

    @GetMapping("/pipe-filter")
    public String pipeFilter(Model model) {
        model.addAttribute("description", pipeAndFilterService.getDescription());
        model.addAttribute("codeExample", pipeAndFilterService.getCodeExample());
        return "pipe_filter";
    }

    @GetMapping("/select-architecture")
    public String selectArchitecture(@RequestParam("architecture") String architecture) {
        switch (architecture) {
            case "main-program":
                return "redirect:/main-program";
            case "object-oriented":
                return "redirect:/object-oriented";
            case "event-driven":
                return "redirect:/event-driven";
            case "pipe-filter":
                return "redirect:/pipe-filter";
            default:
                return "redirect:/";
        }
    }

    @PostMapping("/run-pipe-filter")
    public String runPipeFilter(@RequestParam("inputFile") MultipartFile inputFile, Model model) {
        File outputFile = new File("E:\\output.txt"); // 输出文件路径

        try {
            // 将上传的文件保存到临时位置
            File tempInputFile = File.createTempFile("input-", ".txt");
            inputFile.transferTo(tempInputFile); // 保存上传的文件

            // 调用 PipeFilterService 处理文件
            pipeAndFilterService.runCode(tempInputFile, outputFile);

            // 读取输出文件内容作为结果
            String result = new String(Files.readAllBytes(outputFile.toPath()));
            model.addAttribute("result", result);
            model.addAttribute("description", pipeAndFilterService.getDescription());
            model.addAttribute("codeExample", pipeAndFilterService.getCodeExample());

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "文件加载错误: " + e.getMessage());
        }

        return "pipe_filter"; // 返回结果显示页面
    }

    @PostMapping("/run-main-progra")
    public String runMainProgra(@RequestParam("inputFile") MultipartFile inputFile, Model model) {
        File outputFile = new File("E:\\output.txt"); // 输出文件路径

        try {
            // 将上传的文件保存到临时位置
            File tempInputFile = File.createTempFile("input-", ".txt");
            inputFile.transferTo(tempInputFile); // 保存上传的文件

            mainProgramService.runCode(tempInputFile, outputFile); // 调用服务处理逻辑

            // 读取输出文件内容作为结果
            String result = new String(Files.readAllBytes(outputFile.toPath()));
            model.addAttribute("result", result);
            model.addAttribute("description", pipeAndFilterService.getDescription());
            model.addAttribute("codeExample", pipeAndFilterService.getCodeExample());

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "文件加载错误: " + e.getMessage());
        }

        return "main_program"; // 返回处理结果页面
    }

    @PostMapping("/run-object-oriented")
    public String runObjectOriented(@RequestParam("inputFile") MultipartFile inputFile, Model model) {
        File outputFile = new File("E:\\output.txt"); // 输出文件路径

        try {
            // 将上传的文件保存到临时位置
            File tempInputFile = File.createTempFile("input-", ".txt");
            inputFile.transferTo(tempInputFile); // 保存上传的文件

            objectOrientedService.runCode(tempInputFile, outputFile); // 调用服务处理逻辑

            // 读取输出文件内容作为结果
            String result = new String(Files.readAllBytes(outputFile.toPath()));
            model.addAttribute("result", result);
            model.addAttribute("description", pipeAndFilterService.getDescription());
            model.addAttribute("codeExample", pipeAndFilterService.getCodeExample());

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "文件加载错误: " + e.getMessage());
        }

        return "object_oriented"; // 返回处理结果页面
    }

    @PostMapping("/run-event-driven")
    public String runEventDriven(@RequestParam("inputFile") MultipartFile inputFile, Model model) {
        File outputFile = new File("E:\\output.txt"); // 输出文件路径

        try {
            // 将上传的文件保存到临时位置
            File tempInputFile = File.createTempFile("input-", ".txt");
            inputFile.transferTo(tempInputFile); // 保存上传的文件

            eventDrivenService.runCode(tempInputFile, outputFile); // 调用服务处理逻辑

            // 读取输出文件内容作为结果
            String result = new String(Files.readAllBytes(outputFile.toPath()));
            model.addAttribute("result", result);
            model.addAttribute("description", pipeAndFilterService.getDescription());
            model.addAttribute("codeExample", pipeAndFilterService.getCodeExample());

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "文件加载错误: " + e.getMessage());
        }

        return "event_driven"; // 返回处理结果页面
    }
}
