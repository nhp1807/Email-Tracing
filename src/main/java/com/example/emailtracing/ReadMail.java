package com.example.emailtracing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadMail {
    /**
     * this method reads the email and password from the file and returns a map
     * @param path: the path to the file containing the email and password
     * @return: a map containing the email and password
     */
    public static Map<String, String> emailAndPass(String path){
        Map<String, String> emailAndPasswords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Phân tách dữ liệu dựa vào dấu phẩy và dấu chấm phẩy
                String[] parts = line.split(",");
                if (parts.length > 1) { // Kiểm tra dòng đó có chứa dữ liệu hợp lệ
                    String email = parts[0].trim(); // Lấy email, loại bỏ khoảng trắng
                    String password = parts[1].trim().replace(";", ""); // Lấy password, loại bỏ khoảng trắng và dấu chấm phẩy
                    emailAndPasswords.put(email, password); // Thêm vào HashMap
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailAndPasswords;
    }
}
