package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

/**
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *@className P2
 *@description TODO
 *@autor Administrator
 *@date 2019/2/16 17:34
 **/
public class P2 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("I LOVE CODING");
        Solution2 solution = new Solution2();
        String s = solution.replaceSpace1(stringBuffer);
        System.out.println(s);
    }
}

class Solution2 {
    /**
     * 不开辟新空间，从后往前替换，避免移动次数过多
     * @param str
     * @return
     */
    public String replaceSpace1(StringBuffer str) {
        //spacenum为计算空格数
        int spacenum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spacenum++;
            }
        }

        //indexold为为替换前的str下标
        int indexold = str.length()-1;
        //计算空格转换成%20之后的str长度
        int newlength = str.length() + spacenum*2;
        //indexold为为把空格替换为%20后的str下标
        int indexnew = newlength-1;
        //使str的长度扩大到转换成%20之后的长度,防止下标越界
        str.setLength(newlength);
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    /**
     * 新开辟空间进行替换复制
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str) {
        if (str==null){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                stringBuffer.append('%');
                stringBuffer.append('2');
                stringBuffer.append('0');
            }else {
                stringBuffer.append(str.charAt(i));
            }

        }
        return stringBuffer.toString();

    }
}