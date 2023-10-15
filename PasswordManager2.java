package gitHomework2;

import java.util.Scanner;

public class PasswordManager2 {
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
                System.out.println("请输入要判断强度的密码：");
                String password = scanner.next();
                int strength = checkPasswordStrength(password);
                System.out.println("密码强度为：" + strength);
                System.out.println();
                System.out.println("按任意键返回");
                scanner.nextLine(); // 读取换行符

                scanner.nextLine(); // 等待用户输入

                break;
            case 4:
                System.out.println("==============================");
                System.out.println("请输入要生成密码的长度：");
                int length = scanner.nextInt();
                String generatedPassword = generatePassword(length);
                System.out.println("生成的密码为：" + generatedPassword);
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

/**
 * 对输入的数字密码进行加密

 * @param plaintext 要加密的数字密码

 * @return 加密后的字符串

 */
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

/**
 * 对输入的字符串进行解密

 * @param ciphertext 要解密的字符串

 * @return 解密后的数字密码

 */
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

// 判断密码强度函数

/**
 * 判断输入的密码强度

 * @param password 要判断强度的密码

 * @return 密码强度级别，返回值为1、2、3分别代表弱、中、强

 */
public static int checkPasswordStrength(String password) {
    // TODO: 实现判断密码强度的逻辑

    int strength = 0;
    // 根据密码的复杂程度进行评估，可以根据具体需求添加判断条件

    if (password.length() >= 8) {
        strength++;
    }
    if (password.matches(".*[a-z]+.*")) {
        strength++;
    }
    if (password.matches(".*[A-Z]+.*")) {
        strength++;
    }
    if (password.matches(".*\\d+.*")) {
        strength++;
    }
    if (password.matches(".*[@#$%^&+=]+.*")) {
        strength++;
    }
    return strength;
}

// 密码生成函数

/**
 * 生成指定长度的随机密码

 * @param length 密码长度

 * @return 生成的随机密码

 */
public static String generatePassword(int length) {
    // TODO: 实现密码生成的逻辑

    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    StringBuilder password = new StringBuilder();
    for (int i = 0; i < length; i++) {
        int index = (int) (Math.random() * characters.length());
        password.append(characters.charAt(index));
    }
    return password.toString();
}
}
