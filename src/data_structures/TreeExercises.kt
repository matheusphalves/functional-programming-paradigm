package data_structures

import com.sun.source.tree.Tree

//01. Find the bigger value
fun bigger(root:BinaryNode?):BinaryNode?{

    if(root!=null){

        if(root.right==null){
            return root
        }else{
            return bigger(root.right)
        }
    }else
        return null
}


//02. Find a specific node value
fun findBin(no:BinaryNode?, valor:Int):BinaryNode?{
    if(no==null)
        return null//nó não encontrado
    else if(no.value==valor){
        return no
    }else if(valor>no.value)
        return findBin(no.right, valor)
    else
        return findBin(no.left, valor)
}


//03. Calculate how many values exists
fun TreeSize(root:BinaryNode?):Int{
    if(root==null){
        return 0
    }else{
        return  1 + TreeSize(root.left) + TreeSize(root.right)
    }
}




fun main(args:Array<String>):Unit{

    val tree = BinaryNode(3, BinaryNode(2, BinaryNode(1,null,null), null), BinaryNode(4, null, BinaryNode(6, null, null)))
    println(bigger(tree))
    println(TreeSize(tree))

}