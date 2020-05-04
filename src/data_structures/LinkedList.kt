package data_structures

data class Node(val i:Int, val prox:Node?)

fun sumTerms (n1:Node?):Int = if(n1==null) 0 else n1.i + sumTerms(n1.prox)

fun print(prim:Node?){
    if(prim!=null){
        print(prim.i)
        print(prim.prox)
    }
}