package se331.project.projectTwoCompo.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.util.CloudStorageHelper;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorangHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file)
            throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorangHelper.getImageUrl(file, "drowninworkbn.appspot.com"));
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestParam(value = "image") MultipartFile file) throws IOException, ServletException{
        return
        ResponseEntity.ok(this.cloudStorangHelper.getStorageFileDto(file, "drowninworkbn.appspot.com"));
    }
}
