package gitHomework;

import java.util.Scanner;

import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("==============================");
            System.out.println("欢迎使用密码管理系统");
            System.out.println("==============================");
            System.out.println("请选择操作：");
            System.out.println("1. 加密");
            System.out.println("2. 解密");
            System.out.println("3. 判断密码强度（第三周任务添加）");
            System.out.println("4. 密码生成（第三周任务添加）");
            System.out.println("5. 退出");
            System.out.print("请输入选项序号：");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("==============================");
                    System.out.println("请输入要加密的数字密码：");
                    String plaintext = scanner.next();
                    String encryptedText = encrypt(plaintext);
                    System.out.println("加密后的结果是：" + encryptedText);
                    System.out.println();
                    System.out.println("按任意键返回");
                    scanner.nextLine(); // 读取换行符

                    scanner.nextLine(); // 等待用户输入

                    break;
                case 2:
                    System.out.println("==============================");
                    System.out.println("请输入要解密的字符串：");
                    String ciphertext = scanner.next();
                    String decryptedText = decrypt(ciphertext);
                    System.out.println("解密后的结果是：" + decryptedText);
                    System.out.println();
                    System.out.println("按任意键返回");
                    scanner.nextLine(); // 读取换行符

                    scanner.nextLine(); // 等待用户输入

                    break;
                case 3:
                    System.out.println("==============================");
                    // TODO: 判断密码强度的代码

                    System.out.println("判断密码强度功能暂未实现");
                    System.out.println();
                    System.out.println("按任意键返回");
                    scanner.nextLine(); // 读取换行符

                    scanner.nextLine(); // 等待用户输入

                    break;
                case 4:
                    System.out.println("==============================");
                    // TODO: 密码生成的代码

                    System.out.println("密码生成功能暂未实现");
                    System.out.println();
                    System.out.println("按任意键返回");
                    scanner.nextLine(); // 读取换行符

                    scanner.nextLine(); // 等待用户输入

                    break;
                case 5:
                    System.out.println("感谢使用密码管理系统，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的选择！");
                    System.out.println();
                    System.out.println("按任意键返回");
                    scanner.nextLine(); // 读取换行符

                    scanner.nextLine(); // 等待用户输入

            }
        }
    }
    
    // 加密函数


    public static String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        
        // 将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3


        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int ascii = (int) c + i + 1 + 3;
            encryptedText.append((char) ascii);
        }
        
        // 将字符串的第一位和最后一位调换顺序


        if (encryptedText.length() > 1) {
            char firstChar = encryptedText.charAt(0);
            char lastChar = encryptedText.charAt(encryptedText.length() - 1);
            encryptedText.setCharAt(0, lastChar);
            encryptedText.setCharAt(encryptedText.length() - 1, firstChar);
        }
        
        // 将字符串反转


        encryptedText.reverse();
        
        return encryptedText.toString();
    }
    
    // 解密函数


    public static String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder(ciphertext);
        
        // 将字符串反转


        decryptedText.reverse();
        
        // 将字符串的第一位和最后一位调换顺序


        if (decryptedText.length() > 1) {
            char firstChar = decryptedText.charAt(0);
            char lastChar = decryptedText.charAt(decryptedText.length() - 1);
            decryptedText.setCharAt(0, lastChar);
            decryptedText.setCharAt(decryptedText.length() - 1, firstChar);
        }
        
        // 将每个字符的ASCII码减去它在字符串中的位置(1开始)和偏移值3


        for (int i = 0; i < decryptedText.length(); i++) {
            char c = decryptedText.charAt(i);
            int ascii = (int) c - i - 1 - 3;
            decryptedText.setCharAt(i, (char) ascii);
        }
        
        return decryptedText.toString();
    }
}
//新增注释