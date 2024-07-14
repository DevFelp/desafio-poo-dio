import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = criarCurso("Curso Java", "Descrição Curso Java", 8);
        Curso curso2 = criarCurso("Curso JS", "Descrição Curso JS", 4);
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição Mentoria Java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().addAll(Arrays.asList(curso1, curso2, mentoria));

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        exibirProgresso(devCamila);

        Dev devJoao = new Dev("João");
        devJoao.inscreverBootcamp(bootcamp);
        exibirProgresso(devJoao);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        return new Curso(titulo, descricao, cargaHoraria);
    }

    private static void exibirProgresso(Dev dev) {
        System.out.printf("Conteúdos Inscritos %s: %s%n", dev.getNome(), dev.getConteudosInscritos());
        dev.progredir();
        System.out.printf("Conteúdos Inscritos %s: %s%n", dev.getNome(), dev.getConteudosInscritos());
        System.out.printf("Conteúdos Concluídos %s: %s%n", dev.getNome(), dev.getConteudosConcluidos());
        System.out.printf("XP: %.2f%n", dev.calcularTotalXp());
        System.out.println("-------");
    }
}
