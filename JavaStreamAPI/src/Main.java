import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Livre> livres = new ArrayList<>();

        Livre livre1 = new Livre();
        livre1.setAnnee(2001);
        livre1.setTitre("a");
        livre1.setAuteur("auteur4");

        Livre livre2 = new Livre();
        livre2.setAnnee(1999);
        livre2.setTitre("livre2");
        livre2.setAuteur("auteur1");

        Livre livre3 = new Livre();
        livre3.setAnnee(2002);
        livre3.setTitre("livre3");
        livre3.setAuteur("auteur3");

        livres.add(livre1);
        livres.add(livre2);
        livres.add(livre3);

        Stream<Livre> livreStream = livres.stream();
        System.out.println(livreStream.count());


        List<Livre> filteredLivres = trierAnne(livres);
        System.out.println(filteredLivres);

        List<Livre> Dsc =trierTitre(livres);
        System.out.println(Dsc);

        Optional<Livre> filteredLivres1 = findFirstBook(livres);
        System.out.println(filteredLivres1);

        List<Livre> sortedLivres = trierTitreEtAuteur(livres);

        sortedLivres.stream()
                .map(Livre::getTitre)
                .forEach(System.out::println);
    }

    //Q-b1
    public static List<Livre> filter(List<Livre> livres) {
        Stream<Livre> livreStream = livres.stream();
        List<Livre> filteredList = livreStream.filter(livre -> livre.getAnnee() > 2000).collect(Collectors.toList());
        return filteredList;
    }

    //Q-b2
    public static List<Livre> findFirstLivre(List<Livre> livres) {
        return livres.stream().filter(livre -> livre.getAuteur().equals("auteur1")).findFirst().stream().collect(Collectors.toList());
    }

    //Q-b2
    public static Optional<Livre> findFirstBook(List<Livre> livres) {
        return livres.stream().filter(livre -> livre.getAuteur().equals("auteur1")).findFirst();
    }
    //Q-c1

    //Asc
    public static List<Livre> trierAnne(List <Livre> livres){
        return livres.stream().sorted((a,b)->Integer.compare(a.getAnnee(), b.getAnnee())).collect(Collectors.toList());
    }
    //DSC
    public static List<Livre> trierAnneeDesc(List<Livre> livres) {
        return livres.stream()
                .sorted((a, b) -> Integer.compare(b.getAnnee(), a.getAnnee()))  // Descending order
                .collect(Collectors.toList());
    }
    public static List<Livre> trierTitre(List<Livre> livres) {
        return livres.stream()
                .sorted((a, b) -> a.getTitre().compareTo(b.getTitre()))
                .sorted((a,b)->a.getAuteur().compareTo((b.getAuteur())))
                .collect(Collectors.toList());
    }
    public static List<Livre> trierTitreEtAuteur(List<Livre> livres) {
        return livres.stream()
                .sorted(Comparator.comparing(Livre::getTitre)
                        .thenComparing(Livre::getAuteur))
                .collect(Collectors.toList());
    }
}