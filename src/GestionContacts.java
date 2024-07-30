
import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.sql.*;

public class GestionContacts extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/contacts";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private JTable ContanctsTable;
    private DefaultTableModel tableModel;

    public GestionContacts() {
        setTitle("Gestion des Contacts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel(new BorderLayout());

        // Création du panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        JButton addButton = new JButton("Ajouter Contact");
        JButton deleteButton = new JButton("Supprimer Contact");
        JButton updateButton = new JButton("Modifier Contact");
        JButton searchButton = new JButton("Rechercher Contact");
        JButton refreshButton = new JButton("Actualiser");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(refreshButton);

        // Création du tableau pour afficher les Contacts
        tableModel = new DefaultTableModel(new String[]{"ID", "Nom", "Numero", "Gmail"}, 0);
        ContanctsTable = new JTable(tableModel);
        ContanctsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(ContanctsTable);

        // Ajout des composants au panel principal
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Ajout des écouteurs d'événements
        addButton.addActionListener(e -> ajouterContacts());
        deleteButton.addActionListener(e -> supprimerContactes());
        updateButton.addActionListener(e -> modifierContact());
        searchButton.addActionListener(e -> rechercherContacte());
        refreshButton.addActionListener(e -> actualiserTableau());

        // Chargement des Contacts depuis la base de données
        actualiserTableau();

        add(mainPanel);
    }

    private void ajouterContacts() {
        // Créer une nouvelle fenêtre pour saisir les informations des Contact
        JDialog addDialog = new JDialog(this, "Ajouter un contacts", true);
        addDialog.setSize(400, 300);
        addDialog.setLocationRelativeTo(this);

        // Création des champs de saisie
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField nomField = new JTextField();
        JTextField prixField = new JTextField();
        JTextField typeField = new JTextField();
        formPanel.add(new JLabel("Nom :"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Numero :"));
        formPanel.add(prixField);
        formPanel.add(new JLabel("Gmail :"));
        formPanel.add(typeField);



        // Boutons d'action
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Enregistrer");
        JButton cancelButton = new JButton("Annuler");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Ajout des composants à la fenêtre
        addDialog.add(formPanel, BorderLayout.CENTER);
        addDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Gestion des événements
        saveButton.addActionListener(e -> {
            // Récupérer les valeurs saisies
            String nom = nomField.getText();
            double prix = Double.parseDouble(prixField.getText());
            String type = typeField.getText();


            // Enregistrer le nouveau contact dans la base de données
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO contacts (ID,nom,Numero,Gmail) VALUES (?, ?, ?, ?)")) {
                stmt.setString(1, null);
                stmt.setString(2, nom);
                stmt.setDouble(3, prix);
                stmt.setString(4, type);
                stmt.executeUpdate();
                actualiserTableau();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // Fermer la fenêtre
            addDialog.dispose();
        });

        cancelButton.addActionListener(e -> addDialog.dispose());

        addDialog.setVisible(true);
    }

    private void supprimerContactes() {
        // Récupérer le Contacte sélectionné
        int selectedRow = ContanctsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un Contact à supprimer.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);

        // Supprimer contacte de la base de données
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Contact WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            actualiserTableau();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void modifierContact() {
        // Récupérer le contacte sélectionné
        int selectedRow = ContanctsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un Contact à modifier.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String nom = (String) tableModel.getValueAt(selectedRow, 1);
        double Numero = (double) tableModel.getValueAt(selectedRow, 2);
        String Gmail = (String) tableModel.getValueAt(selectedRow, 3);


        // Créer une nouvelle fenêtre pour modifier les informations du contactes
        JDialog updateDialog = new JDialog(this, "Modifier un contact", true);
        updateDialog.setSize(400, 300);
        updateDialog.setLocationRelativeTo(this);

        // Création des champs de saisie
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField nomField = new JTextField(nom);
        JTextField prixField = new JTextField(String.valueOf(Numero));
        JTextField typeField = new JTextField(Gmail);
        formPanel.add(new JLabel("Nom :"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Numero :"));
        formPanel.add(prixField);
        formPanel.add(new JLabel("Gmail :"));
        formPanel.add(typeField);


        // Boutons d'action
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Enregistrer");
        JButton cancelButton = new JButton("Annuler");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Ajout des composants à la fenêtre
        updateDialog.add(formPanel, BorderLayout.CENTER);
        updateDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Gestion des événements
        saveButton.addActionListener(e -> {
            // Récupérer les nouvelles valeurs saisies
            String nouveauNom = nomField.getText();
            double nouveauPrix = Double.parseDouble(prixField.getText());
            String nouveauType = typeField.getText();

            // Mettre à jour le Contact dans la base de données
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("UPDATE contacts SET nom = ?, Numero = ?, Gmail = ?,  WHERE id = ?")) {
                stmt.setString(1, nouveauNom);
                stmt.setDouble(2, nouveauPrix);
                stmt.setString(3, nouveauType);
                stmt.setInt(5, id);
                stmt.executeUpdate();
                actualiserTableau();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // Fermer la fenêtre
            updateDialog.dispose();
        });

        cancelButton.addActionListener(e -> updateDialog.dispose());

        updateDialog.setVisible(true);
    }

    private void rechercherContacte() {
        // Créer une nouvelle fenêtre pour saisir les critères de recherche
        JDialog searchDialog = new JDialog(this, "Rechercher un Contact", true);
        searchDialog.setSize(400, 300);
        searchDialog.setLocationRelativeTo(this);

        // Création des champs de saisie
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField nomField = new JTextField();
        JTextField prixMinField = new JTextField();
        JTextField prixMaxField = new JTextField();
        formPanel.add(new JLabel("Nom :"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("numero professionnel :"));
        formPanel.add(prixMinField);
        formPanel.add(new JLabel("numero personnel :"));
        formPanel.add(prixMaxField);

        // Boutons d'action
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton searchButton = new JButton("Rechercher");
        JButton cancelButton = new JButton("Annuler");
        buttonPanel.add(searchButton);
        buttonPanel.add(cancelButton);

        // Ajout des composants à la fenêtre
        searchDialog.add(formPanel, BorderLayout.CENTER);
        searchDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Gestion des événements
        searchButton.addActionListener(e -> {
            // Récupérer les critères de recherche
            String nom = nomField.getText();
            double prixMin = Double.parseDouble(prixMinField.getText());
            double prixMax = Double.parseDouble(prixMaxField.getText());

            // Effectuer la recherche dans la base de données
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contact WHERE nom LIKE ? AND prix BETWEEN ? AND ?")) {
                stmt.setString(1, "%" + nom + "%");
                stmt.setDouble(2, prixMin);
                stmt.setDouble(3, prixMax);
                ResultSet rs = stmt.executeQuery();

                // Mettre à jour le tableau avec les résultats de la recherche
                tableModel.setRowCount(0);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nomMedicament = rs.getString("nom");
                    double prix = rs.getDouble("Numero");
                    String type = rs.getString("Gmail");
                    tableModel.addRow(new Object[]{id, nomMedicament, prix, type,});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // Fermer la fenêtre
            searchDialog.dispose();
        });

        cancelButton.addActionListener(e -> searchDialog.dispose());

        searchDialog.setVisible(true);
    }

    private void actualiserTableau() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM contacts")) {
            tableModel.setRowCount(0);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("Numero");
                String type = rs.getString("Gmail");
                tableModel.addRow(new Object[]{id, nom, prix, type,});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionContacts gui = new GestionContacts();
            gui.setVisible(true);
        });
    }
}
