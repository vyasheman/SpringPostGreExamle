package com.vyas.hemant.SpringPostGreExamle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController
{
  private static String UPLOADED_FOLDER = "c://temp//";

  @GetMapping({"/"})
  public String index() {
    return "upload";
  }

  @PostMapping({"/upload"})
  public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
  {
    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
      return "redirect:uploadStatus";
    }

    try
    {
      byte[] bytes = file.getBytes();
      Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename(), new String[0]);
      Files.write(path, bytes, new OpenOption[0]);

      redirectAttributes.addFlashAttribute("message", 
        "You successfully uploaded '" + file.getOriginalFilename() + "'");
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return "redirect:/uploadStatus";
  }

  @GetMapping({"/uploadStatus"})
  public String uploadStatus() {
    return "uploadStatus";
  }
}