package com.springboot.architecture.service;

import java.io.File;
import java.io.IOException;

public interface ArchitectureService {
    String getDescription();
    String getCodeExample();

    void runCode(File inputFile, File outputFile) throws IOException;
}
