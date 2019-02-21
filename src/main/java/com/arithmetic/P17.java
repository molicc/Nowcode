package com.arithmetic;
/**
 * Created by Administrator on 2019/2/20.
 *
 * @author Administrator
 */

import java.util.LinkedList;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @className P17
 * @description TODO
 * @autor Administrator
 * @date 2019/2/20 15:08
 **/
public class P17 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(5);
        // TreeNode treeNode8 = new TreeNode(3);
        // TreeNode treeNode9 = new TreeNode(4);
        // TreeNode treeNode10 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode6.right = treeNode7;
        // treeNode6.right = treeNode8;
        Solution17 solution17 = new Solution17();
        boolean b = solution17.HasSubtree(treeNode1, treeNode6);
        System.out.println(b);
    }
}

class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        LinkedList treeNodes1 = new <TreeNode>LinkedList();
        LinkedList treeNodes2 = new <TreeNode>LinkedList();
        LinkedList tempNodes = null;
        treeNodes1.offer(root1);
        treeNodes2.offer(root2);
        boolean flag = false;
        while (treeNodes1.size() != 0 && treeNodes2.size() != 0) {
            TreeNode node1 = (TreeNode) treeNodes1.poll();
            TreeNode node2 = (TreeNode) treeNodes2.peek();
            tempNodes=treeNodes1;
            if (node1.val == node2.val) {
                treeNodes2.poll();
                if (node2.left != null) {
                    treeNodes2.offer(node2.left);
                }
                if (node2.right != null) {
                    treeNodes2.offer(node2.right);
                }
                if (node1.left != null) {
                    treeNodes1.offer(node1.left);
                }
                if (node1.right != null) {
                    treeNodes1.offer(node1.right);
                }

                flag = true;
                continue;
            }
            treeNodes1=tempNodes;
            node1= (TreeNode) treeNodes1.peek();
            treeNodes1.offer(node1.left);
            treeNodes1.offer(node1.right);
            flag = false;
            treeNodes2.clear();
            treeNodes2.offer(root2);
        }
        if (flag == true && treeNodes2.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}