package 密码管理系统;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String args []) throws ErrorException_1, ErrorException_2 {
    Inlet inlet = new Inlet();
    inlet.boundary();
    }
}
class Inlet{
    Scanner input = new Scanner(System.in);
    int erro = 0;
    public void  boundary() throws ErrorException_1, ErrorException_2 {                    //程序进入界面
        System.out.println("------------------------");
        System.out.println("欢迎使用密码管理系统");
        System.out.println("------------------------");
        System.out.println("请选择你的操作：");
        System.out.println("1. 加密");
        System.out.println("2. 解密");
        System.out.println("3. 判断密码强度");
        System.out.println("4. 密码生成");
        System.out.println("5. 退出");
        System.out.print("请输入选项序号：");
        int number = input.nextInt();
        try{
        ErrorException_1 error = new ErrorException_1();
        error.Error(number);
        }
        catch(ErrorException_1 e){
            e.printStackTrace();
            this.boundary();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        judge(number);   //通过用户输入数字跳转功能
    }
    public void judge(int sum) throws ErrorException_1, ErrorException_2 {      //判断输入数字并使用功能方法，以及循环
        if(sum == 1) {
            this.process();
            this.transition();
            this.boundary();
        }
        if(sum == 2){
            this.untie();
            this.transition();
            this.boundary();
        }
        if(sum == 3){
            this.evaluate();
            this.transition();
            this.boundary();
        }
        if(sum == 4){
            this.creat();
            this.transition();
            this.boundary();
        }
        if(sum == 5){
            System.out.println("退出成功");
        }
    }
    public void  process(){       //加密功能方法
        Scanner put = new Scanner(System.in);
        System.out.print("请输入要加密的密码：");
        String result = put.nextLine();
        char [] CharArry = result.toCharArray();
        int [] SumArry = new int[CharArry.length];   //将字符数组转换为整数数组
        ErrorException_3 Err = new ErrorException_3();
        try{
            Err.Error(CharArry.length);
        }
        catch(ErrorException_3 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < SumArry.length ;i++){    //将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
            SumArry[i] = CharArry[i] + 4 + i;
        }
        ErrorException_2 Error = new ErrorException_2();
        try{
            Error.Error(CharArry);
        }
        catch(ErrorException_2 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int sum = SumArry[0];                       //将字符串的第一位和最后一位调换顺序
            SumArry[0] = SumArry[SumArry.length - 1];
            SumArry[SumArry.length - 1] = sum;
            int a = 0;                                  //将字符串反转
            for (int i = SumArry.length - 1; i > a; i--) {
                sum = SumArry[a];
                SumArry[a] = SumArry[i];
                SumArry[i] = sum;
                a++;
            }
            for (int i = 0; i < CharArry.length; i++) {         //将整数数组转换为字符数组
                CharArry[i] = (char) SumArry[i];
            }
            System.out.print("加密后的结果是：" );
            System.out.println(CharArry);
        }

    public void untie(){            //解密功能方法
        Scanner put = new Scanner(System.in);
        System.out.print("请输入要解密的密码：");
        String result = put.nextLine();
        char [] CharArry = result.toCharArray();
        int [] SumArry = new int[CharArry.length];//将字符数组转换为整数数组
        ErrorException_3 Err = new ErrorException_3();
        try{
            Err.Error(CharArry.length);
        }
        catch(ErrorException_3 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < SumArry.length ;i++){
            SumArry[i] = CharArry[i];
        }
        ErrorException_2 Error = new ErrorException_2();
        try{
            Error.Error(CharArry);
        }
        catch(ErrorException_2 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int sum;                                        //将字符串反转
        int a = 0;
        for (int i = SumArry.length - 1; i > a; i--) {
            sum = SumArry[a];
            SumArry[a] = SumArry[i];
            SumArry[i] = sum;
            a++;
        }
        sum = SumArry[0];                            //将字符串的第一位和最后一位调换顺序
        SumArry[0] = SumArry[SumArry.length - 1];
        SumArry[SumArry.length - 1] = sum;
        for (int i = 0; i < CharArry.length; i++) {            //解决乱码
            CharArry[i] = (char) SumArry[i];
        }
        for(int i = 0; i < SumArry.length ;i++) {
            SumArry[i] = CharArry[i];
        }
        for(int i = 0; i < SumArry.length ;i++){     //将每个字符的ASCII码减上它在字符串中的位置(1开始)和偏移值3
            SumArry[i] = CharArry[i] -4 - i;
        }
        for (int i = 0; i < CharArry.length; i++) {
            CharArry[i] = (char) SumArry[i];
        }
        System.out.print("解密后的结果是：" );
        System.out.println(CharArry);
    }
    public void evaluate(){
        Scanner put = new Scanner(System.in);
        System.out.print("请输入要判断密码强度的密码：");
        String result = put.nextLine();
        char [] CharArry = result.toCharArray();
        int [] SumArry = new int[CharArry.length];       //将字符数组转换为整数数组
        ErrorException_3 Err = new ErrorException_3();
        try{
            Err.Error(CharArry.length);
        }
        catch(ErrorException_3 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < SumArry.length ;i++){
            SumArry[i] = CharArry[i];
        }
        ErrorException_2 Error = new ErrorException_2();
        try{
            Error.Error(CharArry);
        }
        catch(ErrorException_2 e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int capital;
        int sum;
        int lowerCase;
        capital = sum = lowerCase = 0;
        for(int i:SumArry){
            if(i >= 48 && i<= 57 && sum != 1){
                sum += 1;
            }
            if(i >= 'a' && i <= 'z' && lowerCase != 1){
                lowerCase += 1;
            }
            if(i >= 'A' && i <= 'Z' && capital != 1){
                capital += 1;
            }
        }
        if( sum == 1 && lowerCase == 0 && capital == 0 && CharArry.length > 8 ){
            System.out.println("该密码为弱强度");
        }
        if( sum == 0 && lowerCase == 1 && capital == 1 && CharArry.length > 8 ){
            System.out.println("该密码为弱强度");
        }
        if( sum == 0 && lowerCase == 0 && capital == 1 && CharArry.length > 8 ){
            System.out.println("该密码为弱强度");
        }
        if( sum == 0 && lowerCase == 1 && capital == 0 && CharArry.length > 8 ){
            System.out.println("该密码为弱强度");
        }
        if(CharArry.length < 8){
            System.out.println("该密码为弱强度");
        }
        if( sum == 1 && lowerCase == 1 && capital == 0 && CharArry.length > 8 ){
            System.out.println("该密码为中强度");
        }
        if( sum == 1 && lowerCase == 0 && capital == 1 && CharArry.length > 8 ){
            System.out.println("该密码为中强度");
        }
        if( sum == 1 && lowerCase == 1 && capital == 1 && CharArry.length > 8 ){
            System.out.println("该密码为高强度");
        }
    }
    public void creat(){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.print("请输入设定密码长度（至少8位）:");
        int length = input.nextInt();
        ErrorException_4 Error = new ErrorException_4();
        try{
            Error.Error(length);
        }
        catch(ErrorException_4 e){
            e.printStackTrace();
        }
        int sum,capital,lowerCase;
        sum = capital = lowerCase = 0;
        while((sum + capital + lowerCase) != length && sum == 0 && capital == 0 && lowerCase == 0){
            sum = random.nextInt(length - 1) + 1;
            capital = random.nextInt(length - 1) + 1;
            lowerCase = random.nextInt(length - 1) + 1;
        }
        int sumRandom = random.nextInt(9) + 48;
        int capitalRandom = random.nextInt(25) + 65;
        int lowerCaseRandom = random.nextInt(25) + 97;
        int SumArry [] = new int[length];
        char CharArry[] = new char[length];
        int a,b,c;
        a = b = c = 1;
        for(int i = 0 ;i < length ;i++) {
            if ((a + b + c) == 3) {
                int judge = random.nextInt(3);
                if (judge == 0) {
                    SumArry[i] = sumRandom;
                    sum--;
                    sumRandom = random.nextInt(9) + 48;
                    if (sum == 0) {
                        a = 0;
                    }
                }
                if (judge == 1) {
                    SumArry[i] = capitalRandom;
                    capital--;
                    capitalRandom = random.nextInt(25) + 65;
                    if (capital == 0) {
                        b = 0;
                    }
                }
                if (judge == 2) {
                    SumArry[i] = lowerCaseRandom;
                    lowerCase--;
                    lowerCaseRandom = random.nextInt(25) + 97;
                    if (lowerCase == 0) {
                        c = 0;
                    }
                }
            }
            if (a == 0 && b == 1 && c == 1) {
                int judge = random.nextInt(2);
                if (judge == 0) {
                    SumArry[i] = capitalRandom;
                    capital--;
                    capitalRandom = random.nextInt(25) + 65;
                    if (capital == 0) {
                        b = 0;
                    }
                }
                if (judge == 1) {
                    SumArry[i] = lowerCaseRandom;
                    lowerCase--;
                    lowerCaseRandom = random.nextInt(25) + 97;
                    if (lowerCase == 0) {
                        c = 0;
                    }
                }
            }
            if (a == 1 && b == 0 && c == 1) {
                int judge = random.nextInt(2);
                if (judge == 0) {
                    SumArry[i] = sumRandom;
                    sum--;
                    sumRandom = random.nextInt(9) + 48;
                    if (sum == 0) {
                        a = 0;
                    }
                }
                if (judge == 1) {
                    SumArry[i] = lowerCaseRandom;
                    lowerCase--;
                    lowerCaseRandom = random.nextInt(25) + 97;
                    if (lowerCase == 0) {
                        c = 0;
                    }
                }
            }
            if (a == 1 && b == 1 && c == 0) {
                int judge = random.nextInt(2);
                if (judge == 0) {
                    SumArry[i] = sumRandom;
                    sum--;
                    sumRandom = random.nextInt(9) + 48;
                    if (sum == 0) {
                        a = 0;
                    }
                }
                if (judge == 1) {
                    SumArry[i] = capitalRandom;
                    capital--;
                    capitalRandom = random.nextInt(25) + 65;
                    if (capital == 0) {
                        b = 0;
                    }
                }
            }
            if (a == 1 && b == 0 && c == 0) {
                SumArry[i] = sumRandom;
                sum--;
                sumRandom = random.nextInt(9) + 48;
                if (sum == 0) {
                    a = 0;
                }
            }
            if (a == 0 && b == 1 && c == 0) {
                SumArry[i] = capitalRandom;
                capital--;
                capitalRandom = random.nextInt(25) + 65;
                if (capital == 0) {
                    b = 0;
                }
            }
            if (a == 0 && b == 0 && c == 1) {
                SumArry[i] = lowerCaseRandom;
                lowerCase--;
                lowerCaseRandom = random.nextInt(25) + 97;
                if (lowerCase == 0) {
                    c = 0;
                }
            }
        }
        for (int i = 0; i < CharArry.length; i++) {         //将整数数组转换为字符数组
            CharArry[i] = (char) SumArry[i];
        }
        System.out.print("密码生成:");
        System.out.println(CharArry);
        if(erro == 0) {
            System.out.println("第一次可能会出现错误，请再重复一次");
            erro ++;
        }
    }
    public void transition()  {            //任意键返回方法
        System.out.println("按任意键返回(需要回车)");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class ErrorException_1 extends  Exception{
    public ErrorException_1(){
        super("超过菜单选项范围");
    }
    public void Error(int cause)throws Exception{
            if (cause <= 0 || cause > 5) {
                throw new ErrorException_1();
            }
        }
}
class ErrorException_2 extends Exception{
    public ErrorException_2(){
        super("输入的非法密码,字符中含有其它字符");
    }
    public void Error(char SumArry [])throws Exception{
        char CharArry [] = SumArry;
        String str = String.valueOf(CharArry);
        if(!str.matches("\\p{Alnum}{8,16}")) {
            throw new ErrorException_2();
        }
    }
}
class ErrorException_3 extends Exception {
    public ErrorException_3() {
        super("输入的非法密码,长度不符合要求");
    }
    public void Error(int length)throws ErrorException_3{
        if(length > 16){
            throw new ErrorException_3();
        }
    }
}
class ErrorException_4 extends Exception{
    public ErrorException_4(){
        super("输入的密码长度不符合高强度密码要求或者超过范围");
}
    public void Error(int length)throws ErrorException_4{
        if(length > 16 || length < 8) {
            throw new ErrorException_4();
        }
    }
}