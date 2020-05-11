package data_structures

data class Node(val info:Int, val prox:Node?)

    fun add(base:Node?, valor:Int):Node?{
        if(base!=null){
            if(base.prox==null)
                return Node(base.info, Node(valor, null))
            else
                return Node(base.info, add(base.prox, valor))
        }else
            return null
    }

    //remove
    fun remove(no:Node?, valor:Int):Node?{
        if(no!=null){
            if(no.info==valor) //caso seja o primeiro item da lista
                return no.prox
            else
                return Node(no.info, remove(no.prox, valor))
        }else
            return null
    }

    //Contains
    fun contains(no:Node?, c:Int):Boolean{
        if(no==null)
            return false
        else if(no.info==c)
            return true
        else
            return contains(no.prox, c)
    }

    fun print(prim:Node?){
        if(prim!=null){
            print(prim.info)
            print(prim.prox)
        }
    }

    //size
    fun size(no:Node?, c:Int):Int{
        if(no==null)
            return c
        else
            return size(no.prox, c +1)
    }

    fun removeIndex(no:Node?, index:Int):Node?{
        return removeByIndex(no, index, 0)
    }

    fun removeByIndex(no:Node?, index:Int, c:Int):Node?{

        if(no!=null){
            if(c==index)
                return remove(no, no.info)
            else
                return Node(no.info, removeByIndex(no.prox, index, c +1))
        }else
            return null
    }










