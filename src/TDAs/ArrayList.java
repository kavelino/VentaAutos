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
public class ArrayList<E> implements List<E>{
    private E[] arreglo;
    private int MAX = 100;
    private int efectivo;

    public ArrayList() {
        this.arreglo = (E[]) new Object[MAX];
        this.efectivo = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        if(element==null)
            return false;
        else{
            if(this.efectivo==this.MAX)
                this.incrementList();
            if(this.isEmpty())
                this.arreglo[efectivo] = element;
            else{
                for(int i=this.efectivo-1; i>=0; i--){
                    this.arreglo[i+1] = this.arreglo[i];
                }
                this.arreglo[0] = element;
            }
            this.efectivo ++;
            return true;
        }
    }

    @Override
    public boolean addLast(E element) {
        if(element==null)
            return false;
        else{
            if(this.efectivo==this.MAX)
                this.incrementList();
            this.arreglo[efectivo] = element;
            this.efectivo++;
            return true;
        }
    }

    @Override
    public E getFirst() {
        if(this.isEmpty())
            return null;
        return this.arreglo[0];
    }

    @Override
    public E getLast() {
        if(this.isEmpty())
            return null;
        return this.arreglo[efectivo-1];
    }

    @Override
    public boolean removeFirst() {
        if(this.isEmpty())
            return false;
        for(int i=0; i<this.efectivo; i++)
            this.arreglo[i] = arreglo[i+1];
        this.efectivo --;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty())
            return false;
        this.arreglo[efectivo-1] = this.arreglo[efectivo];
        this.efectivo --;
        return true;
    }

    @Override
    public boolean contains(E element) {
        for(int i=0; i<this.efectivo; i++){
            if(this.arreglo[i].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
         if(index>=0 && index<this.efectivo)
             return this.arreglo[index];
         return null;
    }
    
    private void incrementList(){
        E[] x = this.arreglo;        
        this.arreglo = (E[]) new Object[this.MAX*2];
        for (int i=0; i<this.MAX; i++){
            this.arreglo[i] = x[i];
        }
        this.MAX = this.MAX*2;
    } 

    @Override
    public List<E> slicing(int inicio, int fin) {
        List<E> newList = new ArrayList();
        if(inicio>=0 && inicio<=fin){
            if(fin-inicio>this.MAX)
                this.incrementList();
            for(int i=inicio; i<=fin; i++){
                newList.addLast(this.arreglo[i]);
            }
            return newList;
        }
        return newList;
    }
    
    @Override
    public String toString() {
        String str = "[";
        for (int i=0; i<this.efectivo; i++) {
            str += this.arreglo[i] + ","; 
        }
        str = str.substring(0, str.length()-1)+"]";
        return str;
    }

    @Override
    public boolean remove(int index) {
        if(this.isEmpty())
            return false;
        else if(index<this.efectivo){
            for (int i=index; i<this.efectivo; i++) {
            this.arreglo[i] = this.arreglo[i+1];
            }
            this.efectivo --;
            this.arreglo[this.efectivo] = null;
            return true;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (index>=efectivo)
            index = efectivo - 1;
        E tmp = this.arreglo[index];
        if(index>=0 && index<this.efectivo)
            this.arreglo[index] = element;
        return tmp;
    }

    @Override
    public boolean add(int index, E element) {
        if(this.efectivo==this.MAX)
            this.incrementList();        
        else if (index>=efectivo)
            index = efectivo;
        for(int i=this.efectivo-1; i>=index; i--){
                    this.arreglo[i+1] = this.arreglo[i];
        }
        this.arreglo[index] = element;
        this.efectivo ++;
        return true;
    }

    @Override
    public int indexOf(E element) {
        if(element!=null && this.contains(element)){
            int index = 0;
            while(this.arreglo[index]!=element){
                index ++;
            }
            return index;
        }
        else{
            return -1;
        }
    }
}
