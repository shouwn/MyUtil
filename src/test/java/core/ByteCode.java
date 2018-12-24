package core;

// 바이트 코드 보는 명령어 javap - c
public class ByteCode {

    public static void main(String[] args){
        test();
    }

    public static void test(){
        test2();
    }

    public static void test2(){
        try{
            throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){ // Exception table 로 catch 하게 됨
            throw new IllegalArgumentException();
        }
    }
}
