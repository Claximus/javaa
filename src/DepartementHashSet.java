public class DepartementHashSet {
    import java.util.HashSet;
import java.util.TreeSet;

    public class DepartementHashSet implements IDepartement<Departement> {
        private HashSet<Departement> listeDepartements;

        public DepartementHashSet() {
            listeDepartements = new HashSet<>();
        }

        @Override
        public void ajouterDepartement(Departement departement) {
            listeDepartements.add(departement);
        }

        @Override
        public boolean rechercherDepartement(String nom) {
            for (Departement departement : listeDepartements) {
                if (departement.getNomDepartement().equals(nom)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean rechercherDepartement(Departement departement) {
            return listeDepartements.contains(departement);
        }

        @Override
        public void supprimerDepartement(Departement departement) {
            listeDepartements.remove(departement);
        }

        @Override
        public void displayDepartement() {
            for (Departement departement : listeDepartements) {
                System.out.println(departement);
            }
        }

        @Override
        public TreeSet<Departement> trierDepartementById() {
            TreeSet<Departement> sortedDepartements = new TreeSet<>(new Comparator<Departement>() {
                @Override
                public int compare(Departement dep1, Departement dep2) {
                    return Integer.compare(dep1.getId(), dep2.getId());
                }
            });
            sortedDepartements.addAll(listeDepartements);
            return sortedDepartements;
        }
    }

}
