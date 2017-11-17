/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author Kleberth
 * @param <E>
 */
public class SimpleLinkedList<E> implements List<E> {
    private Nodo<E> first, last;
    private int efectivo;

    public SimpleLinkedList(){
        this.first = this.last = null;
        this.efectivo = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.first==null && this.last==null;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        Nodo <E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if(this.isEmpty()){
            this.first = this.last = nodo;
        }
         else{
             nodo.setNext(this.first);
             this.first = nodo;
        }
        this.efectivo ++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo <E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if(this.isEmpty()){
            this.first = this.last = nodo;
        }
         else{
             this.last.setNext(nodo);
             this.last = nodo;
        }
        this.efectivo ++;
        return true;
    }

    @Override
    public E getFirst() {
        if(this.isEmpty())
            return null;
        return this.first.getData();
    }

    @Override
    public E getLast() {
        if(this.isEmpty())
            return null;
        return this.last.getData();
    }

    @Override
    public boolean removeFirst() {
        if(this.isEmpty())
            return false;
        else if(this.first==this.last)
                this.first = this.last = null;
        else{
            Nodo<E> tmp = this.first;
            this.first = this.first.getNext();
            tmp.setNext(null);
        }
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty())
            return false;
        else if(this.first==this.last)
                this.first = this.last = null;
        else{
            Nodo<E> tmp = this.getPrevious(last);
            this.last = tmp;
            tmp.setNext(null);
        }
        return true;
    }
    
    private Nodo<E> getPrevious(Nodo<E> nodo){
        for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
            if(p.getNext()==nodo)
                return p;
        }
        return null;
    }

    @Override
    public boolean contains(E element) {
        for(Nodo<E> p = this.first; p != null; p = p.getNext()){
            if (p.getData().equals(element)){
                return true;
            }            
        }        
        return false; 
    }

    @Override
    public E get(int index){
        Nodo<E> p = findNodo(index);
        if(p!=null) {
            return p.getData();
        }
        return null;
    }
    
    private Nodo<E> findNodo(int index) {
        int cont = 0;
        for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
            if(cont==index){
                return p;
            }
            cont++;
        }
        return null;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        List<E> newLinked = new SimpleLinkedList();
        if(inicio>=0 && inicio<=fin){
            for(int i=inicio; i<=fin; i++){
                newLinked.addLast(this.get(i));
            }
            return newLinked;
            }
        return null;
        }
    
    @Override
    public String toString(){
        String str = "[";
        for (Nodo<E> p=this.first; p!=null; p=p.getNext()) {
            str += p.getData() + ",";
        }
        str = str.substring(0, str.length()-1)+"]";
        return str;
    }

    @Override
    public boolean remove(int index) {
        if(this.isEmpty())
            return false;
        else if(this.first==this.last)
                this.first = this.last = null;
        else{
            int cont = 0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    Nodo<E> nodo = this.getPrevious(p);
                    nodo.setNext(p.getNext());
                    p.setNext(null);
                }
                cont++;
            }
        }
        this.efectivo --;
        return true;
    }

    @Override
    public E set(int index, E element) {
        int cont = 0;
        Nodo<E> nodo = new Nodo(0);
        for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    nodo.setData(p.getData());
                    p.setData(element);
                }
                cont++;
            }
        return nodo.getData();
    }

    @Override
    public boolean add(int index, E element) {
        Nodo <E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if(this.isEmpty()){
            this.first = this.last = nodo;
        }
         else{
            int cont = 0;
             for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    this.getPrevious(p).setNext(nodo);
                    nodo.setNext(p);
                }
                cont++;
            }
        }
        this.efectivo ++;
        return true;
    }

    @Override
    public int indexOf(E element) {
        if(element!=null && this.contains(element)){
            int index = 0;
            Nodo<E> nodo = this.first;
            while(!nodo.getData().equals(element)){
                nodo = nodo.getNext();
                index ++;
            }
            return index;
        }
        else{
            return -1;
        }
    }
}
