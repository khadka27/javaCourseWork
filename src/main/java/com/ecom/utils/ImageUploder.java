package com.ecom.utils;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUploder {

	public class ImageUploader {
		public String saveImage(Part file, String path1, String path2) throws IOException {
			String fileName = file.getSubmittedFileName();
			InputStream fileContent = file.getInputStream();
			File dir1 = new File(path1);
			if (!dir1.exists()) {
				dir1.mkdirs();
			}
			File dir2 = new File(path2);
			if (!dir2.exists()) {
				dir2.mkdirs();
			}

			FileOutputStream outputStream = new FileOutputStream(path2 + fileName);

			outputStream.write(fileContent.readAllBytes());

			fileContent.close();
			outputStream.close();

			return path1 + fileName;
		}
	}

}
