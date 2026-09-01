import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente outro = (Cliente) obj;
        return this.cpf.equals(outro.cpf); // dois clientes são "iguais" se o CPF bate
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
}

// List<Cliente> comDuplicatas = buscarClientesDoBanco(); // tem CPFs repetidos
// Set<Cliente> semDuplicatas = new HashSet<>(comDuplicatas); // Set remove duplicata automaticamente

// Map<String, List<Produto>> porCategoria = new HashMap<>();
//
// for (Produto p : produtos) {
//         porCategoria.computeIfAbsent(p.getCategoria(), k -> new ArrayList<>()).add(p);
// }
// computeIfAbsent é um método bem útil: "se essa chave ainda não existe no map, cria o valor usando essa função; se já existe, só retorna o que já tem" — evita você escrever manualmente o if (containsKey) ... else ...