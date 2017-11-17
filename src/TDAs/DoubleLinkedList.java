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
public class DoubleLinkedList<E> implements List<E> {
    private Nodo<E> first, last;
    private int efectivo;

    public DoubleLinkedList(){
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
        Nodo<E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if (this.isEmpty()) {
            this.first = this.last = nodo;
            this.last.setNext(this.first);
            this.first.setPrevious(this.last);
        } else{
            this.last.setNext(nodo);
            this.first.setPrevious(nodo);
            nodo.setNext(this.first);
            nodo.setPrevious(this.last);
            this.first = nodo;
        }
        this.efectivo ++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if (this.isEmpty()) {
            this.first = this.last = nodo;
            this.last.setNext(this.first);
            this.first.setPrevious(this.last);
        } else{
            this.last.setNext(nodo);
            this.first.setPrevious(nodo);
            nodo.setNext(this.first);
            nodo.setPrevious(this.last);
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
            Nodo<E> nodo = this.first;
            this.first = this.first.getNext();
            this.last.setNext(this.first);
            this.first.setPrevious(this.last);
            nodo.setNext(null);
            nodo.setPrevious(null);
        }
        this.efectivo --;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty())
            return false;
        else if(this.first==this.last)
                this.first = this.last = null;
        else{
            Nodo<E> nodo = this.last.getPrevious();
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.last.setNext(null);
            this.first.setPrevious(null);
            this.last = nodo;
        }
        this.efectivo --;
        return true;
    }

    @Override
    public boolean contains(E element) {
        Nodo<E> p = this.first;
        Nodo<E> q = this.last;
        do{
            if (p.getData().equals(element) || q.getData().equals(element))
                return true;
            else{
                p = p.getNext();
                q = q.getPrevious();
            }
            
        }while(p!=this.first && q!=this.last);  
        return false;
    }

    @Override
    public E get(int index) {
        if(index>=0 && index<efectivo){
            if(index==0)
                return this.first.getData();
            else if(index==efectivo-1)
                return this.last.getData();
            else{
                Nodo nodo = this.first;
                for (int i=0; i<index; i++) {
                    nodo = nodo.getNext();
                }
                return (E)nodo.getData();
            }
        }
        return null;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        List<E> newLinked = new DoubleLinkedList();
        if(inicio>=0 && inicio<=fin && fin<=this.efectivo-1){
            for(int i=inicio; i<=fin; i++){
                newLinked.addLast(this.get(i));
            }
            return newLinked;
            }
        return null;
    }

    @Override
    public boolean remove(int index) {
        if(this.isEmpty())
            return false;
        else if(this.first==this.last)
                this.first = this.last = null;
        else if(index==0){
            this.removeFirst();
            return true;
        }
        else if(index>=efectivo-1){
            this.removeLast();
            return true;
        }
        else{
            Nodo<E> p = this.first;
            for(int i=0; i<=index; i++){
                if(i==index){
                    p.getPrevious().setNext(p.getNext());
                    p.getNext().setPrevious(p.getPrevious());
                    p.setNext(null);
                    p.setPrevious(null);
                }
                p = p.getNext();
            }
            this.efectivo --;
            return true;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        Nodo<E> nodo = new Nodo(element);
        if((index<0 && index>=this.efectivo) || element==null){
            return null;
        }
        else if(index==0){
            Nodo<E> p = this.first;
            this.last.setNext(nodo);
            nodo.setPrevious(this.last);
            nodo.setNext(this.first.getNext());
            this.first.setNext(null);
            this.first.setPrevious(null);
            this.first = nodo;
            return p.getData();
        }
        else if(index==efectivo-1){
            Nodo<E> p = this.last;
            nodo.setPrevious(this.last.getPrevious());
            nodo.setNext(this.first);
            this.last.setNext(null);
            this.last.setPrevious(null);
            this.last = nodo;
            return p.getData();
        }
        else{
            Nodo<E> p = this.first;
            for(int i=0; i<=index; i++){
                if(i==index){
                    nodo.setData(p.getData());
                    p.setData(element);
                }
                p = p.getNext();
            }
            return nodo.getData();
        }
    }

    @Override
    public boolean add(int index, E element) {
        Nodo <E> nodo = new Nodo<>(element);
        if(element==null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nodo;
        else if(index==0){
            this.addFirst(element);
            return true;
        }  
        else if(index>=this.efectivo){
            this.addLast(element);
            return true;
        }
        else{
            Nodo<E> p = this.first;
            for(int i=0; i<=index; i++){
               if(i==index){
                    p.getPrevious().setNext(nodo);
                    nodo.setPrevious(p.getPrevious());
                    nodo.setNext(p);
                    p.setPrevious(nodo);
                }
               else{
                   p = p.getNext();
               }
            }
            this.efectivo ++;
            return true;
        }
        return false;
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
    
    @Override
    public String toString(){
        String str = "[";
        Nodo<E> p = this.first;
        do{
            str += p.getData() + ",";
            p = p.getNext();
        }while(p!=this.first);
        str = str.substring(0, str.length()-1)+"]";
        return str;
    }
}
