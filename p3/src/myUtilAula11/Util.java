package myUtilAula11;

import myUtilAula3.Figura;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static Figura maiorFiguraArea(List<Figura> figs) {
        return figs.stream().max(Comparator.comparing(Figura::area)).orElse(null);
    }

    private static Figura maiorFiguraPerim(List<Figura> figs) {
        return figs.stream().max(Comparator.comparing(Figura::perimetro)).orElse(null);
    }

    private static double somaAreaFig(List<Figura> figs) {
        return figs.stream().mapToDouble(Figura::area).reduce(0, Double::sum);
    }

    private static double somaPerimFig(List<Figura> figs) {
        return figs.stream().mapToDouble(Figura::perimetro).reduce(0, Double::sum);
    }
}
