package ex1;

import ex1.dao.UserDAO;
import ex1.exception.EmptyStorageException;
import ex1.exception.UserNotFoundException;
import ex1.exception.ValidatorException;
import ex1.model.MenuOption;
import ex1.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static ex1.validators.UserValidator.verifyModel;

public class Main {

    private static final UserDAO dao = new UserDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nBem vindo ao cadastro de usuários, selecione a operação desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");

            var input = scanner.nextInt();
            scanner.nextLine();

            var opt = MenuOption.values()[input - 1];

            switch (opt) {

                case SAVE -> {
                    try {
                        var user = requestUserInfo();
                        dao.save(user);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }


                case UPDATE -> {
                    try {
                        System.out.println("Informe o ID do usuário:");
                        var id = scanner.nextLong();

                        var user = requestUserInfo();
                        user.setId(id);

                        dao.update(user);
                        System.out.println("Usuário atualizado com sucesso!");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }


                case DELETE -> {
                    try {
                        System.out.println("Informe o ID do usuário:");
                        var id = scanner.nextLong();

                        dao.delete(id);
                        System.out.println("Usuário excluído com sucesso!");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }


                case FIND_BY_ID -> {
                    try {
                        System.out.println("Informe o ID do usuário:");
                        var id = scanner.nextLong();
                        var user = dao.findById(id);
                        System.out.println(user);
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                }


                case FIND_ALL -> {
                    var users = dao.findAll();

                    if (users.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        users.forEach(System.out::println);
                    }
                }

                case EXIT -> {
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                }
            }
        }
    }

    public static UserModel requestUserInfo() {

        System.out.println("Informe o nome do usuário:");
        var name = scanner.nextLine();

        System.out.println("Informe o email do usuário:");
        var email = scanner.nextLine();

        System.out.println("Informe a data de nascimento (dd/mm/yyyy):");
        var birthdayString = scanner.nextLine();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        var user = new UserModel(0, name, email, birthday);
        try {
            verifyModel(user);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

}