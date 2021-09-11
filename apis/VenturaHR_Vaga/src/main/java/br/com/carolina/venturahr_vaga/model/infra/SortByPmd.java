package br.com.carolina.venturahr_vaga.model.infra;

import br.com.carolina.venturahr_vaga.model.domain.Candidatura;

import java.util.Comparator;

public class SortByPmd implements Comparator<Candidatura> {

    @Override
    public int compare(Candidatura o1, Candidatura o2) {
        return Float.compare(o2.getNota(), o1.getNota());
    }
}
