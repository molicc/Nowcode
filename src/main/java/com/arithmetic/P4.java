package com.arithmetic;
/**
 * Created by Administrator on 2019/2/16.
 *
 * @author Administrator
 */

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @className P4
 * @description TODO
 * @autor Administrator
 * @date 2019/2/16 19:45
 **/
public class P4 {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        Solution4 solution4 = new Solution4();
        TreeNode treeNode = solution4.reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Solution4 {

    /**
     * 根据前序和中序遍历性质，找出分界点root，统计左右子树个数，然后进行递归处理
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = new TreeNode(pre[0]);
        dealBinaryTree(pre,in,treeNode);
        return treeNode;
    }
    public void dealBinaryTree(int[] pre,int[] in,TreeNode treeNode){
        if (pre.length!=1){
            int root = 0;
            int leftnum;
            int rightnum;
            for (int i = 0; i < in.length; i++) {
                if (in[i]==pre[0]){
                    root=i;
                }
            }
            leftnum=root;
            rightnum=in.length-root-1;

            if (leftnum>0){
                TreeNode treeNode1 = new TreeNode(pre[1]);
                treeNode.left=treeNode1;
                dealBinaryTree(Arrays.copyOfRange(pre,1,leftnum+1),Arrays.copyOfRange(in,0,root),treeNode1);
            }
            if (rightnum>0){
                TreeNode treeNode1 = new TreeNode(pre[leftnum+1]);
                treeNode.right=treeNode1;
                dealBinaryTree(Arrays.copyOfRange(pre,leftnum+1,pre.length),Arrays.copyOfRange(in,root+1,in.length),
                        treeNode1);
            }
        }
    }

}