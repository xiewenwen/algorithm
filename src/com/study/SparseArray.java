package com.study;
/**
 * 稀疏数组
 *
 * */
public class SparseArray {
    public static void main(String[] args){
        //创建一个原始的二维数组 11*11
        //0表示 无  1表示黑  2表示蓝
        int chessArr1[][]=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        for(int[] row:chessArr1){
            for(int item:row){
                System.out.print(item);
            }
            System.out.println();
        }
        //////////////////////////
        //1.将二维数组循环遍历 得到有几个非0的值
        //sum为稀疏数组下值的个数
        int sum=0;
        for(int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //2.创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        //稀疏数组第一行
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二维数组 给稀疏数组赋值
        int count=0;//声明一个计数器 用于记录稀疏数组的行
        for(int i=0;i<chessArr1.length;i++){
            for (int j=0;j<chessArr1.length;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        //遍历打印稀疏数组
        for (int i=0;i<sparseArr.length;i++){
            for (int j=0;j<3;j++){
                System.out.print(sparseArr[i][j]);
            }
            System.out.println();
        }

        //稀疏数组转正二维数组
        //1.读取稀疏数组的第一行数据 可以创建得到二维数组的大小
        int hang=sparseArr[0][0];//=11
        int lie=sparseArr[0][1];//11
        int chassArr2[][]=new int[hang][lie];
        //2.稀疏数组下的值赋予
        for (int i=1;i<sparseArr.length;i++){
            chassArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //打印从稀疏数组中恢复的二维数组
        for(int[] row:chassArr2){
            for(int item:row){
                System.out.print(item);
            }
            System.out.println();
        }


    }
}
