package data_structures

data class BinaryNode(val value:Int, val left:BinaryNode?, val right:BinaryNode?){}

fun maior(root:BinaryNode?):BinaryNode?{

    if(root!=null){

        if(root.right==null){
            return root
        }else{
            return maior(root.right)
        }
    }else
        return null
}
fun main(args:Array<String>):Unit{

    val tree = BinaryNode(3, BinaryNode(2, null, null), BinaryNode(4, null, BinaryNode(6, null, null)))
    println(maior(tree))

}