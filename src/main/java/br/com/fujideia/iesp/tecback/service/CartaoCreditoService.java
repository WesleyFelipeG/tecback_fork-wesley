package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import br.com.fujideia.iesp.tecback.repository.CartaoCreditoRepository;
import br.com.fujideia.iesp.tecback.util.CartaoCreditoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartaoCreditoService {

    private final CartaoCreditoRepository cartaoCreditoRepository;

    public CartaoCredito salvar(CartaoCredito cartaoCredito) {
        return cartaoCreditoRepository.save(cartaoCredito);
    }

    public Optional<CartaoCredito> buscarPorId(Long id) {
        return cartaoCreditoRepository.findById(id);
    }

    public List<CartaoCredito> listarTodos() {
        return cartaoCreditoRepository.findAll();
    }

    public boolean deletar(Long id) {
        if (cartaoCreditoRepository.existsById(id)) {
            cartaoCreditoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<CartaoCredito> validarCartao(CartaoCredito cartao) {
        if (!CartaoCreditoValidator.isNumeroCartaoValido(cartao.getNumeroCartao())) {
            throw new IllegalArgumentException("Número do cartão inválido.");
        }

        if (!CartaoCreditoValidator.isCvvValido(String.valueOf(cartao.getCvv()))) {
            throw new IllegalArgumentException("CVV inválido.");
        }

        if (!CartaoCreditoValidator.isValidadeValida(cartao.getValidade())) {
            throw new IllegalArgumentException("Data de validade inválida.");
        }
        return Optional.of(cartao);
    }
}