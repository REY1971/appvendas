package loja.service;

import loja.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public boolean cadastrarCliente(Cliente cliente) {
        if (buscarPorCpf(cliente.getCpf()) != null) {
            return false; // CPF já cadastrado
        }
        clientes.add(cliente);
        return true;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}


