package org.example;

public class FilaComPrioridade<T> extends Fila<T> {
    private int qtdPrioritarias = 0;

    @Override
    public void enfileira(T elemento) {
        Comparable<T> chave = (Comparable<T>) elemento;
        aumentaCapacidade();

        if (qtdPrioritarias < 3) {
            int i;
            for (i = 0; i < this.tamanho; i++) {
                if (chave.compareTo(this.elemento[i]) < 0) {
                    break;
                }
            }
            // Desloca os elementos para abrir espaço para o novo elemento
            for (int j = this.tamanho; j > i; j--) {
                this.elemento[j] = this.elemento[j - 1];
            }

            this.elemento[i] = elemento; // Insere o novo elemento na posição correta
            this.tamanho++;
            qtdPrioritarias++; // Incrementa a contagem de prioritários

        } else { // Adiciona paciente comum (não prioritário)
            // Pacientes não prioritários devem ser adicionados no final da fila
           int i = 0;
           for (i = this.tamanho; i > 0; i--) {
                if (chave.compareTo(this.elemento[i - 1]) > 0) {
                    break;
                }
           }
           this.elemento[this.tamanho] = elemento;
           this.tamanho++;

           qtdPrioritarias = 0;
        }
    }

}
