//
// Created by 张沫雷 on 2022/12/17.
//

#include <jni.h>
#include <stdlib.h>
#include <stdio.h>

/**
 * 把一个jstring转换成一个c语言的char* 类型.
 */
char *_JString2CStr(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env, "GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)");
    jbyteArray barr = (jbyteArray) (*env)->CallObjectMethod(env, jstr, mid,strencode);
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba, 0);
    return rtn;
}

JNIEXPORT jstring JNICALL Java_com_fly_demo5_JNI_encodeInC(JNIEnv *env, jobject clazz, jstring jstr) {
    char *cstr = _JString2CStr(env, jstr);
    int length = strlen(cstr);
    int i;
    for (i = 0; i < length; i++) {
        *(cstr + i) += 2;
    }
    return (*env)->NewStringUTF(env, cstr);
}


JNIEXPORT jstring JNICALL Java_com_fly_demo5_JNI_decodeInC(JNIEnv *env, jobject clazz, jstring jstr) {
    char *cstr = _JString2CStr(env, jstr);
    int length = strlen(cstr);
    int i;
    for (i = 0; i < length; i++) {
        *(cstr + i) -= 2;
    }
    return (*env)->NewStringUTF(env, cstr);
}
