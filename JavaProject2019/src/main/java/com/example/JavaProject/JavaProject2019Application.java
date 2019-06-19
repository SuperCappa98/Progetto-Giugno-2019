package com.example.JavaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.JavaProject.SviluppoDati.*;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class JavaProject2019Application {

	public static void main(String[] args) {
		DownloadCSV.main(args);
		SpringApplication.run(JavaProject2019Application.class, args);
	}

}



