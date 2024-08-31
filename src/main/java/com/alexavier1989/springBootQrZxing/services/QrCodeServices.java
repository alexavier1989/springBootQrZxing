package com.alexavier1989.springBootQrZxing.services;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;


public interface QrCodeServices {
    BufferedImage generateQrCode(String text, int width, int height) throws WriterException;
}
