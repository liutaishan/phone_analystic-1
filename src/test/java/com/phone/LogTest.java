package com.phone;

import com.phone.etl.ip.LogUtil;

/**
 * @ClassName LogTest
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description //TODO $
 **/
public class LogTest {
    public static void main(String[] args) {
        System.out.println(LogUtil.parserLog("58.59.132.227^A1535532300.980^A221.13.21.192^A/shopping.jsp?c_time=1535530816980&oid=123459&u_mid=1c6c39fe-fe6f-4fa6-a417-819021ea60af&pl=java_server&en=e_cs&sdk=jdk&ver=1"));
        System.out.println(LogUtil.parserLog("119.31.192.11^A1535530827.901^A119.31.192.11^A/qf.png?en=e_l&ver=1&pl=website&sdk=js&u_ud=0DCFADBE-375A-4AED-AF7C-C95A7FE975B4&u_sd=AD5BCC19-2067-4E22-B163-CC8EA8DAF0D4&c_time=1535616633889&b_iev=Mozilla%2F4.0%20(compatible%3B%20MSIE%208.0%3B%20Windows%20NT%206.1%3B%20Win64%3B%20x64%3B%20Trident%2F4.0%3B%20.NET%20CLR%202.0.50727%3B%20SLCC2%3B%20.NET%20CLR%203.5.30729%3B%20.NET%20CLR%203.0.30729%3B%20Media%20Center%20PC%206.0%3B%20.NET4.0C%3B%20.NET4.0E)&b_rst=1600*900"));
    }
}