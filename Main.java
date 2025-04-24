import java.util.*;

public class Main {
    /**
     * A função irá gerar e imprimir todos os subsets de um set dado.
     * - Cria um set A com elementos inteiros específicos.
     * - Pode ser até 4 elementos.
     * - Chama a função getSubSets para calcular todos os subsets de A.
     * - Função SubSets:
     *      - Recebe o set A como parâmetro.
     *      - Converte o conunto em uma lista para acessar por índices.
     *      - Gera todos os subsets de tamanho 3, 2, 1 e 0 (set vazio).
     *      - Adiciona cada subset em ordem decrescente de tamanho a uma lista.
     *      - Retorna a lista.
     * - Por fim, a função main imprime todos os subsets em uma única lista.
     */
    public static void main(String[] args) {

        Set<Integer> A = new HashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);
        //A.add(4);

        List<List<Integer>> subsets = getSubSets(A);
        System.out.println(subsets);
    }

    public static List<List<Integer>> getSubSets(Set<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elements = new ArrayList<>(A);
        int setSize = A.size();

        // Subset completo
        result.add(new ArrayList<>(elements));

        // Subset de 3 elementos
        for (int i = 0; i < setSize; i++) {
            for (int j = i + 1; j < setSize; j++) {
                for (int k = j + 1; k < setSize; k++) {
                    result.add(Arrays.asList(elements.get(i), elements.get(j), elements.get(k)));
                }
            }
        }

        // Subset de 2 elementos
        for (int i = 0; i < setSize; i++) {
            for (int j = i + 1; j < setSize; j++) {
                result.add(Arrays.asList(elements.get(i), elements.get(j)));
            }
        }

        // Subset de 1 elemento
        for (int i = 0; i < setSize; i++) {
            result.add(Arrays.asList(elements.get(i)));
        }

        // Subset vazio
        result.add(new ArrayList<>());

        return result;
    }
}