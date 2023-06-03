package edu.zhangmolei.zhangmolei.NDK;

public class zhangMoleiNDKJiami {
    static {
        System.loadLibrary("zmlencrypt");
    }
    public native String encodeInC(String word);

    public native String decodeInC(String word);

}
