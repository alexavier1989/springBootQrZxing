package com.alexavier1989.springBootQrZxing.controller;

import com.alexavier1989.springBootQrZxing.services.QrCodeServices;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/v1/")
public class QrCodeCrontroller {

    @Autowired(required = true)
    private QrCodeServices qrCodeService;

    @GetMapping("/qrcode")
    public void generateNewQrCode( HttpServletResponse response,
                                   @RequestParam String text,
                                   @RequestParam(defaultValue = "350") int width,
                                   @RequestParam(defaultValue = "350") int height ) throws Exception {
        BufferedImage image = qrCodeService.generateQrCode(text, width, height);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"png", outputStream );
        outputStream.flush();
        outputStream.close();
    }
}
