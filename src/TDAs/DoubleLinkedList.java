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
        Nodo<E> nodo = new Nodo(element);
        if(element==null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nodo;
        else{
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.first = nodo;
        }
        this.efectivo ++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo = new Nodo(element);
        if(element==null)
            return false;
        else if(this.isEmpty())
            this.first = this.last = nodo;
        else{
            this.last.setNext(nodo);
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
            Nodo<E> nodo = this.first.getNext();
            this.first.setNext(null);
            this.first = nodo;
            this.first.setPrevious(null);
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
            this.last.setPrevious(null);
            this.last = nodo;
            this.last.setNext(null);
        }
        this.efectivo --;
        return true;
    }

    @Override
    public boolean contains(E element) {
        Nodo<E> p, q;
        p = this.first;
        q = this.last;
        while(!(q.getNext()==p) && (p!=q)){
            if(q.getData().equals(element) || p.getData().equals(element))
                return true;
            p = p.getNext();
            q = q.getPrevious();
        }
        return false;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            int cont = 0;
            for(Nodo<E> p=this.first; p!=null; p=p.getNext()){
                if(cont==index){
                    p.getPrevious().setNext(p.getNext());
                    p.setPrevious(null);
                    p.getNext().setPrevious(p.getPrevious());
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
                    p.getPrevious().setNext(nodo);
                    p.setPrevious(nodo);
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
    
    @Override
    public String toString(){
        String str = "[";
        for (Nodo<E> p=this.first; p!=null; p=p.getNext()) {
            str += p.getData() + ",";
        }
        str = str.substring(0, str.length()-1)+"]";
        return str;
    }
}
