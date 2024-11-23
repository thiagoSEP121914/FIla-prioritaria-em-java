package org.example;

public class Fila<T> {

    public T[] elemento;
    public int tamanho;



    public Fila(int capacidade) {
        this.elemento = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Fila() {
        this(10);
    }


    protected void aumentaCapacidade() {
        if (this.tamanho == this.elemento.length) {
            T[] novoElemento = (T[]) new Object[this.elemento.length * 2];
            System.arraycopy(this.elemento, 0, novoElemento, 0, this.elemento.length);
            this.elemento = novoElemento;
        }
    }

    public void enfileira(T elemento) {
        aumentaCapacidade();
        this.elemento[this.tamanho] = elemento;
        this.tamanho++;
    }


    public T espiar() {
        if (vazio()) {
            return null;  // Fila vazia
        }
        return this.elemento[0];  // Elemento no início da fila
    }


    public T desenfileirar() {
        if (vazio()) {
            return null;  // Fila vazia
        }
        T elementoRemovido = this.elemento[0];
        for (int i = 0; i < this.tamanho - 1; i++) {
            this.elemento[i] = this.elemento[i + 1];  // Desloca os elementos para a esquerda
        }
        this.elemento[this.tamanho - 1] = null;
        this.tamanho--;
        return elementoRemovido;
    }

    public boolean vazio() {
        return this.tamanho == 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.tamanho; i++) {
            s.append(this.elemento[i]);
            if (i < this.tamanho - 1) {
                s.append(", ");
            }
        }
        return s.toString();
    }
}
