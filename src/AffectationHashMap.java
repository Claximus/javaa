import java.util.HashMap;
import java.util.Map;

public class AffectationHashMap {
    private Map<Employe, Departement> affectations;

    public AffectationHashMap() {
        affectations = new HashMap<>();
    }

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
    }
    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println("Employe : " + entry.getKey() + " - Departement : " + entry.getValue());
        }
    }
    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        affectations.remove(e, d);
    }
    public void afficherEmployes() {
        for (Employe employe : affectations.keySet()) {
            System.out.println(employe);
        }
    }
    public void afficherDepartements() {
        for (Departement departement : affectations.values()) {
            System.out.println(departement);
        }
    }
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }
import java.util.TreeMap;

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sortedMap = new TreeMap<>(new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                return Integer.compare(e1.getId(), e2.getId());
            }
        });
        sortedMap.putAll(affectations);
        return sortedMap;
    }


}
