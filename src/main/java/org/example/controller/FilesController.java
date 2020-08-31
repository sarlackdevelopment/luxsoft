package org.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.example.domain.Messages;
import org.example.repos.MessagesRepo;
import org.example.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String filesPage(Map<String, Object> model) {
        return "start";
    }

    @Autowired
    private FileService fileService;

    @Autowired
    MessagesRepo messagesRepo;

    @Autowired
    Messages messages;

    @PostMapping("/")
    public String addFiles(@RequestParam("file") MultipartFile file) throws IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            Map answer = fileService.readFile(uploadPath + "/" + resultFilename);
            if (answer.containsKey("Unknown")) {
                return "error";
            } else if (answer.containsKey("OK")) {
                ArrayList<HashMap<String, String>> info = (ArrayList<HashMap<String, String>>) answer.get("OK");
                messages.setPRIMARY_KEY(Long.parseLong(info.get(0).get("value")));
                messages.setNAME(info.get(1).get("value"));
                messages.setDESCRIPTION(info.get(2).get("value"));
                messages.setUPDATED_TIMESTAMP(info.get(3).get("value"));
                messagesRepo.save(messages);
                return "start";
            } else if (answer.containsKey("Not valid")) {
                return "error";
            }
        }

        return "start";
    }

}

