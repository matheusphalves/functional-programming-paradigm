package data_structures

//generic list
data class NodeList<T>(val info:T, val prox:NodeList<T>?){
    override  fun toString(): String {
        return info.toString() + " " + prox.toString()
    }
}

//01 - return the last element
fun <A>lastElemento(no:NodeList<A>?):A? {

    if(no!=null){
        if(no.prox==null){
            return no.info
        }
        else
            return lastElemento(no.prox)
    }else
        return null
}

fun <A>size(no:NodeList<A>?, c:Int):Int{
    if(no==null)
        return c
    else
        return size(no.prox, c +1)
}
//questão 2
fun <A>penultimoMelhorado(no:NodeList<A>?):A?{

    if(no!=null){
        if(no.prox!=null){
            if(no.prox.prox==null)
                return no.info
            else
                return penultimoMelhorado(no.prox)
        }else
            return no.info
    }else
        return null
}

//3 - find k-th element
fun <A> elementoK(no:NodeList<A>?, index:Int, c:Int):A?{
    if(no!=null){
        if(index==c)
            return no.info
        else
            return elementoK(no.prox, index, c + 1)
    }else
        return null
}

//5 - invert list
fun <A>inverter(no:NodeList<A>?, noAux:NodeList<A>?):NodeList<A>?{

    if(no!=null){
        if(no.prox==null)
            return NodeList(no.info, noAux)//elemento final da lista
        else
            return inverter(no.prox, NodeList(no.info, noAux))
    }else
        return null
}

//6 - is palindrome?
fun <A>palindromo(no:NodeList<A>?):Boolean{

    if(no!=null){
        return no.equals(inverter(no, null))

    }else
        return false
}

//7 - flatten list
fun <T> achatar(nozao:NodeList<NodeList<T>>?, no:NodeList<T>?):NodeList<T>?{ //nós de nós e nó com os elementos

    if(nozao!=null){
        if(nozao.prox==null) { //ainda devem existir ramos principais
            return juntaNo(nozao.info, no) //juntar ultima fileira com os nós concatenados
        } else
            return achatar(nozao.prox, juntaNo(nozao.info, no))
        //junta elementos da fileira de nós atual
    }else
        return null
}

//8 - concatenate list
fun <T> juntaNo(no1:NodeList<T>?, no2:NodeList<T>?):NodeList<T>?{

    if(no1!=null){

        if(no1.prox==null)
            return NodeList(no1.info, no2)
        else
            return NodeList(no1.info, juntaNo(no1.prox, no2))
    }else
        return null
}


fun main(args:Array<String>):Unit{


    val a:NodeList<Int> = NodeList(1, null)
    val b:NodeList<Int> = NodeList(2, NodeList(3, null))
    val c:NodeList<Int> = NodeList(4, NodeList(5, null))

    //lista onde cada elemento é outra lista
    val listaDeLista:NodeList<NodeList<Int>> = NodeList(a, NodeList(b, NodeList(c, null)))

    println(achatar(listaDeLista, null))

    val test = NodeList(1, NodeList(3, NodeList(56, null)))
    val test2 = NodeList(1, NodeList(2, NodeList(3, null)))

}