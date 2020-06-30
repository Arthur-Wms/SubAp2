/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinária;

import java.util.ArrayList;
import java.util.Arrays;

class No {

    int dado;
    No[] filhos;
    int indice;
    No pai;

    public No(int dado) {
        this.dado = dado;
        filhos = new No[2];
        //filhos[0] = esq;
        //filhos[1] = dir;	
    }
}

public class Arvore extends javax.swing.JFrame {

    public static No raiz;
    public static No aux;
    static ArrayList<Integer> listaNos = new ArrayList<>();
    private static int tam;
    private static Integer[] vetor;

    public static void inserir(int valor) {
        inserir(raiz, valor);
    }

    public static void inserir(No novo, int dado) {
        if (novo == null) {
            raiz = new No(dado);
            raiz.indice = 0;
            aux = raiz;
            System.out.println("Raiz " + dado + ", indice " + raiz.indice);
        } else {
            if (dado < novo.dado) {
                if (novo.filhos[0] != null) {
                    aux = novo.filhos[0];
                    inserir(novo.filhos[0], dado);
                } else {
                    novo.filhos[0] = new No(dado);
                    novo.filhos[0].pai = aux;
                    novo.filhos[0].indice = 2 * novo.filhos[0].pai.indice + 1;
                    System.out.println("Inserindo " + dado + " a esquerda de " + novo.dado + ", indice " + novo.filhos[0].indice);
                }

            } else {
                if (novo.filhos[1] != null) {
                    aux = novo.filhos[1];
                    inserir(novo.filhos[1], dado);
                } else {
                    novo.filhos[1] = new No(dado);
                    novo.filhos[1].pai = aux;
                    novo.filhos[1].indice = 2 * novo.filhos[1].pai.indice + 2;
                    System.out.println("Inserindo " + dado + " a direita de " + novo.dado + ", indice " + novo.filhos[1].indice);
                }
            }
        }
    }

    public static void preordem(No no) {
        if (no != null) {
            System.out.print(no.dado + ", ");
            preordem(no.filhos[0]);
            preordem(no.filhos[1]);

        }
    }

    public static void posordem(No no) {
        if (no != null) {
            posordem(no.filhos[0]);
            posordem(no.filhos[1]);
            System.out.print(no.dado + ", ");

        }
    }

    public static void ordem(No no) {
        if (no != null) {
            ordem(no.filhos[0]);
            System.out.print(no.dado + ", ");
            ordem(no.filhos[1]);

        }
    }

    public static void buscaSimples(No r, int i) {
        if (r == null) {
            System.out.println("Null");
        } else {
            if (r.dado > i) {
                buscaSimples(r.filhos[0], i);
            } else {
                if (r.dado < i) {
                    buscaSimples(r.filhos[1], i);
                } else {
                    System.out.println("No com valor: " + r.dado + " localizado no indice " + r.indice);
                }
            }
        }
    }
    
        public static void buscaHeap(No r, int i, int novoI) {
        if (r == null) {
            System.out.println("Null");
        } else {
            if (r.dado > i) {
                buscaHeap(r.filhos[0], i, novoI);
            } else {
                if (r.dado < i) {
                    buscaHeap(r.filhos[1], i, novoI);
                } else {
                    r.indice = novoI;
                }
            }
        }
    }

    public static void heapSortListar(No base) {

        if (base.filhos[0] != null) {
            listaNos.add(base.filhos[0].dado);
            heapSortListar(base.filhos[0]);
        }
        if (base.filhos[1] != null) {
            listaNos.add(base.filhos[1].dado);
            heapSortListar(base.filhos[1]);
        }
    }

    public static void heapSortRaizAdd() {

        listaNos.add(raiz.dado);
    }
    
    public static void heapSort(ArrayList<Integer> list) {

        Integer[] lista = list.toArray(new Integer[list.size()]);
        vetor = lista;

        
        tam = vetor.length - 1;

        constroiHeap();


        for (int i = tam; i > 0; i--) {
            troca(0, tam);
            tam -= 1;
            maxHeapifica(0);
        }
        System.out.println(Arrays.toString(vetor));
        for (int i = 0; i < vetor.length; i++) {
            buscaHeap(raiz, vetor[i], i);
        }
    }


    private static void constroiHeap() {

        int meio;
        meio = (int) (tam / 2);// 'meio' vai ser igual ao valor inteiro da divisão de tam/2


        for (int i = meio - 1; i >= 0; i--) {
            maxHeapifica(i);
        }
    }


    private static void troca(int i, int j) {
        int aux;

        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }


    private static void maxHeapifica(int pai) {
        int maior = pai,
                esquerda = 2 * pai + 1,
                direita = 2 * pai + 2;

        if (esquerda <= tam && vetor[esquerda] > vetor[maior]) {
            maior = esquerda;
        }

        if (direita <= tam && vetor[direita] > vetor[maior]) {
            maior = direita;
        }

        if (maior != pai) {
            troca(pai, maior);
            maxHeapifica(maior);
        }
    }

    public Arvore() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInserir = new javax.swing.JButton();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldInserir = new javax.swing.JTextField();
        jButtonInOrder = new javax.swing.JButton();
        jButtonPreOrder = new javax.swing.JButton();
        jButtonPosOrder = new javax.swing.JButton();
        jButtonHeapSort = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jLabelValor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValor.setText("Valor:");

        jTextFieldInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInserirActionPerformed(evt);
            }
        });

        jButtonInOrder.setText("Imprimir em Ordem");
        jButtonInOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInOrderActionPerformed(evt);
            }
        });

        jButtonPreOrder.setText("Imprimir em PreOrdem");
        jButtonPreOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreOrderActionPerformed(evt);
            }
        });

        jButtonPosOrder.setText("Imprimir em PosOrdem");
        jButtonPosOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPosOrderActionPerformed(evt);
            }
        });

        jButtonHeapSort.setText("HeapSort");
        jButtonHeapSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHeapSortActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonInserir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldInserir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonInOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPreOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPosOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHeapSort, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPreOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPosOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHeapSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        String textFieldValue = jTextFieldInserir.getText();
        int value = Integer.parseInt(textFieldValue);
        Arvore.inserir(value);
        jTextFieldInserir.setText("");
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jTextFieldInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInserirActionPerformed

    }//GEN-LAST:event_jTextFieldInserirActionPerformed

    private void jButtonInOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInOrderActionPerformed
        Arvore.ordem(Arvore.raiz);
        System.out.println();
    }//GEN-LAST:event_jButtonInOrderActionPerformed

    private void jButtonPreOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreOrderActionPerformed
        Arvore.preordem(Arvore.raiz);
        System.out.println();
    }//GEN-LAST:event_jButtonPreOrderActionPerformed

    private void jButtonPosOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPosOrderActionPerformed
        Arvore.posordem(Arvore.raiz);
        System.out.println();
    }//GEN-LAST:event_jButtonPosOrderActionPerformed

    private void jButtonHeapSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeapSortActionPerformed
        Arvore.heapSortRaizAdd();
        Arvore.heapSortListar(raiz);
        Arvore.heapSort(listaNos);
    }//GEN-LAST:event_jButtonHeapSortActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String textFieldValue = jTextFieldBuscar.getText();
        int value = Integer.parseInt(textFieldValue);
        Arvore.buscaSimples(raiz, value);
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arvore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arvore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonHeapSort;
    private javax.swing.JButton jButtonInOrder;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonPosOrder;
    private javax.swing.JButton jButtonPreOrder;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldInserir;
    // End of variables declaration//GEN-END:variables
}
