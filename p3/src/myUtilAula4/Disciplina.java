package myUtilAula4;

import myUtilAula3.Fellow;
import myUtilAula3.Student;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Disciplina {
    String nome, area;
    int ects;
    Professor responsavel;
    ArrayList<Student> alunos;

    public Disciplina(String nome, String area, int ects, Professor responsavel) {
        this.nome = nome;
        this.area = area;
        this.ects = ects;
        this.responsavel = responsavel;
        alunos = new ArrayList<Student>();
    }

    public boolean addAluno(Student est) {
        if (alunos.contains(est)) return false;
        return alunos.add(est);
    }

    public boolean delAluno(int nMec) {
        for (Student s : alunos) {
            if (s.getnMec() == nMec) {
                alunos.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean alunoInscrito(int nMec) {
        for (Student s : alunos) {
            if (s.getnMec() == nMec)
                return true;
        }
        return false;
    }

    public int numAlunos() {
        return alunos.size();
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                ", ects=" + ects +
                ", responsavel=" + responsavel +
                ", alunos=" + alunos +
                '}';
    }

    public Student[] getAlunos() {
        Student[] result = new Student[alunos.size()];
        result = alunos.toArray(result);
        return result;
    }

    public Student[] getAlunos(String tipo) {
        ArrayList<Student> tmp = new ArrayList<Student>(alunos.size());
        for (Student item : alunos) tmp.add(item);

        for (Iterator<Student> iterator = tmp.iterator(); iterator.hasNext(); ) {
            Student s = iterator.next();
            if (tipo.equals("Fellow"))
                if (!(s.getClass() == Fellow.class)) {
                    iterator.remove();
                }
        }

        Student[] result = new Student[tmp.size()];
        result = tmp.toArray(result);
        return result;
    }
}
