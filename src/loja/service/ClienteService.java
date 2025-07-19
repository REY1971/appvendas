package loja.service;

import loja.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente cliente) {
        if (buscarPorCpf(cliente.getCpf()) != null) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
    }
}

