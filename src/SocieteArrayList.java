import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {
    private ArrayList<Employe> listeEmployes;

    public SocieteArrayList() {
        listeEmployes = new ArrayList<>();
    }

    @Override
    public void ajouterEmploye(Employe employe) {
        listeEmployes.add(employe);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe employe : listeEmployes) {
            if (employe.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe employe) {
        return listeEmployes.contains(employe);
    }

    @Override
    public void supprimerEmploye(Employe employe) {
        listeEmployes.remove(employe);
    }

    @Override
    public void displayEmploye() {
        for (Employe employe : listeEmployes) {
            System.out.println(employe);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listeEmployes);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Collections.sort(listeEmployes, new Comparator<Employe>() {
            @Override
            public int compare(Employe emp1, Employe emp2) {
                int result = emp1.getNom().compareTo(emp2.getNom());
                if (result == 0) {
                    result = emp1.getNomDepartement().compareTo(emp2.getNomDepartement());
                    if (result == 0) {
                        // Sort by grade in descending order
                        result = Integer.compare(emp2.getGrade(), emp1.getGrade());
                    }
                }
                return result;
            }
        });
    }
}
