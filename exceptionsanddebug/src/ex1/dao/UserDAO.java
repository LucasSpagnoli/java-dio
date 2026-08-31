package ex1.dao;

import ex1.exception.EmptyStorageException;
import ex1.exception.UserNotFoundException;
import ex1.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1L; // pra simular um db

    private List<UserModel> models = new ArrayList<>(); // pra simular um db

    public UserModel save(final UserModel model) {
        model.setId(nextId);
        nextId++;
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public List<UserModel> findAll() {
        List<UserModel> result = null;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    public UserModel findById(final long id) {
        verifyStorage();
        var message = String.format("Não existe usuário com o id " + id);
        return models.stream().filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    private void verifyStorage() {
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }

}
